package com.neo4j.test.Neo4jDemo.nodes;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class ProjectNode {

	@Id
	@GeneratedValue
	private Long id;
	@Index(unique=true)
	private String projectName;
	private String description;
	private String s3BucketName;

	@Relationship(direction=Relationship.UNDIRECTED,type="HAS_REVISION")
	private Set<RevisionNode> revisions;
	private int latestRevisionNumber;
	private Set<HasUserRelationship> hasUser;

	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getLatestRevisionNumber() {
		return latestRevisionNumber;
	}
	public void setLatestRevisionNumber(int latestRevisionNumber) {
		this.latestRevisionNumber = latestRevisionNumber;
	}	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	public Set<RevisionNode> getRevisions() {
		return revisions;
	}
	public void setRevisions(Set<RevisionNode> revisions) {
		this.revisions = revisions;
	}
	public void addRevisions(Set<RevisionNode> revisionNodes) {

		if(this.revisions == null)
		{
			this.revisions = new HashSet<>();
		}
		this.revisions.addAll(revisionNodes);
	}

	public Set<HasUserRelationship> getHasUser() {
		return hasUser;
	}
	public void setHasUser(Set<HasUserRelationship> hasUser) {
		this.hasUser = hasUser;
	}
	public void addUsers(Set<HasUserRelationship> hasUser) {

		if(this.hasUser == null)
		{
			this.hasUser = new HashSet<>();
		}
		this.hasUser.addAll(hasUser);
	}

	public String getS3BucketName() {
		return s3BucketName;
	}
	public void setS3BucketName(String s3BucketName) {
		this.s3BucketName = s3BucketName;
	}


}
