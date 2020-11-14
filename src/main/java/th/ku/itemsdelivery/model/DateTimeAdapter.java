package th.ku.itemsdelivery.model;

import java.time.LocalDateTime;

public class DateTimeAdapter {
    public DateTimeAdapter() {
    }

    public String changeFormatDateTime(LocalDateTime localDateTime) {
        try {
            return localDateTime.toString().replace("T", " ");
        } catch (NullPointerException e) {
            return "NULL";
        }
    }
}
