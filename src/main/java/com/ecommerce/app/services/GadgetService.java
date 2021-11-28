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

    /**
     * Create a gadget
     * @param gadget Gadget object
     * @return Gadget created
     */
    public Gadget save(Gadget gadget){
        return repository.save(gadget);
    }

    /**
     * Delete gadget
     * @param id Integer
     */
    public void delete(Integer id){
        Optional<Gadget> gadgetTemp = repository.getById(id);
        gadgetTemp.ifPresent(gadget -> repository.delete(id));
    }

    /**
     * Update gadget
     * @param gadget Gadget object
     * @return Gadget with fields updated or gadget with same fields that received
     */
    public Gadget update(Gadget gadget){
        Optional<Gadget> gadgetTemp = repository.getById(gadget.getId());
        if (gadgetTemp.isPresent()){
            if (gadget.getBrand() != null && gadget.getBrand().length() > 0){
                gadgetTemp.get().setBrand(gadget.getBrand());
            }
            if (gadget.getProcessor() != null && gadget.getProcessor().length() > 0){
                gadgetTemp.get().setProcessor(gadget.getProcessor());
            }
            if (gadget.getOs() != null && gadget.getOs().length() > 0){
                gadgetTemp.get().setOs(gadget.getOs());
            }
            if (gadget.getDescription() != null && gadget.getDescription().length() > 0){
                gadgetTemp.get().setDescription(gadget.getDescription());
            }
            if (gadget.getMemory() != null && gadget.getMemory().length() > 0){
                gadgetTemp.get().setMemory(gadget.getMemory());
            }
            if (gadget.getHardDrive() != null && gadget.getHardDrive().length() > 0){
                gadgetTemp.get().setHardDrive(gadget.getHardDrive());
            }
            if (gadget.isAvailability()){
                gadgetTemp.get().setAvailability(gadget.isAvailability());
            }
            if (gadget.getPrice() > 0){
                gadgetTemp.get().setPrice(gadget.getPrice());
            }
            if (gadget.getQuantity() > 0){
                gadgetTemp.get().setQuantity(gadget.getQuantity());
            }
            if (gadget.getPhotography() != null && gadget.getPhotography().length() > 0){
                gadgetTemp.get().setPhotography(gadget.getPhotography());
            }
            return repository.save(gadgetTemp.get());
        }
        return gadget;
    }
}
