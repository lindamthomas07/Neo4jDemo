package com.neo4j.test.Neo4jDemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.neo4j.test.Neo4jDemo.nodes.AggregateNode;
import com.neo4j.test.Neo4jDemo.nodes.ConstraintNode;
import com.neo4j.test.Neo4jDemo.nodes.ControlUnitNode;
import com.neo4j.test.Neo4jDemo.nodes.CycleSegmentNode;
import com.neo4j.test.Neo4jDemo.nodes.HasUserRelationship;
import com.neo4j.test.Neo4jDemo.nodes.LoadpointDataNode;
import com.neo4j.test.Neo4jDemo.nodes.LoadpointNode;
import com.neo4j.test.Neo4jDemo.nodes.MediumConnectionNode;
import com.neo4j.test.Neo4jDemo.nodes.ProjectNode;
import com.neo4j.test.Neo4jDemo.nodes.RevisionNode;
import com.neo4j.test.Neo4jDemo.nodes.SignalConnectionNode;
import com.neo4j.test.Neo4jDemo.nodes.UserNode;
import com.neo4j.test.Neo4jDemo.repository.ProjectRepository;

@Component
public class Neo4jServiceImpl {

	@Autowired
	private Neo4jHelper neo4jHelper;

	@Autowired
	ProjectRepository projectRepository;

	public void createProject(){

		ProjectNode projectNode = new ProjectNode();
		projectNode.setDescription("neo4j test project");
		projectNode.setLatestRevisionNumber(0);
		projectNode.setProjectName("Neo4jDemo");

		UserNode userNode = new UserNode();
		userNode.setCertificate("0B4318EC23CD7A98DB9FF059B0974D17D6B4488A");
		userNode.setGid("neo4j_gid");

		HasUserRelationship hasUser = new HasUserRelationship();
		hasUser.setKey("MTRGQjQyNzdDNzkyRTM3N0IyN0I5ODk3MTUxM0I=");
		hasUser.setProjectNode(projectNode);
		hasUser.setUserNode(userNode);

		projectNode.setHasUser(new HashSet<>(Arrays.asList(hasUser)));

		projectRepository.save(projectNode);

	}

	public void deleteProjectAndItsRevisionsAndUsers(String projectName,String userId){
		projectRepository.deleteProjectAndItsRevisionsAndUsers(projectName, userId);
	}

	public void stageStructure(){

		ProjectNode projectNode = projectRepository.findByProjectName("Neo4jDemo");

		LoadpointNode  loadpointNode = neo4jHelper.createLP();

		for(int i =1;i<3;i++){
			RevisionNode node = new RevisionNode();
			node.setRevisionNumber(i+1);
			Set<AggregateNode> aggregateNodes = new HashSet<>();
			Set<MediumConnectionNode> connectionNodes = new HashSet<>();
			Set<ControlUnitNode> controlUnitNodes = new HashSet<>();
			Set<ConstraintNode> constraintNodes = new HashSet<>();
			Set<SignalConnectionNode> scNodes = new HashSet<>();
			Set<LoadpointDataNode> loadpointDataNodes = new HashSet<>();

			int counter = i*100;
			int endCounter = counter+10;
			for(int j = counter ;j<=endCounter;j++ ){

				AggregateNode aggregateNode = neo4jHelper.createAggregate(j,node);
				aggregateNode.setLabel(new HashSet<>(Arrays.asList("LATEST")));
				aggregateNodes.add(aggregateNode);
				loadpointDataNodes.addAll(aggregateNode.getLoadPointData());

				MediumConnectionNode connectionNode = neo4jHelper.createMediumConnectionNode(j,aggregateNode,node);
				connectionNode.setLabel(new HashSet<>(Arrays.asList("LATEST")));
				connectionNodes.add(connectionNode);
				loadpointDataNodes.addAll(connectionNode.getLoadPointData());

				ControlUnitNode controlUnitNode = neo4jHelper.createControlUnit(j,node);
				controlUnitNode.setLabel(new HashSet<>(Arrays.asList("LATEST")));
				controlUnitNodes.add(controlUnitNode);
				loadpointDataNodes.addAll(controlUnitNode.getLoadPointData());

				ConstraintNode constraintNode = neo4jHelper.createConstraintNode(j);
				constraintNodes.add(constraintNode);
				SignalConnectionNode signalConnectionNode = neo4jHelper.createSC(j, constraintNode, connectionNode);
				scNodes.add(signalConnectionNode);

			}

			CycleSegmentNode cycleSegmentNode = neo4jHelper.createCycleSegmentNode(i,aggregateNodes,node);
			cycleSegmentNode.setLabel(new HashSet<>(Arrays.asList("LATEST")));
			loadpointDataNodes.addAll(cycleSegmentNode.getLoadPointData());

			node.addAggregates(aggregateNodes);
			node.addControlUnits(controlUnitNodes);
			node.addMediumConnections(connectionNodes);
			node.addCycleSegments(new HashSet<>(Arrays.asList(cycleSegmentNode)));
			node.addSignalConnections(scNodes);
			node.addConstraints(constraintNodes);
			node.addLoadpointData(loadpointDataNodes);
			node.addLoadPoints(new HashSet<>(Arrays.asList(loadpointNode)));
			loadpointNode.addConstraintsToLP(constraintNodes);
			loadpointNode.addSignalConnectionsToLP(scNodes);
			loadpointNode.addDataNodesToLP(loadpointDataNodes);
			projectNode.setLatestRevisionNumber(node.getRevisionNumber());
			projectNode.addRevisions(new HashSet<>(Arrays.asList(node)));
		}

		projectRepository.save(projectNode);
	}

	public void stageCheckoutRevision(){

		ProjectNode projectNode = projectRepository.findByProjectName("Neo4jDemo");
		RevisionNode node = new RevisionNode();
		node.setCheckoutRevisionId("gid_3");
		LoadpointNode  loadpointNode = projectRepository.fetchLP("Neo4jDemo");

		Set<AggregateNode> aggregateNodes = new HashSet<>();
		Set<MediumConnectionNode> connectionNodes = new HashSet<>();
		Set<ControlUnitNode> controlUnitNodes = new HashSet<>();
		Set<ConstraintNode> constraintNodes = new HashSet<>();
		Set<SignalConnectionNode> scNodes = new HashSet<>();
		Set<LoadpointDataNode> loadpointDataNodes = new HashSet<>();

		for(int j = 900 ;j<=910;j++ ){
			AggregateNode aggregateNode = neo4jHelper.createAggregate(j,node);
			aggregateNode.getPlantData().stream().findAny().get().setLabel(null);
			aggregateNodes.add(aggregateNode);
			loadpointDataNodes.addAll(aggregateNode.getLoadPointData());

			MediumConnectionNode connectionNode = neo4jHelper.createMediumConnectionNode(j,aggregateNode,node);
			connectionNode.getPlantData().stream().findAny().get().setLabel(null);
			connectionNodes.add(connectionNode);
			loadpointDataNodes.addAll(connectionNode.getLoadPointData());

			ControlUnitNode controlUnitNode = neo4jHelper.createControlUnit(j,node);
			controlUnitNode.getPlantData().stream().findAny().get().setLabel(null);
			controlUnitNodes.add(controlUnitNode);
			loadpointDataNodes.addAll(controlUnitNode.getLoadPointData());

			//ConstraintNode constraintNode = neo4jHelper.createConstraintNode(j);
			//constraintNodes.add(constraintNode);
			//SignalConnectionNode signalConnectionNode = neo4jHelper.createSC(j, constraintNode, connectionNode);
			//scNodes.add(signalConnectionNode);
		}

		CycleSegmentNode cycleSegmentNode = neo4jHelper.createCycleSegmentNode(10,aggregateNodes,node);
		cycleSegmentNode.setLabel(new HashSet<>(Arrays.asList("LATEST")));
		loadpointDataNodes.addAll(cycleSegmentNode.getLoadPointData());

		node.addAggregates(aggregateNodes);
		node.addControlUnits(controlUnitNodes);
		node.addMediumConnections(connectionNodes);
		node.addCycleSegments(new HashSet<>(Arrays.asList(cycleSegmentNode)));
		node.addSignalConnections(scNodes);
		node.addConstraints(constraintNodes);
		node.addLoadpointData(loadpointDataNodes);
		//node.addLoadPoints(new HashSet<>(Arrays.asList(loadpointNode)));
		//loadpointNode.addConstraintsToLP(constraintNodes);
		//loadpointNode.addSignalConnectionsToLP(scNodes);
		loadpointNode.addDataNodesToLP(loadpointDataNodes);
		projectNode.addRevisions(new HashSet<>(Arrays.asList(node)));

		projectRepository.save(projectNode);
	}
	public void updateAggregates(){

	}

	public void deleteAggregates(){

	}

	public void stageLoadpoint(){

	}

	public void fetchStructure(String projectName){

		ProjectNode projectNode = projectRepository.findByProjectName("Neo4jDemo");

		List<RevisionNode> revisionNodes = projectRepository.fetchStructure(projectName, projectNode.getLatestRevisionNumber());
		System.out.println(revisionNodes.size());
	}

	public void fetchStructureCheckout(String projectName,String checkoutRevisionId){

		ProjectNode projectNode = projectRepository.findByProjectName("Neo4jDemo");

		//latest revisionNumber would be the last parameter!
		List<RevisionNode> revisionNodes = projectRepository.fetchCheckoutRevision(projectName, checkoutRevisionId,projectNode.getLatestRevisionNumber());
		System.out.println(revisionNodes.size());
	}

	public void fetchAggregates(String projectName){

		List<Integer> aggregateIds = projectRepository.findAllAggregateIds(projectName);
		System.out.println(aggregateIds.size());
		List<AggregateNode> aggregateNodes = projectRepository.fetchAggregates(projectName, aggregateIds);
		System.out.println(aggregateNodes.size());
	}


	public void fetchAggregatesAndDataNodes(String projectName){

		List<Integer> aggregateIds = projectRepository.findAllAggregateIds(projectName);
		System.out.println(aggregateIds.size());
		List<AggregateNode> aggregateNodes = projectRepository.fetchAggregatesAndDataNodes(projectName, aggregateIds);
		System.out.println(aggregateNodes.size());
	}

	public List<RevisionNode> fetchLoadpoint(String projectId){

		int loadpointId = 1;

		LoadpointNode loadpointNode = projectRepository.fetchLPLatest(projectId, loadpointId);
		List<RevisionNode> revisions = null;
		if(null != loadpointNode){
			revisions = projectRepository.fetchLoadpointDataInLP(projectId,loadpointNode.getUuid());
			if(!CollectionUtils.isEmpty(revisions)){
				List<ConstraintNode> constraintNodes = projectRepository.fetchConstraintsInLP(projectId,loadpointNode.getUuid());
				List<SignalConnectionNode> signalConnectionNodes = projectRepository.fetchSignalConnectionsInLP(projectId,loadpointNode.getUuid());
				revisions.get(0).setConstraintsAdded(new HashSet<>(constraintNodes));
				revisions.get(0).setSignalConnectionsAdded(new HashSet<>(signalConnectionNodes));
			}	
		}
		return revisions;	
	}

	public List<RevisionNode> fetchLoadpointCheckout(String projectId,String checkoutRevisionId){

		int loadpointId = 1;
		ProjectNode projectNode = projectRepository.findByProjectName("Neo4jDemo");

		LoadpointNode loadpointNode = projectRepository.fetchUserRevisionLP(projectId, loadpointId, checkoutRevisionId, projectNode.getLatestRevisionNumber());
		List<RevisionNode> revisions = null;

		if(null != loadpointNode){
			List<RevisionNode> list = projectRepository.fetchLPConnectedNodes(projectId, checkoutRevisionId, projectNode.getLatestRevisionNumber(), loadpointNode.getUuid());
			if(!CollectionUtils.isEmpty(list)){
				List<String> scUUIDS = new ArrayList<>();
				List<String> dataUUIDS = new ArrayList<>();
				List<String> constraintUUIDS = new ArrayList<>();
				Set<ConstraintNode> cNodes = new HashSet<>();
				populateUUIDList(list, scUUIDS, constraintUUIDS, dataUUIDS,cNodes);
				revisions = projectRepository.fetchLPDataStructNodes(projectId,dataUUIDS,checkoutRevisionId,projectNode.getLatestRevisionNumber());
				List<SignalConnectionNode> signalConnectionNodesList = projectRepository.fetchSignalConnectionsWithConnectedNodes(scUUIDS);
				revisions.get(0).setConstraintsAdded(cNodes);
				revisions.get(0).setSignalConnectionsAdded(new HashSet<>(signalConnectionNodesList));
			}
		}
		return revisions;
	}

	private void populateUUIDList(List<RevisionNode> revisionNodes,List<String> scUUIDS,List<String> constraintUUIDS,List<String> dataUUIDS,Set<ConstraintNode> cNodes){

		if(!CollectionUtils.isEmpty(revisionNodes)){
			for(RevisionNode revisionNode:revisionNodes){
				if(!CollectionUtils.isEmpty(revisionNode.getSignalConnectionsAdded())){
					for(SignalConnectionNode dataNode:revisionNode.getSignalConnectionsAdded()){
						scUUIDS.add(dataNode.getUuid());
					}				
				}
				if(!CollectionUtils.isEmpty(revisionNode.getLoadpointDataAdded())){
					for(LoadpointDataNode dataNode:revisionNode.getLoadpointDataAdded()){
						dataUUIDS.add(dataNode.getUuid());
					}				
				}

				if(!CollectionUtils.isEmpty(revisionNode.getConstraintsAdded())){
					for(ConstraintNode constraintNode:revisionNode.getConstraintsAdded()){
						constraintUUIDS.add(constraintNode.getUuid());
						cNodes.add(constraintNode);
					}
				}
			}
		}
	}
}
