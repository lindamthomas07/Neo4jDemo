package com.neo4j.test.Neo4jDemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.neo4j.test.Neo4jDemo.Neo4jDemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Neo4jDemoApplication.class})
@WebAppConfiguration
@AutoConfigureMockMvc
public class Neo4jFetchControllerTest {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void testFetchStructure() throws Exception {
		mockMvc.perform(get("/fetchStructureLatest/Neo4jDemo/3")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testFetchStructureCheckout() throws Exception {
		mockMvc.perform(get("/fetchStructureCheckout/Neo4jDemo/gid_3")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testFetchLPLatest() throws Exception {
		mockMvc.perform(get("/fetchLPLatest/Neo4jDemo/loadpoints")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testFetchLPCheckout() throws Exception {
		mockMvc.perform(get("/fetchLPCheckout/Neo4jDemo/gid_3/loadpoints")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testFetchAggregates() throws Exception {
		mockMvc.perform(post("/fetchAggregates/Neo4jDemo/aggregates")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testFetchAggregatesDataNodes() throws Exception {
		mockMvc.perform(post("/fetchAggregates/Neo4jDemo/aggregates/dataNodes")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
	}


}
