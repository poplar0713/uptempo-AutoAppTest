package com.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

//root-context에 들어가던 태그의 코드화

@Configuration
public class MongoConfig{

	@Value("${spring.data.mongodb.uri}")
	private String mongodb_uri;

	@Bean(name = "mongoTemplate1")
	public MongoTemplate mongoTemplate1() {
		MongoClient mongoClient =  MongoClients.create(mongodb_uri);
		MongoDatabaseFactory factory = new SimpleMongoClientDatabaseFactory(mongoClient, "uptempodevice");
		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(factory), new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null)); return new MongoTemplate(factory, converter);
	}
}