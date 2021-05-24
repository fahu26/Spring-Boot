package com.fahim.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fahim.entity.UserModel;
import com.fahim.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    private final static org.apache.logging.log4j.Logger Logger = LogManager.getLogger(UserController.class);

    @GetMapping("/users")
    @ApiOperation(
            value = "List all users",
            notes = "Provide details about all the user present in  db",
            response = UserModel.class)
    public List<UserModel> listUsers() {
        Logger.info("inside the cointroller");
        return userRepo.findAll();
    }

    @PostMapping("/addUsers")
    @ApiOperation(
            value = "Add a new user",
            notes = "Insert details of new user into the db",
            response = UserModel.class)
    public void addUser(@RequestBody UserModel model) {
        userRepo.save(model);
    }

    @DeleteMapping("/deleteUser/{id}")
    @ApiOperation(
            value = "Display details of selected user",
            notes = "Provide details about the user selected present in  db",
            response = UserModel.class)
    public void deleteUser(@PathVariable int id) {
        UserModel model = userRepo.getOne(id);
        userRepo.delete(model);
    }
}
