package edu.miu.ads.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.annotation.JsonFormat;
import edu.miu.ads.repository.AppointmentRepository;
import edu.miu.ads.service.AppointmentService;
import edu.miu.ads.util.AgeCalculator;
import edu.miu.ads.util.QuarterCalculator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ADSApp {
    private final AppointmentService appointmentService;
    private final ObjectMapper objectMapper;
    private final Scanner scanner;

    public ADSApp(AppointmentService appointmentService, ObjectMapper objectMapper, Scanner scanner) {
        this.appointmentService = appointmentService;
        this.objectMapper = objectMapper;
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.configOverride(LocalDate.class)
                .setFormat(JsonFormat.Value.forPattern("yyyy-MM-dd"));
        objectMapper.configOverride(LocalTime.class)
                .setFormat(JsonFormat.Value.forPattern("h:mm a"));

        AppointmentService appointmentService = new AppointmentService(
                new AppointmentRepository(),
                new AgeCalculator(),
                new QuarterCalculator()
        );

        new ADSApp(appointmentService, objectMapper, new Scanner(System.in)).run();
    }

    public void run() {
        String option;
        do {
            printMenu();
            option = scanner.nextLine().trim();
            handleOption(option);
        } while (!"0".equals(option));
    }

    private void printMenu() {
        System.out.println("=================================");
        System.out.println("ADS Dental Appointment System");
        System.out.println("=================================");
        System.out.println();
        System.out.println("1. Display All Appointments");
        System.out.println("2. Display Quarterly Upcoming Appointments");
        System.out.println("0. Exit");
        System.out.println();
        System.out.print("Select Option: ");
    }

    private void handleOption(String option) {
        try {
            switch (option) {
                case "1" -> printJson(appointmentService.getAllAppointments(LocalDate.now()));
                case "2" -> printJson(appointmentService.getNextQuarterUpcomingAppointments(LocalDate.now()));
                case "0" -> System.out.println("Goodbye.");
                default -> System.out.println("Invalid option. Please select 1, 2, or 0.");
            }
        } catch (Exception exception) {
            System.out.println("Unable to process request: " + exception.getMessage());
        }
        System.out.println();
    }

    private void printJson(Object value) throws Exception {
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(value));
    }
}
