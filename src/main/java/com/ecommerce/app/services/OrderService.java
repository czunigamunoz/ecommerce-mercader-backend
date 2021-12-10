package com.ecommerce.app.services;

import com.ecommerce.app.model.Order;
import com.ecommerce.app.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Represents an order service
 * @version 1.0
 * @author czm
 */
@Service
public class OrderService {

    /**
     * Represents Order repository
     */
    @Autowired
    private OrderRepository repository;

    /**
     * Get order list
     * @return List of orders
     */
    public List<Order> getAll(){
        return repository.getAll();
    }

    /**
     * Get order by id
     * @param id Integer
     * @return Order object or null
     */
    public Optional<Order> getOrder(int id){
        return repository.getOrder(id);
    }

    /**
     * Create an order
     * @param order Order object
     * @return Order created
     */
    public Order save(Order order){
        Optional<Order> orderMaxId = repository.lastOrderId();
        if (order.getId() == null){
            if (orderMaxId.isPresent()){
                order.setId(orderMaxId.get().getId() + 1);
            }else {
                order.setId(1);
            }
        }
        Optional<Order> dbOrder = repository.getOrder(order.getId());
        if (dbOrder.isEmpty()){
            return repository.create(order);
        }
        order.setId(null);
        return order;
    }

    /**
     * Update order
     * @param order Order object
     * @return Order with fields updated or order with same fields that received
     */
    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> orderTemp = repository.getOrder(order.getId());
            if (orderTemp.isPresent()){
               if (order.getStatus() != null){
                    orderTemp.get().setStatus(order.getStatus());
               }
               repository.update(orderTemp.get());
               return orderTemp.get();
            }
            return order;
        }
        return order;
    }

    /**
     * Delete order
     * @param id Integer
     * @return Boolean
     */
    public boolean delete(int id){
        return getOrder(id).map(order -> {
            repository.delete(order);
            return true;
        }).orElse(false);
    }

    /**
     * Return orders by zone
     * @param zone String
     * @return List of orders
     */
    public List<Order> getByZone(String zone){
        return repository.getByZone(zone);
    }

    /**
     * Return orders by status
     * @param status String
     * @param id Integer
     * @return List of orders
     */
    public List<Order> getByStatusAndSalesman(String status, Integer id){ return repository.getByStatusAndSalesman(status, id); }

    /**
     * Return orders by salesman
     * @param id Integer
     * @return List of orders
     */
    public List<Order> getBySalesman(Integer id){
        return repository.getBySalesman(id);
    }

    /**
     * Return orders by register day and salesman
     * @param registerDay Date
     * @param id Integer
     * @return List of orders
     */
    public List<Order> getByRegisterDayAndSalesman(Date registerDay, Integer id){ return repository.getByDateAndSalesman(registerDay, id); }
}
