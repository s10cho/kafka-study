package com.study.user.sdo;

import com.study.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRdo {

    private long id;

    private String name;

    public UserRdo(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
