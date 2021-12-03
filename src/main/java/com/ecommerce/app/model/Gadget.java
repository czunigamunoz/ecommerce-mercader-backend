package com.ecommerce.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a Gadget
 * @version 1.0
 * @author czm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "gadgets")
public class Gadget {

    /**
     * Represents primary key from gadget
     */
    @Id
    private Integer id;

    /**
     * Represents gadget's brand
     */
    private String brand;

    /**
     * Represents gadget's category
     */
    private String category;

    /**
     * Represents gadget's name
     */
    private String name;

    /**
     * Represents gadget's description
     */
    private  String description;

    /**
     * Represents gadget's price
     */
    private double price;

    /**
     * Represents gadget availability
     */
    private  boolean availability = true;

    /**
     * Represents gadget's quantity
     */
    private int quantity;

    /**
     * Represents gadget's photography
     */
    private String photography;
}
