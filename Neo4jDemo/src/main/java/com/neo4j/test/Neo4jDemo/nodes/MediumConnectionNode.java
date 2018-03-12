package com.neo4j.test.Neo4jDemo.nodes;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public class MediumConnectionNode extends DataAttributeNode {

	@Id
	@GeneratedValue
	private Long id;

	private Set<ViaRelationType> via;

	public Set<ViaRelationType> getVia() {
		return via;
	}

	public void setVia(Set<ViaRelationType> via) {
		this.via = via;
	}

	public void addVia(Set<ViaRelationType> via) {

		if(this.via == null)
		{
			this.via = new HashSet<>();
		}
		this.via.addAll(via);
	}
}
