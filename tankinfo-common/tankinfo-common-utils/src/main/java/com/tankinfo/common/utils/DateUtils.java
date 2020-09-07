package com.tankinfo.common.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Company: TANKINFO 坦克信息
 * @Author: Mr.cyw
 * @Machine: chenyawen
 * @Date: 2020/9/7 4:43 下午
 * @Description: Please Write notes scientifically
 */
public class DateUtils {

    public static String LocalDateTime2String(){
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        return ofPattern.format(localDateTime(Instant.now()));
    }

    public static String LocalDateTime2String(String format){
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(format);
        return ofPattern.format(localDateTime(Instant.now()));
    }

    public static String Date2String(Date date){
        LocalDateTime localDateTime = localDateTime(date.toInstant());
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        return ofPattern.format(localDateTime);
    }

    public static String Date2String(Date date, String format){
        LocalDateTime localDateTime = localDateTime(date.toInstant());
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(format);
        return ofPattern.format(localDateTime);
    }

    public static LocalDateTime String2Date(String time){
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(time, ofPattern);
        return localDateTime;
    }

    public static LocalDateTime String2Date(String time, String format){
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = LocalDateTime.parse(time, ofPattern);
        return localDateTime;
    }


    public static Long String2TimeStamp(String time){
        return String2Date(time).toEpochSecond(ZoneOffset.of("+8"));
    }

    public static Long String2TimeStamp(String time, String format){
        return String2Date(time, format).toEpochSecond(ZoneOffset.of("+8"));
    }

    public static Long timeStamp(){
        return localDateTime(Instant.now()).toEpochSecond(ZoneOffset.of("+8"));
    }

    public static Long timeStamp(Date date) {
        return localDateTime(date.toInstant()).toEpochSecond(ZoneOffset.of("+8"));
    }


    private static LocalDateTime localDateTime(Instant instant){
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }
}
