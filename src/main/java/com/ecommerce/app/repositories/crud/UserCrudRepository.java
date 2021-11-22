package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Represents a user CRUD repository
 * @version 1.0
 * @author czm
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {

    /**
     * Find user with a specific email
     * @param email String
     * @return User with this email or null
     */
    Optional<User> findByEmail(String email);

    /**
     * Find user with a specific email and password
     * @param email String
     * @param password String
     * @return User with this email and password or null
     */
    Optional<User> findByEmailAndPassword(String email, String password);
}
