package com.lynas.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * Created by LynAs on 23-Jan-16
 */
@Configuration
@ComponentScan(basePackages = arrayOf("com.lynas"))
open class RootConfig
