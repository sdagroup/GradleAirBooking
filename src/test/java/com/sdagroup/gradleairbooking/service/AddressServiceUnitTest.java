package com.sdagroup.gradleairbooking.service;

import com.sdagroup.gradleairbooking.model.TopDestinationModel;
import com.sdagroup.gradleairbooking.repository.AddressRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by Ryan Alexander on 14/01/2019.
 */

// get the top 8 destinations
public class AddressServiceUnitTest {

    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository = mock(AddressRepository.class);

    // to avoid duplication, we initialise this
    private List<TopDestinationModel> topDestinationModels = new ArrayList<>();

    @Before
    public void setup(){
        for(int i = 10; i >0; i--) {
            TopDestinationModel topDestinationModel = new TopDestinationModel();
            topDestinationModel.setAmount(i);
            topDestinationModel.setCity("City" + i);
            topDestinationModel.setCountry("Country" + i);

            topDestinationModels.add(topDestinationModel);
        }

        addressService = new AddressService(addressRepository);
    }

    @Test
    public void shouldHaveTopDestinations(){
        // given
        Mockito.when(addressRepository.findTopDestinations()).thenReturn(topDestinationModels);

        // when
        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        // then
        //Assert.assertNotNull(topDestinationModels);
        assertNotNull(topDestinationModels);
        assertEquals(8,topDestinationModels.size());
    }

    @Test
    public void shouldHaveSameTopDestinationsWithResultWhenTopDestinationLessThan8(){
        // given
        int actualSize = topDestinationModels.subList(0, 6).size();
        Mockito.when(addressRepository.findTopDestinations()).thenReturn(topDestinationModels.subList(0,6));

        // when
        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        // then
        //Assert.assertNotNull(topDestinationModels);
        assertNotNull(topDestinationModels);
        assertEquals(actualSize,topDestinationModels.size());
    }
}
