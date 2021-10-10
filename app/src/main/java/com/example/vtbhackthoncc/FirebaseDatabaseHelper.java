package com.example.vtbhackthoncc;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class FirebaseDatabaseHelper {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ArrayList<User> users = new ArrayList<>();
    private boolean nameTaken = false;

    public FirebaseDatabaseHelper() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");
    }

    public void addUser(User ourUser, Context context) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = new User();
                boolean nameTaken = false;
                for (DataSnapshot node : snapshot.getChildren()) {
                    user = node.getValue(User.class);
                    if (user.getNickname().equals(ourUser.getNickname())){
                        Toast.makeText(context, "Имя пользователя занято.", Toast.LENGTH_SHORT);
                        nameTaken = true;
                        break;
                    }
                }
                    if(!nameTaken) {
                        String key = databaseReference.push().getKey();
                        databaseReference.child(key).setValue(ourUser);
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    public void updateUser(User ourUser, Context context) {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users.clear();
                String key = "";
                for (DataSnapshot node : snapshot.getChildren()) {
                    User user = node.getValue(User.class);
                    if (user.getNickname().equals(ourUser.getNickname())){
                        key = node.getKey();
                        databaseReference.child(key).removeValue();
                        break;
                    }
                    else {
                        Toast.makeText(context, "Ошибка изменения данных.", Toast.LENGTH_SHORT);
                    }
                }
                databaseReference.child(key).setValue(ourUser);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }


    public void makeUsersTop(UsersTopAdapter usersTopAdapter) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users.clear();
                for (DataSnapshot node : snapshot.getChildren()) {
                    User user = node.getValue(User.class);
                    users.add(user);
                }

                Collections.sort(users, new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        if (o1.getSkill() > o2.getSkill()) {
                            return -1;
                        }
                        else if (o1.getSkill() < o2.getSkill()) {
                            return 1;
                        }
                        return 0;
                    }
                });
                if (usersTopAdapter != null) {
                    usersTopAdapter.setItems(users);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
}
