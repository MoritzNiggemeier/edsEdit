package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of &lt;property&gt; node in {@link configurationProperties}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Property {



	@XmlAttribute(name = "name")
	private String name;

	@XmlAttribute(name = "value")
	private String value;



	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

}