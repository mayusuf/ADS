package edu.miu.ads.util;

import java.time.LocalDate;

public class QuarterCalculator {
    public QuarterRange calculateNextQuarterRange(LocalDate currentDate) {
        if (currentDate == null) {
            throw new IllegalArgumentException("Current date is required.");
        }

        int currentQuarter = ((currentDate.getMonthValue() - 1) / 3) + 1;
        int nextQuarter = currentQuarter == 4 ? 1 : currentQuarter + 1;
        int nextQuarterYear = currentQuarter == 4 ? currentDate.getYear() + 1 : currentDate.getYear();
        int firstMonthOfNextQuarter = ((nextQuarter - 1) * 3) + 1;

        LocalDate startDate = LocalDate.of(nextQuarterYear, firstMonthOfNextQuarter, 1);
        LocalDate endDate = startDate.plusMonths(3).minusDays(1);
        return new QuarterRange(startDate, endDate);
    }

    public record QuarterRange(LocalDate startDate, LocalDate endDate) {
    }
}
