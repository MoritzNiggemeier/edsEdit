package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



/**
 *	Abstract class to represent
 *  {@link ParameterizationDecision} and {@link SetFacetDecision} 
 *  nodes in a {@link GlobalDecisionsList}
 */
@JsonDeserialize(as = EditedDecision.class)
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Decision {

	@XmlTransient
	private	int		index;

	@XmlAttribute(name = "nodeId")
	private	String	nodeId;

	@XmlAttribute(name = "decisionId")
	private	String	decisionId;

	@XmlAttribute(name = "setByExternal")
	private	boolean	setByExternal;

	@XmlAttribute(name = "setByDefault")
	private	boolean	setByDefault;

	@XmlAttribute(name = "instanceId")
	private	String	instanceId;

	@XmlAttribute(name = "parameterName")
	private	String	parameterName;



	public int getIndex() {
		return index;
	}

	public String getNodeId() {
		return nodeId;
	}

	public String getDecisionId() {
		return decisionId;
	}

	public boolean isSetByExternal() {
		return setByExternal;
	}

	public boolean isSetByDefault() {
		return setByDefault;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public void setDecisionId(String decisionId) {
		this.decisionId = decisionId;
	}

	public void setSetByExternal(boolean setByExternal) {
		this.setByExternal = setByExternal;
	}

	public void setSetByDefault(boolean setByDefault) {
		this.setByDefault = setByDefault;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

}