package com.ecommerce.app.services;

import com.ecommerce.app.model.Gadget;
import com.ecommerce.app.repositories.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Represents a user service
 * @version 1.0
 * @author czm
 */
@Service
public class GadgetService {

    /**
     * Represents Gadget repository
     */
    @Autowired
    GadgetRepository repository;

    /**
     * Get gadget list
     * @return List of gadgets
     */
    public List<Gadget> getAll(){
        return repository.getAll();
    }

    public Optional<Gadget> getGadget(int id){
        return repository.getById(id);
    }

    /**
     * Create a gadget
     * @param gadget Gadget object
     * @return Gadget created
     */
    public Gadget save(Gadget gadget){
        if (gadget.getId() == null){
            return gadget;
        }
        return repository.create(gadget);
    }

    /**
     * Delete gadget
     * @param id Integer
     */
    public boolean delete(Integer id){
        return getGadget(id).map(gadget -> {
            repository.delete(gadget);
            return true;
        }).orElse(false);
    }

    /**
     * Update gadget
     * @param gadget Gadget object
     * @return Gadget with fields updated or gadget with same fields that received
     */
    public Gadget update(Gadget gadget){
        if (gadget.getId() != null){
            Optional<Gadget> gadgetTemp = repository.getById(gadget.getId());
            if (gadgetTemp.isPresent()){
                if (gadget.getBrand() != null && gadget.getBrand().length() > 0){
                    gadgetTemp.get().setBrand(gadget.getBrand());
                }
                if (gadget.getCategory() != null && gadget.getCategory().length() > 0){
                    gadgetTemp.get().setCategory(gadget.getCategory());
                }
                if (gadget.getName() != null && gadget.getName().length() > 0){
                    gadgetTemp.get().setName(gadget.getName());
                }
                if (gadget.getDescription() != null && gadget.getDescription().length() > 0){
                    gadgetTemp.get().setDescription(gadget.getDescription());
                }
                if (gadget.getPrice() > 0){
                    gadgetTemp.get().setPrice(gadget.getPrice());
                }
                if (gadget.isAvailability()){
                    gadgetTemp.get().setAvailability(gadget.isAvailability());
                }
                if (gadget.getQuantity() > 0){
                    gadgetTemp.get().setQuantity(gadget.getQuantity());
                }
                if (gadget.getPhotography() != null && gadget.getPhotography().length() > 0){
                    gadgetTemp.get().setPhotography(gadget.getPhotography());
                }
                repository.update(gadgetTemp.get());
                return gadgetTemp.get();
            }
            return gadget;
        }
        return gadget;
    }
}
