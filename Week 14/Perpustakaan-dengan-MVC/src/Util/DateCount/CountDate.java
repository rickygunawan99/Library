package Util.DateCount;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CountDate {

    // FORMAT = YYYY-MM-DD
    public static long countYearsBetween(String firstDate, String secondDate){
        LocalDate bef = LocalDate.parse(firstDate);
        LocalDate af = LocalDate.parse(secondDate);
        return ChronoUnit.YEARS.between(bef,af);
    }

    public static long countDaysBetween(String firstDate, String secondDate){
        LocalDate bef = LocalDate.parse(firstDate);
        LocalDate af = LocalDate.parse(secondDate);
        return ChronoUnit.DAYS.between(bef,af);
    }
}
