package com.neo4j.test.Neo4jDemo.nodes;

import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class LoadpointDataNode {

	@Id
	@GeneratedValue
	private Long id;
	
	@Index(unique=true)
	private String uuid;

	@Labels
	private Set<String> label;
	

	public Set<String> getLabel() {
		return label;
	}

	public void setLabel(Set<String> label) {
		this.label = label;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
