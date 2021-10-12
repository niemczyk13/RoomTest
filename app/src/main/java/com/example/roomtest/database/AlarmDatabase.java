package com.example.roomtest.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.roomtest.model.Alarm;

@Database(entities = {Alarm.class}, version = 1, exportSchema = false)
@TypeConverters({Converts.class})
public abstract class AlarmDatabase extends RoomDatabase {
    public abstract AlarmDAO alarmDAO();
}
