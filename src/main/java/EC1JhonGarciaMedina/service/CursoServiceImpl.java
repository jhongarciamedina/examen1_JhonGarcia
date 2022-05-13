package EC1JhonGarciaMedina.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EC1JhonGarciaMedina.dto.CursoDTOResponse;
import EC1JhonGarciaMedina.dto.CursoDTOResquet;
import EC1JhonGarciaMedina.model.Curso;
import EC1JhonGarciaMedina.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	
	public CursoRepository cursoRepository;
	
	
	@Override
	public void guardarCurso(CursoDTOResquet curso) {
		Curso c = new Curso();
		c.setDescripcion(curso.getDescripcionDTO());
		c.setIdCurso(curso.getIdCursoDTO());
		c.setCurso(curso.getCursoDTO());
		cursoRepository.save(c);
		
	}

	@Override
	public void editarCurso(CursoDTOResquet curso) {
		Curso c = new Curso();
		c.setDescripcion(curso.getDescripcionDTO());
		c.setIdCurso(curso.getIdCursoDTO());
		c.setCurso(curso.getCursoDTO());
		cursoRepository.saveAndFlush(c);
	}
	@Override
	public void eliminarCurso(Integer id) {
		cursoRepository.deleteById(id);
		
	}

	@Override
	public List<CursoDTOResponse> listarCurso() {
		List<CursoDTOResponse> lista = new ArrayList<CursoDTOResponse>();
		CursoDTOResponse c= null;
		for(Curso curso : cursoRepository.findAll()) {
			c= new CursoDTOResponse();
			c.setDescripcionDTO(curso.getDescripcion());
			c.setIdCursoDTO(curso.getIdCurso());
			c.setCursoDTO(curso.getCurso());
			lista.add(c);
		}
		return lista;
	}

	@Override
	public CursoDTOResponse obtenerCurso(Integer id) {
		Curso curso= cursoRepository.findById(id).orElse(null);
		CursoDTOResponse c= new CursoDTOResponse();
		c.setDescripcionDTO(curso.getDescripcion());
		c.setIdCursoDTO(curso.getIdCurso());
		c.setCursoDTO(curso.getCurso());
		return c;
	}
	
	
}
