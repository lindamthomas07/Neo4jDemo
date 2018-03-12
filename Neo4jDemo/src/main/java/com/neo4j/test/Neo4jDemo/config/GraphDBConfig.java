package com.neo4j.test.Neo4jDemo.config;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.neo4j.test.Neo4jDemo.repository")
@EntityScan(basePackages = "com.neo4j.test.Neo4jDemo.nodes")
@EnableTransactionManagement
public class GraphDBConfig {

	@Bean
	public SessionFactory getSessionFactory(){
		return new SessionFactory(configuration(), "com.neo4j.test.Neo4jDemo.nodes");
	}
	@Bean
	public Neo4jTransactionManager transactionManager(){
		return new Neo4jTransactionManager(getSessionFactory());
	}
	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {

		Builder builder = new Builder();
		builder.credentials("neo4j","secret");
		builder.uri("bolt://localhost");
		return builder.build();
	}


}
