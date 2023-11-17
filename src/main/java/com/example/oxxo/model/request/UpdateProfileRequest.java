package com.example.oxxo.model.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileRequest {

    private long id;


    private String email;

    private String firstname;

    private String lastname;

    private String country;

    private String state;

    private String address;

    private String phone;


}
