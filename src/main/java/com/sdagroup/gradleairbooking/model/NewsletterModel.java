package com.sdagroup.gradleairbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Ryan Alexander on 20/12/2018.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsletterModel {
    private long id;
    private Date createdAt;
    private String email;
}
