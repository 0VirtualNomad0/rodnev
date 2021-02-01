package vendorapplication.repositories;


import vendorapplication.entities.RegistrationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationTypeRepository extends CrudRepository<RegistrationType,Integer> {

    @Query(value="select * from mst_reservationtype where active=true", nativeQuery = true)
    List<RegistrationType> getActiveType() throws Exception;

}