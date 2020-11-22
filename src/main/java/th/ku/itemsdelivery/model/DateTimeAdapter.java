package th.ku.itemsdelivery.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAdapter {
    public DateTimeAdapter() {
    }

    public String changeFormatDateTime(LocalDateTime localDateTime) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            return localDateTime.format(dateTimeFormatter);
        } catch (NullPointerException e) {
            return "NULL";
        }
    }

    public String changeFormatDate(LocalDateTime localDateTime) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return localDateTime.format(dateTimeFormatter);
        } catch (NullPointerException e) {
            return "NULL";
        }
    }

    public String changeFormatDateSlash(LocalDateTime localDateTime) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return localDateTime.format(dateTimeFormatter);
        } catch (NullPointerException e) {
            return "NULL";
        }
    }
}
