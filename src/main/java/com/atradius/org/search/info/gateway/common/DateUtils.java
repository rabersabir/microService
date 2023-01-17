package com.atradius.org.search.info.gateway.common;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private final static DateTimeFormatter defaultDateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");



    public static String getDateTimeAsString() {


        return getDateTimeAsString(LocalDateTime.now(),defaultDateTimeFormatter );
    }

    private static String getDateTimeAsString(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return  localDateTime.format(defaultDateTimeFormatter);

    }

}
