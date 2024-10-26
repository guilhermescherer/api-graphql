package com.guilhermescherer.apigraphql.service;

import com.guilhermescherer.apigraphql.model.CarModel;
import com.guilhermescherer.apigraphql.model.UserModel;

import java.util.Collection;

public interface CarService {

    CarModel createCar(String name, String userId);

    Collection<CarModel> getAllCars();

    CarModel getCarById(String uuid);

    Collection<CarModel> getCarsByUser(UserModel user);
}
