package com.sdagroup.gradleairbooking.repository;

import com.sdagroup.gradleairbooking.entity.AddressEntity;
import com.sdagroup.gradleairbooking.model.TopDestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Ryan Alexander on 07/01/2019.
 */
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    @Query("select new com.sdagroup.gradleairbooking.model.TopDestinationModel(count(a.city),a.city,a.country) " +
    "from AddressEntity a group by a.city,a.country order by count(a.city) desc")
            List<TopDestinationModel> findTopDestinations();
}

