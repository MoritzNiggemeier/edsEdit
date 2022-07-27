package com.encoway.edsedit.controller;

import java.util.List;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.encoway.edsedit.model.*;
import com.encoway.edsedit.service.ZIP;

@RestController
public class EncodeController {

    @CrossOrigin( origins = "http://localhost:8088" )
	@RequestMapping( value = "/encode", method = RequestMethod.POST )
	public ResponseEntity<ByteArrayResource> encodeController( @RequestParam String data ){

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			EDSFile edsf = objectMapper.readValue( data, EDSFile.class );

			List<Decision> decisions = edsf.globaldecisionslist.getDecision();
			for( int i = 0; i < decisions.size(); i++ ){
				decisions.set( i, (( EditedDecision ) decisions.get( i )).reassemble());
			}
			edsf.globaldecisionslist.setDecision( decisions );
			
			ByteArrayResource resource = new ByteArrayResource( ZIP.compress( edsf ).getBytes() );
			
		    return ResponseEntity.ok()
		            .contentLength( resource.contentLength() )
		            .contentType( MediaType.parseMediaType( "application/octet-stream" ))
		            .body( resource );
		    
		}
		catch ( JsonParseException excp ){ excp.printStackTrace(); }
		catch ( JsonMappingException excp ){ excp.printStackTrace(); }
		catch ( IOException excp ){ excp.printStackTrace(); }  

		return ResponseEntity.status( 500 ).body( new ByteArrayResource( null ));
	}

}