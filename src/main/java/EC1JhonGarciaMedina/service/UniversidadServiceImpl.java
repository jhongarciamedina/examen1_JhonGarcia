package EC1JhonGarciaMedina.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import EC1JhonGarciaMedina.dto.UniversidadDTOResponse;
import EC1JhonGarciaMedina.dto.UniversidadDTOResquet;

import EC1JhonGarciaMedina.model.Universidad;
import EC1JhonGarciaMedina.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {
	
	@Autowired
	
	public UniversidadRepository universidadRepository;

	@Override
	public void guardarUniversidad(UniversidadDTOResquet universidad) {
		
		Universidad u = new Universidad();
		u.setUniversidad(universidad.getUniversidadDTO());
		u.setIdUniversidad(universidad.getIdUniversidadDTO());
		universidadRepository.save(u);
		
		
	}

	@Override
	public void editarUniversidad(UniversidadDTOResquet universidad) {

		Universidad u = new Universidad();
		u.setUniversidad(universidad.getUniversidadDTO());
		u.setIdUniversidad(universidad.getIdUniversidadDTO());
		universidadRepository.saveAndFlush(u);
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		universidadRepository.deleteById(id);
	}

	@Override
	public List<UniversidadDTOResponse> listarUniversidad() {
		List<UniversidadDTOResponse> lista = new ArrayList<UniversidadDTOResponse>();
		UniversidadDTOResponse u= null;
		for(Universidad universidad : universidadRepository.findAll()) {
			u= new UniversidadDTOResponse();
			u.setUniversidadDTO(universidad.getUniversidad());
			u.setIdUniversidadDTO(universidad.getIdUniversidad());
			lista.add(u);
		}
		return lista;
	}

	@Override
	public UniversidadDTOResponse obtenerUniversidad(Integer id) {
		Universidad universidad= universidadRepository.findById(id).orElse(null);
		UniversidadDTOResponse u= new UniversidadDTOResponse();
		u.setUniversidadDTO(universidad.getUniversidad());
		u.setIdUniversidadDTO(universidad.getIdUniversidad());
		return u;
	}

}
