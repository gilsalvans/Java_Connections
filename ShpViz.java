package SHPreader;

import java.io.File;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.opengis.feature.simple.SimpleFeature;

public class ShpViz {

	public static void main(String[] args) throws Exception {
		String url = "C:\\\\Users\\\\Usuari\\\\Desktop\\\\MSc_Geoinformatics\\\\1st_Semester\\\\Software_Development\\\\Java_Work\\\\Visualization\\\\shp\\\\pop_pnt.shp";
		File file = new File(url);
		if (!file.exists() || !url.endsWith(".shp")) {
			throw new Exception("Invalid shapefile filepath: " + url);
		}

		ShapefileDataStore dataStore = new ShapefileDataStore(file.toURL());
		SimpleFeatureSource source = dataStore.getFeatureSource();
		SimpleFeatureCollection fc = source.getFeatures();
		SimpleFeatureIterator shpFeatures = fc.features();

		while (shpFeatures.hasNext()) {
			SimpleFeature sf = shpFeatures.next();
			System.out.println(sf);
		}

	}

}
