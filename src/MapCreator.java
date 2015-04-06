import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

public class MapCreator {

	private final List<Point> points = new ArrayList<Point>();
	private String backgroundImage;
	private HeatMap heatMap;
	
	public MapCreator(String backgroundImage){
		this.backgroundImage = System.getProperty("user.dir") + File.separator + "heatmap" + File.separator + backgroundImage;
	}
	
	public void addPoint(Integer x, Integer y) {
		points.add(new Point(x, y));
	}

	public void addPointsByList(List<Person> people) {
		for (Person person : people) {
			points.add(new Point(person.getxLocation(), person.getyLocation()));
		}
	}

	public void addPointsBySetOfCities(Set<City> cities) {
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				points.add(new Point(person.getxLocation(), person.getyLocation()));
			}
		}
	}

	public void create(String outputFilename) {
		String outputFile = System.getProperty("user.dir") + File.separator + "heatmap" + File.separator + outputFilename;
		heatMap = new HeatMap(points, outputFile, backgroundImage);
		heatMap.createHeatMap(0.02f); // multiplier depends on density of points. try something between 1f and 10f
	}
	
	private BufferedImage loadImage(final String ref) {
	    BufferedImage b1 = null;
	    try {
	        b1 = ImageIO.read(new File(ref));
	    } catch (final IOException e) {
	        System.out.println("error loading the image: " + ref + " : " + e);
	    }
	    return b1;
	}
	
	public Integer getImageHeight(){
		return loadImage(backgroundImage).getHeight();
	}

	public Integer getImageWidth(){
		return loadImage(backgroundImage).getWidth();
	}
}
