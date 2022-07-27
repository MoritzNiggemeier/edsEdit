package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of &lt;pathElement&gt; node in {@link NodePath}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PathElement {



	@XmlAttribute(name = "knowledgeBase")
	private	String	knowledgeBase;

	@XmlAttribute(name = "startConcept")
	private	String	startConcept;

	@XmlAttribute(name = "nodeCount")
	private	String	nodeCount;



	public String getKnowledgeBase() {
		return knowledgeBase;
	}

	public String getStartConcept() {
		return startConcept;
	}

	public String getNodeCount() {
		return nodeCount;
	}

	public void setKnowledgeBase(String knowledgeBase) {
		this.knowledgeBase = knowledgeBase;
	}

	public void setStartConcept(String startConcept) {
		this.startConcept = startConcept;
	}

	public void setNodeCount(String nodeCount) {
		this.nodeCount = nodeCount;
	}

}