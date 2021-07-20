package com.cmc.evaluacion.fase1.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestAll {
	public static Test suite() {
		TestSuite suite = new TestSuite(TestAll.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestArchivoCorrupto.class);
		suite.addTestSuite(TestCalcularBalances.class);
		suite.addTestSuite(TestCartera.class);
		suite.addTestSuite(TestClientes.class);
		suite.addTestSuite(TestClientesDuplicados.class);
		suite.addTestSuite(TestColocarPrestamos.class);
		suite.addTestSuite(TestConstante.class);
		suite.addTestSuite(TestConvertirFecha.class);
		suite.addTestSuite(TestPagos.class);
		//$JUnit-END$
		return suite;
	}

}
