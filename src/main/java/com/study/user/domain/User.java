package com.study.user.domain;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements Serializable {

    private long id;

    private String name;

    private boolean member;

    public void update(User user) {
        this.name = user.getName();
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void toggleMember() {
        this.member = true;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", member=" + member +
            '}';
    }
}
