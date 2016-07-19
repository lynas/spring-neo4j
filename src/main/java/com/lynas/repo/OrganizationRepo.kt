package com.lynas.repo

import com.lynas.model.Organization
import org.springframework.data.neo4j.repository.GraphRepository

/**
 * Created by sazzad on 7/18/16
 */

interface OrganizationRepo : GraphRepository<Organization>
