package com.neo4j.test.Neo4jDemo.nodes;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class AggregateNode extends DataAttributeNode {

	@Id
	@GeneratedValue
	private Long id;	
	
	private String type;
	
	
	@Relationship(direction=Relationship.OUTGOING, type="ASSEMBLY_PART_OF")
	private AggregateNode assembly;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AggregateNode getAssembly() {
		return assembly;
	}

	public void setAssembly(AggregateNode assembly) {
		this.assembly = assembly;
	}


}
