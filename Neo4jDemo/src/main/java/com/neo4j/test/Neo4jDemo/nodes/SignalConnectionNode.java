package com.neo4j.test.Neo4jDemo.nodes;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class SignalConnectionNode {

	@Id
	@GeneratedValue
	private Long id;
	private int krawalId;

	@Index(unique=true)
	private String uuid;

	private Set<AppliedViaRelationshipType>	 appliedVia;
	private Set<AppliedToRelationshipType> appliedTo;
	public Set<AppliedViaRelationshipType> getAppliedVia() {
		return appliedVia;
	}
	public void setAppliedVia(Set<AppliedViaRelationshipType> appliedVia) {
		this.appliedVia = appliedVia;
	}
	public Set<AppliedToRelationshipType> getAppliedTo() {
		return appliedTo;
	}
	public void setAppliedTo(Set<AppliedToRelationshipType> appliedTo) {
		this.appliedTo = appliedTo;
	}	
	public int getKrawalId() {
		return krawalId;
	}
	public void setKrawalId(int krawalId) {
		this.krawalId = krawalId;
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void appliedVia(Set<AppliedViaRelationshipType> appliedVia) {

		if(this.appliedVia == null)
		{
			this.appliedVia = new HashSet<>();
		}
		this.appliedVia.addAll(appliedVia);
	}

	public void appliedTo(Set<AppliedToRelationshipType> appliedTo) {

		if(this.appliedTo == null)
		{
			this.appliedTo = new HashSet<>();
		}
		this.appliedTo.addAll(appliedTo);
	}
}
