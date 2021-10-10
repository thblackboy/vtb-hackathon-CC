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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class FirebaseDatabaseHelper {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ArrayList<User> users = new ArrayList<>();

    public FirebaseDatabaseHelper() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");
    }

    public boolean addUser(User ourUser, Context context) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                byte nameTaken = 47;
                User user = new User();
                for (DataSnapshot node : snapshot.getChildren()) {
                    user = node.getValue(User.class);
                    if (user.getNickname().equals(ourUser.getNickname())){
                        Toast.makeText(context, "Имя пользователя занято.", Toast.LENGTH_SHORT);
                        nameTaken = 45;
                        break;
                    }
                }
                if (nameTaken == 47) {
                    String key = databaseReference.push().getKey();
                    databaseReference.child(key).setValue(ourUser);
                }

                try {
                    String filename = "kek.data";
                    FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
                    fos.write(nameTaken);
                    fos.close();
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
        int nameTaken = 46;
        String filename = "kek.data";
        FileInputStream fin = null;
        try {
            fin = context.openFileInput(filename);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            nameTaken = bytes[0] - 45;
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("nameTaken " + nameTaken);
        return nameTaken != 1;
    }

    public void updateUser(User ourUser, Context context) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users.clear();
                for (DataSnapshot node : snapshot.getChildren()) {
                    User user = node.getValue(User.class);
                    if (user.getNickname().equals(ourUser.getNickname())){
                        databaseReference.child(node.getKey()).setValue(user);
                    }
                    else {
                        Toast.makeText(context, "Ошибка изменения данных.", Toast.LENGTH_SHORT);
                    }
                }
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
