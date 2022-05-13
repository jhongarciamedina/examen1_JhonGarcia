package EC1JhonGarciaMedina.service;

import java.util.List;


import EC1JhonGarciaMedina.dto.UniversidadDTOResponse;
import EC1JhonGarciaMedina.dto.UniversidadDTOResquet;

public interface UniversidadService {
	
public void guardarUniversidad(UniversidadDTOResquet universidad);
	
	public void editarUniversidad(UniversidadDTOResquet universidad);
	
	public void eliminarUniversidad(Integer id);
	
	public List<UniversidadDTOResponse> listarUniversidad();
	
	public UniversidadDTOResponse obtenerUniversidad(Integer id);

}
