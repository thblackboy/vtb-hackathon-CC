package com.example.vtbhackthoncc;

import android.provider.ContactsContract;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseDatabaseHelper {
    public User user;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ArrayList<User> users = new ArrayList<>();

    public FirebaseDatabaseHelper() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User");
    }

    public void addUser(User user) {
        String key = databaseReference.push().getKey();
        databaseReference.child(key).setValue(user);
    }

    //эта штука не работает user становаится null
    public User getUser(String username) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User getedUser;
                for (DataSnapshot node : dataSnapshot.getChildren()) {
                    getedUser = node.getValue(User.class);
                    if (getedUser.getNickname().equals(username)) {
                        user = getedUser;
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return user;
    }
}
