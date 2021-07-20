package com.cmc.evaluacion.fase1.servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmc.commons.util.DateUtil;
import com.cmc.commons.util.TipoPrestamo;
import com.cmc.evaluacion.fase1.entidades.Cartera;
import com.cmc.evaluacion.fase1.entidades.Cliente;
import com.cmc.evaluacion.fase1.entidades.Prestamo;
import com.cmc.exceptions.EvalucionException;

public class AdminPrestamos {
	
	private static Logger logger = LogManager.getLogger(AdminPrestamos.class);
	
	public static Cartera colocarPrestamos(String rutaArchivo, Cartera cartera){
		
		File file = new File(rutaArchivo);
		FileReader fr = null;
		BufferedReader br = null;
		String linea ="";
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			while((linea = br.readLine()) != null){
				
				armarPrestamo(linea, cartera);
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
	
	
	public static void armarPrestamo(String linea, Cartera cartera){
		String []datos = linea.split("-");
		
		
		try {

			String cedulaCliente = datos[0];
			Cliente cliente = cartera.buscarCliente(cedulaCliente);
			String numeroPrestamo = datos[1];
			String tipoPrestamo = numeroPrestamo.substring(0,1);
			Prestamo prestamo = new Prestamo(numeroPrestamo, cedulaCliente);
		
			if (tipoPrestamo.equals(TipoPrestamo.HIPOTECARIO)){
				prestamo.setTipo(tipoPrestamo);
			}else if(tipoPrestamo.equals(TipoPrestamo.QUIROGRAFARIO)){
				prestamo.setTipo(tipoPrestamo);
			}else{
				prestamo.setTipo(tipoPrestamo);
			}
			
			prestamo.setMonto(Double.parseDouble(datos[3]));
			
	
			Date fecha = DateUtil.convertir(datos[2]);
			prestamo.setFecha(fecha);
			cliente.agregarPrestamo(prestamo);
			
		} catch (Exception e) {
			logger.error("Error al agregar el prestamo al cliente " +e);
		}
		
		
		
		
	}

}
