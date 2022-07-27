package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;



/**
 *	Data structure representation of &lt;nodeStructure&gt; node in {@link NodeStructures}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NodeStructure {



	@XmlAttribute(name = "nodeId")
	private	String	nodeId;

	@XmlElement(name = "nodePath")
	private	NodePath	nodePath;



	public String getNodeId() {
		return nodeId;
	}

	public NodePath getNodePath() {
		return nodePath;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public void setNodePath(NodePath nodePath) {
		this.nodePath = nodePath;
	}

}