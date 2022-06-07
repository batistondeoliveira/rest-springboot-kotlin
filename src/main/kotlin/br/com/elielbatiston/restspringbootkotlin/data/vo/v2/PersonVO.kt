package br.com.elielbatiston.restspringbootkotlin.data.vo.v2

import java.util.*

class PersonVO (

    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = "",
    var birthDay: Date? = null
)