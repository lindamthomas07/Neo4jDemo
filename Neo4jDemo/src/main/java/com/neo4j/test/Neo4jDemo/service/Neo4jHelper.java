package com.neo4j.test.Neo4jDemo.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.neo4j.test.Neo4jDemo.nodes.AggregateNode;
import com.neo4j.test.Neo4jDemo.nodes.AppliedToRelationshipType;
import com.neo4j.test.Neo4jDemo.nodes.AppliedViaRelationshipType;
import com.neo4j.test.Neo4jDemo.nodes.ConstraintNode;
import com.neo4j.test.Neo4jDemo.nodes.ControlUnitNode;
import com.neo4j.test.Neo4jDemo.nodes.CycleSegmentNode;
import com.neo4j.test.Neo4jDemo.nodes.LoadpointDataNode;
import com.neo4j.test.Neo4jDemo.nodes.LoadpointNode;
import com.neo4j.test.Neo4jDemo.nodes.MediumConnectionNode;
import com.neo4j.test.Neo4jDemo.nodes.PlantDataNode;
import com.neo4j.test.Neo4jDemo.nodes.RevisionNode;
import com.neo4j.test.Neo4jDemo.nodes.SignalConnectionNode;
import com.neo4j.test.Neo4jDemo.nodes.ViaRelationType;

@Component
public class Neo4jHelper {

	public AggregateNode createAggregate(int counter,RevisionNode node){

		AggregateNode aggregateNode = new AggregateNode();
		aggregateNode.setKrawalId(counter);
		aggregateNode.setType("type");
		aggregateNode.setUuid(UUID.randomUUID().toString());
		PlantDataNode dataNode  = createPlantData();
		Set<PlantDataNode> independentData = new HashSet<>();
		independentData.add(dataNode);
		aggregateNode.addPlantData(independentData);
		
		LoadpointDataNode loadpointDataNode = createLoadpointData();
		aggregateNode.addLoadpointData(new HashSet<>(Arrays.asList(loadpointDataNode)));
		node.addPlantData(independentData);

		return aggregateNode;
	}

	public ControlUnitNode createControlUnit(int counter,RevisionNode node){

		ControlUnitNode controlUnitNode = new ControlUnitNode();
		controlUnitNode.setKrawalId(counter);
		controlUnitNode.setUuid(UUID.randomUUID().toString());
		PlantDataNode dataNode  = createPlantData();
		Set<PlantDataNode> independentData = new HashSet<>();
		independentData.add(dataNode);
		controlUnitNode.addPlantData(independentData);
		
		LoadpointDataNode loadpointDataNode = createLoadpointData();
		controlUnitNode.addLoadpointData(new HashSet<>(Arrays.asList(loadpointDataNode)));
		
		node.addPlantData(independentData);

		return controlUnitNode;
	}
	
	public MediumConnectionNode createMediumConnectionNode(int counter,AggregateNode aggregateNode,RevisionNode node){

		MediumConnectionNode mediumConnectionNode = new MediumConnectionNode();
		mediumConnectionNode.setKrawalId(counter);
		mediumConnectionNode.setUuid(UUID.randomUUID().toString());
		
		ViaRelationType relationType = new ViaRelationType();
		relationType.setAggregateNode(aggregateNode);
		relationType.setConnectionNode(mediumConnectionNode);
		relationType.setPortNumber("NN1");
		relationType.setUuid(UUID.randomUUID().toString());
		Set<ViaRelationType> relationTypes = new HashSet<>();
		relationTypes.add(relationType);
		mediumConnectionNode.addVia(relationTypes);

		PlantDataNode dataNode  = createPlantData();
		Set<PlantDataNode> independentData = new HashSet<>();
		independentData.add(dataNode);
		mediumConnectionNode.addPlantData(independentData);
		node.addPlantData(independentData);
		LoadpointDataNode loadpointDataNode = createLoadpointData();
		mediumConnectionNode.addLoadpointData(new HashSet<>(Arrays.asList(loadpointDataNode)));
		return mediumConnectionNode;
	}

	public CycleSegmentNode createCycleSegmentNode(int counter,Set<AggregateNode> aggregateNodes,RevisionNode node){

		CycleSegmentNode cycleSegmentNode = new CycleSegmentNode();
		cycleSegmentNode.setKrawalId(counter);
		cycleSegmentNode.setUuid(UUID.randomUUID().toString());
		PlantDataNode dataNode  = createPlantData();
		Set<PlantDataNode> independentData = new HashSet<>();
		independentData.add(dataNode);
		cycleSegmentNode.addPlantData(independentData);
		
		cycleSegmentNode.addAggregates(aggregateNodes);
		
		node.addPlantData(independentData);
		
		LoadpointDataNode loadpointDataNode = createLoadpointData();
		cycleSegmentNode.addLoadpointData(new HashSet<>(Arrays.asList(loadpointDataNode)));
		return cycleSegmentNode;
	}
	
	public ConstraintNode createConstraintNode(int counter){
		
		ConstraintNode constraintNode = new ConstraintNode();
		constraintNode.setKrawalId(counter);
		constraintNode.setUuid(UUID.randomUUID().toString());
		return constraintNode;
	}
	
	public SignalConnectionNode createSC(int counter,ConstraintNode constraintNode,MediumConnectionNode connectionNode){
		
		SignalConnectionNode scNode = new SignalConnectionNode();
		scNode.setKrawalId(counter);
		scNode.setUuid(UUID.randomUUID().toString());
		
		AppliedViaRelationshipType appliedViaRelationshipType = new AppliedViaRelationshipType();
		appliedViaRelationshipType.setDataAttributeNode(constraintNode);
		appliedViaRelationshipType.setSignalConnectionNode(scNode);
		appliedViaRelationshipType.setSourcePort("NN1");
		appliedViaRelationshipType.setSourceType(SignalConnectionSourceType.CONSTRAINT);
		scNode.appliedVia(new HashSet<>(Arrays.asList(appliedViaRelationshipType)));
		
		
		AppliedToRelationshipType appliedToRelationshipType = new AppliedToRelationshipType();
		appliedToRelationshipType.setDataAttributeNode(connectionNode);
		appliedToRelationshipType.setSignalConnectionNode(scNode);
		appliedToRelationshipType.setTargetPort("NN2");
		appliedToRelationshipType.setTargetType(SignalConnectionTargetType.MEDIUMCONNECTION);
		scNode.appliedTo(new HashSet<>(Arrays.asList(appliedToRelationshipType)));
		
		return scNode;
	}
	public LoadpointNode createLP(){
		
		LoadpointNode loadpointNode = new LoadpointNode();
		loadpointNode.setKrawalId(1);
		
		return loadpointNode;		
	}

	
	public PlantDataNode createPlantData(){

		PlantDataNode dataNode = new PlantDataNode();
		dataNode.setUuid(UUID.randomUUID().toString());
		dataNode.setLabel(new HashSet<>(Arrays.asList("LATEST")));
		return dataNode;
	}
	public LoadpointDataNode createLoadpointData(){

		LoadpointDataNode dataNode = new LoadpointDataNode();
		dataNode.setUuid(UUID.randomUUID().toString());
		dataNode.setLabel(new HashSet<>(Arrays.asList("LATEST")));
		return dataNode;
	}
}
