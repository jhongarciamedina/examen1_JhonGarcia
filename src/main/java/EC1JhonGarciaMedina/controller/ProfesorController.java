package EC1JhonGarciaMedina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EC1JhonGarciaMedina.dto.ProfesorDTOResponse;
import EC1JhonGarciaMedina.dto.ProfesorDTOResquet;
import EC1JhonGarciaMedina.service.ProfesorService;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorController {
	@Autowired
	private ProfesorService profesorService;
	
	
	
	@GetMapping
	@RequestMapping(path = "/listar")
	public ResponseEntity<List<ProfesorDTOResponse>>  listarUniversidades(){
		return new ResponseEntity<List<ProfesorDTOResponse>>(profesorService.listarProfesor(), HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping(path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ProfesorDTOResquet profesor){
		profesorService.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<ProfesorDTOResponse>  listarPorId(@PathVariable Integer id) {
		ProfesorDTOResponse u= profesorService.obtenerProfesor(id);
		if (u != null) {
			return new ResponseEntity<ProfesorDTOResponse>(u, HttpStatus.OK);
		}else {
			return new ResponseEntity<ProfesorDTOResponse>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody ProfesorDTOResquet profesor){
		ProfesorDTOResponse c = profesorService.obtenerProfesor(profesor.getIdProfesorDTO());
		
		if (c != null) {
			profesorService.editarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

}

}
