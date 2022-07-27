package com.encoway.edsedit.service;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.springframework.web.multipart.MultipartFile;
import com.encoway.edsedit.model.*;



public class ZIP {

	public static EDSFile decompress( MultipartFile file ){
		try {
			int length;
			byte[] buffer = new byte[1024];
			EDSFile edsFile = new EDSFile();
			ByteArrayOutputStream baos;
			ZipInputStream zis = new ZipInputStream( file.getInputStream() );
			ZipEntry zipEntry = zis.getNextEntry();
			while( zipEntry != null ){
				baos = new ByteArrayOutputStream();
				while(( length = zis.read( buffer )) > 0 ){
					baos.write( buffer, 0, length );
				}
				baos.close();
				edsFile.entry.add(
					new EDSEntry(
						zipEntry.getName(),
						baos.toByteArray()
					)
				);
				zipEntry = zis.getNextEntry();
			}
			zis.closeEntry();
			zis.close();
			return edsFile;
		}
		catch( ZipException excp ){ excp.printStackTrace(); return null; }
		catch( IOException excp ){ excp.printStackTrace(); return null; }
		catch( Exception excp ){ excp.printStackTrace(); return null; }
	}

    public static String compress( EDSFile edsf ){

    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream( baos );

        try {

        	CreateZipEntry( zos, "cl_configtree.xml", ConfigTree.class, edsf.configtree );
        	CreateZipEntry( zos, "cl_globaldecisionslist.xml", GlobalDecisionsList.class, edsf.globaldecisionslist );
        	CreateZipEntry( zos, "cl_configurationProperties.xml", ConfigurationProperties.class, edsf.configurationProperties );
        	CreateZipEntry( zos, "cl_instancestructure.xml", InstanceStructures.class, edsf.instancestructure );
        	CreateZipEntry( zos, "cl_kbversions.xml", KBVersionsMapping.class, edsf.kbversions );
        	CreateZipEntry( zos, "cl_metadata.xml", Metadata.class, edsf.metadata );
        	CreateZipEntry( zos, "cl_nodestructure.xml", NodeStructures.class, edsf.nodestructure );
        	CreateZipEntry( zos, "cl_salesContext.xml", DPMSalesContext.class, edsf.salesContext );
        	CreateZipEntry( zos, "cl_configurations.zip", null, edsf.configurations );
        	
			zos.finish();
	        zos.flush();
			zos.close();
			baos.flush();
	        baos.close();
		}
        catch ( IOException excp ){ excp.printStackTrace(); }

        return Base64.getEncoder().encodeToString( baos.toByteArray() );
    }

    private static boolean CreateZipEntry( ZipOutputStream zos, String filename, Class classType, Object data ) {
    	if( data == null ){ return true; }
        try {
    		zos.putNextEntry( new ZipEntry( filename ));
        	if( classType == null ){
        		zos.write( Base64.getDecoder().decode(((Configurations)data).bytes ) );
        	} else {
        		XML.serialize(classType, data, zos);
        	}
			zos.closeEntry();
        	return true;
		}
        catch ( IOException excp ){
        	excp.printStackTrace();
        	return false;
        }
    }
    
}