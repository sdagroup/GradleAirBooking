package com.sdagroup.gradleairbooking.controller;

import com.sdagroup.gradleairbooking.model.PropertyModel;
import com.sdagroup.gradleairbooking.model.SearchPropertyModel;
import com.sdagroup.gradleairbooking.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Ryan Alexander on 10/01/2019.
 */
@Controller
public class ResultController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/search/{propertyId}")
    public ModelAndView searchPropertyById(@PathVariable("propertyId") Long propertyId) {
        return null;
    }
}
