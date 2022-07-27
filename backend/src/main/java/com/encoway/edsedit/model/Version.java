package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of &lt;Version; node
 *  {@link ConfigTree}, {@link InstanceStructures}, {@link KBVersionsMapping} and {@link NodeStructures}
*/
@XmlAccessorType(XmlAccessType.FIELD)
public class Version {



	@XmlAttribute(name = "version")
	private	String	version;



	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}