package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Represents a user CRUD repository
 * @version 1.0
 * @author czm
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    /**
     * Look for a user associate wit email
     * @param email String
     * @return User object or null
     */
    Optional<User> getByEmail(String email);

    /**
     * Look for a user associate with an email and password
     * @param email String
     * @param password String
     * @return User object or null
     */
    Optional<User> getByEmailAndPassword(String email, String password);

    /**
     * Select user with the highest id
     * @return User object
     */
    Optional<User> findTopByOrderByIdDesc();

    /**
     * Look for user associate with month birthday
     * @param month String
     * @return List of users
     */
    List<User> findByMonthBirthtDay(String month);
}
