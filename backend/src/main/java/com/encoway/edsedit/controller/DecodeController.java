package com.encoway.edsedit.controller;

import java.util.Base64;
import org.json.JSONObject;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.encoway.edsedit.model.*;
import com.encoway.edsedit.service.ZIP;
import com.encoway.edsedit.service.XML;
import com.encoway.edsedit.service.Indexer;

@RestController
public class DecodeController {

    @CrossOrigin( origins = "http://localhost:8088" )
    @RequestMapping( value = "/decode", method = RequestMethod.POST )
	public ResponseEntity< String > decodeController( @RequestParam MultipartFile file ){

		JSONObject json = new JSONObject();
		EDSFile edsf = ZIP.decompress( file );
		String name = "";
		Object data;
		for( EDSEntry edse : edsf.entry ){

			name = edse.name.substring(3, edse.name.length() - 4);
			data = null;
			
			switch( edse.name ){
				case "cl_configtree.xml" :
					data = XML.deserialize( ConfigTree.class, edse.data );
					break;
				case "cl_configurationProperties.xml" :
					data = XML.deserialize( ConfigurationProperties.class, edse.data );
					break;
				case "cl_globaldecisionslist.xml" :
					data = XML.deserialize( GlobalDecisionsList.class, edse.data );
					Indexer.create(( GlobalDecisionsList ) data );
					break;
				case "cl_instancestructure.xml" :
					data = XML.deserialize( InstanceStructures.class, edse.data );
					break;
				case "cl_kbversions.xml" :
					data = XML.deserialize( KBVersionsMapping.class, edse.data );
					break;
				case "cl_metadata.xml" :
					data = XML.deserialize( Metadata.class, edse.data );
					break;
				case "cl_nodestructure.xml" :
					data = XML.deserialize( NodeStructures.class, edse.data );
					break;
				case "cl_salesContext.xml" :
					data = XML.deserialize( DPMSalesContext.class, edse.data );
					break;
				case "cl_configurations.zip" :
					data = Base64.getEncoder().encodeToString( edse.data );
					break;
			}

			if( data != null ) {
				try { json.put( name, new JSONObject( data )); }
				catch( JSONException excp ) {}
			} else {
				json.put( name, data );
			}

		}

	    return ResponseEntity.ok()
	            .headers( null )
	            .contentType( MediaType.parseMediaType( "application/json" ))
	            .body( json.toString());

    }

}