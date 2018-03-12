package com.neo4j.test.Neo4jDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo4j.test.Neo4jDemo.service.Neo4jServiceImpl;

@RestController
public class Neo4jStageController {

	@Autowired
	private Neo4jServiceImpl neo4jServiceImpl;

	//stage changes	
	@RequestMapping("/stageRevision")
	public String stageRevision() {

		neo4jServiceImpl.stageStructure();
		return "stage revision structure is success!";
	}

	@RequestMapping("/stageCheckoutRevision")
	public String stageCheckoutRevision() {

		neo4jServiceImpl.stageCheckoutRevision();
		return "stage checkout revision is success!";
	}
}
