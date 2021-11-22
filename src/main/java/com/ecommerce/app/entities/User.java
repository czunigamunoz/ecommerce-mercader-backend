package com.ecommerce.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Represents an User
 * @version 1.0
 * @author czm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", indexes = @Index(name = "index_email", columnList = "user_email", unique = true))
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_email", nullable = false, length = 50)
    private String email;

    @Column(name = "user_password", nullable = false, length = 50)
    private String password;

    @Column(name = "user_name", nullable = false, length = 80)
    private String name;
}
