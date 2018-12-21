package com.sdagroup.gradleairbooking.repository;

import com.sdagroup.gradleairbooking.entity.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Ryan Alexander on 19/12/2018.
 */

@Repository
// each repo needs its own entity
public interface NewsletterRepository extends JpaRepository<NewsletterEntity, Long> {

    /*
    equivalent of SQL query
    select * from news letter... email
    It will try to generate our custom query
     */
    Optional<NewsletterEntity> findByEmail(final String email);
}
