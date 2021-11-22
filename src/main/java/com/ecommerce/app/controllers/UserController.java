package com.ecommerce.app.controllers;

import com.ecommerce.app.entities.User;
import com.ecommerce.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.authUser(email, password);
    }

    @GetMapping("/{email}")
    public  boolean existEmail(@PathVariable("email") String email){
        return service.existEmail(email);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User signUp(@RequestBody User user){
        return service.save(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return service.update(user);
    }
}
