package edu.eci.arsw.recuperacion.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.eci.arsw.recuperacion.Entities.Libreria;
import edu.eci.arsw.recuperacion.Entities.Libro;
import edu.eci.arsw.recuperacion.Repository.PersistentIn;

@Service
public class ServiceUser {
	@Qualifier("Bean1")
	@Autowired
	PersistentIn pes;

	public List<Libreria> getAllLibreria() {
		return pes.getAllLibreria();
	}

	public Libreria getLibreriaById(int id) {

		for (Libreria l : getAllLibreria()) {
			if (l.getId() == id)
				return l;

		}
		return null;
	}

	public List<Libro> getAllLibro(int Id) {
		return pes.getAllLibro(Id);
	}

	public Libro getLibro(int id, List<Libro> libros) {
		for (Libro l : libros) {
			if (l.getId() == id)
				return l;
		}
		return null;

	}

	public void deleteLibreriaById(int id) {
		List<Libreria> librerias = new ArrayList();
		for (Libreria l : getAllLibreria()) {
			if (l.getId() == id) {
				if (l.getLibros().size() == 0)
					break;

			} else {
				librerias.add(l);
			}

		}
		pes.setLibrerias(librerias);

	}
	
	public void addLibro(int id, Libro libro) {
		pes.addLibro(id, libro);
		
	}
	public void addLibroWithEmail(int id,Libro libro,String email) {
		pes.addLibroWithEmail(id, libro, email);	
	}

}
