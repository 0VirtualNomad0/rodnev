package vendorapplication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationRepository extends CrudRepository<UserRepository,Integer> {
}
