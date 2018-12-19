package com.sdagroup.gradleairbooking.repository;

import com.sdagroup.gradleairbooking.entity.NewsletterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ryan Alexander on 19/12/2018.
 */

@Repository
public interface NewsletterRepository extends CrudRepository<NewsletterEntity, Long> {
}
