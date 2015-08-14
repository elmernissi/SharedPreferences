package com.tutorial.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText usernameInput;
    EditText passwordInput;

    private static Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput =(EditText)findViewById(R.id.usernameInput);
        passwordInput =(EditText)findViewById(R.id.passwordInput);


    }

     //save the users login info
    public void saveInfo(View view){


        switchButton = (Button)findViewById(R.id.SaveInfoButton);
        switchButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent =  new Intent("com.tutorial.sharedpreferences.DisplayInfo");
                        startActivity(intent);

                        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE); //créer fichier userInfo pour stocker les infos
                        SharedPreferences.Editor editor = sharedPref.edit(); // objet qui permet d'editer le ficher userInfo
                        editor.putString("username",usernameInput.getText().toString()); //copier la valeur username dans userInfo
                        editor.putString("password",passwordInput.getText().toString());
                        editor.apply();
                    }
                }
        );


    }


}
