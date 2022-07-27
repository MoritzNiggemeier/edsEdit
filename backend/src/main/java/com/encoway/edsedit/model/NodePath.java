package com.encoway.edsedit.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;



/**
 *	Data structure representation of &lt;nodePath&gt; node in {@link NodeStructure}
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NodePath {



	@XmlElement(name = "pathElement")
	private	List< PathElement >	pathElement;



	public List<PathElement> getPathElement() {
		return pathElement;
	}

	public void setPathElement(List<PathElement> pathElement) {
		this.pathElement = pathElement;
	}

}