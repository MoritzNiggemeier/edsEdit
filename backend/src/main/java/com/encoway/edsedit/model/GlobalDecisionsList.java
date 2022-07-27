package com.encoway.edsedit.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;




/**
 *	Data structure representation of &lt;globalDecisionsList&gt; root node
 *  of 'cl_globaldecisionslist.xml' in an EDS file
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "globalDecisionsList")
public class GlobalDecisionsList {



	@XmlElement(name = "version")
	private	Id	version;

	@XmlElements({
		@XmlElement(
				name = "setFacetDecision",
				type = SetFacetDecision.class ),
		@XmlElement(
				name = "parameterizationDecision",
				type = ParameterizationDecision.class )
	})
	private	List<Decision> decision;



	public Id getVersion() {
		return version;
	}

	public List<Decision> getDecision() {
		return decision;
	}

	public void setVersion(Id version) {
		this.version = version;
	}

	public void setDecision(List<Decision> decision) {
		this.decision = decision;
	}

}