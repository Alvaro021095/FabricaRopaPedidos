package com.prueba.fabrica.ropa.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.fabrica.ropa.entidades.Pedido;
import com.prueba.fabrica.ropa.entidades.ValorTotal;
import com.prueba.fabrica.ropa.repositorio.PedidoRepositorio;
import com.prueba.fabrica.ropa.service.PedidoService;

/**
 * Esta clase permite exponer los metodos que actuaran como
 * microservicio para realizar las consultas de los diferentes
 * tipos de documentos que hay en nuestra bd.
 * 
 * @author alvaro
 *
 */

@RestController
@RequestMapping("api/fabrica/pedido/")
public class PedidosController {	
	
	/**
     * Logger que permite mostrar en consola los mensjaes definidos.
     */
    private final Logger logger = LoggerFactory.getLogger(PedidosController.class);
	
	private final PedidoService pedidoService;
	
	/**
	 * Constructor de la clase que permite la inyeccion de las dependencias.
	 * @param ropaService servicio de tipo documento.
	 */
	@Autowired
	public PedidosController(PedidoService pedService) {
		super();
		this.pedidoService = pedService;
	}
	
	/**
	 * Metodo para enviar el pedido al servicio
	 * @param pedido Pedido que se va a registrar en la bd 
	 */
	@CrossOrigin(origins = "*")
	//@PostMapping("crearPedido")
	@RequestMapping(method = RequestMethod.POST, value = "crearPedido")
	@ResponseBody
    public  ValorTotal crearPedido(@RequestBody Pedido pedido){
		logger.info("Se esta ejecutando el request para crear el pedido "
				+ "con los datos= {}",pedido);
		
		ValorTotal v = new ValorTotal();
		
		v = pedidoService.crearPedido(pedido);		
		return v;
	}

}
