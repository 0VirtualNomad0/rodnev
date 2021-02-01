package vendorapplication.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.RolesRepository;

import java.util.List;

@Service
public class RolesService {
	
	@Autowired
	private RolesRepository rolesRepository;


	public RolesRepository getRolesRepository() {
		return rolesRepository;
	}

	public void setRolesRepository(RolesRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
	}

	public List<Object[]> getRoles(){
		return rolesRepository.getRoles();
	}



}
