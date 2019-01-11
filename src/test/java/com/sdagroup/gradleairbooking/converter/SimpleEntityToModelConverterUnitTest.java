package com.sdagroup.gradleairbooking.converter;

import com.sdagroup.gradleairbooking.entity.NewsletterEntity;
import com.sdagroup.gradleairbooking.model.NewsletterModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Ryan Alexander on 11/01/2019.
 */
public class SimpleEntityToModelConverterUnitTest {

    private SimpleEntityToModelConverter simpleEntityToModelConverter;

    @Before
    public void setup() {
        simpleEntityToModelConverter = new SimpleEntityToModelConverter();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void shouldConvertNewsLetterEntityToNewsLetterModel() {
        // given
        NewsletterEntity newsletterEntity = NewsletterEntity.builder().id(1L).email("hi@google.com").build();

        // when
        //// actual suffix used?? because it returns from my system???
        NewsletterModel actualNewsletterModel = simpleEntityToModelConverter.newsletterEntityToModel(newsletterEntity);

        // then
        Assert.assertEquals("hi@google.com", actualNewsletterModel.getEmail());
        //// checking that the id is 1
        Assert.assertEquals(1L, actualNewsletterModel.getId());

    }

    @Test
    public void shouldThrowExceptionWhenNewsLetterEntityIsEmpty() {
        // given

        // when

        // then
    }
}
