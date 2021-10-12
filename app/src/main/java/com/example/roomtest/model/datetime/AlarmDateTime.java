package com.example.roomtest.model.datetime;

import androidx.room.Embedded;

import java.util.Calendar;

public class AlarmDateTime {
    private Calendar dateTime;
    @Embedded
    private Week week;

    public AlarmDateTime(Calendar dateTime, Week week) {
        this.dateTime = dateTime;
        this.week = week;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public boolean isSchedule() {
        return week.isSchedule();
    }
}
