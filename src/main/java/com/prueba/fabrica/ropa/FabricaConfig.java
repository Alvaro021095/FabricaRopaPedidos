package com.prueba.fabrica.ropa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Esta clase contiene las configuraciones y beans necesarios
 * para la aplicación.
 * 
 * @author alvaro
 *
 */
@Configuration
public class FabricaConfig {

    /**
     * Propiedad con la conexion url de la bd.
     */
    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    /**
     * User name de la bd.
     */
    @Value("${spring.datasource.username}")
    private String jdbcUser;

    /**
     * Pasword para la bd.
     */
    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    /**
     * Driver usado para realizar la conexión.
     */
    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;

    /**
     * Bean que representa la conexión a la base de datos.
     *
     * @return DataSource instance.
     */
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(jdbcUrl);
        driverManagerDataSource.setUsername(jdbcUser);
        driverManagerDataSource.setPassword(jdbcPassword);
        driverManagerDataSource.setDriverClassName(jdbcDriver);
        return driverManagerDataSource;
    }

    /**
     * Bean que permite realizar operaciones sobre la bd.
     *
     * @return nueva instancia de {link JdbcTemplate} con el datasource creado anteriormente.
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    /**
     * Permite manejar de mejor manera la transaccionalidad de la aplicación.
     *
     * @return nueva instancia de {@link DataSourceTransactionManager}
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	
}
