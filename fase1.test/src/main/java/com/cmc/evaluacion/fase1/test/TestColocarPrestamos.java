package com.cmc.evaluacion.fase1.test;

import java.util.ArrayList;

import com.cmc.evaluacion.fase1.entidades.Cartera;
import com.cmc.evaluacion.fase1.entidades.Cliente;
import com.cmc.evaluacion.fase1.entidades.Prestamo;
import com.cmc.evaluacion.fase1.servicios.AdminClientes;
import com.cmc.evaluacion.fase1.servicios.AdminPrestamos;

import junit.framework.TestCase;

public class TestColocarPrestamos extends TestCase {
	
	private static final String ROOT="C:\\Users\\davier\\Desktop\\archivos";
	private static final String ARCHIVO_CLIENTES=ROOT+"\\Clientes1.txt";
	private static final String ARCHIVO_PRESTAMOS=ROOT+"\\Prestamos1.txt";
	
	
	
	public void testColocarClienteA(){
		Cartera cartera=AdminClientes.armarCartera(ARCHIVO_CLIENTES);
		AdminPrestamos adminPrestamos=new AdminPrestamos();
		adminPrestamos.colocarPrestamos(ARCHIVO_PRESTAMOS,cartera);
		
		Cliente cliente=cartera.buscarCliente("1714616123");
		ArrayList<Prestamo> prestamos=cliente.getPrestamos();
		
		assertEquals(2, prestamos.size());
	}
	
	public void testColocarClienteB(){
		Cartera cartera=AdminClientes.armarCartera(ARCHIVO_CLIENTES);
		AdminPrestamos adminPrestamos=new AdminPrestamos();
		adminPrestamos.colocarPrestamos(ARCHIVO_PRESTAMOS,cartera);
		
		Cliente cliente=cartera.buscarCliente("0213982311");
		ArrayList<Prestamo> prestamos=cliente.getPrestamos();
		
		assertEquals(1, prestamos.size());
	}

}
