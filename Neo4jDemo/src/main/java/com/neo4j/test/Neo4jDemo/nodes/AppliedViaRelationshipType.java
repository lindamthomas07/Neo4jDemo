package com.neo4j.test.Neo4jDemo.nodes;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.neo4j.test.Neo4jDemo.service.SignalConnectionSourceType;

@RelationshipEntity(type="APPLIED_VIA")
public class AppliedViaRelationshipType {

	@Id
	@GeneratedValue
	private Long relationshipId;

	@Property
	private SignalConnectionSourceType sourceType;

	@Property
	private String sourcePort;

	@Property
	@Index(unique = true)
	private String uuid;

	@StartNode
	private SignalConnectionNode signalConnectionNode;

	//base graph node project should be CONTROLUNIT or CONSTRAINT
	@EndNode
	private DataAttributeNode dataAttributeNode;

	public SignalConnectionSourceType getSourceType() {
		return sourceType;
	}
	public void setSourceType(SignalConnectionSourceType sourceType) {
		this.sourceType = sourceType;
	}
	public String getSourcePort() {
		return sourcePort;
	}
	public void setSourcePort(String sourcePort) {
		this.sourcePort = sourcePort;
	}
	public SignalConnectionNode getSignalConnectionNode() {
		return signalConnectionNode;
	}
	public void setSignalConnectionNode(SignalConnectionNode signalConnectionNode) {
		this.signalConnectionNode = signalConnectionNode;
	}
	public DataAttributeNode getDataAttributeNode() {
		return dataAttributeNode;
	}
	public void setDataAttributeNode(DataAttributeNode dataAttributeNode) {
		this.dataAttributeNode = dataAttributeNode;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}	
}
