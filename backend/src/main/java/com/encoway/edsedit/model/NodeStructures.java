package com.encoway.edsedit.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *	Data structure representation of &lt;nodeStructures&gt; root node
 *  of 'cl_nodestructure.xml' in an EDS file
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "nodeStructures")
public class NodeStructures {



	@XmlElement(name = "Version")
	private Version version;

	@XmlElement(name = "nodeStructure")
	private List< NodeStructure > nodeStructure;



	public Version getVersion() {
		return version;
	}

	public List<NodeStructure> getNodeStructure() {
		return nodeStructure;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public void setNodeStructure(List<NodeStructure> nodeStructure) {
		this.nodeStructure = nodeStructure;
	}

}