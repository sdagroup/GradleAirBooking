package com.sdagroup.gradleairbooking.service;

import com.sdagroup.gradleairbooking.converter.NewsletterEntityToModelConverter;
import com.sdagroup.gradleairbooking.entity.NewsletterEntity;
import com.sdagroup.gradleairbooking.model.NewsletterModel;
import com.sdagroup.gradleairbooking.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Ryan Alexander on 19/12/2018.
 */

@Service
public class NewsletterService {

    @Autowired
    private NewsletterRepository newsletterRepository;

    @Autowired
    private NewsletterEntityToModelConverter newsletterEntityToModelConverter;

    public void insertNewsLetter(final String email) {
        Optional<NewsletterEntity> newsletterEntity = newsletterRepository.findByEmail(email);

        if (!newsletterEntity.isPresent()) {
            // updating and saving
            newsletterRepository.save(NewsletterEntity.builder().email(email).build());
        }
    }

    public List<NewsletterModel> getAllNewsletters() {
        List<NewsletterEntity> newsletterEntities = newsletterRepository.findAll();
        List<NewsletterModel> newsletterModels =
                newsletterEntities.stream()
                        .map(newsletterEntityToModelConverter::toModel).collect(Collectors.toList());
        return newsletterModels;
    }
}

