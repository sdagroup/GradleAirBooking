package com.sdagroup.gradleairbooking.service;

import com.sdagroup.gradleairbooking.entity.NewsletterEntity;
import com.sdagroup.gradleairbooking.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ryan Alexander on 19/12/2018.
 */

@Service
public class NewsletterService {

    @Autowired
    private NewsletterRepository newsletterRepository;

    public void insertNewsLetter(final String email){
        // updating and saving
        newsletterRepository.save(NewsletterEntity.builder().email(email).build());
    }
}
