package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;



/**
 *	Data structure representation of &lt;configNode&gt; node in {@link ConfigTree}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfigNode {



	@XmlAttribute(name = "id")
	private	String	id;

	@XmlAttribute(name = "parentNodeId")
	private	String	parentNodeId;

	@XmlAttribute(name = "startConcept")
	private	String	startConcept;
	
	@XmlAttribute(name = "knowledgeBase")
	private	String	knowledgeBase;

	@XmlAttribute(name = "knowledgeBaseVersion")
	private	String	knowledgeBaseVersion;

	@XmlAttribute(name = "deactivated")
	private	boolean	deactivated;

	@XmlAttribute(name = "processAll")
	private	boolean	processAll;

	@XmlAttribute(name = "bindedInstanceId")
	private	String	bindedInstanceId;

    @XmlElement(name = "parametersToProcess")
    private ParametersToProcess parametersToProcess;
    
    @XmlElement(name = "bindedInstancesForChilds")
	private BindedInstancesForChilds bindedInstancesForChilds;



	public String getId() {
		return id;
	}

	public String getParentNodeId() {
		return parentNodeId;
	}

	public String getStartConcept() {
		return startConcept;
	}

	public String getKnowledgeBase() {
		return knowledgeBase;
	}

	public String getKnowledgeBaseVersion() {
		return knowledgeBaseVersion;
	}

	public boolean isDeactivated() {
		return deactivated;
	}

	public boolean isProcessAll() {
		return processAll;
	}

	public String getBindedInstanceId() {
		return bindedInstanceId;
	}

	public ParametersToProcess getParametersToProcess() {
		return parametersToProcess;
	}

	public BindedInstancesForChilds getBindedInstancesForChilds() {
		return bindedInstancesForChilds;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setParentNodeId(String parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	public void setStartConcept(String startConcept) {
		this.startConcept = startConcept;
	}

	public void setKnowledgeBase(String knowledgeBase) {
		this.knowledgeBase = knowledgeBase;
	}

	public void setKnowledgeBaseVersion(String knowledgeBaseVersion) {
		this.knowledgeBaseVersion = knowledgeBaseVersion;
	}

	public void setDeactivated(boolean deactivated) {
		this.deactivated = deactivated;
	}

	public void setProcessAll(boolean processAll) {
		this.processAll = processAll;
	}

	public void setBindedInstanceId(String bindedInstanceId) {
		this.bindedInstanceId = bindedInstanceId;
	}

	public void setParametersToProcess(ParametersToProcess parametersToProcess) {
		this.parametersToProcess = parametersToProcess;
	}

	public void setBindedInstancesForChilds(BindedInstancesForChilds bindedInstancesForChilds) {
		this.bindedInstancesForChilds = bindedInstancesForChilds;
	}

}