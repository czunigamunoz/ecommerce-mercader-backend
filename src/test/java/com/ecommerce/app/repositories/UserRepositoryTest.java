package com.ecommerce.app.repositories;

import com.ecommerce.app.model.User;
import com.ecommerce.app.repositories.crud.UserCrudRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCrudRepository crudRepository;

    @Test
    @Order(1)
    public void testInitialQuery(){
        crudRepository.deleteAll();

        List<User> users = userRepository.getAll();
        Assertions.assertEquals(0, users.size());
    }

//    @Test
//    @Order(2)
//    public void testSaveQuery(){
//        User user1 = new User(1, "nombre1@correo.com", "name1", "2000/12/12", "password1", "password1", "password1", "nombre1@correo.com", "password1", "password1", "password1");
//        Optional<User> user = Optional.ofNullable(userRepository.save(user1));
//        Assertions.assertTrue(user.isPresent());
//    }
//
//    @Test
//    @Order(3)
//    public void testGetByEmail(){
//        Optional<User> user = userRepository.getById(1);
//        Assertions.assertTrue(user.isPresent());
//    }
//
//    @Test
//    @Order(4)
//    public void testGetByEmailAndPassword(){
//        Optional<User> user = userRepository.authUser("nombre1@correo.com", "password1");
//        Assertions.assertTrue(user.isPresent());
//    }
}
