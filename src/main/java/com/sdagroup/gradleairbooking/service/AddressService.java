package com.sdagroup.gradleairbooking.service;

import com.sdagroup.gradleairbooking.model.TopDestinationModel;
import com.sdagroup.gradleairbooking.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ryan Alexander on 08/01/2019.
 */
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // protection for private fields
    public AddressService(final AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<TopDestinationModel> getTopDestinations() {
        List<TopDestinationModel> topDestinationModels = addressRepository.findTopDestinations();
        return topDestinationModels.size() > 8 ? topDestinationModels.subList(0, 8) : topDestinationModels;
    }

}
