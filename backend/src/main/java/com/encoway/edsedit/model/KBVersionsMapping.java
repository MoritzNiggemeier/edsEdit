package com.encoway.edsedit.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *	Data structure representation of &lt;kbversionsmapping&gt; root node
 *  of 'cl_kbversions.xml' in an EDS file
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "kbversionsmapping")
public class KBVersionsMapping {



	@XmlElement(name = "Version")
	private Version version;
	
    @XmlElement(name = "kbversionmapping")
	private List< KBVersionMapping > kbVersionMapping;



	public Version getVersion() {
		return version;
	}

	public List<KBVersionMapping> getKbVersionMapping() {
		return kbVersionMapping;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public void setKbVersionMapping(List<KBVersionMapping> kbVersionMapping) {
		this.kbVersionMapping = kbVersionMapping;
	}

}