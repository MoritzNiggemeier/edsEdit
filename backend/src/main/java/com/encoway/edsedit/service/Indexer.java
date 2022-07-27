package com.encoway.edsedit.service;

import java.util.List;
import com.encoway.edsedit.model.Decision;
import com.encoway.edsedit.model.GlobalDecisionsList;

public class Indexer {

	public static GlobalDecisionsList create( GlobalDecisionsList gdl ){
		int index;
		List< Decision > decision = gdl.getDecision();
		for( index = 0; index < decision.size(); index++ ) {
			decision.get( index ).setIndex( index );
		}
		gdl.setDecision( decision );
		return gdl;
	}

}
