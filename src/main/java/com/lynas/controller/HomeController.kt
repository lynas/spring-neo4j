package com.lynas.controller

import com.lynas.model.Organization
import com.lynas.model.Person
import com.lynas.repo.OrganizationRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by sazzad on 7/15/16
 */

@Controller
class HomeController {

    @Autowired
    lateinit var orgRepo: OrganizationRepo
    @RequestMapping(value = "/")
    fun home(): String {
        return "home"
    }

    @RequestMapping(value = "/save")
    fun save(): String {
        val person = Person(1, "sazzad")
        val listOfPerson = listOf(person)
        orgRepo.save(Organization(1, "name", 29, listOfPerson))
        return "home"
    }
}