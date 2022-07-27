package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of &lt;Mappingdate&gt; node in {@link Metadata}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Mappingdate {



	@XmlAttribute(name = "date")
	private String date;



	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}