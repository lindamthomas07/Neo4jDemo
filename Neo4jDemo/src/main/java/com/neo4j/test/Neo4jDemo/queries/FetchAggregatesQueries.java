package com.neo4j.test.Neo4jDemo.queries;

public class FetchAggregatesQueries {

	public static final String FETCH_AGGREGATES = "WITH {1} as ids"
			+ " MATCH (p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(k:RevisionNode) with collect(k) as revisions,ids"
			+ " optional match (n:AggregateNode)-[:DELETED]-(r) where r in revisions and n.krawalId in ids "
			+ " with revisions,collect(n) as csD,ids"
			+ " match (r)-[:CREATED]- (n:AggregateNode)"
			+ " where r in revisions and n.krawalId in ids and not n in csD"
			+ " RETURN collect(n)";
	
	public static final String FETCH_AGGREGATES_DATANODES = "WITH {1} as ids "
			+ " MATCH (p:ProjectNode{projectName:{0}})-[:HAS_REVISION]-(k:RevisionNode) with collect(k) as revisions,ids "
			+ " optional match (k:AggregateNode) -[:HAS_LOADPOINT_DATA|HAS_PLANT_DATA]-(g)-[:DELETED]-(r) "
			+ " where r in revisions  and k.krawalId in ids with collect(g) as dataD,revisions,ids "
			+ " optional match (r) -[:DELETED] - (n:AggregateNode) "
			+ " where r in revisions  and n.krawalId in ids "
			+ " with collect(n) as csD,revisions,ids,dataD "
			+ " match (r) -[:CREATED]- (n:AggregateNode) "
			+ " where r in revisions and n.krawalId in ids and not n in csD "
			+ " with collect(n) as cs,revisions,ids,dataD "
			+ " optional match (k:AggregateNode)-[r1:HAS_LOADPOINT_DATA|HAS_PLANT_DATA]-(j)-[:CREATED]-(r)  "
			+ " where r in revisions and k.krawalId in ids and k in cs and not j in dataD "
			+ " RETURN r1,cs,j";
}
