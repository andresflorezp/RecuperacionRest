package edu.eci.arsw.recuperacion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.eci.arsw.recuperacion.Entities.Libro;
import edu.eci.arsw.recuperacion.Service.ServiceUser;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/librerias")
public class RestController {

	@Autowired
	ServiceUser ser;

	@GetMapping
	public ResponseEntity<?> getAllLibrerias() {
		if (ser.getAllLibreria().size() == 0)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(ser.getAllLibreria(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getLibreriraById(@PathVariable("id") int id) {
		if (ser.getLibreriaById(id) == null)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(ser.getLibreriaById(id), HttpStatus.ACCEPTED);

	}

	@GetMapping("/{id}/libros")
	public ResponseEntity<?> getlibros(@PathVariable("id") int id) {
		if (ser.getLibreriaById(id) == null)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(ser.getLibreriaById(id).getLibros(), HttpStatus.ACCEPTED);

	}

	@GetMapping("/{id}/libros/{idLibro}")
	public ResponseEntity<?> getlibrosById(@PathVariable("id") int id, @PathVariable("idLibro") int idLibro) {
		if (ser.getLibreriaById(id) == null)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		else {

			List<Libro> libros = ser.getAllLibro(id);
			Libro li = null;
			for (Libro l : libros) {
				if (l.getId() == idLibro)
					return new ResponseEntity<>(l, HttpStatus.ACCEPTED);
			}

		}
		return new ResponseEntity<>(ser.getLibreriaById(id).getLibros(), HttpStatus.ACCEPTED);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteLibreria(@PathVariable("id") int id) {
		if (ser.getLibreriaById(id) == null) {
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		} else {
			ser.deleteLibreriaById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public  @ResponseBody ResponseEntity<?> manejadorCreate(@PathVariable("id") int id, Libro libro) {
		try {
			ser.addLibro(id, libro);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {

			return new ResponseEntity<>("No es posible crear el recurso", HttpStatus.FORBIDDEN);
		}

	}
	@RequestMapping(method = RequestMethod.POST, value = "/{id}/{correo}")
	public  @ResponseBody ResponseEntity<?> manejadorCreateMail(@PathVariable("id") int id, Libro libro,@PathVariable("correo") String correo) {
		try {
			ser.addLibroWithEmail(id, libro, correo);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {

			return new ResponseEntity<>("No es posible crear el recurso", HttpStatus.FORBIDDEN);
		}

	}

}
