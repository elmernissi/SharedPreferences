package com.tutorial.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class DisplayInfo extends ActionBarActivity {

    TextView displayinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        displayinfo =(TextView)findViewById(R.id.displayTextView);
    }


    public void displayInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username", "");
        String pw = sharedPref.getString("password", "");
        displayinfo.setText(name + " " + pw);
    }
}
