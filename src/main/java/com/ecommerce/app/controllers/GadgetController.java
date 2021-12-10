package com.ecommerce.app.controllers;

import com.ecommerce.app.model.Gadget;
import com.ecommerce.app.services.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Represents a gadget controller
 * @version 1.0
 * @author czm
 */
@RestController
@RequestMapping("gadget")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
     * Return Gadget object by id
     * @param id Integer
     * @return Gadget object
     */
    @GetMapping("/{id}")
    public Optional<Gadget> getGadget(@PathVariable("id") int id){
        return service.getGadget(id);
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
    public boolean delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }
}
