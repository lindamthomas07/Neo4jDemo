package com.neo4j.test.Neo4jDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo4j.test.Neo4jDemo.service.Neo4jServiceImpl;

@RestController
public class Neo4jFetchController {

	@Autowired
	private Neo4jServiceImpl neo4jServiceImpl;

	//fetch	
	@RequestMapping("/fetchStructureLatest/{projectName}")
	public String fetchStructureLatest(@PathVariable String projectName) {

		neo4jServiceImpl.fetchStructure(projectName);
		return "fetch revision structure is success!!";
	}
	@RequestMapping("/fetchStructureCheckout/{projectName}/{checkoutRevisionId}")
	public String fetchStructureCheckoutRevision(@PathVariable String projectName,@PathVariable String checkoutRevisionId) {

		neo4jServiceImpl.fetchStructureCheckout(projectName, checkoutRevisionId);
		return "fetch revision structure is success!!";
	}

	@RequestMapping("/fetchLPLatest/{projectName}/loadpoints")
	public String fetchLoadpointLatest(@PathVariable String projectName) {

		neo4jServiceImpl.fetchLoadpoint(projectName);
		return "fetch revision lp is success!!";
	}
	
	@RequestMapping("/fetchLPCheckout/{projectName}/{checkoutRevisionId}/loadpoints")
	public String fetchLoadpointCheckout(@PathVariable String projectName,@PathVariable String checkoutRevisionId) {

		neo4jServiceImpl.fetchLoadpointCheckout(projectName,checkoutRevisionId);
		return "fetch revision lp is success!!";
	}

	@RequestMapping("/fetchAggregates/{projectName}/aggregates")
	public String fetchAggregates(@PathVariable String projectName) {

		neo4jServiceImpl.fetchAggregates(projectName);
		return "fetch aggregates is success!!";
	}	

	@RequestMapping("/fetchAggregates/{projectName}/aggregates/dataNodes")
	public String fetchAggregatesWithDataNodes(@PathVariable String projectName) {

		neo4jServiceImpl.fetchAggregatesAndDataNodes(projectName);
		return "success!";
	}	

}
