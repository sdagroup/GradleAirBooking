package com.sdagroup.gradleairbooking.service;

import com.sdagroup.gradleairbooking.converter.SimpleEntityToModelConverter;
import com.sdagroup.gradleairbooking.entity.AddressEntity;
import com.sdagroup.gradleairbooking.entity.PropertyEntity;
import com.sdagroup.gradleairbooking.model.PropertyModel;
import com.sdagroup.gradleairbooking.model.SearchPropertyModel;
import com.sdagroup.gradleairbooking.repository.CustomPropertyRepository;
import com.sdagroup.gradleairbooking.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sdagroup.gradleairbooking.repository.specification.PropertySpecification.prepareSearchPropertyQuery;

/**
 * Created by Ryan Alexander on 09/01/2019.
 */
@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private SimpleEntityToModelConverter simpleEntityToModelConverter;

    @Autowired
    private CustomPropertyRepository customPropertyRepository;


    public PropertyModel getPropertyByPropertyIdAndAddressId(final Long propertyId, final Long addressId) {
        Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyId);

        if (propertyEntity.isPresent()) {
            return simpleEntityToModelConverter.getPropertyByPropertyIdAndAddressId(propertyEntity.get(), addressId);
        } else {
            throw new NullPointerException("You haven't selected a property");
        }
    }

    public List<PropertyModel> getAllProperties() {
        return simpleEntityToModelConverter.propertyEntitiesToModels(propertyRepository.findAll());
    }

    public Page<PropertyModel> getSearchedProperties(final SearchPropertyModel searchPropertyModel) {

        // returns one specification and one hibernation query
        List<AddressEntity> addressEntities = customPropertyRepository
                .findAll(prepareSearchPropertyQuery(searchPropertyModel));

        List<PropertyModel> propertyModels = simpleEntityToModelConverter
                .addressEntitiesToPropertyModels(addressEntities);

        return new PageImpl<>(propertyModels, PageRequest.of(0, 10), propertyModels.size());
    }

}
