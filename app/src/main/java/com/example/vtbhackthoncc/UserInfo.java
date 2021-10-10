package com.example.vtbhackthoncc;

import android.provider.ContactsContract;

public class UserInfo {
    private String nickname;
    private String dateOfBirth;
    UserInfo(){
        nickname = "SomeNickname";
        dateOfBirth = "01.01.1901";
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNickname() {
        return nickname;
    }
}
