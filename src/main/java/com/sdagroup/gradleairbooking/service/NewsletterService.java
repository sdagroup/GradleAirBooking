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


    // our converter class from entity to model
    public List<NewsletterModel> getAllNewsletters() {
        List<NewsletterEntity> newsletterEntities = newsletterRepository.findAll();

//        // non lambda for loop version
//        List<NewsletterModel> newsletterModels1 = new ArrayList<>();
//        for(NewsletterEntity newsletterEntity: newsletterEntities){
//            NewsletterModel newsletterModel = new NewsletterModel();
//            newsletterModel.setId(newsletterEntity.getId());
//            newsletterModel.setEmail(newsletterEntity.getEmail());
//            newsletterModel.setCreatedAt(newsletterEntity.getCreatedAt());
//            newsletterModels1.add(newsletterModel);
//        }

        // lambda Java8 expression instead of needing to use a for loop
        List<NewsletterModel> newsletterModels =
                newsletterEntities.stream()
                        .map(newsletterEntityToModelConverter::toModel)
                        .collect(Collectors.toList());
        return newsletterModels;
    }

    public NewsletterModel findById (final Long id) {
        NewsletterEntity newsletterEntity = newsletterRepository.getOne(id);
        return newsletterEntityToModelConverter.toModel(newsletterEntity);
    }



}

