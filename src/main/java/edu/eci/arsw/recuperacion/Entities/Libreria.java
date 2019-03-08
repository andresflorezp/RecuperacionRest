package edu.eci.arsw.recuperacion.Entities;

import java.util.List;

public class Libreria {
	private int Id;
	private String Nombre;
	private String Direccion;
	private String Telefono;
	private List<Libro> libros;
	
	public Libreria(){
		
		
	}
	public Libreria(int id, String nombre, String direccion, String telefono,List<Libro> libros) {
		Id = id;
		Nombre = nombre;
		Direccion = direccion;
		Telefono = telefono;
		this.libros= libros;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	
	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	@Override
	public String toString() {
		return "Libreria [Id=" + Id + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", Telefono=" + Telefono
				+ ", libros=" + libros + "]";
	}
	

	

}
