package com.guilhermescherer.apigraphql.service;

import com.guilhermescherer.apigraphql.model.UserModel;

import java.util.Collection;

public interface UserService {

    UserModel createUser(String name, String email);

    Collection<UserModel> getAllUsers();

    UserModel getUserById(String uuid);
}
