package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of &lt;setFacetDecision&gt; node in {@link GlobalDecisionsList}
 */
public class SetFacetDecision extends Decision {



	@XmlAttribute(name = "facetName")
	private	String	facetName;

	@XmlAttribute(name = "facetValue")
	private	String	facetValue;



	public String getFacetName() {
		return facetName;
	}

	public String getFacetValue() {
		return facetValue;
	}

	public void setFacetName(String facetName) {
		this.facetName = facetName;
	}

	public void setFacetValue(String facetValue) {
		this.facetValue = facetValue;
	}

}