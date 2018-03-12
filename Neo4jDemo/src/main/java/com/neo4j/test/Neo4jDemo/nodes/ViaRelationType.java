package com.neo4j.test.Neo4jDemo.nodes;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "VIA")
public class ViaRelationType {

	@Id
	@GeneratedValue
	private Long relationshipId;
	@Property
	private String portNumber;
	@Property
	@Index(unique = true)
	private String uuid;
	@StartNode
	private MediumConnectionNode connectionNode;
	@EndNode
	private AggregateNode aggregateNode;
	
	public String getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public MediumConnectionNode getConnectionNode() {
		return connectionNode;
	}
	public void setConnectionNode(MediumConnectionNode connectionNode) {
		this.connectionNode = connectionNode;
	}
	public AggregateNode getAggregateNode() {
		return aggregateNode;
	}
	public void setAggregateNode(AggregateNode aggregateNode) {
		this.aggregateNode = aggregateNode;
	}

	
}
