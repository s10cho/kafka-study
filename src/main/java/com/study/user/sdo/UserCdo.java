package com.study.user.sdo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.study.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserCdo {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    public User toDomain() {
        return new User(
            id,
            name,
            false
        );
    }
}
