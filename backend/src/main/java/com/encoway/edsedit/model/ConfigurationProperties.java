package com.encoway.edsedit.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *	Data structure representation of &lt;configurationProperties&gt; root node
 *  of 'cl_configurationProperties.xml' in an EDS file
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "configurationProperties")
public class ConfigurationProperties {



	@XmlAttribute(name = "versionID")
	private	String	versionID;

	@XmlElement(name = "property")
	private	List< Property >	property;



	public String getVersionID() {
		return versionID;
	}

	public List<Property> getProperty() {
		return property;
	}

	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}

}