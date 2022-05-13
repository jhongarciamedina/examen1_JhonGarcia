package EC1JhonGarciaMedina.service;

import java.util.List;

import EC1JhonGarciaMedina.dto.ProfesorDTOResponse;
import EC1JhonGarciaMedina.dto.ProfesorDTOResquet;

public interface ProfesorService {
	
	public void guardarProfesor(ProfesorDTOResquet profesor);
	
	public void editarProfesor(ProfesorDTOResquet profesor);
	
	public void eliminarProfesor(Integer id);
	
	public List<ProfesorDTOResponse> listarProfesor();
	
	public ProfesorDTOResponse obtenerProfesor(Integer id);


}
