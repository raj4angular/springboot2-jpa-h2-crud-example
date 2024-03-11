package net.guides.springboot2.springboot2jpacrudexample.model;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Time {

    private Integer timeId;
    private String time;

    public Time(Integer timeId, String time) {
        this.timeId = timeId;
        this.time = time;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public static void main(String[] args) {
        ZoneId istZoneId = ZoneId.of("Asia/Kolkata");
        LocalDate lt = LocalDate.now(istZoneId);
        String strToday = lt.toString();
        System.out.println("lt=>"+lt);
        System.out.println("strToday=>"+strToday);
    }



}
