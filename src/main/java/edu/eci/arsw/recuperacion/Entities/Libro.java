package edu.eci.arsw.recuperacion.Entities;

public class Libro {
	private int Id;
	private String Nombre;
	private String Autor;
	private String Sinopsis;

	public Libro(){
		
		
	}
	public Libro(int id, String nombre, String autor, String sinopsis) {
		Id = id;
		Nombre = nombre;
		Autor = autor;
		Sinopsis = sinopsis;
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

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getSinopsis() {
		return Sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		Sinopsis = sinopsis;
	}

	@Override
	public String toString() {
		return "Libro [Id=" + Id + ", Nombre=" + Nombre + ", Autor=" + Autor + ", Sinopsis=" + Sinopsis + "]";
	}
	

}
