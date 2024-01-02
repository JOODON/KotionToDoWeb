package com.example.kotiontodoweb.dto

import java.time.LocalDate

class User(
     val id : Int,

     val name : String,

     val birthDate : LocalDate
)
{
    override fun toString(): String {
        return "User(id=$id, name='$name', birthDate=$birthDate)"
    }
}