package th.ku.itemsdelivery.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAdapter {
    public DateTimeAdapter() {
    }

    public String changeFormatDateTime(LocalDateTime localDateTime) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return localDateTime.format(dateTimeFormatter);
        } catch (NullPointerException e) {
            return "NULL";
        }
    }
}
