package com.angelica.modelos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Revista {
	private Integer idRevista;
	private Date fechaPublicacion;
	private Double precio;
	private Integer numeroPaginas;
	private List<Articulo> listaArticulos = new ArrayList<Articulo>();
	
	public Revista(Integer idRevista, Double precio) {
		this.idRevista = idRevista;
		this.precio = precio;
		fechaPublicacion = new Date();
	}
	
	public void agregarArticulo(Articulo articulo) {
		listaArticulos.add(articulo);
	}
	
	public Boolean quitarArticulo(Articulo articulo) {
		return listaArticulos.remove(articulo);		
	}
	
	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}

	
	public Integer getIdRevista() {
		return idRevista;
	}

	public void setIdRevista(Integer idRevista) {
		this.idRevista = idRevista;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		string.append("Id: " + idRevista + "\tFechaPublicacion: " + sdf.format(fechaPublicacion) + "\tArticulos: \n");
		listaArticulos.forEach(articulo -> string.append("->\t" + articulo.toString() + "\n"));
		string.append("\n\n");
		return string.toString(); 
	}
}
