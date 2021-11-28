package com.ecommerce.app.controllers;

import com.ecommerce.app.model.Gadget;
import com.ecommerce.app.services.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Represents a user controller
 * @version 1.0
 * @author czm
 */
@RestController
@RequestMapping("gadget")
public class GadgetController {

    /**
     * Represents gadget service to connect with repository
     */
    @Autowired
    private GadgetService service;

    /**
     * Return a list of gadgets
     * @return A list representing gadgets on database
     */
    @GetMapping("/all")
    public List<Gadget> getAll() {
        return service.getAll();
    }

    /**
     * Function to create a gadget
     * @param gadget Gadget object
     * @return gadget created
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget save(@RequestBody Gadget gadget) {
        return service.save(gadget);
    }

    /**
     * Function to update a gadget
     * @param gadget Gadget object
     * @return Gadget updated or if already exists on database return same data that receives
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget gadget) {
        return service.update(gadget);
    }

    /**
     * Function to delete a gadget
     * @param id Integer
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
