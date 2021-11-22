package com.ecommerce.app.repositories;

import com.ecommerce.app.entities.User;
import com.ecommerce.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Represents a user repository
 * @version 1.0
 * @author czm
 */
@Repository
public class UserRepository {

    /**
     * Represents user repository to connect with CRUD repository
     */
    @Autowired
    private UserCrudRepository crudRepository;

    /**
     * Get users
     * @return List
     */
    public List<User> getAll(){
        return (List<User>) crudRepository.findAll();
    }

    /**
     * Get a user with this id
     * @param id Integer
     * @return User with this id or null
     */
    public Optional<User> getUser(int id){
        return crudRepository.findById(id);
    }

    /**
     * Save new user
     * @param user User
     * @return User
     */
    public User save(User user){
        return crudRepository.save(user);
    }

    /**
     * Delete a user
     * @param user User
     */
    public void delete(User user){
        crudRepository.delete(user);
    }

    /**
     * Get if exists a user with this email
     * @param email String
     * @return Boolean, true if exists or false if not
     */
    public boolean existEmail(String email){
        Optional<User> user = crudRepository.findByEmail(email);
        return user.isPresent();
    }

    /**
     * Get user with this email and password
     * @param email String
     * @param password String
     * @return User with this credentials
     */
    public Optional<User> authUser(String email, String password){
        return crudRepository.findByEmailAndPassword(email, password);
    }
}
