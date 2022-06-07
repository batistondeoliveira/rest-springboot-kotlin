package br.com.elielbatiston.restspringbootkotlin.services

import br.com.elielbatiston.restspringbootkotlin.data.vo.v1.PersonVO
import br.com.elielbatiston.restspringbootkotlin.data.vo.v2.PersonVO as PersonVOV2
import br.com.elielbatiston.restspringbootkotlin.exceptions.ResourceNotFoundException
import br.com.elielbatiston.restspringbootkotlin.mapper.DozerMapper
import br.com.elielbatiston.restspringbootkotlin.mapper.custom.PersonMapper
import br.com.elielbatiston.restspringbootkotlin.model.Person
import br.com.elielbatiston.restspringbootkotlin.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var repository: PersonRepository

    @Autowired
    private lateinit var mapper: PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<PersonVO> {
        logger.info("Finding all people!")

        val persons = repository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)
    }

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person!")

        var person = repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("No records found for this ID!") }

        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun create(personVO: PersonVO): PersonVO {
        logger.info("Creating one person with name ${personVO.firstName}!")
        var person: Person = DozerMapper.parseObject(personVO, Person::class.java)
        return DozerMapper.parseObject(repository.save(person), PersonVO::class.java)
    }

    fun createV2(personVO: PersonVOV2): PersonVOV2 {
        logger.info("Creating one person with name ${personVO.firstName}!")
        var person: Person = mapper.mapVOToEntity(personVO)
        return mapper.mapEntityToVO(repository.save(person))
    }

    fun update(personVO: PersonVO) : PersonVO {
        logger.info("Updating one person with ID ${personVO.id}!")

        val entity = repository.findById(personVO.id)
            .orElseThrow{ ResourceNotFoundException("No records found for this ID!") }

        entity.firstName = personVO.firstName
        entity.lastName = personVO.lastName
        entity.address = personVO.address
        entity.gender = personVO.gender

        return DozerMapper.parseObject(repository.save(entity), PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Deleting one person with ID ${id}!")

        val entity = repository.findById(id)
            .orElseThrow{ ResourceNotFoundException("No records found for this ID!") }

        repository.delete(entity)
    }
}