package EC1JhonGarciaMedina.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EC1JhonGarciaMedina.dto.ProfesorDTOResponse;
import EC1JhonGarciaMedina.dto.ProfesorDTOResquet;
import EC1JhonGarciaMedina.model.Profesor;
import EC1JhonGarciaMedina.repository.ProfesorRepository;


@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	public ProfesorRepository profesorRepository;
	
	@Override
	public void guardarProfesor(ProfesorDTOResquet profesor) {
		Profesor p = new Profesor();
		p.setProfesor(profesor.getProfesorDTO());
		p.setIdProfesor(profesor.getIdProfesorDTO());
		profesorRepository.save(p);
		
	}

	@Override
	public void editarProfesor(ProfesorDTOResquet profesor) {
		// TODO Auto-generated method stub
		Profesor p = new Profesor();
		p.setProfesor(profesor.getProfesorDTO());
		p.setIdProfesor(profesor.getIdProfesorDTO());
		profesorRepository.saveAndFlush(p);
		
	}

	@Override
	public void eliminarProfesor(Integer id) {
		// TODO Auto-generated method stub
		profesorRepository.deleteById(id);
		
	}

	@Override
	public List<ProfesorDTOResponse> listarProfesor() {
		List<ProfesorDTOResponse> lista = new ArrayList<ProfesorDTOResponse>();
		ProfesorDTOResponse p= null;
		for(Profesor profesor : profesorRepository.findAll()) {
			p= new ProfesorDTOResponse();
			p.setProfesorDTO(profesor.getProfesor());
			p.setIdProfesorDTO(profesor.getIdProfesor());
			lista.add(p);
		}
		return lista;
	}

	@Override
	public ProfesorDTOResponse obtenerProfesor(Integer id) {
		Profesor profesor= profesorRepository.findById(id).orElse(null);
		ProfesorDTOResponse p= new ProfesorDTOResponse();
		p.setProfesorDTO(profesor.getProfesor());
		p.setIdProfesorDTO(profesor.getIdProfesor());
		return p;
	}

}
