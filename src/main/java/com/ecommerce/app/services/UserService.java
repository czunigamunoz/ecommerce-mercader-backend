package com.ecommerce.app.services;

import com.ecommerce.app.entities.User;
import com.ecommerce.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Represents a user service
 * @version 1.0
 * @author czm
 */
@Service
public class UserService {

    /**
     * Represents user repository
     */
    @Autowired
    private UserRepository repository;

    /**
     * Get user list
     * @return List of users
     */
    public List<User> getAll(){
        return repository.getAll();
    }

    /**
     * Get a user
     * @param id Integer
     * @return User if exists or false if not
     */
    public Optional<User> getUser(int id){
        return repository.getUser(id);
    }

    /**
     * Create a user
     * @param user User
     * @return User created
     */
    public User save(User user){
        if (user.getId() == null){
            if (!existEmail(user.getEmail())){
                return repository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * Update user
     * @param user User
     * @return User with fields updated or user with same fields that received
     */
    public User update(User user){
        if (user.getId() != null){
            Optional<User> isUser = repository.getUser(user.getId());
            if (isUser.isPresent()){
                if (user.getEmail() != null){
                    isUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null){
                    isUser.get().setPassword(user.getPassword());
                }
                if (user.getName() != null){
                    isUser.get().setName(user.getName());
                }
                return repository.save(isUser.get());
            }
        }
        return user;
    }

    /**
     * Delete user
     * @param id Integer
     * @return Boolean
     */
    public boolean delete(int id){
        return getUser(id).map(user -> {
            repository.delete(user);
            return true;
        }).orElse(false);
    }

    /**
     * Validate if an email is in the database
     * @param email
     * @return
     */
    public boolean existEmail(String email){
        return repository.existEmail(email);
    }

    /**
     * Validate if a user exists with an email and password received
     * @param email String
     * @param password String
     * @return User with these credentials or user with an id null and name "NO DEFINIDO"
     */
    public User authUser(String email, String password){
        Optional<User> user = repository.authUser(email, password);

        if (user.isPresent()){
            return user.get();
        } else {
            User userTemp = new User();
            userTemp.setEmail(email);
            userTemp.setPassword(password);
            userTemp.setName("NO DEFINIDO");
            return userTemp;
        }
    }
}
