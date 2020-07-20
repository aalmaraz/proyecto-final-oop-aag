package com.angelica.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pago {
	private Integer idPago;
	private Autor autor;
	private Articulo articulo;
	private Double monto;
	private Date fechaPago;
	
	public Pago(Integer idPago, Double monto) {
		this.idPago = idPago;
		this.monto = monto;
		fechaPago = new Date();
	}

	public Integer getIdPago() {
		return idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		return "Id: " + idPago + "\tArticulo: " + articulo.getTituloArticulo() + "\tAutor: " + autor.nombre + "\tMonto: " + monto + "\nEl: " + sdf.format(fechaPago) + "\n\n";
	}
}
