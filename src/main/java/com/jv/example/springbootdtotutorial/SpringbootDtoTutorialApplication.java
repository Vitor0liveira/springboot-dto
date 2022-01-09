package com.jv.example.springbootdtotutorial;

import com.jv.example.springbootdtotutorial.model.Location;
import com.jv.example.springbootdtotutorial.model.User;
import com.jv.example.springbootdtotutorial.repository.LocationRepository;
import com.jv.example.springbootdtotutorial.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDtoTutorialApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDtoTutorialApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {
		Location location = new Location();
		location.setPlace("Recife");
		location.setDescription("Recife is a great place to live");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		locationRepository.save(location);

		User user = new User();
		user.setFirstName("Vitor");
		user.setLastName("Oliveira");
		user.setEmail("vitor@gmail.com");
		user.setPassword("secret");
		user.setLocation(location);
		userRepository.save(user);

		User user2 = new User();
		user2.setFirstName("John");
		user2.setLastName("Cena");
		user2.setEmail("john@gmail.com");
		user2.setPassword("secret");
		user2.setLocation(location);
		userRepository.save(user2);
	}
}
