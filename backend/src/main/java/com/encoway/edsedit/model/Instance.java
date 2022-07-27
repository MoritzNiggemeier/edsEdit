package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of &lt;instance&gt; node in {@link InstanceStructure}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Instance {



	@XmlAttribute(name = "instanceId")
	private	String	instanceId;



	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

}