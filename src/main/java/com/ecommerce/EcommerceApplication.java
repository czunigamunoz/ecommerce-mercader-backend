package com.ecommerce;

import com.ecommerce.app.model.User;
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

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepo.deleteAll();
		userRepo.saveAll(List.of(
				new User(1,
					"123123",
					"CARLOS ALBERTO GARCIA",
					"CR 34-45",
					"311222222",
					"cgarcia@gmail.com",
					"Demo123.",
					"ZONA 2",
					"ADM"
				),
				new User(2,
						"1231234",
						"Isabel Castillo",
						"CR 34-45",
						"311222224",
						"isabelcast@gmail.com",
						"Demo12345",
						"ZONA 2",
						"ADM"
				)
		));
		userRepo.findAll().forEach(System.out::println);

		Optional<User> user = userRepo.getByEmail("isabelcast@gmail.com");
		user.ifPresent(value -> System.out.println("Datos del usuario: " + value));
		Optional<User> userPas = userRepo.getByEmailAndPassword("cgarcia@gmail.com", "Demo123.");
		userPas.ifPresent(value -> System.out.println("Datos del usuario verificado: " + value));

		userRepo.deleteAll();
	}
}
