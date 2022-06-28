package com.mediscreen.AssessApp.controller.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PatientInfos {

    private Integer id;

    private String firstname;

    private String lastname;

    private LocalDate dateOfBorn;

    private String sex;

    private String address;

    private String phoneNumber;

    private String family;

    private String given;

    private List<String> notes;
}
