package com.mediscreen.AssessApp.controller.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Patient {

    private Integer id;


    private String firstname;


    private String lastname;

    private LocalDate dateOfBorn;

    private String sex;

    private String address;

    private String phoneNumber;

    private String family;

    private String given;



    public Patient() {
    }
    public Patient(String family, String given, LocalDate dateOfBorn, String sex, String address, String phoneNumber) {
        this.family      = family;
        this.given       = given;
        this.dateOfBorn  = dateOfBorn;
        this.sex         = sex;
        this.address     = address;
        this.phoneNumber = phoneNumber;
    }
}
