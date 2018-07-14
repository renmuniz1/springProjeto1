package renato.io.projeto1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import renato.io.projeto1.entity.User;

public interface UserRepository extends MongoRepository<User, Long>{
	
	@Query("{ 'email' : ?0 }")
	User findByEmailTeste(String email);
	
	User findByNameIgnoreCaseLike(String name);
	
}
