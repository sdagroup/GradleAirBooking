package com.sdagroup.gradleairbooking.repository;

import com.sdagroup.gradleairbooking.entity.AddressEntity;
import com.sdagroup.gradleairbooking.model.TopDestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ryan Alexander on 08/01/2019.
 */
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    // We will find 'room' only through property
    @Query("select new com.sdagroup.gradleairbooking.model.TopDestinationModel(" +
            "count(distinct a.room.property),a.city,a.country) " +
            "from AddressEntity a group by a.city, a.country order by count(distinct a.room.property) desc")
    List<TopDestinationModel> findTopDestinations();
}