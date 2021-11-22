package com.ecommerce.app.services;

import com.ecommerce.app.entities.User;
import com.ecommerce.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll(){
        return repository.getAll();
    }

    public Optional<User> getUser(int id){
        return repository.getUser(id);
    }

    public User save(User user){
        if (user.getId() == null){
            if (!existEmail(user.getEmail())){
                return repository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public User update(User user){
        if (user.getId() != null){
            Optional<User> isUser = repository.getUser(user.getId());
            if (isUser.isPresent()){
                if (user.getEmail() != null){
                    isUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null){
                    isUser.get().setPassword(user.getPassword());
                }
                if (user.getName() != null){
                    isUser.get().setName(user.getName());
                }
                return repository.save(isUser.get());
            }
        }
        return user;
    }

    public boolean delete(int id){
        return getUser(id).map(user -> {
            repository.delete(user);
            return true;
        }).orElse(false);
    }

    public boolean existEmail(String email){
        return repository.existEmail(email);
    }

    public User authUser(String email, String password){
        Optional<User> user = repository.authUser(email, password);

        if (user.isPresent()){
            return user.get();
        } else {
            User userTemp = new User();
            userTemp.setEmail(email);
            userTemp.setPassword(password);
            userTemp.setName("NO DEFINIDO");
            return userTemp;
        }
    }
}
