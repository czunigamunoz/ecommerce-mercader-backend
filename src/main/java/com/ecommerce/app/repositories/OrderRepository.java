package com.ecommerce.app.repositories;

import com.ecommerce.app.model.Order;
import com.ecommerce.app.repositories.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
     * Represents instance of Mongo template for criteria
     */
    @Autowired
    private MongoTemplate mongoTemplate;

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
    public List<Order> getByZone(String zone){
        return crudRepository.findByZone(zone);
    }

    /**
     * Return order by status
     * @param status String
     * @param id Integer
     * @return List of orders
     */
    public List<Order> getByStatusAndSalesman(String status, Integer id){ return crudRepository.findByStatusAndSalesMan_Id(status, id); }

    /**
     * Return order with an associate salesman
     * @param id Integer
     * @return List of orders
     */
    public List<Order> getBySalesman(Integer id){
        return crudRepository.findBySalesMan_Id(id);
    }

    /**
     * Returns orders by date and salesman id
     * @param dateStr String
     * @param id Integer
     * @return List of orders
     */
    public List<Order> getByDateAndSalesman(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        return mongoTemplate.find(query,Order.class);
    }
}
