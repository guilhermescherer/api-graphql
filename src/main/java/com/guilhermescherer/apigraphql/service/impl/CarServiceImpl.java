package com.guilhermescherer.apigraphql.service.impl;

import com.guilhermescherer.apigraphql.model.CarModel;
import com.guilhermescherer.apigraphql.model.UserModel;
import com.guilhermescherer.apigraphql.service.CarService;
import com.guilhermescherer.apigraphql.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    private final Map<String, CarModel> cars = new HashMap<>();

    private final UserService userService;

    public CarServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CarModel createCar(String name, String userId) {
        String uuid = UUID.randomUUID().toString();
        UserModel user = userService.getUserById(userId);

        CarModel car = new CarModel(uuid, name, user);
        cars.put(uuid, car);
        return car;
    }

    @Override
    public Collection<CarModel> getAllCars() {
        return cars.values();
    }

    @Override
    public CarModel getCarById(String uuid) {
        return cars.get(uuid);
    }

    @Override
    public Collection<CarModel> getCarsByUser(UserModel user) {
        return cars.values().stream()
                .filter(car -> car.user().equals(user))
                .toList();
    }
}
