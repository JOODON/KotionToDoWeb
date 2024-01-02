package com.example.kotiontodoweb.service

import com.example.kotiontodoweb.dto.User
import org.springframework.stereotype.Component
import java.net.URL
import java.time.LocalDate


@Component
class UserDaoService {

    private var userCount : Int = 0
    val userList : MutableList<User> = mutableListOf(
        User(++userCount,"하나", LocalDate.now().minusYears(20)),
        User(++userCount,"들나", LocalDate.now().minusYears(25)),
        User(++userCount,"세나", LocalDate.now().minusYears(30)),
    )

    fun findAllUser() : List<User> {
        return userList
    }
    fun findOne(id: Int): User? {
        val predicate: (User) -> Boolean = { user -> user.id == id }
        return userList.firstOrNull(predicate)
    }

    fun save(user : User) : User{
        userList.add(user)

        return user
    }

}