package com.lynas.config

import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.data.neo4j.config.Neo4jConfiguration
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * Created by LynAs on 7/16/2016
 */

@Configuration
@EnableNeo4jRepositories(basePackages = arrayOf("com.lynas.repo"))
@EnableTransactionManagement
open class DBConfig : Neo4jConfiguration() {

    @Bean
    override fun getSessionFactory(): SessionFactory {
        return SessionFactory(getConfiguration(), "com.lynas.model")
    }


    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Throws(Exception::class)
    override fun getSession(): Session {
        return super.getSession()
    }

    @Bean
    open fun getConfiguration(): org.neo4j.ogm.config.Configuration {
        val config = org.neo4j.ogm.config.Configuration()
        config
                .driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .uri = "http://neo4j:s2015@localhost:7474"
        return config
    }
}
