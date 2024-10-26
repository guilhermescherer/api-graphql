package com.guilhermescherer.apigraphql.controller;

import com.guilhermescherer.apigraphql.model.CarModel;
import com.guilhermescherer.apigraphql.model.UserModel;

import java.util.Collection;

public interface CoreController {

    Collection<CarModel> getAllCars();

    CarModel getCarById(String id);

    Collection<UserModel> getAllUsers();

    UserModel getUserById(String id);

    UserModel createUser(String name, String email);

    CarModel createCar(String name, String userId);
}
