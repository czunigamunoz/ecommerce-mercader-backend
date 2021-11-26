package com.ecommerce.app.controllers;

import com.ecommerce.app.model.Gadget;
import com.ecommerce.app.services.GadgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gadget")
public class GadgetController {

    @Autowired
    private GadgetService service;

    @GetMapping("/all")
    public List<Gadget> getAll() {
        return service.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget save(@RequestBody Gadget gadget) {
        return service.save(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget gadget) {
        return service.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
