package com.sdagroup.gradleairbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ryan Alexander on 11/01/2019.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MediaModel {

    private Long mediaId;

    private String mediaUrl;

    private PropertyModel propertyModel;
}
