package edu.wgu.d387_sample_code.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class TimeConverter {
    public static String convertTime(LocalTime time, String fromZone, String toZone){
        ZonedDateTime zdtFrom = time.atDate(java.time.LocalDate.now()).atZone(ZoneId.of(fromZone));
        ZonedDateTime zdtTo = zdtFrom.withZoneSameInstant(ZoneId.of(toZone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return zdtTo.format(formatter);
    }
}
