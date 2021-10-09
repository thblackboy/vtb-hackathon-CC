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
    }

    public String getNickname() {
        return nickname;
    }

    public Long getSkill() {
        return skill;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSkill(Long skill) {
        this.skill = skill;
    }
}
