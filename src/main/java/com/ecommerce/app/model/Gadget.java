package com.ecommerce.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "gadgets")
public class Gadget {

    @Id
    private Integer id;

    private String brand;

    private String processor;

    private String os;

    private  String description;

    private String memory;

    private String hardDrive;

    private  boolean availability = true;

    private double price;

    private int quantity;

    private String photography;
}
