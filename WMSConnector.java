package eot_Schlagbauer_Salvans_Servais_Rossboth;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import javax.imageio.ImageIO;

import org.geotools.ows.ServiceException;
import org.geotools.ows.wms.WMSCapabilities;
import org.geotools.ows.wms.WebMapServer;
import org.geotools.ows.wms.request.GetMapRequest;
import org.geotools.ows.wms.response.GetMapResponse;
import org.xml.sax.SAXException;

import processing.core.PApplet;
import processing.core.PImage;

public class WMSConnector extends PApplet {
	
	PImage wms_image;
	
public WMSConnector(){
			URL url = null;
			try {
				url = new URL("http://maps.heigit.org/osm-wms/service?service=WMS&request=GetCapabilities&version=1.1.1");
			} catch (MalformedURLException e) {

			}

			WebMapServer wms = null;
			try {
				wms = new org.geotools.ows.wms.WebMapServer(url);
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
			  wms_image = new PImage(image);
			  //We would use image writer if we want to store the image somewhere in our local environment
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
}
		
		public PImage getwms() {
			return wms_image;
		}
		
}

