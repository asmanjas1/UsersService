package com.user.beans;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String locality;
    private String landmark;
    private String city;
    private String state;
    private String pincode;
    private String longitude;
    private String latitude;
    private String googleObject;
}
