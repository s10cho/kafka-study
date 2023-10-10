package com.study.user.store;

import java.util.List;
import java.util.Optional;

import com.study.user.domain.User;

public interface UserStore {

    Optional<User> find(long id);

    List<User> findAll();

    void register(User user);

    void modify(User user);

    void remove(long id);
}
