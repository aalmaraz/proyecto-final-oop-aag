package com.angelica.modelos;

public class Pseudonimo extends Autor {
	
	private Autor autor;
	
	public Pseudonimo(Integer idAutor, String nombre) {
		super(idAutor, nombre);
	}
	
	public Pseudonimo(Integer idAutor, String nombre, Autor autor) {
		super(idAutor, nombre);
		this.autor = autor;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public String toString() {
		return "Id: " + super.idAutor + "\tPseudonimo: " + super.nombre + "\tNombre Real: " + autor.nombre;
	}
}
