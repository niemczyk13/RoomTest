package com.example.roomtest.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.roomtest.model.datetime.AlarmDateTime;

@Entity
public class Alarm {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public RisingSound risingSound;
    @Embedded
    public AlarmDateTime alarmDateTime;

    public Alarm(String name, RisingSound risingSound, AlarmDateTime alarmDateTime) {
        this.name = name;
        this.risingSound = risingSound;
        this.alarmDateTime = alarmDateTime;
    }
}
