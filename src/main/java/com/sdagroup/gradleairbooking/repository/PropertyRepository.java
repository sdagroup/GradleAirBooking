package com.sdagroup.gradleairbooking.repository;

import com.sdagroup.gradleairbooking.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ryan Alexander on 09/01/2019.
 */
@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
}
