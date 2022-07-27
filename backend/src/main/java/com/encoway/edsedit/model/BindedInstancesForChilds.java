package com.encoway.edsedit.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;



/**
 *	Data structure representation of &lt;bindedInstancesForChilds&gt; node in {@link ConfigNode}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BindedInstancesForChilds {



	@XmlElement(name = "bindedInstanceForChild")
	private	List< BindedInstanceForChild >	bindedInstanceForChild;



	public List<BindedInstanceForChild> getBindedInstanceForChild() {
		return bindedInstanceForChild;
	}

	public void setBindedInstanceForChild(List<BindedInstanceForChild> bindedInstanceForChild) {
		this.bindedInstanceForChild = bindedInstanceForChild;
	}

}