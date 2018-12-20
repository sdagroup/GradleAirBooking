package com.sdagroup.gradleairbooking.converter;

import com.sdagroup.gradleairbooking.entity.NewsletterEntity;
import com.sdagroup.gradleairbooking.model.NewsletterModel;
import org.springframework.stereotype.Component;

/**
 * Created by Ryan Alexander on 20/12/2018.
 */

@Component
public class NewsletterEntityToModelConverter {

//    // without using Builder
//    public NewsletterModel toModel(final NewsletterEntity newsletterEntity) {
//        NewsletterModel newsletterModel = new NewsletterModel();
//        newsletterModel.setId(newsletterEntity.getId());
//        newsletterModel.setCreatedAt(newsletterEntity.getCreatedAt());
//        newsletterModel.setEmail(newsletterEntity.getEmail());
//        return newsletterModel;
//    }

    // using Builder (preferred)
    public NewsletterModel toModel(final NewsletterEntity newsletterEntity) {
        return NewsletterModel.builder()
                .id(newsletterEntity.getId())
                .createdAt(newsletterEntity.getCreatedAt())
                .email(newsletterEntity.getEmail())
                .build();
    }
}
