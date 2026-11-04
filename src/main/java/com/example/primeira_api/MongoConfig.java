package com.example.primeira_api;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        // Conecta diretamente no seu MongoDB local
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        // AQUI você força o Spring a usar o seu banco, ignorando qualquer outra configuração!
        return new MongoTemplate(mongoClient(), "primeira_api_db");
    }
}
