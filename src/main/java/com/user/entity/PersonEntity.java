package com.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "person")
public class PersonEntity {
    @Id
    @Column(name = "phoneNumber", length = 15)
    private String phoneNumber;
    @Column(name = "name")
    private String name;
    @JsonIgnore
    @Column(name = "password")
    private String password;
    @CreationTimestamp
    @Column(name = "registrationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp registrationDate;
    @UpdateTimestamp
    @Column(name = "lastUpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp lastUpdateDate;
}
