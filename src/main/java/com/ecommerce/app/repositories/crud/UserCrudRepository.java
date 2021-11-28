package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

/**
 * Represents a user CRUD repository
 * @version 1.0
 * @author czm
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    public Optional<User> getByEmail(String email);

    public Optional<User> getByEmailAndPassword(String email, String password);
}
