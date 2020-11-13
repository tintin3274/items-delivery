package th.ku.itemsdelivery.model;

import java.time.LocalDateTime;

public class DateTimeAdapter {
    public DateTimeAdapter() {
    }

    public String changeFormatDateTime(LocalDateTime localDateTime) {
        return localDateTime.toString().replace("T", " ");
    }
}
