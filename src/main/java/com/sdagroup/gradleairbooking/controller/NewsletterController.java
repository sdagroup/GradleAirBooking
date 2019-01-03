package com.sdagroup.gradleairbooking.controller;

import com.sdagroup.gradleairbooking.model.NewsletterModel;
import com.sdagroup.gradleairbooking.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Ryan Alexander on 21/12/2018.
 */
@Controller
public class NewsletterController {
    @Autowired
    private NewsletterService newsletterService;

    // browser endpoint
    @GetMapping("/newsletter")
    public ModelAndView indexPage(){
        return new ModelAndView("index-old")
                .addObject("newsletter", new NewsletterModel())
                .addObject("user", "Ms. M George");
    }

    @PostMapping("/newsletter")
    public ModelAndView insertNewsletter(@ModelAttribute("email") final String email){
        newsletterService.insertNewsletter(email);
        return new ModelAndView("result").addObject("email", email);
    }
}
