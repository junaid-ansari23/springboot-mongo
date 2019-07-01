/**
 * 
 */
package com.junaid.sample.springbootmongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.junaid.sample.springbootmongo.mongo.MongoAppDetails;
import com.junaid.sample.springbootmongo.mongo.MongoAppRepository;

/**
 * @author juansari
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@MockBean
	private MongoAppRepository mongoAppRepository;

	@MockBean
	private MongoAppDetails mongoAppDetails;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	private static final String input = "{\r\n" + "\"appId\":1,\r\n" + "\"appName\":\"Test Mongo\",\r\n"
			+ "\"appDescription\":\"Test mongo boot support\",\r\n" + "\"appType\":\"service\"\r\n" + "}";

	@Test
	public void testGetAppDetails() throws Exception {
		Mockito.when(mongoAppRepository.findAll()).thenReturn(new ArrayList<MongoAppDetails>());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/get").contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse());
		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	public void testsaveAppDetails() throws Exception {

		Mockito.when(mongoAppRepository.save(Mockito.any(MongoAppDetails.class)))
				.thenReturn(Mockito.any(MongoAppDetails.class));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveAppDetails").content(input)
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertNotNull(result.getResponse());
		assertEquals(200, result.getResponse().getStatus());
	}

}
