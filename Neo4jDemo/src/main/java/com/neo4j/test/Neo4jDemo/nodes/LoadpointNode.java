package com.neo4j.test.Neo4jDemo.nodes;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class LoadpointNode  extends DataAttributeNode{

	@Id
	@GeneratedValue
	private Long id;	

	@Relationship(type="BELONGS_TO",direction=Relationship.UNDIRECTED)
	private Set<LoadpointDataNode> loadpointDataNodes;

	@Relationship(type="BELONGS_TO",direction=Relationship.UNDIRECTED)
	private Set<ConstraintNode> constraintNodes;
	
	@Relationship(type="HAS_SIGNAL_CONNECTION",direction=Relationship.UNDIRECTED)
	private Set<SignalConnectionNode> signalConnectionNodes;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<LoadpointDataNode> getLoadpointDataNodes() {
		return loadpointDataNodes;
	}
	public void setLoadpointDataNodes(Set<LoadpointDataNode> loadpointDataNodes) {
		this.loadpointDataNodes = loadpointDataNodes;
	}
	public Set<ConstraintNode> getConstraintNodes() {
		return constraintNodes;
	}
	public void setConstraintNodes(Set<ConstraintNode> constraintNodes) {
		this.constraintNodes = constraintNodes;
	}
	public Set<SignalConnectionNode> getSignalConnectionNodes() {
		return signalConnectionNodes;
	}
	public void setSignalConnectionNodes(Set<SignalConnectionNode> signalConnectionNodes) {
		this.signalConnectionNodes = signalConnectionNodes;
	}
	public void addDataNodesToLP(Set<LoadpointDataNode> loadpointDataNodes) {

		if(this.loadpointDataNodes == null)
		{
			this.loadpointDataNodes = new HashSet<>();
		}
		this.loadpointDataNodes.addAll(loadpointDataNodes);
	}

	public void addConstraintsToLP(Set<ConstraintNode> constraintNodes) {

		if(this.constraintNodes == null)
		{
			this.constraintNodes = new HashSet<>();
		}
		this.constraintNodes.addAll(constraintNodes);
	}
	
	public void addSignalConnectionsToLP(Set<SignalConnectionNode> signalConnectionNodes) {

		if(this.signalConnectionNodes == null)
		{
			this.signalConnectionNodes = new HashSet<>();
		}
		this.signalConnectionNodes.addAll(signalConnectionNodes);
	}
}
