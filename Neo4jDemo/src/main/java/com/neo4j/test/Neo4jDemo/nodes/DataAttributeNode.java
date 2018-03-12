package com.neo4j.test.Neo4jDemo.nodes;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.Relationship;

public abstract class DataAttributeNode {

	private int krawalId;

	@Index(unique=true)
	private String uuid;

	@Relationship(direction=Relationship.UNDIRECTED,type="HAS_LOADPOINT_DATA")
	private Set<LoadpointDataNode> loadPointData;

	@Relationship(direction=Relationship.UNDIRECTED,type="HAS_PLANT_DATA")
	private Set<PlantDataNode> plantData;

	@Labels
	private Set<String> label;
	

	public Set<String> getLabel() {
		return label;
	}

	public void setLabel(Set<String> label) {
		this.label = label;
	}

	public int getKrawalId() {
		return krawalId;
	}

	public void setKrawalId(int krawalId) {
		this.krawalId = krawalId;
	}	

	public Set<LoadpointDataNode> getLoadPointData() {
		return loadPointData;
	}

	public void setLoadPointData(Set<LoadpointDataNode> loadPointData) {
		this.loadPointData = loadPointData;
	}

	public Set<PlantDataNode> getPlantData() {
		return plantData;
	}

	public void setPlantData(Set<PlantDataNode> plantData) {
		this.plantData = plantData;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void addLoadpointData(Set<LoadpointDataNode> dependentData) {

		if(this.loadPointData == null)
		{
			this.loadPointData = new HashSet<>();
		}
		this.loadPointData.addAll(dependentData);
	}
	public void addPlantData(Set<PlantDataNode> independentData) {

		if(this.plantData == null)
		{
			this.plantData = new HashSet<>();
		}
		this.plantData.addAll(independentData);
	}

}
