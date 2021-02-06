package vendorapplication.services;

import java.util.List;


import org.springframework.cache.annotation.Cacheable;
import vendorapplication.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	//@Cacheable("books")


	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	
	public UserEntity getUserDetails(Long mobileNumber) {
		return userRepository.getUserDetails(mobileNumber);
		
	}

	public UserEntity saveUser(UserEntity entity) {
		return userRepository.save(entity);

	}

	public List<Object[] > getUserId(String username){
		return userRepository.getUserID(username);
	}

}
