package com.neo4j.test.Neo4jDemo.nodes;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "HAS_USER")
public class HasUserRelationship {

	@Id
	@GeneratedValue
	private Long relationshipId;
	@Property
	@Index(unique = true)
	private String key;
	@StartNode
	private ProjectNode projectNode;
	@EndNode
	private UserNode userNode;
	
	public Long getRelationshipId() {
		return relationshipId;
	}
	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public ProjectNode getProjectNode() {
		return projectNode;
	}
	public void setProjectNode(ProjectNode projectNode) {
		this.projectNode = projectNode;
	}
	public UserNode getUserNode() {
		return userNode;
	}
	public void setUserNode(UserNode userNode) {
		this.userNode = userNode;
	}	
}
