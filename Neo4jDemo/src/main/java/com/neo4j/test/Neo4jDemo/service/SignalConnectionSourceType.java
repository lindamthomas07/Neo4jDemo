package com.neo4j.test.Neo4jDemo.service;

public enum SignalConnectionSourceType {

	CONTROLUNIT("CONTROLUNIT"),CONSTRAINT("CONSTRAINT");

	private String sourceType;

	SignalConnectionSourceType(String sourceType)
	{
		this.sourceType = sourceType;
	}
	
	public String getSourceType(){
		
		return this.sourceType;
	}
}
