package com.sdagroup.gradleairbooking.controller;

import com.sdagroup.gradleairbooking.model.NewsletterModel;
import com.sdagroup.gradleairbooking.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

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

    /*
    With POST mapping, details are hidden, unlike GET mapping.
    This is good when sending over sensitive information
     */
    @PostMapping(value= "/newsletter")
    public HttpStatus addNewsletter(@RequestParam("email") final String email) {
        newsletterService.insertNewsLetter(email);
        return HttpStatus.OK;
    }

    @GetMapping(value="/newsletters")
    public List<NewsletterModel> getAllNewsletters(){
        List<NewsletterModel> newsletterModels = newsletterService.getAllNewsletters();
        return newsletterModels;
    }
}
