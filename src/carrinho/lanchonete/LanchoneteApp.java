package carrinho.lanchonete;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class LanchoneteApp {
	
	public static void main(String[] args) {
		
		SpringApplication.run(LanchoneteApp.class, args);
		
	}//end public static void main(String[] args) 
	
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource h2DataSource() {
		
	    return DataSourceBuilder.create().type(org.h2.jdbcx.JdbcDataSource.class).build();
	    
	    
	}//end public DataSource h2DataSource() 

}//end public class LanchoneteApp 