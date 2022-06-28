package com.mediscreen.AssessApp.controller.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
public class PatientReport {

    private String firstname;

    private String lastname;

    private int age;

    private String sex;

    private String address;

    private String phoneNumber;
    private String riskLevel;

    public PatientReport(Patient patient, String riskLevel) {
        this.firstname = patient.getFirstname();
        this.lastname = patient.getLastname();
        this.age =  Period.between(patient.getDateOfBorn(), LocalDate.now()).getYears();
        this.sex = patient.getSex();
        this.address = patient.getAddress();
        this.phoneNumber = patient.getPhoneNumber();
        this.riskLevel = riskLevel;
    }

    public PatientReport() {

    }
}
