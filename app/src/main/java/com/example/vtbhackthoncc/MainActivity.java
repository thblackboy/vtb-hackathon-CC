package com.example.vtbhackthoncc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    private UserGameData playerData = new UserGameData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playerData = UserGameData.readFromFile(this);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onPause(){
        super.onPause();
        playerData.saveToFile(this);
    }
    @Override
    protected void onResume(){
        super.onResume();
        playerData = UserGameData.readFromFile(this);
    }
}