package com.sdagroup.gradleairbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by Ryan Alexander on 04/01/2019.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="address")
@EntityListeners(AuditingEntityListener.class)

public class AddressEntity {

    @Id
//    .IDENTITY instead of AUTO because it stops it from creating an additional table
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column
    private String street;

    @Column String postalCode;

    @Column
    private String city;

    @Column
    private String country;

    @ManyToOne(targetEntity = PropertyEntity.class)
    @JoinColumn(name = "propertyId", referencedColumnName = "propertyId")
    private PropertyEntity property;
}
