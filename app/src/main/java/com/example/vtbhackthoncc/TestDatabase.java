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
        FirebaseDatabaseHelper helper = new FirebaseDatabaseHelper();
        User user = helper.getUser("sus");
        if (user != null) {
            System.out.println(user.getNickname());
            Toast.makeText(getApplicationContext(), user.getNickname() + " " + user.getEmail() + " " + user.getPhoneNumber() + " " + user.getPhoneNumber().toString(), Toast.LENGTH_LONG);
        }



    }

    public void push(View view) {
        String nickname = ((EditText) findViewById(R.id.nickname)).getText().toString();
        Long skill = Long.parseLong(((EditText) findViewById(R.id.skill)).getText().toString());
        String phonenumber = ((EditText) findViewById(R.id.phonenumber)).getText().toString();
        String email = ((EditText) findViewById(R.id.email)).getText().toString();

        User user = new User(nickname, skill, phonenumber, email);

        FirebaseDatabaseHelper dbHelper = new FirebaseDatabaseHelper();
        dbHelper.addUser(user);
    }
}