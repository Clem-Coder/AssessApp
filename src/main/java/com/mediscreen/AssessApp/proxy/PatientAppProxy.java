package com.mediscreen.AssessApp.proxy;

import com.mediscreen.AssessApp.controller.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(contextId = "Patient" , name="patientApp", url="http://localhost:8081")
public interface PatientAppProxy {


    @GetMapping("/patient/get/{id}")
    public Patient getPatientById(@PathVariable Integer id);



}
