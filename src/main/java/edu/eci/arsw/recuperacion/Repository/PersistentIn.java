package edu.eci.arsw.recuperacion.Repository;

import java.util.List;

import edu.eci.arsw.recuperacion.Entities.Libreria;
import edu.eci.arsw.recuperacion.Entities.Libro;

public interface PersistentIn {
	public List<Libreria> getLibrerias();
	public void setLibrerias(List<Libreria> librerias);
	public List<Libreria> getAllLibreria();
	public List<Libro> getAllLibro(int Id);
	public void addLibro(int id,Libro libro);
	public void addLibroWithEmail(int id,Libro libro,String email);
}
