package com.ejercicio.init;

import javax.annotation.Resource; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration; 
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories; 
import org.springframework.web.servlet.config.annotation.EnableWebMvc; 
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@ComponentScan(basePackages={ "com.ejercicio" })
@EnableMongoRepositories(basePackages = "com.ejercicio.persistencia")
public class Configuracion  extends AbstractMongoConfiguration {
 
	private static final String PROPERTY_NAME_DATABASE="db.name";
	private static final String PROPERTY_NAME_SERVER="db.server";
	private static final String PROPERTY_NAME_PORT="db.port";
	private static final String PROPERTY_NAME_PACKAGE="package";


	@Resource
	private Environment env;
	
	
	@Override
	protected String getDatabaseName() {
		 return env.getRequiredProperty(PROPERTY_NAME_DATABASE);
	 
	}
    
    @Bean
	public Mongo mongo() throws Exception {
		  return new MongoClient(env.getRequiredProperty(PROPERTY_NAME_SERVER),Integer.parseInt(env.getRequiredProperty(PROPERTY_NAME_PORT)));
	}
	
    public String getMappingBasePackage() {
        return env.getRequiredProperty(PROPERTY_NAME_PACKAGE);
    }
    
    @Bean 
    public MongoOperations mongoOperations() throws Exception{
    	return new MongoTemplate(mongo(), getDatabaseName());
    }
    
}
