package com.prueba.fabrica.ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.fabrica.ropa.entidades.Pedido;
import com.prueba.fabrica.ropa.entidades.ValorTotal;
import com.prueba.fabrica.ropa.repositorio.PedidoRepositorio;

/**
 * Servicio que permite realizar las operaciones necesarias 
 * sobre la entidad de servicio y exponerlo al controlador.
 * 
 * @author alvaro
 *
 */

@Service
public class PedidoService {

	
	
	/**
	 * Clase que permite el acceso a base de datos
	 */
	private final PedidoRepositorio pedidoRepositorio;
	
	/**
	 * Constructor que permite inyectar las dependencias.
	 * @param documentoRepositorio
	 */
	@Autowired
	public PedidoService(PedidoRepositorio pedRepositorio){
		this.pedidoRepositorio = pedRepositorio;
	}
	
	/**
	 * Envia al Repositorio el Pedido que se va guardar
	 * @param pedido Pedido a guardar
	 */
	public ValorTotal crearPedido(Pedido pedido){
		pedidoRepositorio.crearPedido(pedido);
		
		return pedidoRepositorio.obtenerPrecio(pedido.getTipoRopa(), pedido.getCantidad());
	}
	
	
}
