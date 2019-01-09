package com.sdagroup.gradleairbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan Alexander on 09/01/2019.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyModel {

//    To produce the results html page
    private Long propertyId;
    private String propertyName;
    private String propertyDescription;
    private BigDecimal startsFrom;
    private String resultPageImageUrl;
    private List<String> mediaLinks;


    private List<AddressModel> addresses=new ArrayList<>();
    private List<RoomModel> rooms = new ArrayList<>();
}
