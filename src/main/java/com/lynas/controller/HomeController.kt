package com.lynas.controller

import com.lynas.model.Organization
import com.lynas.model.Person
import com.lynas.service.OrganizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by sazzad on 7/15/16
 */

@Controller
class HomeController {

    @Autowired
    lateinit var orgService: OrganizationService

    @RequestMapping(value = "/")
    fun home(): String {
        return "home"
    }

    @RequestMapping(value = "/save")
    fun save(): String {
        val person = Person()
        person.name = "Sazzad"
        val listOfPerson = listOf(person)
        val organization = Organization()
        organization.name = "orgName"
        organization.person = listOfPerson
        orgService.saveOrganization(organization)
        return "home"
    }

    @RequestMapping(value = "/org/{id}")
    fun read(@PathVariable id: Long, model: Model): String {
        val organization = orgService.readByID(id)
        println(organization.name)
        return "home"
    }
}