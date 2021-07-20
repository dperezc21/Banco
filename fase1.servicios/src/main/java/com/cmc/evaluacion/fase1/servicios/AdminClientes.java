package com.cmc.evaluacion.fase1.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmc.evaluacion.fase1.entidades.Cartera;
import com.cmc.evaluacion.fase1.entidades.Cliente;
import com.cmc.exceptions.EvalucionException;

public class AdminClientes {
	
	private static Logger logger = LogManager.getLogger(AdminClientes.class);
	
	
	public static Cartera armarCartera(String rutaArchivo) throws EvalucionException{
		Cartera cartera = new Cartera();
		File file = new File(rutaArchivo);
		FileReader fr = null;
		BufferedReader br = null;
		String linea ="";
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while((linea = br.readLine()) != null){
				
				armarCliente(linea, cartera);
			}
			return cartera;
		} catch (FileNotFoundException e) {
			logger.error("archivo no encontrado "+e);
			throw new EvalucionException("Error con el nombre del archivo");
		} catch (IOException e) {
			logger.error("Error al intentar leer una linea del archivo "+e);
			throw new EvalucionException("Error con una linea del archivo");
		}finally{
			
				try {
					if (br != null){
						br.close();
					}
				} catch (IOException e) {
					logger.error("No se puedo cerrar el BufferedReader "+e);
				}
				
				try {
					if (fr != null){
						fr.close();
					}
				} catch (IOException e) {
					logger.error("No se puedo cerrar el FileReader "+e);
				}
			
		}
		
		
	}
	
	
	private static void armarCliente(String dato, Cartera cartera){
		String datos[] = dato.split(",");
		try{
			
			cartera.agregarCliente(new Cliente(datos[0], datos[1], datos[2]));
			
		}catch (Exception e) {
			logger.error("los datos en la linea del archivo leido no tiene el formato esperado " +e);
		}
		
		
		
	}

}
