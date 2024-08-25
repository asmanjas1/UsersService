package com.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String locality;
    private String landmark;
    private String city;
    private String state;
    private String pincode;
    private String longitude;
    private String latitude;
    @Column(columnDefinition = "TEXT")
    private String googleObject;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phoneNumber", nullable = false)
    @JsonIgnore
    private PersonEntity personEntity;
}
