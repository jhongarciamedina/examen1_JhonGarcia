package EC1JhonGarciaMedina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EC1JhonGarciaMedina.dto.CursoDTOResponse;
import EC1JhonGarciaMedina.dto.CursoDTOResquet;
import EC1JhonGarciaMedina.service.CursoService;

@RestController
@RequestMapping("/curso/v1")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	@RequestMapping(path = "/listar")
	public ResponseEntity<List<CursoDTOResponse>>  listarcursos(){
		return new ResponseEntity<List<CursoDTOResponse>>(cursoService.listarCurso(), HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping(path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody CursoDTOResquet curso){
		cursoService.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<CursoDTOResponse>  listarPorId(@PathVariable Integer id) {
		CursoDTOResponse c= cursoService.obtenerCurso(id);
		if (c != null) {
			return new ResponseEntity<CursoDTOResponse>(c, HttpStatus.OK);
		}else {
			return new ResponseEntity<CursoDTOResponse>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody CursoDTOResquet curso){
		CursoDTOResponse c = cursoService.obtenerCurso(curso.getIdCursoDTO());
		
		if (c != null) {
			cursoService.editarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}")
	@DeleteMapping
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		CursoDTOResponse c = cursoService.obtenerCurso(id);
		
		if (c != null) {
			cursoService.eliminarCurso(id);;
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
