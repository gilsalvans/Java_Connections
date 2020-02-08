package plus.swe.ows;


import java.io.IOException;
import java.util.HashMap;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.wfs.WFSDataStore;
import org.geotools.data.wfs.WFSDataStoreFactory;
import org.opengis.feature.simple.SimpleFeature;


public class WFSConnector {

	public static void main(String[] args) {
	
		 String url = "https://data.wien.gv.at/daten/geo/wfs?service=wfs&version=1.1.0&request=getCapabilities";
		
		 HashMap connectionParameters = new HashMap();
		 connectionParameters.put("WFSDataStoreFactory:GET_CAPABILITIES_URL", url);
		 WFSDataStoreFactory  dsf = new WFSDataStoreFactory();
	
		     WFSDataStore dataStore;
			try {
				dataStore = dsf.createDataStore(connectionParameters);
				SimpleFeatureSource source = dataStore.getFeatureSource("ogdwien:OEFFHALTESTOGD");
		        SimpleFeatureCollection fc = source.getFeatures();
		        SimpleFeatureIterator wfsFeatures = fc.features();
		        
		        
		     while(wfsFeatures.hasNext()){
		         SimpleFeature sf = wfsFeatures.next();

		         System.out.println(sf);
		       
		     } 
			} catch (IOException e) {
							e.printStackTrace();
			}
	}
}

		   
 //WMS CONNECTION		
		/*
		URL url = null;
		try {
		  url = new URL("https://data.stadt-salzburg.at/geodaten/wfs?service=wfs&version=1.1.0&request=getCapabilities");
		} catch (MalformedURLException e) {
		 
		}

		WebMapServer wms = null;
		try {
		  wms = new WebMapServer(url);
		} catch (IOException e) {
		  //There was an error communicating with the server
		  //For example, the server is down
		} catch (ServiceException e) {
		  //The server returned a ServiceException (unusual in this case)
		} catch (SAXException e) {
		  //Unable to parse the response from the server
		  //For example, the capabilities it returned was not valid
		}
		WMSCapabilities capabilities = wms.getCapabilities();
		System.out.println("Capabilities retrieved!");
		System.out.println(capabilities);
	}
}


*/



	

	
	

		

	

	


