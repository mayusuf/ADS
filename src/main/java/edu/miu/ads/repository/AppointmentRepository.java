package edu.miu.ads.repository;

import edu.miu.ads.domain.Address;
import edu.miu.ads.domain.Appointment;
import edu.miu.ads.domain.Dentist;
import edu.miu.ads.domain.Patient;
import edu.miu.ads.domain.Surgery;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {
    private final List<Appointment> appointments;

    public AppointmentRepository() {
        this.appointments = loadAppointments();
    }

    public List<Appointment> findAll() {
        return new ArrayList<>(appointments);
    }

    private List<Appointment> loadAppointments() {
        Address fairfieldAddress = new Address("1000 N 4th St", "Fairfield", "IA", "52557");
        Address ottumwaAddress = new Address("221 E Main St", "Ottumwa", "IA", "52501");

        Dentist dentistOne = new Dentist(1, "Helen", "Morgan", "helen.morgan@adsdental.com");
        Dentist dentistTwo = new Dentist(2, "James", "Patel", "james.patel@adsdental.com");

        Surgery surgeryOne = new Surgery(1, "ADS Dental Fairfield", "(641) 472-7000", fairfieldAddress);
        Surgery surgeryTwo = new Surgery(2, "ADS Dental Ottumwa", "(641) 682-7000", ottumwaAddress);

        return List.of(
                new Appointment(
                        1,
                        LocalDate.of(2026, 2, 28),
                        LocalTime.of(10, 5),
                        LocalDate.of(2025, 12, 15),
                        new Patient(
                                1,
                                "John",
                                "Smith",
                                "(641) 001-1234",
                                LocalDate.of(1987, 1, 19),
                                new Address("415 W Broadway Ave", "Fairfield", "IA", "52556")
                        ),
                        dentistOne,
                        surgeryOne
                ),
                new Appointment(
                        2,
                        LocalDate.of(2025, 12, 31),
                        LocalTime.of(13, 45),
                        LocalDate.of(2025, 11, 20),
                        new Patient(
                                2,
                                "Anna",
                                "Jones",
                                "(319) 716-1987",
                                LocalDate.of(2001, 7, 26),
                                new Address("809 N Court St", "Iowa City", "IA", "52245")
                        ),
                        dentistTwo,
                        surgeryTwo
                ),
                new Appointment(
                        3,
                        LocalDate.of(2027, 5, 4),
                        LocalTime.of(14, 0),
                        LocalDate.of(2026, 12, 5),
                        new Patient(
                                3,
                                "Carlos",
                                "Jimenez",
                                "(319) 098-7711",
                                LocalDate.of(1969, 11, 5),
                                new Address("120 Maple Dr", "Cedar Rapids", "IA", "52401")
                        ),
                        dentistOne,
                        surgeryTwo
                ),
                new Appointment(
                        4,
                        LocalDate.of(2026, 9, 16),
                        LocalTime.of(11, 15),
                        LocalDate.of(2026, 6, 1),
                        new Patient(
                                4,
                                "Albert",
                                "Einstein",
                                "(641) 119-6142",
                                LocalDate.of(1955, 12, 28),
                                new Address("12 Science Way", "Fairfield", "IA", "52556")
                        ),
                        dentistTwo,
                        surgeryOne
                )
        );
    }
}
