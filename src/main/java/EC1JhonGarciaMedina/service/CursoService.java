package EC1JhonGarciaMedina.service;

import java.util.List;

import EC1JhonGarciaMedina.dto.CursoDTOResponse;
import EC1JhonGarciaMedina.dto.CursoDTOResquet;

public interface CursoService {
	public void guardarCurso(CursoDTOResquet curso);
	
	public void editarCurso(CursoDTOResquet curso);
	
	public void eliminarCurso(Integer id);
	
	public List<CursoDTOResponse> listarCurso();
	
	public CursoDTOResponse obtenerCurso(Integer id);

}
