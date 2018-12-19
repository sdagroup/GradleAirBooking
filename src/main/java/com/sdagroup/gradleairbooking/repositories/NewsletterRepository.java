package com.sdagroup.gradleairbooking.repositories;

import com.sdagroup.gradleairbooking.entity.NewsletterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterRepository extends CrudRepository<NewsletterEntity, Long> {

}
