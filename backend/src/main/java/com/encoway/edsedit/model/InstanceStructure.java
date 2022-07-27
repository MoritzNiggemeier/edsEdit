package com.encoway.edsedit.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;



/**
 *	Data structure representation of &lt;instanceStructure&gt; node in {@link InstanceStructures}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InstanceStructure {



	@XmlAttribute(name = "nodeId")
	private	String	nodeId;

	@XmlElement(name = "instance")
	private	List< Instance >	instance;



	public String getNodeId() {
		return nodeId;
	}

	public List<Instance> getInstance() {
		return instance;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public void setInstance(List<Instance> instance) {
		this.instance = instance;
	}

}