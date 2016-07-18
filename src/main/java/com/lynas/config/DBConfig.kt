package com.lynas.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
* Created by LynAs on 7/16/2016
*/

@Configuration
@EnableNeo4jRepositories(basePackages = arrayOf("com.lynas"))
@EnableTransactionManagement
open class DBConfig{

}
