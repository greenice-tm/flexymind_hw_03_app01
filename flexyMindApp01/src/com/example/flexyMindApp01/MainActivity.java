package com.example.flexyMindApp01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {

    private static final int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    private static final int matchParent = LinearLayout.LayoutParams.MATCH_PARENT;
    private static final String REGISTRATION = "Регистрация";
    private static final String EXIT = "Выход";
    private static final int REGISTRATION_TAG  = 0;
    private static final int EXIT_TAG = 1;
    private static final int REGISTRATION_ACTIVITY = 1;

    LinearLayout linLayout;
    LinearLayout.LayoutParams linLayoutParam, lpView;
    Button registration;
    Button  exit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        linLayout = new LinearLayout(this);
        linLayout.setOrientation(LinearLayout.VERTICAL);
        linLayoutParam = new LinearLayout.LayoutParams(matchParent, matchParent);
        setContentView(linLayout, linLayoutParam);

        lpView = new LinearLayout.LayoutParams(matchParent, wrapContent);
        registration = new Button(this);
        registration.setText(REGISTRATION);
        registration.setId(REGISTRATION_TAG);
        registration.setGravity(Gravity.CENTER);
        linLayout.addView(registration, lpView);
        registration.setOnClickListener(this);

        exit = new Button(this);
        exit.setText(EXIT);
        exit.setId(EXIT_TAG);
        exit.setGravity(Gravity.CENTER);
        linLayout.addView(exit, lpView);
        exit.setOnClickListener(this);
    }

    public void onClick(View v) {
         switch (v.getId()){
             case REGISTRATION_TAG:
                 Intent intent = new Intent(this, RegistrationActivity.class);
                 startActivityForResult(intent, REGISTRATION_ACTIVITY);
                 break;
             case EXIT_TAG:
                 finish();
                 break;
         }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REGISTRATION_ACTIVITY) {
            if(data != null) {
                if(resultCode == RESULT_OK) {

                } else {

                }
            }
        }
    }
}
