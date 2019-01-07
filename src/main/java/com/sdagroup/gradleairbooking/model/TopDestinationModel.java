package com.sdagroup.gradleairbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ryan Alexander on 07/01/2019.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopDestinationModel {
    private long amount;
    private String city;
    private String country;
}
