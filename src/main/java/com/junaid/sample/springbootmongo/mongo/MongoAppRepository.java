/**
 * 
 */
package com.junaid.sample.springbootmongo.mongo;


import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author juansari
 * 
 * A repository to interact with Mongo DB. For each collection type MongoRepository<MongoAppDetails,Long>, a separate repository must be defined
 *
 */
public interface MongoAppRepository extends MongoRepository<MongoAppDetails,Long> {
	
	public MongoAppDetails findByAppName(String appName);

}
