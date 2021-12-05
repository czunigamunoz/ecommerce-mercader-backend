package com.ecommerce.app.services;

import com.ecommerce.app.model.User;
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
     * Get one user by id
     * @param id Integer
     * @return User object or null
     */
    public Optional<User> getUser(int id) {
        return repository.getById(id);
    }

    /**
     * Create a user
     * @param user User
     * @return User created
     */
    public User save(User user){

        if (user.getName() == null
                || user.getEmail() == null
                || user.getPassword() == null
                || user.getIdentification() == null
                || user.getType() == null){
            return user;
        }
        Optional<User> userIdMax = repository.lastUserId();
        if (user.getId() == null){
            if (userIdMax.isPresent()){
                user.setId(userIdMax.get().getId() + 1);
            }else {
                user.setId(1);
            }
        }
        Optional<User> userTemp = repository.getById(user.getId());
        if (userTemp.isEmpty()){
            if (!existEmail(user.getEmail())){
                return repository.create(user);
            }
            user.setId(null);
            return user;
        }
        user.setId(null);
        return user;
    }

    /**
     * Update user
     * @param user User
     * @return User with fields updated or user with same fields that received
     */
    public User update(User user){
        if (user.getId() != null){
            Optional<User> isUser = repository.getById(user.getId());
            if (isUser.isPresent()) {
                if (user.getIdentification() != null && user.getIdentification().length() > 0){
                    isUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null && user.getName().length() > 0){
                    isUser.get().setName(user.getName());
                }
                if (user.getAddress() != null && user.getAddress().length() > 0){
                    isUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null && user.getCellPhone().length() > 0){
                    isUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null && user.getEmail().length() > 0){
                    isUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null && user.getPassword().length() > 0){
                    isUser.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null && user.getZone().length() > 0){
                    isUser.get().setZone(user.getZone());
                }
                if (user.getType() != null && user.getType().length() > 0){
                    isUser.get().setType(user.getType());
                }
                repository.update(isUser.get());
                return isUser.get();
            }
            return user;
        }
        return user;
    }

    /**
     * Delete user
     * @param id Integer
     */
    public boolean delete(Integer id){
        return getUser(id).map(user -> {
            repository.delete(user);
            return true;
        }).orElse(false);
    }

    /**
     * Validate if an email is in the database
     * @param email String
     * @return Boolean
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
        return user.orElse(new User());
    }
}
