package edu.miu.ads.dto;

import edu.miu.ads.domain.Dentist;
import edu.miu.ads.domain.Patient;
import edu.miu.ads.domain.Surgery;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentResponseDTO {
    private int appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Patient patient;
    private int patientAge;
    private Dentist dentist;
    private Surgery surgery;

    public AppointmentResponseDTO() {
    }

    public AppointmentResponseDTO(int appointmentId, LocalDate appointmentDate, LocalTime appointmentTime,
                                  Patient patient, int patientAge, Dentist dentist, Surgery surgery) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.patient = patient;
        this.patientAge = patientAge;
        this.dentist = dentist;
        this.surgery = surgery;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }
}
