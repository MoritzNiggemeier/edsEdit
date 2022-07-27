package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of
 *  &lt;k-connect-version&gt; node in {@link Metadata}
 *  and
 *  &lt;root-startconcept&gt; node in {@link Metadata}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Name {



	@XmlAttribute(name = "name")
	private String name;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}