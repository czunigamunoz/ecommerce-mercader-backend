package com.ecommerce.app.controllers;

import com.ecommerce.app.entities.User;
import com.ecommerce.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Represents a user controller
 * @version 1.0
 * @author czm
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

    /**
     * Represents user service to connect with repository
     */
    @Autowired
    private UserService service;

    /**
     * Return a list of users
     * @return A list representing users
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }

    /**
     * Return a user
     * @param email String email's user
     * @param password String password's user
     * @return User with these credentials
     */
    @GetMapping("{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.authUser(email, password);
    }

    /**
     * Return true if exits or false if not
     * @param email String email's user
     * @return Boolean
     */
    @GetMapping("/{email}")
    public  boolean existEmail(@PathVariable("email") String email){
        return service.existEmail(email);
    }

    /**
     * Function to create a user
     * @param user User
     * @return user created
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User signUp(@RequestBody User user){
        return service.save(user);
    }

    /**
     * Function to update a user
     * @param user User
     * @return User with all data updated
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return service.update(user);
    }
}
