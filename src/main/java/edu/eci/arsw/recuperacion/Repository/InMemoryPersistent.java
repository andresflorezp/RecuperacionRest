package edu.eci.arsw.recuperacion.Repository;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import edu.eci.arsw.recuperacion.Entities.Libreria;
import edu.eci.arsw.recuperacion.Entities.Libro;
import edu.eci.arsw.recuperacion.Service.EmailSenderService;

import java.util.*;

@Service("Bean1")
public class InMemoryPersistent implements PersistentIn {
	public List<Libreria> librerias;

	public InMemoryPersistent() {
		Libro l1 = new Libro(1, "miperro", "yo", "algo");
		Libro l2 = new Libro(2, "migato", "yo", "algo");
		Libro l3 = new Libro(3, "x", "yo", "algo");
		Libro l4 = new Libro(4, "y", "yo", "algo");
		Libro l5 = new Libro(5, "z", "yo", "algo");
		Libro l6 = new Libro(6, "estesi", "yo", "algo");
		Libro l7 = new Libro(7, "ustednosabe..", "yo", "algo");
		Libro l8 = new Libro(8, "spti", "yo", "algo");
		Libro l9 = new Libro(9, "que mas", "yo", "algo");
		List<Libro> libros1 = new ArrayList<>();
		List<Libro> libros2 = new ArrayList<>();

		libros1.add(l1);
		libros1.add(l2);
		libros1.add(l3);
		libros1.add(l4);
		libros1.add(l5);

		libros2.add(l6);
		libros2.add(l7);
		libros2.add(l8);
		libros2.add(l9);

		Libreria libreria1 = new Libreria(1, "DMartica", "Cll 34 a sur", "38728342", libros1);
		Libreria libreria2 = new Libreria(2, "DPatico", "Cll 35 a sur", "745154", libros2);
		librerias = new ArrayList<Libreria>();
		librerias.add(libreria1);
		librerias.add(libreria2);
	}

	

	@Override
	public List<Libreria> getAllLibreria() {
		// TODO Auto-generated method stub
		return librerias;
	}
	@Override
	public List<Libro> getAllLibro(int Id) {
		// TODO Auto-generated method stub
		List<Libro> l1 = null;
		for (Libreria l : librerias) {
			if (l.getId() == Id) {
				l1 = l.getLibros();
			}
		}
		return l1;
	}



	public List<Libreria> getLibrerias() {
		return librerias;
	}



	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}


	
	@Override
	public void addLibro(int id, Libro libro) {
		List<Libreria> libre = new ArrayList<Libreria>();
		for (Libreria l : librerias) {
			if (l.getId() == id) {
				l.getLibros().add(libro);
				libre.add(l);
			}
			else {
				libre.add(l);
				
			}
		}
		setLibrerias(libre);
		
	}
	
	@Override
	@Async
	public void addLibroWithEmail(int id,Libro libro,String email) {
		
		addLibro(id, libro);
		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Si Pasa hasta aca");
		EmailSenderService.enviarConGMail(email);
		
	}
	



	
	

}
