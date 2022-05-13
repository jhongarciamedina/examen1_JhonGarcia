package EC1JhonGarciaMedina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EC1JhonGarciaMedina.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
	

}
