package com.example.vtbhackthoncc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class UsersTop extends AppCompatActivity {

    private RecyclerView usersTopRecycleView;
    private UsersTopAdapter usersTopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_top);

        initRecyclerView();
    }

    private void initRecyclerView() {
        usersTopRecycleView = findViewById(R.id.users_top_recycler_view);

        usersTopRecycleView.setLayoutManager(new LinearLayoutManager(this));

        usersTopAdapter = new UsersTopAdapter();
        usersTopRecycleView.setAdapter(usersTopAdapter);
        FirebaseDatabaseHelper h = new FirebaseDatabaseHelper();
        h.makeUsersTop(usersTopAdapter);
    }
}