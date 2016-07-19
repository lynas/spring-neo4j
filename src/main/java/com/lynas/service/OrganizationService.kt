package com.lynas.service

import com.lynas.model.Organization
import com.lynas.repo.OrganizationRepo
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

    @Transactional
    open fun saveOrganization(org: Organization) {
        orgRepo.save(org)
    }


    @Transactional
    open fun readByID(id: Long): Organization {
        return orgRepo.findOne(id)
    }
}