package com.pakulko.billing.tariff;


import java.sql.Time;
import java.sql.Date;

public class Tariff {
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;

    private String userKey;
    private String metrickKey;
    private Integer daysGroupId;
    private Integer monthNumber;
    private Integer dayNumber;
    private Integer dayOfTheWeekNumber;
    private Double cost;
    private Integer priority;


}
