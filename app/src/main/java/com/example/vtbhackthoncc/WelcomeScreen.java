package com.example.vtbhackthoncc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class WelcomeScreen extends AppCompatActivity {
    private Button goNext;
    private EditText inputNameAge;
    private TextView invitationToAction;
    private int step = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
        goNext = findViewById(R.id.goNext);
        inputNameAge = findViewById(R.id.inputNameAge);
        invitationToAction = findViewById(R.id.invitationToAction);

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputNameAge.getText().toString().trim().equals(""))
                    Toast.makeText(WelcomeScreen.this, R.string.no_user_input, Toast.LENGTH_SHORT).show();
                else{
                    //name/age_getter
                    if (step == 0) {
                        invitationToAction.setText(R.string.input_age);
                        inputNameAge.clearComposingText();
                        inputNameAge.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                        inputNameAge.setText(R.string.hint_age);
                        goNext.setText(R.string.done);
                        step++;
                    } else {
                        Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}