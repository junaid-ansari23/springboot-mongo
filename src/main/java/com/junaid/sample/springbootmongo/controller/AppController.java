/**
 * 
 */
package com.junaid.sample.springbootmongo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junaid.sample.springbootmongo.mongo.MongoAppDetails;
import com.junaid.sample.springbootmongo.mongo.MongoAppRepository;

/**
 * @author juansari
 *
 */
@RestController
public class AppController {

	private static Logger logger = LoggerFactory.getLogger(AppController.class);

	@Value("${spring.env.name}")
	private String env;

	@Autowired
	private MongoAppRepository mongoRepo;

	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MongoAppDetails> getAppDetails(HttpServletRequest request) {		
		return mongoRepo.findAll();
	}
	
	@RequestMapping(value = "/get/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MongoAppDetails getAppDetailsByName(HttpServletRequest request,@PathVariable("name") String name) {		
		return mongoRepo.findByAppName(name);
	}

	@RequestMapping(value = "/saveAppDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> saveAppDetails(@RequestBody MongoAppDetails input, HttpServletRequest request) {
		logger.info("Spring profile running: {}", env);
		Map<String, String> output = new HashMap<>();
		mongoRepo.save(input);
		output.put("status", "success");
		output.put("message", "Application with Id-"+input.getAppId()+" saves successfully in mongo");
		
		return output;
	}

}
