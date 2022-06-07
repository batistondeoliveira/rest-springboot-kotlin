package br.com.elielbatiston.restspringbootkotlin.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("id", "address", "first_name", "lastName", "gender")
class PersonVO (

    var id: Long = 0,
    @field:JsonProperty("first_name")
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",

    @field:JsonIgnore
    var gender: String = ""
)