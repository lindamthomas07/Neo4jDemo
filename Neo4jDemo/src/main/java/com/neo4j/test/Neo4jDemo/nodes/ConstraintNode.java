package com.neo4j.test.Neo4jDemo.nodes;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class ConstraintNode extends DataAttributeNode {

	@Id
	@GeneratedValue
	private Long id;	

	@Relationship(type = "LINKS_TO",direction = Relationship.UNDIRECTED)
	private LoadpointNode referenceLoadpoint;

	public LoadpointNode getReferenceLoadpoint() {
		return referenceLoadpoint;
	}

	public void setReferenceLoadpoint(LoadpointNode referenceLoadpoint) {
		this.referenceLoadpoint = referenceLoadpoint;
	}
}
