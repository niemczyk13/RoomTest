package com.example.roomtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import com.example.roomtest.database.AlarmDAO;
import com.example.roomtest.database.AlarmDatabase;
import com.example.roomtest.model.Alarm;
import com.example.roomtest.model.RisingSound;
import com.example.roomtest.model.datetime.AlarmDateTime;
import com.example.roomtest.model.datetime.DayOfWeek;
import com.example.roomtest.model.datetime.Week;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringBuilder string = new StringBuilder();

        RisingSound risingSound1 = new RisingSound(30);
        Week week1 = new Week();
        week1.activeDay(DayOfWeek.THURSDAY);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2021, 8, 10, 16,35, 0);
        AlarmDateTime alarmDateTime = new AlarmDateTime(calendar1, week1);
        Alarm alarm1 = new Alarm("pierwszy", risingSound1, alarmDateTime);

        string.append("Nazwa: " + alarm1.name + ", risingSound: " + alarm1.risingSound.getTime() + ", data: " + alarm1.alarmDateTime.getDateTime().getTime() + ", Week: " + alarm1.alarmDateTime.getWeek().getDays().values() + '\n');
        RisingSound risingSound2 = new RisingSound(60);
        Week week2 = new Week();
        week2.activeDay(DayOfWeek.THURSDAY);
        week2.activeDay(DayOfWeek.MONDAY);
        Calendar calendar2 = Calendar.getInstance();

        calendar2.set(2021, 1, 10, 12,9, 0);

        AlarmDateTime alarmDateTime2 = new AlarmDateTime(calendar2, week2);

        Alarm alarm2 = new Alarm("drugi", risingSound2, alarmDateTime2);

        AlarmDatabase database = Room.databaseBuilder(getApplicationContext(), AlarmDatabase.class, "nazwa1").allowMainThreadQueries().build();

        AlarmDAO dao = database.alarmDAO();

        //dao.insertAlarm(alarm1);
        dao.insertAlarm(alarm2);

        List<Alarm> list = dao.getAll();
        


        for (Alarm a : list) {
            string.append("Nazwa: " + a.name + ", risingSound: " + a.risingSound.getTime() + ", data: " + a.alarmDateTime.getDateTime().getTime() + ", Week: " + a.alarmDateTime.getWeek().getDays().values() + '\n');

            System.out.println("Nazwa: " + a.name + ", risingSound: " + a.risingSound.getTime());
        }

        TextView tv = findViewById(R.id.text_view);
        tv.setText(string);

    }
}