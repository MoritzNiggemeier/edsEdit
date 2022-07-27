package com.encoway.edsedit.model;

import java.util.List;
import java.util.ArrayList;

public class EDSFile {

	public	List< EDSEntry >		entry;
	
	public	ConfigTree				configtree;
	public	ConfigurationProperties	configurationProperties;
	public	GlobalDecisionsList		globaldecisionslist;
	public	InstanceStructures		instancestructure;
	public	KBVersionsMapping		kbversions;
	public	Metadata				metadata;
	public	NodeStructures			nodestructure;
	public	DPMSalesContext			salesContext;

	public	Configurations			configurations;

	public	EDSFile() {
		this.entry = new ArrayList< EDSEntry >();
	}

}