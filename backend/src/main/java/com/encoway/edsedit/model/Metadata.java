package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 *	Data structure representation of &lt;metadata&gt; root node
 *  of 'cl_metadata.xml' in an EDS file
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "metadata")
public class Metadata {



	@XmlElement(name = "version")
	private Id version;

	@XmlElement(name = "saveformat-version")
	private Id saveformatVersion;

	@XmlElement(name = "Mappingdate")
	private Mappingdate mappingdate;

	@XmlElement(name = "k-connect-version")
	private Name kConnectVersion;

	@XmlElement(name = "root-startconcept")
	private Name rootStartconcept;



	public Id getVersion() {
		return version;
	}

	public Id getSaveformatVersion() {
		return saveformatVersion;
	}

	public Mappingdate getMappingdate() {
		return mappingdate;
	}

	public Name getkConnectVersion() {
		return kConnectVersion;
	}

	public Name getRootStartconcept() {
		return rootStartconcept;
	}

	public void setVersion(Id version) {
		this.version = version;
	}

	public void setSaveformatVersion(Id saveformatVersion) {
		this.saveformatVersion = saveformatVersion;
	}

	public void setMappingdate(Mappingdate mappingdate) {
		this.mappingdate = mappingdate;
	}

	public void setkConnectVersion(Name kConnectVersion) {
		this.kConnectVersion = kConnectVersion;
	}

	public void setRootStartconcept(Name rootStartconcept) {
		this.rootStartconcept = rootStartconcept;
	}
    
}