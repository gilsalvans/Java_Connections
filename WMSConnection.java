package plus.swe.ows;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import javax.imageio.ImageIO;

import org.geotools.data.ows.WMSCapabilities;
import org.geotools.data.wms.WMS1_1_0.GetMapRequest;

import org.geotools.data.wms.WebMapServer;
import org.geotools.data.wms.response.GetMapResponse;

import org.geotools.ows.ServiceException;

import org.xml.sax.SAXException;

public class WMSConnection {

	public static void main(String[] args) {
		URL url = null;
		try {
		  url = new URL("http://maps.heigit.org/osm-wms/service?service=WMS&request=GetCapabilities&version=1.1.1");
		} catch (MalformedURLException e) {
		 
		}

		WebMapServer wms = null;
		try {
		  wms = new WebMapServer(url);
		} catch (IOException e) {
	
		} catch (ServiceException e) {
	
		} catch (SAXException e) {
		 
		}
		WMSCapabilities capabilities = wms.getCapabilities();
	    GetMapRequest request = (GetMapRequest) wms.createGetMapRequest();
	   
	    request.setSRS("EPSG:4326");
	    request.setBBox("-71.13,42.32,-71.03,42.42");
	    request.setDimensions("1000", "1000");
	    request.setFormat("image/png");
	    request.setTransparent(true);
	    request.setVersion("1.1.1");
	    
	   request.addLayer("osm_auto:all", "default");
	    
	 
	    
	    GetMapResponse response = null;
		try {
			response = (GetMapResponse) wms.issueRequest(request);
		} catch (ServiceException | IOException e) {
			
			e.printStackTrace();
		}
			try {
				BufferedImage image = ImageIO.read(response.getInputStream());
				
				ImageIO.write(image, "png",new File("C:\\Users\\Usuari\\Desktop\\img.png"));
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    

			 String googlechromePath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
			 String filepath = "C:\\Users\\Usuari\\Desktop\\img.png";
		
			 
			  String [] parameters = new String[2];
			  
			  parameters[0] = googlechromePath;
			  parameters[1] = filepath;
			 
			 
			  try {
				Runtime.getRuntime().exec(parameters);
			} catch (IOException e) {
				System.out.println("Wrong path!");
				e.printStackTrace();
			}
			
		  
		}
	    
	   


}

