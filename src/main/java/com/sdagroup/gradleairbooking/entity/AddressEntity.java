package com.sdagroup.gradleairbooking.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by Ryan Alexander on 08/01/2019.
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@EntityListeners(AuditingEntityListener.class)
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column
    private String street;

    @Column
    private String postalCode;

    @Column
    private String city;

    @Column
    private String country;

    @ManyToOne(targetEntity = PropertyEntity.class)
    @JoinColumn(name = "propertyId", referencedColumnName = "propertyId")
    private PropertyEntity property;


}
