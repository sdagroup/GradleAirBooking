package com.sdagroup.gradleairbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Ryan Alexander on 09/01/2019.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {

    private Long addressId;
    private String street;
    private String postalCode;
    private String city;
    private String country;
    private RoomModel roomModel;
}
