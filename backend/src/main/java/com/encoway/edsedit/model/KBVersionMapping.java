package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of &lt;kbversionmapping&gt; node in {@link KBVersionsMapping}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class KBVersionMapping {



	@XmlAttribute(name = "kb-name")
	private	String	kbName;

	@XmlAttribute(name = "kb-version")
	private	String	kbVersion;



	public String getKbName() {
		return kbName;
	}

	public String getKbVersion() {
		return kbVersion;
	}

	public void setKbName(String kbName) {
		this.kbName = kbName;
	}

	public void setKbVersion(String kbVersion) {
		this.kbVersion = kbVersion;
	}

}