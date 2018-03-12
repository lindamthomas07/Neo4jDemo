package com.neo4j.test.Neo4jDemo.nodes;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class RevisionNode {

	@Id
	@GeneratedValue
	private Long id;

	@Index(unique=true)
	private int revisionNumber;
	private String checkoutRevisionId;
	private String comment;
	private String s3FolderName;

	@Relationship(direction=Relationship.UNDIRECTED,type="CREATED")
	private Set<AggregateNode> aggregatesAdded;
	@Relationship(direction=Relationship.UNDIRECTED,type="CREATED")
	private Set<MediumConnectionNode> mediumConnectionsAdded;
	@Relationship(direction=Relationship.UNDIRECTED,type="CREATED")
	private Set<CycleSegmentNode> cycleSegmentsAdded;
	@Relationship(direction=Relationship.UNDIRECTED,type="CREATED")
	private Set<LoadpointDataNode> loadpointDataAdded;
	@Relationship(direction=Relationship.UNDIRECTED,type="CREATED")
	private Set<PlantDataNode> plantDataAdded;
	@Relationship(direction=Relationship.UNDIRECTED,type="CREATED")
	private Set<LoadpointNode> loadPointsAdded;
	@Relationship(direction=Relationship.UNDIRECTED,type="CREATED")
	private Set<ConstraintNode> constraintsAdded ;
	@Relationship(direction=Relationship.UNDIRECTED,type="CREATED")
	private Set<SignalConnectionNode> signalConnectionsAdded;
	@Relationship(direction=Relationship.UNDIRECTED,type="CREATED")
	private Set<ControlUnitNode> controlUnitsAdded;


	@Relationship(direction=Relationship.UNDIRECTED,type="DELETED")
	private Set<AggregateNode> aggregatesDeleted;
	@Relationship(direction=Relationship.UNDIRECTED,type="DELETED")
	private Set<MediumConnectionNode> mediumConnectionsDeleted;
	@Relationship(direction=Relationship.UNDIRECTED,type="DELETED")
	private Set<CycleSegmentNode> cycleSegmentsDeleted;
	@Relationship(direction=Relationship.UNDIRECTED,type="DELETED")
	private Set<LoadpointDataNode> loadpointDataDeleted;
	@Relationship(direction=Relationship.UNDIRECTED,type="DELETED")
	private Set<PlantDataNode> plantDataDeleted;
	@Relationship(direction=Relationship.UNDIRECTED,type="DELETED")
	private Set<LoadpointNode> loadPointsDeleted;
	@Relationship(direction=Relationship.UNDIRECTED,type="DELETED")
	private Set<ConstraintNode> constraintsDeleted ;
	@Relationship(direction=Relationship.UNDIRECTED,type="DELETED")
	private Set<SignalConnectionNode> signalConnectionsDeleted ;
	@Relationship(direction=Relationship.UNDIRECTED,type="DELETED")
	private Set<ControlUnitNode> controlUnitsDeleted;

	@Relationship(direction=Relationship.UNDIRECTED,type="UPDATED")
	private Set<AggregateNode> aggregatesUpdated;
	@Relationship(direction=Relationship.UNDIRECTED,type="UPDATED")
	private Set<MediumConnectionNode> mediumConnectionsUpdated;
	@Relationship(direction=Relationship.UNDIRECTED,type="UPDATED")
	private Set<CycleSegmentNode> cycleSegmentsUpdated;
	@Relationship(direction=Relationship.UNDIRECTED,type="UPDATED")
	private Set<LoadpointNode> loadPointsUpdated;
	@Relationship(direction=Relationship.UNDIRECTED,type="UPDATED")
	private Set<ConstraintNode> constraintsUpdated;
	@Relationship(direction=Relationship.UNDIRECTED,type="UPDATED")
	private Set<SignalConnectionNode> signalConnectionsUpdated;
	@Relationship(direction=Relationship.UNDIRECTED,type="UPDATED")
	private Set<ControlUnitNode> controlUnitsUpdated;

	@Relationship(direction=Relationship.UNDIRECTED,type="ACCESSIBLE_TO")
	private Set<UserNode> users;

	public int getRevisionNumber() {
		return revisionNumber;
	}
	public void setRevisionNumber(int revisionNumber) {
		this.revisionNumber = revisionNumber;
	}
	public Set<AggregateNode> getAggregatesAdded() {
		if(null == this.aggregatesAdded){
			return new HashSet<>();
		}
		return aggregatesAdded;
	}
	public void setAggregatesAdded(Set<AggregateNode> aggregatesAdded) {
		this.aggregatesAdded = aggregatesAdded;
	}
	public Set<MediumConnectionNode> getMediumConnectionsAdded() {
		if(null == this.mediumConnectionsAdded){
			return new HashSet<>();
		}
		return mediumConnectionsAdded;
	}
	public void setMediumConnectionsAdded(Set<MediumConnectionNode> mediumConnectionsAdded) {
		this.mediumConnectionsAdded = mediumConnectionsAdded;
	}
	public Set<CycleSegmentNode> getCycleSegmentsAdded() {
		if(null == this.cycleSegmentsAdded){
			return new HashSet<>();
		}
		return cycleSegmentsAdded;
	}
	public void setCycleSegmentsAdded(Set<CycleSegmentNode> cycleSegmentsAdded) {
		this.cycleSegmentsAdded = cycleSegmentsAdded;
	}
	public Set<AggregateNode> getAggregatesDeleted() {
		return aggregatesDeleted;
	}
	public void setAggregatesDeleted(Set<AggregateNode> aggregatesDeleted) {
		this.aggregatesDeleted = aggregatesDeleted;
	}
	public Set<MediumConnectionNode> getMediumConnectionsDeleted() {
		return mediumConnectionsDeleted;
	}
	public void setMediumConnectionsDeleted(Set<MediumConnectionNode> mediumConnectionsDeleted) {
		this.mediumConnectionsDeleted = mediumConnectionsDeleted;
	}
	public Set<CycleSegmentNode> getCycleSegmentsDeleted() {
		return cycleSegmentsDeleted;
	}
	public void setCycleSegmentsDeleted(Set<CycleSegmentNode> cycleSegmentsDeleted) {
		this.cycleSegmentsDeleted = cycleSegmentsDeleted;
	}
	public Set<LoadpointNode> getLoadPointsAdded() {
		if(null == this.loadPointsAdded){
			return new HashSet<>();
		}
		return loadPointsAdded;
	}
	public void setLoadPointsAdded(Set<LoadpointNode> loadPointsAdded) {
		this.loadPointsAdded = loadPointsAdded;
	}
	public Set<LoadpointNode> getLoadPointsDeleted() {
		return loadPointsDeleted;
	}
	public void setLoadPointsDeleted(Set<LoadpointNode> loadPointsDeleted) {
		this.loadPointsDeleted = loadPointsDeleted;
	}			
	public String getCheckoutRevisionId() {
		return checkoutRevisionId;
	}
	public void setCheckoutRevisionId(String checkoutRevisionId) {
		this.checkoutRevisionId = checkoutRevisionId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}	
	public String getS3FolderName() {
		return s3FolderName;
	}
	public void setS3FolderName(String s3FolderName) {
		this.s3FolderName = s3FolderName;
	}
	public Set<LoadpointDataNode> getLoadpointDataAdded() {
		if(null == this.loadpointDataAdded){
			return new HashSet<>();
		}
		return loadpointDataAdded;
	}
	public void setLoadpointDataAdded(Set<LoadpointDataNode> loadpointDataAdded) {
		this.loadpointDataAdded = loadpointDataAdded;
	}
	public Set<PlantDataNode> getPlantDataAdded() {
		if(null == this.plantDataAdded){
			return new HashSet<>();
		}
		return plantDataAdded;
	}
	public void setPlantDataAdded(Set<PlantDataNode> plantDataAdded) {
		this.plantDataAdded = plantDataAdded;
	}
	public Set<LoadpointDataNode> getLoadpointDataDeleted() {
		return loadpointDataDeleted;
	}
	public void setLoadpointDataDeleted(Set<LoadpointDataNode> loadpointDataDeleted) {
		this.loadpointDataDeleted = loadpointDataDeleted;
	}
	public Set<PlantDataNode> getPlantDataDeleted() {
		return plantDataDeleted;
	}
	public void setPlantDataDeleted(Set<PlantDataNode> plantDataDeleted) {
		this.plantDataDeleted = plantDataDeleted;
	}	
	public Set<ConstraintNode> getConstraintsAdded() {
		if(null == this.constraintsAdded){
			return new HashSet<>();
		}
		return constraintsAdded;
	}
	public void setConstraintsAdded(Set<ConstraintNode> constraintsAdded) {
		this.constraintsAdded = constraintsAdded;
	}
	public Set<ConstraintNode> getConstraintsDeleted() {
		return constraintsDeleted;
	}
	public void setConstraintsDeleted(Set<ConstraintNode> constraintsDeleted) {
		this.constraintsDeleted = constraintsDeleted;
	}
	public Set<SignalConnectionNode> getSignalConnectionsAdded() {
		if(null == this.signalConnectionsAdded){
			return new HashSet<>();
		}
		return signalConnectionsAdded;
	}
	public void setSignalConnectionsAdded(Set<SignalConnectionNode> signalConnectionsAdded) {
		this.signalConnectionsAdded = signalConnectionsAdded;
	}
	public Set<SignalConnectionNode> getSignalConnectionsDeleted() {
		return signalConnectionsDeleted;
	}
	public void setSignalConnectionsDeleted(Set<SignalConnectionNode> signalConnectionsDeleted) {
		this.signalConnectionsDeleted = signalConnectionsDeleted;
	}
	public Set<ControlUnitNode> getControlUnitsAdded() {
		if(null == this.controlUnitsAdded){
			return new HashSet<>();
		}
		return controlUnitsAdded;
	}
	public void setControlUnitsAdded(Set<ControlUnitNode> controlUnitsAdded) {
		this.controlUnitsAdded = controlUnitsAdded;
	}
	public Set<ControlUnitNode> getControlUnitsDeleted() {
		return controlUnitsDeleted;
	}
	public void setControlUnitsDeleted(Set<ControlUnitNode> controlUnitsDeleted) {
		this.controlUnitsDeleted = controlUnitsDeleted;
	}
	public Set<AggregateNode> getAggregatesUpdated() {
		return aggregatesUpdated;
	}
	public void setAggregatesUpdated(Set<AggregateNode> aggregatesUpdated) {
		this.aggregatesUpdated = aggregatesUpdated;
	}
	public Set<MediumConnectionNode> getMediumConnectionsUpdated() {
		return mediumConnectionsUpdated;
	}
	public void setMediumConnectionsUpdated(Set<MediumConnectionNode> mediumConnectionsUpdated) {
		this.mediumConnectionsUpdated = mediumConnectionsUpdated;
	}
	public Set<CycleSegmentNode> getCycleSegmentsUpdated() {
		return cycleSegmentsUpdated;
	}
	public void setCycleSegmentsUpdated(Set<CycleSegmentNode> cycleSegmentsUpdated) {
		this.cycleSegmentsUpdated = cycleSegmentsUpdated;
	}
	public Set<LoadpointNode> getLoadPointsUpdated() {
		return loadPointsUpdated;
	}
	public void setLoadPointsUpdated(Set<LoadpointNode> loadPointsUpdated) {
		this.loadPointsUpdated = loadPointsUpdated;
	}
	public Set<ConstraintNode> getConstraintsUpdated() {
		return constraintsUpdated;
	}
	public void setConstraintsUpdated(Set<ConstraintNode> constraintsUpdated) {
		this.constraintsUpdated = constraintsUpdated;
	}
	public Set<SignalConnectionNode> getSignalConnectionsUpdated() {
		return signalConnectionsUpdated;
	}
	public void setSignalConnectionsUpdated(Set<SignalConnectionNode> signalConnectionsUpdated) {
		this.signalConnectionsUpdated = signalConnectionsUpdated;
	}
	public Set<ControlUnitNode> getControlUnitsUpdated() {
		return controlUnitsUpdated;
	}
	public void setControlUnitsUpdated(Set<ControlUnitNode> controlUnitsUpdated) {
		this.controlUnitsUpdated = controlUnitsUpdated;
	}
	public Set<UserNode> getUsers() {
		return users;
	}
	public void setUsers(Set<UserNode> users) {
		this.users = users;
	}
	public void addAggregates(Set<AggregateNode> aggregatesAdded) {

		if(this.aggregatesAdded == null)
		{
			this.aggregatesAdded = new HashSet<>();
		}
		this.aggregatesAdded.addAll(aggregatesAdded);
	}

	public void deleteAggregates(Set<AggregateNode> aggregatesDeleted) {

		if(this.aggregatesDeleted == null)
		{
			this.aggregatesDeleted = new HashSet<>();
		}
		this.aggregatesDeleted.addAll(aggregatesDeleted);
	}

	public void updateAggregates(Set<AggregateNode> aggregatesUpdated) {

		if(this.aggregatesUpdated == null)
		{
			this.aggregatesUpdated = new HashSet<>();
		}
		this.aggregatesUpdated.addAll(aggregatesUpdated);
	}

	public void addMediumConnections(Set<MediumConnectionNode> mediumConnectionsAdded) {

		if(this.mediumConnectionsAdded == null)
		{
			this.mediumConnectionsAdded = new HashSet<>();
		}
		this.mediumConnectionsAdded.addAll(mediumConnectionsAdded);
	}

	public void deleteMediumConnections(Set<MediumConnectionNode> mediumConnectionsDeleted) {

		if(this.mediumConnectionsDeleted == null)
		{
			this.mediumConnectionsDeleted = new HashSet<>();
		}
		this.mediumConnectionsDeleted.addAll(mediumConnectionsDeleted);
	}

	public void updateMediumConnections(Set<MediumConnectionNode> mediumConnectionsUpdated) {

		if(this.mediumConnectionsUpdated == null)
		{
			this.mediumConnectionsUpdated = new HashSet<>();
		}
		this.mediumConnectionsUpdated.addAll(mediumConnectionsUpdated);
	}

	public void addCycleSegments(Set<CycleSegmentNode> cycleSegmentsAdded) {

		if(this.cycleSegmentsAdded == null)
		{
			this.cycleSegmentsAdded = new HashSet<>();
		}
		this.cycleSegmentsAdded.addAll(cycleSegmentsAdded);
	}

	public void deleteCycleSegments(Set<CycleSegmentNode> cycleSegmentsDeleted) {

		if(this.cycleSegmentsDeleted == null)
		{
			this.cycleSegmentsDeleted = new HashSet<>();
		}
		this.cycleSegmentsDeleted.addAll(cycleSegmentsDeleted);
	}

	public void updateCycleSegments(Set<CycleSegmentNode> cycleSegmentsUpdated) {

		if(this.cycleSegmentsUpdated == null)
		{
			this.cycleSegmentsUpdated = new HashSet<>();
		}
		this.cycleSegmentsUpdated.addAll(cycleSegmentsUpdated);
	}

	public void addLoadpointData(Set<LoadpointDataNode> dependentDataAdded) {

		if(this.loadpointDataAdded == null)
		{
			this.loadpointDataAdded = new HashSet<>();
		}
		this.loadpointDataAdded.addAll(dependentDataAdded);
	}

	public void deleteLoadpointData(Set<LoadpointDataNode> dependentDataDeleted) {

		if(this.loadpointDataDeleted == null)
		{
			this.loadpointDataDeleted = new HashSet<>();
		}
		this.loadpointDataDeleted.addAll(dependentDataDeleted);
	}

	public void addPlantData(Set<PlantDataNode> independentDataAdded) {

		if(this.plantDataAdded == null)
		{
			this.plantDataAdded = new HashSet<>();
		}
		this.plantDataAdded.addAll(independentDataAdded);
	}

	public void deletePlantData(Set<PlantDataNode> independentDataDeleted) {

		if(this.plantDataDeleted == null)
		{
			this.plantDataDeleted = new HashSet<>();
		}
		this.plantDataDeleted.addAll(independentDataDeleted);
	}
	
	public void addLoadPoints(Set<LoadpointNode> loadPointsAdded) {

		if(this.loadPointsAdded == null)
		{
			this.loadPointsAdded = new HashSet<>();
		}
		this.loadPointsAdded.addAll(loadPointsAdded);
	}

	public void deleteLoadPoints(Set<LoadpointNode> loadPointsDeleted) {

		if(this.loadPointsDeleted == null)
		{
			this.loadPointsDeleted = new HashSet<>();
		}
		this.loadPointsDeleted.addAll(loadPointsDeleted);
	}

	public void updateLoadPoints(Set<LoadpointNode> loadPointsUpdated) {

		if(this.loadPointsUpdated == null)
		{
			this.loadPointsUpdated = new HashSet<>();
		}
		this.loadPointsUpdated.addAll(loadPointsUpdated);
	}

	public void addConstraints(Set<ConstraintNode> constraintsAdded) {

		if(this.constraintsAdded == null)
		{
			this.constraintsAdded = new HashSet<>();
		}
		this.constraintsAdded.addAll(constraintsAdded);
	}

	public void deleteConstraints(Set<ConstraintNode> constraintsDeleted) {

		if(this.constraintsDeleted == null)
		{
			this.constraintsDeleted = new HashSet<>();
		}
		this.constraintsDeleted.addAll(constraintsDeleted);
	}

	public void updateConstraints(Set<ConstraintNode> constraintsUpdated) {

		if(this.constraintsUpdated == null)
		{
			this.constraintsUpdated = new HashSet<>();
		}
		this.constraintsUpdated.addAll(constraintsUpdated);
	}

	public void addSignalConnections(Set<SignalConnectionNode> signalConnectionsAdded) {

		if(this.signalConnectionsAdded == null)
		{
			this.signalConnectionsAdded = new HashSet<>();
		}
		this.signalConnectionsAdded.addAll(signalConnectionsAdded);
	}

	public void deleteSignalConnections(Set<SignalConnectionNode> signalConnectionsDeleted) {

		if(this.signalConnectionsDeleted == null)
		{
			this.signalConnectionsDeleted = new HashSet<>();
		}
		this.signalConnectionsDeleted.addAll(signalConnectionsDeleted);
	}
	public void updateSignalConnections(Set<SignalConnectionNode> signalConnectionsUpdated) {

		if(this.signalConnectionsUpdated == null)
		{
			this.signalConnectionsUpdated = new HashSet<>();
		}
		this.signalConnectionsUpdated.addAll(signalConnectionsUpdated);
	}

	public void addControlUnits(Set<ControlUnitNode> controlUnitsAdded) {

		if(this.controlUnitsAdded == null)
		{
			this.controlUnitsAdded = new HashSet<>();
		}
		this.controlUnitsAdded.addAll(controlUnitsAdded);
	}

	public void deleteControlUnits(Set<ControlUnitNode> controlUnitsDeleted) {

		if(this.controlUnitsDeleted == null)
		{
			this.controlUnitsDeleted = new HashSet<>();
		}
		this.controlUnitsDeleted.addAll(controlUnitsDeleted);
	}

	public void updateControlUnits(Set<ControlUnitNode> controlUnitsUpdated) {

		if(this.controlUnitsUpdated == null)
		{
			this.controlUnitsUpdated = new HashSet<>();
		}
		this.controlUnitsUpdated.addAll(controlUnitsUpdated);
	}
	
	public void addAccess(Set<UserNode> users) {

		if(this.users == null)
		{
			this.users = new HashSet<>();
		}
		this.users.addAll(users);
	}

}
