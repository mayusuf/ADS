# ADS Dental Appointment Management System

Java 21 Maven CLI application for displaying dental appointment data as pretty-printed JSON.

## Requirements

- Java 21
- Apache Maven

## Build

From the project root:

```bash
mvn clean package
```

## Run

```bash
java -jar target/ADS-Dental-Appointment-Management-System-1.0.0.jar
```

## Menu Options

```text
=================================
ADS Dental Appointment System
=================================

1. Display All Appointments
2. Display Quarterly Upcoming Appointments
0. Exit

Select Option:
```

- Enter `1` to display all appointments sorted by appointment date and time descending.
- Enter `2` to display appointments in the next quarter sorted by appointment date and time ascending.
- Enter `0` to exit the application.

## Example Quick Run

```bash
printf '1\n2\n0\n' | java -jar target/ADS-Dental-Appointment-Management-System-1.0.0.jar
```

## Container Image

Build the Docker image:

```bash
docker build -t ads-dental-appointment-management-system .
```

Run the CLI in a container:

```bash
docker run --rm -it ads-dental-appointment-management-system
```

Example non-interactive container run:

```bash
printf '1\n2\n0\n' | docker run --rm -i ads-dental-appointment-management-system
```
