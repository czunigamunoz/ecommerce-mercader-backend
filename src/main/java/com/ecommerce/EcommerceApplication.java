package com.ecommerce;

import com.ecommerce.app.model.User;
import com.ecommerce.app.repositories.crud.GadgetCrudRepository;
import com.ecommerce.app.repositories.crud.OrderCrudRepository;
import com.ecommerce.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ecommerce.app"})
public class EcommerceApplication  implements CommandLineRunner {

	@Autowired
	private UserCrudRepository userRepo;
	@Autowired
	private GadgetCrudRepository gadgetRepo;
	@Autowired
	private OrderCrudRepository orderRepo;


	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepo.deleteAll();
		gadgetRepo.deleteAll();
		orderRepo.deleteAll();
	}
}
