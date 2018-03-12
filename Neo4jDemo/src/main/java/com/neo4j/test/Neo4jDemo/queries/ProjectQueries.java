package com.neo4j.test.Neo4jDemo.queries;

public class ProjectQueries {

	public static final String DELETE_PROJECT = "MATCH (a:ProjectNode {projectName:{0}}) WITH a OPTIONAL MATCH (a)-[s:HAS_REVISION]->(d:RevisionNode)-[r]->(allRelatedNodes)--(p)"
			+ " DETACH DELETE a,d,allRelatedNodes,p with p match(u:UserNode{gid:{1}}) detach delete u ";
}
