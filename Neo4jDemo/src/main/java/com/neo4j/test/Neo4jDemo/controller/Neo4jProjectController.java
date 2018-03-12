package com.neo4j.test.Neo4jDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo4j.test.Neo4jDemo.service.Neo4jServiceImpl;

@RestController
public class Neo4jProjectController {

	@Autowired
	private Neo4jServiceImpl neo4jServiceImpl;


	//create & delete project
	@RequestMapping("/createProject")
	public String creatRevision() {

		neo4jServiceImpl.createProject();
		return "created project";
	}

	@RequestMapping("/deleteProject/{projectName}/{userId}")
	public String deleteProjectAndItsRevisionsAndUsers(@PathVariable String projectName,@PathVariable String userId){
		neo4jServiceImpl.deleteProjectAndItsRevisionsAndUsers(projectName,userId);
		return "delete project";
	}

}
