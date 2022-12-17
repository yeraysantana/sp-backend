package com.sp.users;

import com.sp.entities.User;

import java.util.Optional;

public interface IUserService {
    User addUser(User user);
    Iterable<User> getUsers();
    Optional<User> getUser(Long id);
}
