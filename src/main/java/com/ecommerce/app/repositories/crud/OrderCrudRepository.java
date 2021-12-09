package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.model.Order;
import com.ecommerce.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Represents an order CRUD repository
 * @version 1.0
 * @author czm
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {

    /**
     * Return orders with a specific zone
     * @param zone User's zone
     * @return List of orders
     */
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);

    /**
     * Return orders by status
     * @param status String
     * @return List of orders
     */
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    /**
     * Select order with the highest id
     * @return User object
     */
    Optional<Order> findTopByOrderByIdDesc();
}
