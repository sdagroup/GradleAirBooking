package com.sdagroup.gradleairbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Ryan Alexander on 07/01/2019.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchPropertyModel {
    private Date checkInDate;
    private Date checkOutDate;
    private int rooms;
    private int adults;
    private int children;
    private String destination;
}
