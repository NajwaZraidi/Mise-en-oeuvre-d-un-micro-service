package ma.enset.repositories;

import ma.enset.entities.CompteBanque;
import ma.enset.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteBanqueRepository extends JpaRepository<CompteBanque,String> {
    @RestResource(path = "/byType")
    List<CompteBanque> findByTypeCompte(@Param("t") TypeCompte typeCompte);

}
