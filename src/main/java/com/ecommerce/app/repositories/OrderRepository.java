package com.ecommerce.app.repositories;

import com.ecommerce.app.model.Order;
import com.ecommerce.app.model.User;
import com.ecommerce.app.repositories.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Represents an order repository
 * @version 1.0
 * @author czm
 */
@Repository
public class OrderRepository {

    /**
     * Represents order repository to connect with CRUD repository
     */
    @Autowired
    private OrderCrudRepository crudRepository;

    /**
     * Get orders
     * @return List of objects
     */
    public List<Order> getAll(){
        return crudRepository.findAll();
    }

    /**
     * Get order by id
     * @param id Integer
     * @return Order object
     */
    public Optional<Order> getOrder(Integer id){
        return crudRepository.findById(id);
    }

    /**
     * Save new order
     * @param order Order object
     * @return Order object
     */
    public Order create(Order order){
        return crudRepository.save(order);
    }

    /**
     * Update an order
     * @param order Order object
     */
    public void update(Order order){
        crudRepository.save(order);
    }

    /**
     *Delete an order
     * @param order Order object
     */
    public void delete(Order order){
        crudRepository.delete(order);
    }

    /**
     * Get order with the highest id
     * @return Order object
     */
    public Optional<Order> lastOrderId(){
        return crudRepository.findTopByOrderByIdDesc();
    }

    /**
     * Return order with an associate zone
     * @param zone String
     * @return List or orders
     */
    public List<Order> findByZone(String zone){
        return crudRepository.findByZone(zone);
    }
}
