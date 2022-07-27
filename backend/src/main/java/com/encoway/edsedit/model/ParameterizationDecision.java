package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of &lt;parameterizationDecision&gt; node in {@link GlobalDecisionsList}
 */
public class ParameterizationDecision extends Decision {



	@XmlAttribute(name = "parameterValue")
	private	String	parameterValue;

	@XmlAttribute(name = "parameterDomain")
	private	String	parameterDomain;



	public String getParameterValue() {
		return parameterValue;
	}

	public String getParameterDomain() {
		return parameterDomain;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	public void setParameterDomain(String parameterDomain) {
		this.parameterDomain = parameterDomain;
	}

}