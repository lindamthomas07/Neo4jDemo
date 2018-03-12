package com.neo4j.test.Neo4jDemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

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
public class Neo4jControllerTest {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void testCreatProject() throws Exception {
		mockMvc.perform(post("/createProject")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
		
		mockMvc.perform(post("/stageRevision")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
		
		mockMvc.perform(post("/stageCheckoutRevision")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void deleteProjectAndItsRevisionsAndUsers() throws Exception{
		
		mockMvc.perform(post("/deleteProject/Neo4jDemo/neo4j_gid")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(MockMvcResultHandlers.print());
	}
	
}
