package com.neo4j.test.Neo4jDemo.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.neo4j.test.Neo4jDemo.nodes.AggregateNode;
import com.neo4j.test.Neo4jDemo.nodes.ConstraintNode;
import com.neo4j.test.Neo4jDemo.nodes.LoadpointNode;
import com.neo4j.test.Neo4jDemo.nodes.ProjectNode;
import com.neo4j.test.Neo4jDemo.nodes.RevisionNode;
import com.neo4j.test.Neo4jDemo.nodes.SignalConnectionNode;
import com.neo4j.test.Neo4jDemo.queries.FetchAggregatesQueries;
import com.neo4j.test.Neo4jDemo.queries.FetchLPQueries;
import com.neo4j.test.Neo4jDemo.queries.FetchStrutureQueries;
import com.neo4j.test.Neo4jDemo.queries.ProjectQueries;


public interface ProjectRepository extends Neo4jRepository<ProjectNode,Long>{

	public ProjectNode findByProjectName(String projectName);

	@Query(FetchStrutureQueries.FETCH_STRUTURE_LATEST)
	public List<RevisionNode> fetchStructure(String projectName,int revisionNumber);

	@Query(FetchStrutureQueries.FETCH_STRUTURE_CHECKOUT)
	public List<RevisionNode> fetchCheckoutRevision(String projectName,String checkoutRevisionId,int revisionNumber);

	@Query(ProjectQueries.DELETE_PROJECT)
	public void deleteProjectAndItsRevisionsAndUsers(String projectName,String userId);	

	//this query is just for demonstration purpose. not used actually!
	@Query("match (p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(r:RevisionNode) with collect(r) as revisions "
			+ "optional match(r)-[]-(a:AggregateNode) where r in revisions return a.krawalId")
	public List<Integer> findAllAggregateIds(String projectName);

	/*it is possible to have "DELETED" relationships as well from a revision to aggregate. However, that is not depicted in this demo model.
	this query aims to fetch all nodes that has ONLY created and NOT deleted relationship
	not necessarily to have LATEST label as USER might be yet to commit the changes. 
	LATEST label is added on "commit"*/

	@Query(FetchAggregatesQueries.FETCH_AGGREGATES)
	public List<AggregateNode> fetchAggregates(String projectName,List<Integer> aggregateIds);

	@Query(FetchAggregatesQueries.FETCH_AGGREGATES_DATANODES)
	public List<AggregateNode> fetchAggregatesAndDataNodes(String projectName,List<Integer> aggregateIds);



	//fetch LP
	@Query(FetchLPQueries.FETCH_LOADPOINT_WITH_ID_LATEST)
	public LoadpointNode fetchLPLatest(String projectName,int loadpointId);

	@Query(FetchLPQueries.FETCH_LOADPOINT_DATA_LATEST)
	public List<RevisionNode> fetchLoadpointDataInLP(String projectName,String lpUUID);

	@Query(FetchLPQueries.FETCH_CONSTRAINT_LATEST)
	public List<ConstraintNode> fetchConstraintsInLP(String projectName,String lpUUID);

	@Query(FetchLPQueries.FETCH_SIGNALCONNECTION_LATEST)
	public List<SignalConnectionNode> fetchSignalConnectionsInLP(String projectName,String lpUUID);

	//fetch lp - user revision
	@Query(FetchLPQueries.FETCH_LOADPOINT_WITH_ID_CHECKOUT_REVISION)
	public LoadpointNode fetchUserRevisionLP(String projectName,int loadpointId,String checkoutRevisionId, int latestRevisionNumber);

	@Query(FetchLPQueries.FETCH_LP_NODES)
	public List<RevisionNode> fetchLPConnectedNodes(String projectName,String checkoutRevisionId, int latestRevisionNumber,String lpUUID);

	@Query(FetchLPQueries.FETCH_LP_DATA_STRUCTNODES)
	public List<RevisionNode> fetchLPDataStructNodes(String projectId,List<String> objectUUIDs, String checkoutRevisionId, int latestRevisionNumber);

	@Query(FetchLPQueries.FETCH_SC_STRUCTURE_NODES)
	public List<SignalConnectionNode> fetchSignalConnectionsWithConnectedNodes(List<String> objectUUIDs);

	@Query("match (p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(r:RevisionNode) with collect(r) as revisions "
			+ "optional match(r)-[]-(a:LoadpointNode{krawalId:1}) where r in revisions return a")
	public LoadpointNode fetchLP(String prName);

}
