package com.ecommerce.app.repositories;

import com.ecommerce.app.entities.User;
import com.ecommerce.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository crudRepository;

    public List<User> getAll(){
        return (List<User>) crudRepository.findAll();
    }

    public Optional<User> getUser(int id){
        return crudRepository.findById(id);
    }

    public User save(User user){
        return crudRepository.save(user);
    }

    public void delete(User user){
        crudRepository.delete(user);
    }

    public boolean existEmail(String email){
        Optional<User> user = crudRepository.findByEmail(email);
        return user.isPresent();
    }

    public Optional<User> authUser(String email, String password){
        return crudRepository.findByEmailAndPassword(email, password);
    }
}
