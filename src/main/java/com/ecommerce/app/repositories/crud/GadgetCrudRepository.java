package com.ecommerce.app.repositories.crud;

import com.ecommerce.app.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer> {
}
