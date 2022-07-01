package com.mediscreen.AssessApp;

import com.mediscreen.AssessApp.controller.AssessController;
import com.mediscreen.AssessApp.domain.Patient;
import com.mediscreen.AssessApp.domain.PatientReport;
import com.mediscreen.AssessApp.service.AssessRiskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AssessAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class AssessAppApplicationTests {

	@Autowired
	AssessRiskService assessRiskService;

	@Test
	void assessRiskService_getPatientReportWithRiskLevel_None() {
		Patient  patient = new Patient(LocalDate.ofEpochDay(1990), "M");
		List<String>  notes = new ArrayList<>();
		PatientReport patientReport = assessRiskService.calculatePatientRisk(patient, notes);
		Assertions.assertEquals("None", patientReport.getRiskLevel());
	}

	@Test
	void assessRiskService_getPatientReport_LessThan30YearsOld_Male_WithRiskLevel_InDanger() {
		LocalDate dateOfBorn = LocalDate.of(2000,1,1);
		Patient       patient = new Patient(dateOfBorn, "M");
		List<String>  notes = new ArrayList<>();
		notes.add("Hémoglobine A1C");
		notes.add("Microalbumine");
		notes.add("Taille");
		notes.add("Poids");
		PatientReport patientReport = assessRiskService.calculatePatientRisk(patient, notes);
		Assertions.assertEquals("In Danger", patientReport.getRiskLevel());
	}

	@Test
	void assessRiskService_getPatientReport_LessThan30YearsOld_Male_WithRiskLevel_EarlyOnset()  {
		LocalDate dateOfBorn = LocalDate.of(2000,1,1);
		Patient       patient = new Patient(dateOfBorn, "M");
		List<String>  notes = new ArrayList<>();
		notes.add("Hémoglobine A1C");
		notes.add("Microalbumine");
		notes.add("Taille");
		notes.add("Poids");
		notes.add("Fumeur");
		PatientReport patientReport = assessRiskService.calculatePatientRisk(patient, notes);
		Assertions.assertEquals("Early onset", patientReport.getRiskLevel());
	}

	@Test
	void assessRiskService_getPatientReport_LessThan30YearsOld_Female_WithRiskLevel_InDanger() {
		LocalDate dateOfBorn = LocalDate.of(2000,1,1);
		Patient       patient = new Patient(dateOfBorn, "F");
		List<String>  notes = new ArrayList<>();
		notes.add("Hémoglobine A1C");
		notes.add("Microalbumine");
		notes.add("Taille");
		notes.add("Poids");
		PatientReport patientReport = assessRiskService.calculatePatientRisk(patient, notes);
		Assertions.assertEquals("In Danger", patientReport.getRiskLevel());
	}

	@Test
	void assessRiskService_getPatientReport_LessThan30YearsOld_Female_WithRiskLevel_EarlyOnset()  {
		LocalDate dateOfBorn = LocalDate.of(2000,1,1);
		Patient       patient = new Patient(dateOfBorn, "F");
		List<String>  notes = new ArrayList<>();
		notes.add("Hémoglobine A1C");
		notes.add("Microalbumine");
		notes.add("Taille");
		notes.add("Poids");
		notes.add("Fumeur");
		notes.add("Anormal");
		notes.add("Cholestérol");
		PatientReport patientReport = assessRiskService.calculatePatientRisk(patient, notes);
		Assertions.assertEquals("Early onset", patientReport.getRiskLevel());
	}

	@Test
	void assessRiskService_getPatientReport_MoreThan30YearsOld_WithRiskLevel_Borderline()  {
		LocalDate dateOfBorn = LocalDate.of(1990,1,1);
		Patient       patient = new Patient(dateOfBorn, "F");
		List<String>  notes = new ArrayList<>();
		notes.add("Hémoglobine A1C");
		notes.add("Microalbumine");
		notes.add("Taille");
		notes.add("Poids");
		PatientReport patientReport = assessRiskService.calculatePatientRisk(patient, notes);
		Assertions.assertEquals("Borderline", patientReport.getRiskLevel());
	}

	@Test
	void assessRiskService_getPatientReport_LessThan30YearsOld_WithRiskLevel_InDanger()  {
		LocalDate dateOfBorn = LocalDate.of(1990,1,1);
		Patient       patient = new Patient(dateOfBorn, "F");
		List<String>  notes = new ArrayList<>();
		notes.add("Hémoglobine A1C");
		notes.add("Microalbumine");
		notes.add("Taille");
		notes.add("Poids");
		notes.add("Fumeur");
		notes.add("Anormal");
		notes.add("Cholestérol");
		PatientReport patientReport = assessRiskService.calculatePatientRisk(patient, notes);
		Assertions.assertEquals("In Danger", patientReport.getRiskLevel());
	}

	@Test
	void assessRiskService_getPatientReport_LessThan30YearsOld_WithRiskLevel_EarlyOnset()  {
		LocalDate dateOfBorn = LocalDate.of(1990,1,1);
		Patient       patient = new Patient(dateOfBorn, "F");
		List<String>  notes = new ArrayList<>();
		notes.add("Hémoglobine A1C");
		notes.add("Microalbumine");
		notes.add("Taille");
		notes.add("Poids");
		notes.add("Fumeur");
		notes.add("Anormal");
		notes.add("Cholestérol");
		notes.add("Rechute");
		PatientReport patientReport = assessRiskService.calculatePatientRisk(patient, notes);
		Assertions.assertEquals("Early onset", patientReport.getRiskLevel());
	}








	@Test
	void assessRiskService_getPatientReport_MoreThan30YearsOld_Male_WithRiskLevel_Borderline()  {
		Patient       patient = new Patient(LocalDate.ofEpochDay(1990), "M");
		List<String>  notes = new ArrayList<>();
		notes.add("Hémoglobine A1C");
		notes.add("Microalbumine");
		notes.add("Taille");
		PatientReport patientReport = assessRiskService.calculatePatientRisk(patient, notes);
		Assertions.assertEquals("Borderline", patientReport.getRiskLevel());
	}


}
