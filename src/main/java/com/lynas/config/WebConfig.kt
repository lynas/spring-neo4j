package com.lynas.config

import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect
import nz.net.ultraq.thymeleaf.LayoutDialect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.thymeleaf.dialect.IDialect
import org.thymeleaf.spring4.SpringTemplateEngine
import org.thymeleaf.spring4.view.ThymeleafViewResolver
import org.thymeleaf.templateresolver.ServletContextTemplateResolver
import java.util.*

@Configuration
@EnableWebMvc
@ComponentScan("com.lynas")
open class WebConfig() : WebMvcConfigurerAdapter() {


    @Bean(name = arrayOf("templateResolver"))
    open fun templateResolver(): ServletContextTemplateResolver {
        val resolver = ServletContextTemplateResolver()
        resolver.isCacheable = false
        setProperty(resolver)
        return resolver

    }

    fun setProperty(resolver: ServletContextTemplateResolver) {
        resolver.prefix = "/"
        resolver.suffix = ".html"
        resolver.templateMode = "HTML5"
    }

    @Bean
    open fun templateEngine(): SpringTemplateEngine {
        val dialects = HashSet<IDialect>()
        dialects.add(LayoutDialect())

        val engine = SpringTemplateEngine()
        engine.setTemplateResolver(templateResolver())
        engine.setAdditionalDialects(dialects)
        engine.addDialect(DataAttributeDialect())
        return engine
    }

    @Bean
    open fun viewResolver(): ThymeleafViewResolver {
        val resolver = ThymeleafViewResolver()
        resolver.templateEngine = templateEngine()
        resolver.order = 1
        resolver.viewNames = arrayOf("*", "js/*", "template/*")
        return resolver
    }


    override fun configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer) {
        configurer.enable()
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/")
    }
}

















