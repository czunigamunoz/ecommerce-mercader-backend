package com.ecommerce.app.repositories;

import com.ecommerce.app.model.Gadget;
import com.ecommerce.app.repositories.crud.GadgetCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Represents a user repository
 * @version 1.0
 * @author czm
 */
@Repository
public class GadgetRepository {

    /**
     * Represents user repository to connect with CRUD repository
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
     * Get a user with this id
     * @param id Integer
     * @return Gadget with this id or null
     */
    public Optional<Gadget> getById(Integer id){
        return crudRepository.findById(id);
    }

    /**
     * Save new user
     * @param gadget Gadget object
     * @return Gadget
     */
    public Gadget create(Gadget gadget){
        return crudRepository.save(gadget);
    }

    public void update(Gadget gadget){
        crudRepository.save(gadget);
    }

    /**
     * Delete a gadget
     * @param gadget Gadget
     */
    public void delete(Gadget gadget){
        crudRepository.delete(gadget);
    }
}
