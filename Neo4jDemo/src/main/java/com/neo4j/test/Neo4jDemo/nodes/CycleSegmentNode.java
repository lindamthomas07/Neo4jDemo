package com.neo4j.test.Neo4jDemo.nodes;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class CycleSegmentNode extends DataAttributeNode {

	@Id
	@GeneratedValue
	private Long id;

	@Relationship(direction=Relationship.UNDIRECTED,type="CONTAINS_AGGREGATES")
	private Set<AggregateNode> aggregates;

	public Set<AggregateNode> getAggregates() {
		return aggregates;
	}
	public void setAggregates(Set<AggregateNode> aggregates) {
		this.aggregates = aggregates;
	}
	public void addAggregates(Set<AggregateNode> aggregates) {

		if(this.aggregates == null)
		{
			this.aggregates = new HashSet<>();
		}
		this.aggregates.addAll(aggregates);
	}
}
