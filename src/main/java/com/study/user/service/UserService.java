package com.study.user.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.study.user.domain.User;
import com.study.user.sdo.UserCdo;
import com.study.user.sdo.UserUdo;
import com.study.user.store.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStore userStore;

    public User find(long id) {
        return userStore.find(id)
            .orElseThrow(() -> new NoSuchElementException("Not found user."));
    }

    public List<User> findAll() {
        return userStore.findAll();
    }

    public void register(UserCdo userCdo) {
        User user = userCdo.toDomain();
        userStore.register(user);
    }

    public void modify(long id, UserUdo userUdo) {
        User findUser = find(id);
        findUser.changeName(userUdo.getName());
        userStore.modify(findUser);
    }

    public void remove(long id) {
        userStore.remove(id);
    }
}
