package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

/**
 * Represents a gadget CRUD repository
 * @version 1.0
 * @author czm
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer> {

    /**
     * Select order with the highest id
     * @return Gadget object
     */
    public Optional<Gadget> findTopByOrderByIdDesc();

}
