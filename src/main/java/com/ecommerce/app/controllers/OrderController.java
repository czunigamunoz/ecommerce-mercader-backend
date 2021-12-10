package com.ecommerce.app.controllers;

import com.ecommerce.app.model.Order;
import com.ecommerce.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Represents a order controller
 * @version 1.0
 * @author czm
 */
@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderController {

    /**
     * Represents order service to connect with repository
     */
    @Autowired
    private OrderService service;

    /**
     * Return a list of orders
     * @return A list representing orders on database
     */
    @GetMapping("/all")
    public List<Order> getAll(){
        return service.getAll();
    }

    /**
     * Return Order object by id
     * @param id Integer
     * @return Object object
     */
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id){
        return service.getOrder(id);
    }

    /**
     * Function to create an order
     * @param order Order object
     * @return order created
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order){
        return service.save(order);
    }

    /**
     * Function to update an order
     * @param order Order object
     * @return Order updated or if already exists on database return same data that receives
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return service.update(order);
    }

    /**
     * Function to delete an order by id
     * @param id Integer
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }

    /**
     * Function to return order by zone
     * @param zone String
     * @return List of orders
     */
    @GetMapping("/zona/{zone}")
    public List<Order> getByZone(@PathVariable("zone") String zone){
        return service.getByZone(zone);
    }

    /**
     * Function to return order by status and salesman
     * @param status String
     * @param id Integer
     * @return List of orders
     */
    @GetMapping("state/{status}/{id}")
    public List<Order> getByStatusAndSalesman(@PathVariable("status") String status, @PathVariable("id") Integer id){
        return service.getByStatusAndSalesman(status, id);
    }

    /**
     * Function to return order by salesman
     * @param id Integer
     * @return List of orders
     */
    @GetMapping("salesman/{id}")
    public List<Order> getBySalesman(@PathVariable("id") Integer id){ return service.getBySalesman(id); }

    /**
     *
     * @param registerDay Date
     * @param id Integer
     * @return List of orders
     */
    @GetMapping("/order/{registerDay}/{id}")
    public List<Order> getByRegisterDayAndSalesman(@PathVariable("registerDay")Date registerDay, @PathVariable("id") Integer id){
        return service.getByRegisterDayAndSalesman(registerDay, id);
    }
}
