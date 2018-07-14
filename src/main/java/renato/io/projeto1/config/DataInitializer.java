package renato.io.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import renato.io.projeto1.entity.User;
import renato.io.projeto1.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			createUser("Renato Muniz", "renmuniz1@gmail.com");
			createUser("Frank Brasil", "frankbrasil@gmail.com");
			createUser("Beto Bahia", "betobahia@gmail.com");

		}
		
		User user = userRepository.findByEmailTeste("renmuniz1@gmail.com");
		
		System.out.println(user.getName());
		
		//user.setName("Muniz");
		
		//userRepository.save(user);
		
		//System.out.println(user.getName());

	}
	
	public void createUser(String name, String email) {
		User user = new User(name,email);
		
		userRepository.save(user);
	}
}
