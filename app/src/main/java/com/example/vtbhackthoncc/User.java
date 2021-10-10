package com.example.vtbhackthoncc;

public class User {
    private String nickname;
    private Long skill;
    private String birthday;

    public User() {}

    public User(String nickname, Long skill, String birthday) {
        this.nickname = nickname;
        this.skill = skill;
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public Long getSkill() { return skill; }

    public String getBirthday() { return birthday; }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSkill(Long skill) {
        this.skill = skill;
    }

    public void setBirthday(String birthday) { this.birthday = birthday; }
}
