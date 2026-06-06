package edu.miu.ads.service;

import edu.miu.ads.domain.Appointment;
import edu.miu.ads.dto.AppointmentResponseDTO;
import edu.miu.ads.repository.AppointmentRepository;
import edu.miu.ads.util.AgeCalculator;
import edu.miu.ads.util.QuarterCalculator;
import edu.miu.ads.util.QuarterCalculator.QuarterRange;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AgeCalculator ageCalculator;
    private final QuarterCalculator quarterCalculator;

    public AppointmentService(AppointmentRepository appointmentRepository, AgeCalculator ageCalculator,
                              QuarterCalculator quarterCalculator) {
        this.appointmentRepository = appointmentRepository;
        this.ageCalculator = ageCalculator;
        this.quarterCalculator = quarterCalculator;
    }

    public List<AppointmentResponseDTO> getAllAppointments(LocalDate currentDate) {
        return appointmentRepository.findAll().stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate)
                        .thenComparing(Appointment::getAppointmentTime)
                        .reversed())
                .map(appointment -> toResponseDTO(appointment, currentDate))
                .toList();
    }

    public List<AppointmentResponseDTO> getNextQuarterUpcomingAppointments(LocalDate currentDate) {
        QuarterRange nextQuarterRange = quarterCalculator.calculateNextQuarterRange(currentDate);

        return appointmentRepository.findAll().stream()
                .filter(appointment -> isWithinRange(appointment.getAppointmentDate(), nextQuarterRange))
                .sorted(Comparator.comparing(Appointment::getAppointmentDate)
                        .thenComparing(Appointment::getAppointmentTime))
                .map(appointment -> toResponseDTO(appointment, currentDate))
                .toList();
    }

    private boolean isWithinRange(LocalDate appointmentDate, QuarterRange quarterRange) {
        return !appointmentDate.isBefore(quarterRange.startDate())
                && !appointmentDate.isAfter(quarterRange.endDate());
    }

    private AppointmentResponseDTO toResponseDTO(Appointment appointment, LocalDate currentDate) {
        return new AppointmentResponseDTO(
                appointment.getAppointmentId(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                appointment.getPatient(),
                ageCalculator.calculateAge(appointment.getPatient().getDateOfBirth(), currentDate),
                appointment.getDentist(),
                appointment.getSurgery()
        );
    }
}
