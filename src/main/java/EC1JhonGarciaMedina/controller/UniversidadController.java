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


import EC1JhonGarciaMedina.dto.UniversidadDTOResponse;
import EC1JhonGarciaMedina.dto.UniversidadDTOResquet;
import EC1JhonGarciaMedina.service.UniversidadService;

@RestController
@RequestMapping("/universidad/v1")
public class UniversidadController {
	
	@Autowired
	private UniversidadService universidadService;
	
	@GetMapping
	@RequestMapping(path = "/listar")
	public ResponseEntity<List<UniversidadDTOResponse>>  listarUniversidades(){
		return new ResponseEntity<List<UniversidadDTOResponse>>(universidadService.listarUniversidad(), HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping(path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody UniversidadDTOResquet universidad){
		universidadService.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<UniversidadDTOResponse>  listarPorId(@PathVariable Integer id) {
		UniversidadDTOResponse u= universidadService.obtenerUniversidad(id);
		if (u != null) {
			return new ResponseEntity<UniversidadDTOResponse>(u, HttpStatus.OK);
		}else {
			return new ResponseEntity<UniversidadDTOResponse>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody UniversidadDTOResquet universidad){
		UniversidadDTOResponse c = universidadService.obtenerUniversidad(universidad.getIdUniversidadDTO());
		
		if (c != null) {
			universidadService.editarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

}
}
