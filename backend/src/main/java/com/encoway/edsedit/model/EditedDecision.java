package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 *	Class to hold react decision list
 */
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties( ignoreUnknown = true )
public class EditedDecision extends Decision {

	private	int			index;
	private	String		indexUpdated;

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

	
	@XmlAttribute(name = "parameterValue")
	private	String	parameterValue;

	@XmlAttribute(name = "parameterDomain")
	private	String	parameterDomain;
	

	@XmlAttribute(name = "facetName")
	private	String	facetName;

	@XmlAttribute(name = "facetValue")
	private	String	facetValue;



	public int getIndex() {
		return index;
	}

	public String getIndexUpdated() {
		return indexUpdated;
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


	public String getParameterValue() {
		return parameterValue;
	}

	public String getParameterDomain() {
		return parameterDomain;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public void setParameterDomain(String parameterDomain) {
		this.parameterDomain = parameterDomain;
	}


	public String getFacetName() {
		return facetName;
	}

	public String getFacetValue() {
		return facetValue;
	}

	public void setFacetName(String facetName) {
		this.facetName = facetName;
	}

	public void setFacetValue(String facetValue) {
		this.facetValue = facetValue;
	}

	
	public <T> T reassemble(){
		T result = this.parameterDomain.equals("FACET")
			? (T)new SetFacetDecision()
			: (T)new ParameterizationDecision();
		((Decision)result).setNodeId( this.nodeId );
		((Decision)result).setDecisionId( this.decisionId );
		((Decision)result).setSetByExternal( this.setByExternal );
		((Decision)result).setSetByDefault( this.setByDefault );
		((Decision)result).setInstanceId( this.instanceId );
		if( this.parameterDomain.equals("FACET" )){
			((SetFacetDecision)result).setParameterName( this.parameterName.split(" ")[1] );
			((SetFacetDecision)result).setFacetName( this.parameterName.split(" ")[0] );
			((SetFacetDecision)result).setFacetValue( this.parameterValue );
		} else {
			((ParameterizationDecision)result).setParameterName( this.parameterName );
			((ParameterizationDecision)result).setParameterValue( this.parameterValue );
			((ParameterizationDecision)result).setParameterDomain( this.parameterDomain );
		}
		return result;
	}
	
}