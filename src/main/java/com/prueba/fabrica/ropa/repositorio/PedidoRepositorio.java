package com.prueba.fabrica.ropa.repositorio;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.prueba.fabrica.ropa.FabricaConfig;
import com.prueba.fabrica.ropa.entidades.Pedido;
import com.prueba.fabrica.ropa.entidades.ValorTotal;

import ch.qos.logback.core.subst.Token.Type;

/**
 * Clase que permite manejar la data en la base de datos.
 * 
 * @author alvaro
 *
 */

@Repository
public class PedidoRepositorio {

	/**
     * Logger que permite mostrar en consola los mensjaes definidos.
     */
    private final Logger logger = LoggerFactory.getLogger(PedidoRepositorio.class);
    
    /**
	 * Bean para realizar las operaciones sobre bd
	 * configurado en {@link FabricaConfig}
	 */
	private final JdbcTemplate jdbcTemplate;
	
	private static final String QUERY_CREAR_PEDIDO
	= "INSERT INTO pedido" +
            "(tipodocumento_id,tiporopa_id,nombrepersona, numerodocumento,cantidad,"
            + "fechaentrega,direccion) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";

	
	private static final String QUERY_OBTENER_PRECIO
	= "SELECT precio FROM tiporopa WHERE id=(?)";
	
	
	/**
	 * Constructor que permite inyectar las dependencias.
	 * @param jdbcTemplate
	 */
	@Autowired
	public PedidoRepositorio(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	/**
	 * Metodo donde se crea el objeto Pedido con sus atributos
	 * correspondientes para ser guardado en la bd
	 * @param pedido Pedido a guardar
	 */
	public void crearPedido(Pedido pedido){
		Object[] params = new Object[]{
				pedido.getTipoDocumento(),
				pedido.getTipoRopa(),
				pedido.getNombrePersona(),
				pedido.getDocumento(),
				pedido.getCantidad(),
				pedido.getFechaEntrega(),
				pedido.getDireccion()};
		int[] types = new int[]{Types.INTEGER,  Types.INTEGER, Types.VARCHAR,
				Types.VARCHAR, Types.INTEGER,Types.TIMESTAMP,Types.VARCHAR};
		
		jdbcTemplate.update(QUERY_CREAR_PEDIDO, params, types);

	}
	
	
	/**
	 * Metodo para buscar el precio de la ropa y luego multiplicar
	 * la cantidad de prendas para obtener el precio a pagar
	 * @param idRopa Ropa del pedido
	 * @param cantidad Cantidad de prendas
	 * @return Precio a pagar
	 */
	public ValorTotal obtenerPrecio(int idRopa, int cantidad){
		
		ValorTotal valorTotal = new ValorTotal();
		
		double precio = this.jdbcTemplate.queryForObject(
				"SELECT precio FROM tiporopa WHERE id= ?",new Object[]{idRopa}, Double.class);
		
		valorTotal.setIdRopa(idRopa);
		valorTotal.setCantidad(cantidad);
		valorTotal.setTotal(precio*cantidad);
		
		return valorTotal;
		
	}

	
	

	
	

}
