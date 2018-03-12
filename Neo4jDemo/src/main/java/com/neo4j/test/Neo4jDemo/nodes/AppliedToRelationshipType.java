package com.neo4j.test.Neo4jDemo.nodes;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.neo4j.test.Neo4jDemo.service.SignalConnectionTargetType;


@RelationshipEntity(type="APPLIED_TO")
public class AppliedToRelationshipType {

	@Id
	@GeneratedValue
	private Long relationshipId;
	@Property
	private SignalConnectionTargetType targetType;
	@Property
	@Index(unique = true)
	private String uuid;
	@Property
	private String targetPort;
	@StartNode
	private SignalConnectionNode signalConnectionNode;
	@EndNode
	private DataAttributeNode dataAttributeNode;
	
	public SignalConnectionTargetType getTargetType() {
		return targetType;
	}
	public void setTargetType(SignalConnectionTargetType targetType) {
		this.targetType = targetType;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTargetPort() {
		return targetPort;
	}
	public void setTargetPort(String targetPort) {
		this.targetPort = targetPort;
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
	
	
}
