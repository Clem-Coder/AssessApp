package com.mediscreen.AssessApp.service;

import com.mediscreen.AssessApp.constants.Age;
import com.mediscreen.AssessApp.controller.domain.Patient;
import com.mediscreen.AssessApp.controller.domain.PatientReport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.mediscreen.AssessApp.constants.Triggers;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class AssessRiskService {
    public PatientReport calculatePatientRisk(Patient patient, List<String> notes){

        int numberOfOccurrences = 0;
        int patientAge = Period.between(patient.getDateOfBorn(), LocalDate.now()).getYears();

        for(String note: notes){
            for(String trigger : Triggers.TRIGGERS){
                if(StringUtils.containsIgnoreCase(note, trigger)){
                    numberOfOccurrences++;
                }
            }
        }

        if( patientAge > Age.THIRTY_YEARS_OLD){
            if(numberOfOccurrences >= 2 && numberOfOccurrences <=5){
                return new PatientReport(patient,"Borderline");
            }
            if(numberOfOccurrences >= 6 && numberOfOccurrences <=7){
                return new PatientReport(patient,"In Danger");
            }
            if(numberOfOccurrences >= 8){
                return new PatientReport(patient,"Early onset");
            }
        }
        if(patientAge < Age.THIRTY_YEARS_OLD){
            if(patient.getSex().equals("M")){
                if (numberOfOccurrences >= 3 && numberOfOccurrences <=4 ){
                    return new PatientReport(patient,"In Danger");
                }
                if (numberOfOccurrences == 5 ){
                    return new PatientReport(patient,"Early onset");
                }
            }

            if(patient.getSex().equals("F")){
                if (numberOfOccurrences >= 4 && numberOfOccurrences <= 6 ){
                    return new PatientReport(patient,"In Danger");
                }
                if (numberOfOccurrences == 7 ){
                    return new PatientReport(patient,"Early onset");
                }
            }
        }

        return new PatientReport(patient, "None");
    }



}
