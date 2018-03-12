package com.neo4j.test.Neo4jDemo.queries;

public class FetchStrutureQueries {

	public static final String FETCH_STRUTURE_LATEST = "match (p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(r:RevisionNode) where r.revisionNumber>0 and r.revisionNumber<={1}"
			+ " with collect(r) as revisions"
			+ " call apoc.path.subgraphAll(revisions,{maxlevel:1,labelFilter:\"+LATEST\"}) yield nodes, relationships"
			+ " return filter(x in nodes where not x:LoadpointNode and not x:LoadpointDataNode and not x:SignalConnectionNode and not x:ConstraintNode), relationships";

	public static final String FETCH_STRUTURE_CHECKOUT = "match (p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(r:RevisionNode)"
			+ " where (r.revisionNumber<={2} and r.revisionNumber>0) or r.checkoutRevisionId={1}"
			+ " with collect(r) as revisions"
			+ " optional match (r)-[:DELETED]-(n) where r in revisions and not n:LoadpointNode and not n:LoadpointDataNode and not n:SignalConnectionNode and not n:ConstraintNode"
			+ " with revisions, collect(id(n)) as dids"
			+ " call apoc.path.subgraphAll(revisions,{maxlevel:1,relationshipFilter:\"CREATED>\",labelFilter:\"-LoadpointNode|LoadpointDataNode|SignalConnectionNode|ConstraintNode\"}) yield nodes, relationships"
			+ " return filter(x in nodes where not id(x) in dids), relationships";
}
