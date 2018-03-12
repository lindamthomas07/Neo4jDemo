package com.neo4j.test.Neo4jDemo.queries;

public class FetchLPQueries {

	public static final String FETCH_LOADPOINT_WITH_ID_LATEST = "match(p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(r:RevisionNode) "
			+ " with collect(r) as revisions "
			+ " match(l:LoadpointNode:LATEST{krawalId:{1}})-[:CREATED]-(r) where r in revisions"
			+ " return l";

	public static final String FETCH_LOADPOINT_DATA_LATEST = "match(p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(r:RevisionNode) "
			+ " with collect(r) as revisions "
			+ " match(l:LoadpointNode{uuid:{1}})  with l,revisions "
			+ " match(l)-[:BELONGS_TO]-(dataN:LATEST)-[dataR:HAS_LOADPOINT_DATA]-(structN:LATEST)-[createdR:CREATED]-(r)"
			+ " where r in revisions "
			+ " return createdR,r,structN,dataR,dataN";

	public static final String FETCH_CONSTRAINT_LATEST =  "match(l:LoadpointNode{uuid:{1}}) with l "
			+ " match(l)-[:BELONGS_TO]-(consN:ConstraintNode:LATEST) with  collect(consN) as constraints "
			+ " optional match(c)-[linkR:LINKS_TO]-(lpN:LoadpointNode) where c in constraints "
			+ " return constraints,linkR,lpN";

	public static final String FETCH_SIGNALCONNECTION_LATEST =  " match(l:LoadpointNode{uuid:{1}})"
			+ " with l   "
			+ " match(l)-[:HAS_SIGNAL_CONNECTION]-(dataN:LATEST)-[dataR]-(structN:LATEST) return collect(dataN) as sc,dataR,collect(structN)";

	
	
	
	//user revision
	public static final String FETCH_LOADPOINT_WITH_ID_CHECKOUT_REVISION = "match (p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(r:RevisionNode)"
			+ " where r.checkoutRevisionId={2} or (r.revisionNumber>0 and r.revisionNumber<={3})"
			+ " with collect(r) as revisions"
			+ " optional match(l:LoadpointNode{krawalId:{1}})-[:DELETED]-(r) where r in revisions with collect(l) as lpD,revisions"
			+ " match (l:LoadpointNode{krawalId:{1}})-[:CREATED]-(r) where r in revisions and not l in lpD"
			+ " return l";

	public static final String FETCH_LP_NODES = "match (p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(r:RevisionNode) "
			+ " where (r.revisionNumber<={2} and r.revisionNumber>0) or r.checkoutRevisionId={1} "
			+ " with collect(r) as revisions "
			+ " match(l:LoadpointNode{uuid:{3}})"
			+ " optional match(l)-[]-(dataNodes)-[:DELETED]-(r) where r in revisions with collect(dataNodes) as dataD,revisions,l "
			+ " match(l)-[]-(dataNodes)-[cr:CREATED]-(r) where r in revisions and not dataNodes in dataD "
			+ " with collect(dataNodes) as dataN,cr,r"
			+ " optional match (s:ConstraintNode)-[lpR:LINKS_TO]-(l:LoadpointNode) where s in dataN"
			+ " return dataN,cr,r,lpR,l";

	public static final String FETCH_LP_DATA_STRUCTNODES="with {1} as map "
			+ " match (p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(r:RevisionNode)"
			+ " where r.checkoutRevisionId={2} or (r.revisionNumber>0 and r.revisionNumber<={3}) "
			+ " with collect(r) as revisions,map"
			+ " optional match(d:LoadpointDataNode)-[:HAS_LOADPOINT_DATA]-(structNodes)-[:DELETED]-(r) where r in revisions and d.uuid in map "
			+ " with collect(structNodes) as structD,revisions,map "
			+ " match (d:LoadpointDataNode)-[dataR:HAS_LOADPOINT_DATA]-(structNodes)-[structCR:CREATED]-(r) where r in revisions and d.uuid in map and not structNodes in structD"
			+ " return collect(structNodes) as struct,collect(d) as data, dataR,structCR,r ";

	public static final String FETCH_SC_STRUCTURE_NODES = "with {0} as map "
			+ " match(s:SignalConnectionNode)-[viaR]-(viaN) where s.uuid in map "
			+ " return collect(s),viaR,collect(viaN) as viaNodes";


}
