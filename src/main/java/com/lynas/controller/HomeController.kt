package com.lynas.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by sazzad on 7/15/16
 */

@Controller
class HomeController {

    @RequestMapping(value = "/")
    fun home(): String {
        return "home"
    }
}