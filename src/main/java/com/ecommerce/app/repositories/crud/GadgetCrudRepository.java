package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
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
    Optional<Gadget> findTopByOrderByIdDesc();

    /**
     * Get a list of gadget with less and equal than a price
     * @param price double
     * @return List of gadgets
     */
    List<Gadget> findByPriceLessThanEqual(double price);

    /**
     * Get a list of gadget by description
     * @param description String
     * @return List of gadgets
     */
    List<Gadget> findByDescriptionContainingIgnoreCase(String description);
}
