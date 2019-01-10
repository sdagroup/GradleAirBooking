package com.sdagroup.gradleairbooking.controller;

import com.sdagroup.gradleairbooking.model.NewsletterModel;
import com.sdagroup.gradleairbooking.model.PropertyModel;
import com.sdagroup.gradleairbooking.model.SearchPropertyModel;
import com.sdagroup.gradleairbooking.model.TopDestinationModel;
import com.sdagroup.gradleairbooking.service.AddressService;
import com.sdagroup.gradleairbooking.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Ryan Alexander on 02/01/2019.
 */

@Controller
public class IndexController {

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public ModelAndView indexPage() {

        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        return new ModelAndView("index")
                .addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("newsletter", new NewsletterModel())
                .addObject("topDestinationModels", topDestinationModels);
    }

    @GetMapping("/search")
    public ModelAndView searchProperty(@ModelAttribute SearchPropertyModel searchPropertyModel) {

        Page<PropertyModel> propertyModelPage = propertyService.getSearchedProperties(searchPropertyModel);
        return new ModelAndView("/result")
                .addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("propertyModelPage", propertyModelPage);
    }

    @GetMapping("/search/{city}")
    public ModelAndView searchPropertyByCity(@PathVariable("city") String city) {

        return new ModelAndView("result");
    }

}
