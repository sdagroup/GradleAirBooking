package com.sdagroup.gradleairbooking.service;

import com.sdagroup.gradleairbooking.entity.NewsletterEntity;
import com.sdagroup.gradleairbooking.repositories.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {

    @Autowired
    private NewsletterRepository newsletterRepository;

    public void insertNewsletter(final String email){
        newsletterRepository.save(NewsletterEntity
                .builder()
                .email(email)
                .build());
    }
}
