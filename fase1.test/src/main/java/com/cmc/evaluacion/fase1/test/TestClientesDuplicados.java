package com.cmc.evaluacion.fase1.test;

import com.cmc.evaluacion.fase1.entidades.Cartera;
import com.cmc.evaluacion.fase1.servicios.AdminClientes;

import junit.framework.TestCase;

public class TestClientesDuplicados extends TestCase{
	
private static final String ROOT="C:\\Users\\davier\\Desktop\\archivos";
	
	public void testLeer(){
		Cartera cartera=AdminClientes.armarCartera(ROOT+"\\Clientes2.txt");
		assertEquals(4,cartera.getClientes().size());
		assertEquals("Rolando",cartera.getClientes().get(3).getNombre());
	}

}
