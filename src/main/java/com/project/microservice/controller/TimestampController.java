package com.project.microservice.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dto.TimestampDTO;
import utils.DateValidator;
import utils.DateValidatorUsingLocalDate;

@RestController
public class TimestampController {

    @GetMapping("/api/timestamp/{time}")
    public TimestampDTO getTimestamp(@PathVariable(value = "time") String time) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);
        if (validator.isValid(time)) {
            LocalDate localDate = LocalDate.parse(time, DateTimeFormatter.ISO_LOCAL_DATE);
            ZoneId zoneId = ZoneId.of("UTC");
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
            return new TimestampDTO(zonedDateTime.toEpochSecond(), zonedDateTime.toString());
        } else {
            return new TimestampDTO(System.currentTimeMillis(), "Time is in valid");
        }
    }
}
