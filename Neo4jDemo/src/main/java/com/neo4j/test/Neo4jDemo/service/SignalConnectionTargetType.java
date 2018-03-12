package com.neo4j.test.Neo4jDemo.service;

public enum SignalConnectionTargetType {

	AGGREGATE("AGGREGATE"),MEDIUMCONNECTION("MEDIUMCONNECTION"),CONSTRAINT("CONSTRAINT");

	private String targetType;

	private SignalConnectionTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getTargetType(){

		return this.targetType;
	}
}
