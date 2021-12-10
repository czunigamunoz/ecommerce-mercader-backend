package com.ecommerce.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Represents an User
 * @version 1.0
 * @author czm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    /**
     * Represents primary key from user
     */
    @Id
    private Integer id;

    /**
     * Represents user's identification
     */
    private String identification;

    /**
     * Represents user's name
     */
    private String name;
    /**
     * Represents user's birthday
     */
    private Date birthtDay;
    /**
     * Represents user's month birthday
     */
    private String monthBirthtDay;
    /**
     * Represents user's address
     */
    private String address;

    /**
     * Represents user's cell-phone
     */
    private String cellPhone;

    /**
     * Represents user's email
     */
    private String email;

    /**
     * Represents user's password
     */
    private String password;

    /**
     * Represents user's zone
     */
    private String zone;

    /**
     * Represents user's type
     */
    private String type;

}
