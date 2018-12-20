package com.sdagroup.gradleairbooking.controller;

import com.sdagroup.gradleairbooking.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;

/**
 * Created by Ryan Alexander on 19/12/2018.
 */

/*
http://localhost:8080/booking/api/newsletter?email=isa@gmail.com -> HTTP GET request
 */
// a small change

@RestController
@RequestMapping("/api") // returns response value and json rest calls
public class NewsletterRestController {

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping("/newsletter")
    // create newsletter for visitors
    // also returns http status call
    public HttpStatus createNewsletter(@RequestParam("email") String email) {
       newsletterService.insertNewsLetter(email);
       return HttpStatus.OK;
    }
}