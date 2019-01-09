package com.sdagroup.gradleairbooking.repository;

import com.sdagroup.gradleairbooking.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Ryan Alexander on 09/01/2019.
 */
public interface CustomPropertyRepository extends PagingAndSortingRepository<AddressEntity, Long>, JpaSpecificationExecutor {
}
