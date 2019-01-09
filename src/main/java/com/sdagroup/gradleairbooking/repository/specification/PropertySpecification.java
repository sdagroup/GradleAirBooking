package com.sdagroup.gradleairbooking.repository.specification;

import com.sdagroup.gradleairbooking.entity.AddressEntity;
import com.sdagroup.gradleairbooking.entity.PropertyEntity;
import com.sdagroup.gradleairbooking.entity.RoomEntity;
import com.sdagroup.gradleairbooking.model.SearchPropertyModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ryan Alexander on 09/01/2019.
 */
public class PropertySpecification {

    public static Specification<AddressEntity> prepareSearchPropertyQuery(final SearchPropertyModel searchPropertyModel) {
        return new Specification<AddressEntity>() {

            @Override
            public Predicate toPredicate(Root<AddressEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (searchPropertyModel.getDestination() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("city"), searchPropertyModel.getDestination()));
                }

                // getting room entity from property entity
                if (searchPropertyModel.getStartsFrom() != null) {
                    Path<RoomEntity> roomEntityPath = root.get("room");
                    Path<PropertyEntity> propertyEntityPath = roomEntityPath.get("property");
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                            propertyEntityPath.get("startsFrom"), searchPropertyModel.getStartsFrom()));
                }

//                if (searchPropertyModel.getAdults() != 0 && searchPropertyModel.getChildren() != 0) {
//                    Path<RoomEntity> roomEntityPath = root.get("room");
//                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(
//                            roomEntityPath.get("maximumPerson"),
//                            searchPropertyModel.getAdults() + searchPropertyModel.getChildren()));
//                }

                if (searchPropertyModel.getAdults() != 0 || searchPropertyModel.getChildren() != 0) {
                    int amountOfPeople = 0;

                    if (searchPropertyModel.getAdults() != 0) {
                        amountOfPeople += searchPropertyModel.getAdults();
                    }

                    if (searchPropertyModel.getChildren() != 0) {
                        amountOfPeople += searchPropertyModel.getChildren();
                    }

                    Path<RoomEntity> roomEntityPath = root.get("room");
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                            roomEntityPath.get("maximumPerson"), amountOfPeople));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}