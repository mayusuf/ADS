package edu.miu.ads.util;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    public int calculateAge(LocalDate dateOfBirth, LocalDate currentDate) {
        if (dateOfBirth == null || currentDate == null) {
            throw new IllegalArgumentException("Date of birth and current date are required.");
        }
        return Period.between(dateOfBirth, currentDate).getYears();
    }
}
