package com.sdagroup.gradleairbooking.repository;

import com.sdagroup.gradleairbooking.entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ryan Alexander on 19/12/2018.
 */

@Repository
// each repo needs its own entity
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {
}
