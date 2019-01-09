package com.sdagroup.gradleairbooking.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Ryan Alexander on 08/01/2019.
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="room")
@EntityListeners(AuditingEntityListener.class)

public class RoomEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private  Date modifiedAt;

    private String roomName;

    private int maximumPerson;

    private String includes;

    private BigDecimal pricePerNight;

    @ManyToOne(targetEntity = PropertyEntity.class)
    @JoinColumn(name="propertyId", referencedColumnName = "propertyId")
    private PropertyEntity property;

    @OneToOne(targetEntity = AddressEntity.class, mappedBy = "room", cascade= CascadeType.ALL)
    private AddressEntity address;

}
