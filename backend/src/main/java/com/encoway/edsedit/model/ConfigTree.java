package com.encoway.edsedit.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;



/**
 *	Data structure representation of &lt;configTree&gt; root node
 *  of 'cl_configtree.xml' in an EDS file
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "configTree")
public class ConfigTree {



    @XmlElement(name = "Version")
    private Version version;
	
    @XmlElement(name = "configNode")
    private List< ConfigNode > configNode;



	public Version getVersion() {
		return version;
	}

	public List<ConfigNode> getConfigNode() {
		return configNode;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public void setConfigNode(List<ConfigNode> configNode) {
		this.configNode = configNode;
	}

}