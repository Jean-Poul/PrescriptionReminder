package cph.databases.assignment.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helepr {

    // Date formatter
    public String formattingDate (LocalDateTime myDateObj) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return myDateObj.format(myFormatObj);
    }
}
