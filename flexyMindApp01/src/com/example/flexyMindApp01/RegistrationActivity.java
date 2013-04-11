package com.example.flexyMindApp01;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.GridLayoutAnimationController;
import android.widget.*;

import java.util.Calendar;

public class RegistrationActivity extends Activity implements OnClickListener {

    private static final int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    private static final int matchParent = LinearLayout.LayoutParams.MATCH_PARENT;
    private static final String NAME  = "Введите Ф.И.О";
    private static final String BIRTHDAY = "Выберите дату рождения";
    private static final String CITY  = "Выберите город";
    private static final String HOBBY = "Ваше хобби";
    private static final String SWIMMING = "Плаванье";
    private static final String RUNNING = "Бег";

    private static final String[] city = {"Санкт- Петербург", "Приозерск", "Петергоф"};

    private LinearLayout linLayout;
    private LinearLayout.LayoutParams linLayoutParam, lpView;
    private TextView nameText, birthDayText, hobbyText, cityText;
    private EditText name;
    private DatePicker birthDay;
    private CheckBox swimming, running;
    private Calendar calendar;

    private int year;
    private int month;
    private int day;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(Configuration.ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        linLayout = new LinearLayout(this);
        linLayout.setOrientation(LinearLayout.VERTICAL);
        linLayoutParam = new LinearLayout.LayoutParams(matchParent, matchParent);
        setContentView(linLayout, linLayoutParam);

        //User Name
        lpView = new LinearLayout.LayoutParams(matchParent, wrapContent);
        nameText = new TextView(this);
        nameText.setText(NAME);
        nameText.setGravity(Gravity.CENTER);
        linLayout.addView(nameText, lpView);

        name = new EditText(this);
        linLayout.addView(name, lpView);

        //User BirthDay
        birthDayText = new TextView(this);
        birthDayText.setText(BIRTHDAY);
        birthDayText.setGravity(Gravity.CENTER);
        linLayout.addView(birthDayText, lpView);

        birthDay = new DatePicker(this);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        birthDay.init(year, month, day, null);
        linLayout.addView(birthDay, lpView);

        //User City
        cityText = new TextView(this);
        cityText.setText(CITY);
        cityText.setGravity(Gravity.CENTER);
        linLayout.addView(cityText, lpView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = new Spinner(this);
        spinner.setAdapter(adapter);
        spinner.setPrompt(CITY);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        linLayout.addView(spinner, lpView);

        //User Hobby
        hobbyText = new TextView(this);
        hobbyText.setText(HOBBY);
        hobbyText.setGravity(Gravity.CENTER);
        linLayout.addView(hobbyText, lpView);

        swimming = new CheckBox(this);
        swimming.setText(SWIMMING);
        running = new CheckBox(this);
        running.setText(RUNNING);

        linLayout.addView(swimming, lpView);
        linLayout.addView(running, lpView);
    }

    public void onClick(View v) {

    }
}
