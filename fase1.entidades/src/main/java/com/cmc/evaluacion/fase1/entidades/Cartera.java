package com.cmc.evaluacion.fase1.entidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cartera {
	
	private Logger logger = LogManager.getLogger(Cartera.class);
	private ArrayList<Cliente> clientes;
	private HashMap<String, ArrayList<Pago>> pagos;
	
	public Cartera(){
		this.clientes = new ArrayList<Cliente>();
		this.pagos = new HashMap<String, ArrayList<Pago>>();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public void agregarPago(Pago pago){
		ArrayList<Pago> nuevoPago = new ArrayList<Pago>();
		ArrayList<Pago> p;
		if(!this.pagos.containsKey(pago.getNumeroPrestamo())){
			nuevoPago.add(pago);
			this.pagos.put(pago.getNumeroPrestamo(),nuevoPago);
		}else{
			p = this.pagos.get(pago.getNumeroPrestamo());
			p.add(pago);
			
		}
	}
	
	
	public ArrayList<Pago> consultarPagos(String codigoPrestamo){
		ArrayList<Pago> pago = new ArrayList<Pago>();
		if (this.pagos.containsKey(codigoPrestamo)){
			return this.pagos.get(codigoPrestamo);
		}
		return pago;
	}
	
	
	public Cliente buscarCliente(String cedulaCliente){
		for(Cliente cli: this.clientes){
			if (cli.getCedula().equals(cedulaCliente)){
				return cli;
			}	
		}
		return null;
	}
	
	
	public boolean agregarCliente(Cliente cliente){
		Cliente cli = buscarCliente(cliente.getCedula());
		if(cli == null){
			
			this.clientes.add(cliente);
			return true;
		}
		return false;
	}
	
	
	public void colocarPrestamo(Prestamo prestamo){
		Cliente cliente = buscarCliente(prestamo.getCedulaCliente());
		if(cliente != null){
			cliente.agregarPrestamo(prestamo);
		}
	}
	
	
	public ArrayList<Balance> calcularBalances(){
		ArrayList<Balance> balanceCompleto = new ArrayList<Balance>();
		for(Cliente cli: this.clientes){
			Balance balance = new Balance();
			double valorPrestamo = 0;
			 double valorPagado = 0;
			ArrayList<Pago> pagos;
			for(Prestamo prestamo: cli.getPrestamos()){
				valorPrestamo += prestamo.getMonto();
				 pagos = consultarPagos(prestamo.getNumero());
				
				 for(Pago pago: pagos){
					 valorPagado += pago.getMonto();
				 }
				 
				 //System.out.println(valorPagado);
				
			}
			balance.setValorPagado(valorPagado);
			balance.setValorPrestamo(valorPrestamo);
			 balance.setSaldo(valorPrestamo-balance.getValorPagado());
			 balanceCompleto.add(balance);
		}
		return balanceCompleto;
	}
	
	
}


