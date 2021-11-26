package com.ecommerce.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Date;

/**
 * Represents an User
 * @version 1.0
 * @author czm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuarios")
public class User implements Serializable {

    /**
     * Represents primary key from user
     */
    @Id
    private Integer id;

    private String identification;

    /**
     * Represents user's name
     */
    private String name;

    private Date birthDay;

    private String monthBirthDay;

    private String address;

    private String cellPhone;

    /**
     * Represents user's email
     */
    private String email;

    /**
     * Represents user's password
     */
    private String password;

    private String zone;

    private String type;

}
