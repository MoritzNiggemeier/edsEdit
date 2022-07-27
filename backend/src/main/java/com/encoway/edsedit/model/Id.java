package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of &lt;version&gt; node in {@link GlobalDecisionsList} and {@link Metadata} 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Id {



	@XmlAttribute(name = "id")
	private String id;



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}