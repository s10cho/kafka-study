package com.study.user.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import com.study.user.domain.User;
import com.study.user.sdo.RdoListRdo;
import com.study.user.sdo.UserCdo;
import com.study.user.sdo.UserRdo;
import com.study.user.sdo.UserUdo;
import com.study.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserResource {

    private final UserService userService;

    @GetMapping
    public RdoListRdo<UserRdo> findAll() {
        List<UserRdo> list = userService.findAll().stream()
            .map(UserRdo::new)
            .collect(Collectors.toList());
        return new RdoListRdo<>(list);
    }

    @GetMapping("{id}")
    public UserRdo find(
        @PathVariable long id
    ) {
        User user = userService.find(id);
        return new UserRdo(user);
    }

    @PostMapping
    public void register(
        @Valid @RequestBody UserCdo userCdo
    ) {
        userService.register(userCdo);
    }

    @PutMapping("{id}")
    public void modify(
        @PathVariable long id,
        @Valid @RequestBody UserUdo userUdo
    ) {
        userService.modify(id, userUdo);
    }

    @DeleteMapping("{id}")
    public void remove(
        @PathVariable long id
    ) {
        userService.remove(id);
    }
}
