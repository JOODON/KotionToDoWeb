package com.example.kotiontodoweb.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class MainController {

    @RequestMapping("/todo")
    fun showIndex() : String{

        return "index"
    }

}