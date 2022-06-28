package com.mediscreen.AssessApp.controller;


import com.mediscreen.AssessApp.controller.domain.Patient;
import com.mediscreen.AssessApp.controller.domain.PatientInfos;
import com.mediscreen.AssessApp.controller.domain.PatientReport;
import com.mediscreen.AssessApp.proxy.NoteAppProxy;
import com.mediscreen.AssessApp.proxy.PatientAppProxy;
import com.mediscreen.AssessApp.service.AssessRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssessController {

    @Autowired
    PatientAppProxy patientAppProxy;

    @Autowired
    NoteAppProxy noteAppProxy;

    @Autowired
    AssessRiskService assessRiskService;


    @GetMapping("/assess/{id}")
    public PatientReport getPatientReport(@PathVariable Integer id){
        Patient      patient = patientAppProxy.getPatientById(id);
        List<String> notes   = noteAppProxy.getNotesById(id);
        return assessRiskService.calculatePatientRisk(patient, notes);
    }

    @GetMapping("/home")
    public String sayHello(){
        System.out.println("Hello world !" );
        return "hello world! ";
    }


}
