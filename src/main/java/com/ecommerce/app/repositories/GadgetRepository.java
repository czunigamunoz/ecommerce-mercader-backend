package com.ecommerce.app.repositories;

import com.ecommerce.app.model.Gadget;
import com.ecommerce.app.repositories.crud.GadgetCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Represents a gadget repository
 * @version 1.0
 * @author czm
 */
@Repository
public class GadgetRepository {

    /**
     * Represents gadget repository to connect with CRUD repository
     */
    @Autowired
    private GadgetCrudRepository crudRepository;

    /**
     * Get gadgets
     * @return List
     */
    public List<Gadget> getAll(){
        return crudRepository.findAll();
    }

    /**
     * Get a gadget with this id
     * @param id Integer
     * @return Gadget with this id or null
     */
    public Optional<Gadget> getById(Integer id){
        return crudRepository.findById(id);
    }

    /**
     * Save new gadget
     * @param gadget Gadget object
     * @return Gadget
     */
    public Gadget create(Gadget gadget){
        return crudRepository.save(gadget);
    }

    /**
     * Update a gadget
     * @param gadget Gadget object
     */
    public void update(Gadget gadget){
        crudRepository.save(gadget);
    }

    /**
     * Delete a gadget
     * @param gadget Gadget object
     */
    public void delete(Gadget gadget){
        crudRepository.delete(gadget);
    }

    /**
     * Return gadget with the highest id
     * @return Gadget object
     */
    public Optional<Gadget> lastGadgetId(){
        return crudRepository.findTopByOrderByIdDesc();
    }

    /**
     * Return list of gadget lower and equal than a price
     * @param price double
     * @return List of gadgets
     */
    public List<Gadget> getByPriceLower(double price){ return crudRepository.findByPriceLessThanEqual(price);}

    /**
     * Return list of gadget with a description
     * @param description String
     * @return List of gadgets
     */
    public List<Gadget> getByDescription(String description){ return crudRepository.findByDescriptionContainingIgnoreCase(description);}
}
