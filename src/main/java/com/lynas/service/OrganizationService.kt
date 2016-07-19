package com.lynas.service

import com.lynas.model.Organization
import com.lynas.repo.OrganizationRepo
import com.lynas.repo.OrganizationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by sazzad on 7/19/16
 */

@Service
open class OrganizationService {


    @Autowired
    lateinit var orgRepo: OrganizationRepo
    @Autowired
    lateinit var organizationRepo: OrganizationRepository

    @Transactional
    open fun saveOrganization(org: Organization) {
        orgRepo.save(org)
    }


    @Transactional
    open fun readByID(id: Long): Organization {
        return orgRepo.findOne(id)
    }

    @Transactional
    open fun readByName(name: String): List<Organization> {
        return organizationRepo.findByName(name)
    }

    @Transactional
    open fun readByOtherName(name: String): List<Organization> {
        return orgRepo.findByName(name)
    }


}