package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.model.Order;
import com.ecommerce.app.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Represents an order CRUD repository
 * @version 1.0
 * @author czm
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {

    /**
     * Return orders with a specific salesman zone
     * @param zone String User's zone
     * @return List of orders
     */
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);

    /**
     * Return orders by status and salesman
     * @param status String
     * @param id Integer
     * @return List of orders
     */
    List<Order> findByStatusAndSalesMan_Id(String status, Integer id);

    /**
     * Return orders by salesman id
     * @param id Integer
     * @return List or orders
     */
    List<Order> findBySalesMan_Id(Integer id);

    /**
     * Return orders by register day and salesman
     * @param registerDay Date
     * @param id Integer
     * @return List of orders
     */
    List<Order> findByRegisterDayAndSalesMan_Id(Date registerDay, Integer id);

    /**
     * Select order with the highest id
     * @return User object
     */
    Optional<Order> findTopByOrderByIdDesc();
}
