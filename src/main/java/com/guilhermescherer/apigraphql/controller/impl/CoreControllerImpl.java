package com.guilhermescherer.apigraphql.controller.impl;

import com.guilhermescherer.apigraphql.controller.CoreController;
import com.guilhermescherer.apigraphql.model.CarModel;
import com.guilhermescherer.apigraphql.model.UserModel;
import com.guilhermescherer.apigraphql.service.CarService;
import com.guilhermescherer.apigraphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class CoreControllerImpl implements CoreController {

    private final CarService carService;
    private final UserService userService;

    public CoreControllerImpl(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @SchemaMapping(typeName = "Query", value = "getAllCars")
    @Override
    public Collection<CarModel> getAllCars() {
        return carService.getAllCars();
    }

    // Informação: Caso o nome do método seja diferente do declarado, ou caso eu queira colocar Query em uma tabela diferente
    @SchemaMapping(typeName = "Query", value = "getCarById")
    @Override
    public CarModel getCarById(@Argument String id) {
        return carService.getCarById(id);
    }

    // Informação: Caso o nome do método seja igual ao declarado no meu schema
    @QueryMapping
    @Override
    public Collection<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    @Override
    public UserModel getUserById(@Argument String id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    @Override
    public UserModel createUser(@Argument String name, @Argument String email) {
        return userService.createUser(name, email);
    }

    @MutationMapping
    @Override
    public CarModel createCar(@Argument String name, @Argument String userId) {
        return carService.createCar(name, userId);
    }

    @SchemaMapping(typeName = "User", value = "cars")
    public Collection<CarModel> cars(UserModel user) {
        return carService.getCarsByUser(user);
    }
}
