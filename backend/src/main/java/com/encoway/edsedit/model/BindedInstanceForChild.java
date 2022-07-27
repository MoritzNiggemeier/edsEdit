package com.encoway.edsedit.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



/**
 *	Data structure representation of &lt;bindedInstanceForChild&gt; node in {@link BindedInstancesForChilds}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BindedInstanceForChild {



	@XmlAttribute(name = "bindedInstanceId")
	private	String	bindedInstanceId;

	@XmlAttribute(name = "childNodeId")
	private	String	childNodeId;



	public String getBindedInstanceId() {
		return bindedInstanceId;
	}

	public String getChildNodeId() {
		return childNodeId;
	}

	public void setBindedInstanceId(String bindedInstanceId) {
		this.bindedInstanceId = bindedInstanceId;
	}

	public void setChildNodeId(String childNodeId) {
		this.childNodeId = childNodeId;
	}

}