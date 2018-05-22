package com.prueba.fabrica.ropa.entidades;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pedido {

	@JsonProperty("nombrePersona")
	private String nombrepersona;
	
	@JsonProperty("tipoIdentificacion")
	private int tipodocumento_id;
	
	@JsonProperty("numeroIndentificacion")
	private String numerodocumento;
	
	@JsonProperty("tipoRopa")
	private int tiporopa_id;
	
	@JsonProperty("cantidadProductos")
	private int cantidad;
	
	@JsonProperty("fechaEntrega")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fechaentrega;
	
	@JsonProperty("direccion")
	private String direccion;
	

	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public Pedido(int tipoDoc,int tipoRopa,String nombrePersona, String documento,
			int cantidad, LocalDateTime fechaEntrega, String direccion) {
		super();
		this.tipodocumento_id= tipoDoc;
		this.tiporopa_id = tipoRopa;
		this.nombrepersona = nombrePersona;
		this.numerodocumento = documento;
		this.cantidad = cantidad;
		this.fechaentrega = fechaEntrega;
		this.direccion = direccion;
		// TODO Auto-generated constructor stub
	}

	public String getNombrePersona() {
		return nombrepersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrepersona = nombrePersona;
	}

	public int getTipoDocumento() {
		return tipodocumento_id;
	}

	public void setTipoDocumento(int tipoDocumento) {
		this.tipodocumento_id = tipoDocumento;
	}

	public String getDocumento() {
		return numerodocumento;
	}

	public void setDocumento(String documento) {
		this.numerodocumento = documento;
	}

	public int getTipoRopa() {
		return tiporopa_id;
	}

	public void setTipoRopa(int tipoRopa) {
		this.tiporopa_id = tipoRopa;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDateTime getFechaEntrega() {
		return fechaentrega;
	}

	public void setFechaEntrega(LocalDateTime fechaEntrega) {
		this.fechaentrega = fechaEntrega;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Pedido [nombrepersona=" + nombrepersona + ", tipodocumento_id=" + tipodocumento_id
				+ ", numerodocumento=" + numerodocumento + ", tiporopa_id=" + tiporopa_id + ", cantidad=" + cantidad
				+ ", fechaentrega=" + fechaentrega + ", direccion=" + direccion + "]";
	}

	
	
	
	
}
