package com.sdagroup.gradleairbooking.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ryan Alexander on 10/01/2019.
 */

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="media")
@EntityListeners(AuditingEntityListener.class)

public class MediaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;

    @Column(nullable = false, updatable = false )
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column
    private String mediaUrl;

    @ManyToOne(targetEntity = PropertyEntity.class)
    @JoinColumn(name="propertyId", referencedColumnName = "propertyId")
    private PropertyEntity property;
}
