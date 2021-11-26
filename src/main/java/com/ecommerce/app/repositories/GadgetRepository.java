package com.ecommerce.app.repositories;

import com.ecommerce.app.model.Gadget;
import com.ecommerce.app.repositories.crud.GadgetCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GadgetRepository {

    @Autowired
    private GadgetCrudRepository crudRepository;

    public List<Gadget> getAll(){
        return crudRepository.findAll();
    }

    public Optional<Gadget> getById(Integer id){
        return crudRepository.getById(id);
    }

    public Gadget save(Gadget gadget){
        return crudRepository.save(gadget);
    }

    public void delete(Gadget gadget){
        crudRepository.delete(gadget);
    }
}
