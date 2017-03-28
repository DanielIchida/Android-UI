package com.example.daniel.introapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.daniel.introapp.util.PreferencesManager;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void regresarIntro(View view){
        PreferencesManager prefManager = new PreferencesManager(this);
        prefManager.setPrimeraEjecucion(true);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
