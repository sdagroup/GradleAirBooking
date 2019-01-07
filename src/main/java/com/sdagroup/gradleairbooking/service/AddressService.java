package com.sdagroup.gradleairbooking.service;

import com.sdagroup.gradleairbooking.model.TopDestinationModel;
import com.sdagroup.gradleairbooking.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ryan Alexander on 07/01/2019.
 */

@Service

public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<TopDestinationModel> getTopDestinations(){
        //return addressRepository.findTopDestinations();


        // ternary notation usage, which is better. It's like an 'If Else' statement but better for our situation
        List<TopDestinationModel> topDestinationModels = addressRepository.findTopDestinations();
        // remember this from Codecademy lessons!
                return topDestinationModels.size()> 8 ? topDestinationModels.subList(0,7) : topDestinationModels;
    }
}
