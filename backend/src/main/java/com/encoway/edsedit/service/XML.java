package com.encoway.edsedit.service;

import java.io.ByteArrayInputStream;
import java.util.zip.ZipOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class XML {

	public static <T> T deserialize( Class<T> model, byte[] data ) {
		try {
			JAXBContext context = JAXBContext.newInstance( model );
			Unmarshaller unmarshaller = context.createUnmarshaller();
			JAXBElement<T> element = unmarshaller.unmarshal(
				new StreamSource( new ByteArrayInputStream( data )), model );
			return element.getValue();
		}
		catch( JAXBException excp ){ excp.printStackTrace(); return null; }
		catch( Exception excp ){ excp.printStackTrace(); return null; }
	}

	public static void serialize( Class classType, Object data, ZipOutputStream zos ) {
		try {
			Marshaller marshaller = JAXBContext.newInstance( classType ).createMarshaller();
//			marshaller.setProperty( Marshaller.JAXB_FRAGMENT, Boolean.TRUE );
/*        	marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE ) ;
			marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
					"<?xml version=\"1.0\" encoding=\"UTF-8\"?>");*/
			marshaller.marshal( data, zos );
		}
		catch( JAXBException excp ){ excp.printStackTrace(); }
	}

}