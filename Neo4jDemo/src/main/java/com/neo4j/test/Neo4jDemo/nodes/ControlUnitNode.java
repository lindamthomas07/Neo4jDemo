package com.neo4j.test.Neo4jDemo.nodes;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class ControlUnitNode extends DataAttributeNode{

	@Id
	@GeneratedValue
	private Long id;
}
