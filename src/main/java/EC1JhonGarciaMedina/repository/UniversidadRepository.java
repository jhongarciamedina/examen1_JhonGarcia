package EC1JhonGarciaMedina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EC1JhonGarciaMedina.model.Universidad;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer> {
	

}
