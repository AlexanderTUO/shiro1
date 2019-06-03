package com.itdragon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: itdragon
 * @Date: 2019/5/17 13:57
 * @Description:
 */
@Controller
public class PageController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard() {
        return "/dashboard";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "forward/dashboard";
    }
}
