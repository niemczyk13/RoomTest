package com.example.roomtest.database;

import androidx.room.TypeConverter;

import com.example.roomtest.model.RisingSound;
import com.example.roomtest.model.datetime.DayOfWeek;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Calendar.*;

public class Converts {
    @TypeConverter
    public static int risingSoundToInt(RisingSound risingSound) {
        return risingSound == null ? 0 : risingSound.getTime();
    }

    @TypeConverter
    public static RisingSound risingSoundFromInt(int time) {
        return new RisingSound(time);
    }

    @TypeConverter
    public static Long calendarToLong(Calendar calendar) {
        return calendar == null ? null : calendar.getTimeInMillis();
    }

    @TypeConverter
    public static Calendar calendarFromLong(Long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar;
    }

    @TypeConverter
    public static String daysToList(Map<DayOfWeek, Boolean> days) {
        List<Boolean> list = new ArrayList<>();
        list.add(days.get(DayOfWeek.MONDAY));
        list.add(days.get(DayOfWeek.THURSDAY));
        list.add(days.get(DayOfWeek.WEDNESDAY));
        list.add(days.get(DayOfWeek.THURSDAY));
        list.add(days.get(DayOfWeek.FRIDAY));
        list.add(days.get(DayOfWeek.SATURDAY));
        list.add(days.get(DayOfWeek.SUNDAY));

        for (Boolean bool : days.values()) {
            System.out.println("Bool1: " + bool);
        }

        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println("JSON: " + json);
        return json;
    }

    @TypeConverter
    public static Map<DayOfWeek, Boolean> daysForList(String json) {
        Type listType = new TypeToken<ArrayList<Boolean>>() {}.getType();

        List<Boolean> list = new Gson().fromJson(json, listType);

        Map<DayOfWeek, Boolean> days = new HashMap<>();
        days.put(DayOfWeek.MONDAY, list.get(0));
        days.put(DayOfWeek.TUESDAY, list.get(0));
        days.put(DayOfWeek.WEDNESDAY, list.get(0));
        days.put(DayOfWeek.THURSDAY, list.get(0));
        days.put(DayOfWeek.FRIDAY, list.get(0));
        days.put(DayOfWeek.SATURDAY, list.get(0));
        days.put(DayOfWeek.SUNDAY, list.get(0));

        for (Boolean bool : list) {
            System.out.println("Bool: " + bool);
        }
        return days;
    }
}
