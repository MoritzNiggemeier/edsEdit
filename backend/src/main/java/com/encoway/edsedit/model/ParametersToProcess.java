package com.encoway.edsedit.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;



/**
 *	Data structure representation of &lt;parametersToProcess&gt; node in {@link configNode}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ParametersToProcess {



    @XmlElement(name = "parameterToProcess")
	private	List< ParameterToProcess >	parameterToProcess;



	public List<ParameterToProcess> getParameterToProcess() {
		return parameterToProcess;
	}

	public void setParameterToProcess(List<ParameterToProcess> parameterToProcess) {
		this.parameterToProcess = parameterToProcess;
	}

}