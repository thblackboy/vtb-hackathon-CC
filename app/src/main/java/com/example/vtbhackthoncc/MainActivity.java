package com.example.vtbhackthoncc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    private UserGameData playerData = new UserGameData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if ((UserGameData.readFromFile(this) != null)) {
            playerData.setNickname(getIntent().getStringExtra("nickname"));
            playerData.setDateOfBirth(getIntent().getStringExtra("dateOfBirth"));
            playerData.setRegistrationStatus(getIntent().getBooleanExtra("registrationStatus", false));
            if(playerData.isRegistrationStatus()) playerData.saveToFile(this);
            playerData = UserGameData.readFromFile(this);
            if(!playerData.isRegistrationStatus()){
                Intent intent = new Intent(MainActivity.this, WelcomeScreen.class);
                startActivity(intent);
            }
        } else {
            playerData.saveToFile(this);
            Intent intent = new Intent(MainActivity.this, WelcomeScreen.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        playerData.saveToFile(this);
    }
    @Override
    protected void onResume(){
        super.onResume();
        if ((UserGameData.readFromFile(this) != null)) {
            playerData = UserGameData.readFromFile(this);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        playerData.saveToFile(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        playerData.saveToFile(this);
    }

    @Override
    public void onBackPressed() {
    }
}