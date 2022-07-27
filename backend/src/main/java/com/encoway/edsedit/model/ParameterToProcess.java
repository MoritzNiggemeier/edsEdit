package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;



/**
 *	Data structure representation of &lt;parameterToProcess&gt; node in {@link ParametersToProcess}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ParameterToProcess {



	@XmlValue
	private String parameterName;



	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

}