package com.cmc.evaluacion.fase1.entidades;

import java.util.ArrayList;

public class Cliente {
	private ArrayList<Prestamo> prestamos;
	private String cedula;
	private String nombre;
	private String apellido;
	
	public Cliente(String cedula, String nombre, String apellido ){
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.prestamos = new ArrayList<Prestamo>();
	}
	
	public void agregarPrestamo(Prestamo prestamo){
		this.prestamos.add(prestamo);
	}
	
	
	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	

}
