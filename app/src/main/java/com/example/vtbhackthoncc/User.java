package com.example.vtbhackthoncc;

public class User {
    private String nickname;
    private Long skill;
    private String phoneNumber;
    private String email;

    public User() {}

    public User(String nickname, Long skill, String phoneNumber, String email) {
        this.nickname = nickname;
        this.skill = skill;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public Long getSkill() {
        return skill;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
