package com.angelica.modelos;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
	private Integer idArticulo;
	private String tituloArticulo;
	private List<Autor> autores = new ArrayList<Autor>();
	
	public Articulo(Integer idArticulo, String tituloArticulo) {
		this.idArticulo = idArticulo;
		this.tituloArticulo = tituloArticulo;
	}
	
	public Integer getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getTituloArticulo() {
		return tituloArticulo;
	}

	public void setTituloArticulo(String tituloArticulo) {
		this.tituloArticulo = tituloArticulo;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	public String toStringSimple() {
		return "Id: " + idArticulo + "\tTitulo: " + tituloArticulo + "\n"; 
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Id: " + idArticulo + "\tTitulo: " + tituloArticulo + "\tAutores: \n");
		autores.forEach(autor -> string.append("\t->\t" + autor.toString() + "\n"));
		return string.toString(); 
	}
}
