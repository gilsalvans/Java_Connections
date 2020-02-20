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

		   



	

	
	

		

	

	


