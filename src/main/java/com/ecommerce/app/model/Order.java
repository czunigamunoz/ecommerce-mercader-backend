package com.ecommerce.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

/**
 * Represents an Order
 * @version 1.0
 * @author czm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    /**
     * Status constant Pendiente
     */
    public static String PENDING = "Pendiente";
    /**
     * Status constant Aprobada
     */
    public static String APPROVED = "Aprobada";
    /**
     * Status constant Rechazada
     */
    public static String REJECTED = "Rechazada";

    /**
     * Represents primary key from order
     */
    @Id
    private Integer id;
    /**
     * Represents order register day as date
     */
    private Date registerDay;
    /**
     * Represents order status
     */
    private String status;
    /**
     * Represents order sales man
     */
    private User salesMan;
    /**
     * Represents order's products
     */
    private Map<Integer, Gadget> products;
    /**
     * Represents order's quantities
     */
    private Map<Integer, Integer> quantities;
}
