package com.encoway.edsedit.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *	Data structure representation of &lt;instanceStructures&gt; root node
 *  of 'cl_instancesstructure.xml' in an EDS file
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "instanceStructures")
public class InstanceStructures {


	
	@XmlElement(name = "Version")
	private Version version;
	
	@XmlElement(name = "instanceStructure")
	private List< InstanceStructure > instanceStructure;



	public Version getVersion() {
		return version;
	}

	public List<InstanceStructure> getInstanceStructure() {
		return instanceStructure;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public void setInstanceStructure(List<InstanceStructure> instanceStructure) {
		this.instanceStructure = instanceStructure;
	}

}