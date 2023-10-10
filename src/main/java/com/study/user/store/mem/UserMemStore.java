package com.study.user.store.mem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.study.user.domain.User;
import com.study.user.store.UserStore;
import org.springframework.stereotype.Repository;

@Repository
public class UserMemStore implements UserStore {

    private final Map<Long, User> map = new ConcurrentHashMap<>();

    @Override
    public Optional<User> find(long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void register(User user) {
        map.put(user.getId(), user);
    }

    @Override
    public void modify(User user) {
        find(user.getId()).ifPresent(findUser -> findUser.update(user));
    }

    @Override
    public void remove(long id) {
        map.remove(id);
    }
}
