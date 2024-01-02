package com.example.kotiontodoweb.controller

import com.example.kotiontodoweb.dto.User
import com.example.kotiontodoweb.exception.UserNotFoundException
import com.example.kotiontodoweb.service.UserDaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.net.URL


@RestController
class UserController {

    @Autowired
    val userDaoService = UserDaoService()

    @GetMapping("/users")
    fun retrieveAllUsers() : ResponseEntity<List<User>> {

        return ResponseEntity.ok(userDaoService.findAllUser())
    }
    @GetMapping("/users/{id}")
    fun retrieveUser(@PathVariable id: Int) : ResponseEntity<User> {
        val user = userDaoService.findOne(id) ?: throw UserNotFoundException("ID : $id 가 존재하지 않습니다.")

        return ResponseEntity.ok(user)
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user : User) : ResponseEntity<User>{
        val saveUser = userDaoService.save(user)

        val location : URI =
            ServletUriComponentsBuilder.fromCurrentRequest()
                //현재 경로 가지고오기
                .path("/{id}").buildAndExpand(saveUser.id)
                //{id} 라는 매개변수를 추가해서 값 리턴 userID로 대체
                .toUri()


        return ResponseEntity.created(location).build();
    }

}