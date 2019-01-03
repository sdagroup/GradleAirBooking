package com.sdagroup.gradleairbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Ryan Alexander on 02/01/2019.
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView indexPage(){
//        return new ModelAndView("index-old");
        return new ModelAndView("index");
    }
}
