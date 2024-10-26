package com.guilhermescherer.apigraphql.service.impl;

import com.guilhermescherer.apigraphql.model.UserModel;
import com.guilhermescherer.apigraphql.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final Map<String, UserModel> users = new HashMap<>();

    @Override
    public UserModel createUser(String name, String email) {
        String uuid = UUID.randomUUID().toString();
        UserModel user = new UserModel(uuid, name, email);
        users.put(uuid, user);
        return user;
    }

    @Override
    public Collection<UserModel> getAllUsers() {
        return users.values();
    }

    @Override
    public UserModel getUserById(String uuid) {
        return users.get(uuid);
    }
}
