package com.example.vtbhackthoncc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class TestDatabase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);
    }

   /* public void push(View view) {
        String nickname = ((EditText) findViewById(R.id.nickname)).getText().toString();
        Long skill = Long.parseLong(((EditText) findViewById(R.id.skill)).getText().toString());
        String phonenumber = ((EditText) findViewById(R.id.phonenumber)).getText().toString();
        String email = ((EditText) findViewById(R.id.email)).getText().toString();

        User user = new User(nickname, skill, phonenumber, email);

        FirebaseDatabaseHelper dbHelper = new FirebaseDatabaseHelper();
        dbHelper.addUser(user, getApplicationContext());
    }*/
}