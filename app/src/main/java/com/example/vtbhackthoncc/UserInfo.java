package com.example.vtbhackthoncc;

import android.provider.ContactsContract;

public class UserInfo {
    private String nickname;
    private String dateOfBirth;
    private boolean sentToInvestStatus;
    UserInfo(){
        nickname = "SomeNickname";
        dateOfBirth = "01.01.1901";
        sentToInvestStatus = false;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSentToInvestStatus(boolean sentToInvestStatus) {
        this.sentToInvestStatus = sentToInvestStatus;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean getSentToInvestStatus(){
        return  sentToInvestStatus;
    }
}
