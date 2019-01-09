package com.sdagroup.gradleairbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by Ryan Alexander on 09/01/2019.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomModel {

    private Long roomId;
    private String roomName;
    private String includes;
    private int maximumPerson;
    private BigDecimal pricePerNight;
    private PropertyModel propertyModel;
}
