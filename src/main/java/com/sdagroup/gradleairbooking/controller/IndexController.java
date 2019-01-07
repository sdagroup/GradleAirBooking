package com.sdagroup.gradleairbooking.controller;

import com.sdagroup.gradleairbooking.model.NewsletterModel;
import com.sdagroup.gradleairbooking.model.TopDestinationModel;
import com.sdagroup.gradleairbooking.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Ryan Alexander on 02/01/2019.
 */

@Controller
public class IndexController {

    @Autowired
    private AddressService addressService;


    @GetMapping("/")
    public ModelAndView indexPage(){

        //top destinations
        List<TopDestinationModel> topDestinationModelList = addressService.getTopDestinations();

//        return new ModelAndView("index-old");
        return new ModelAndView("index")
                .addObject("newsletter", new NewsletterModel())
                .addObject("topDestinationModels", topDestinationModelList);
    }
}
