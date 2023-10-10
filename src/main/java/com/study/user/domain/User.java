package com.study.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private long id;

    private String name;

    public void update(User user) {
        this.name = user.getName();
    }

    public void changeName(String name) {
        this.name = name;
    }
}
