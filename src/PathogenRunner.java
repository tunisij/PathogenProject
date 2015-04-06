import java.util.HashSet;
import java.util.Set;

public class PathogenRunner {
	
	private static final Integer NBR_OF_CITIES = 6;
	private static final String[] CITY_NAMES = {"Detroit", "Ann Arbor", "Lansing", "Grand Rapids", "Kalamazoo", "Traverse City"};
	private static final Integer[] POPULATIONS = {688701, 117025, 113972, 192294, 75548, 15018};
	private static final Double[] WEALTH_MODIFIERS = {0.6, 1.4, 0.9, 1.1, 1.0, 1.3};
	private static final Double[] HEALTH_MODIFIERS = {0.4, 1.6, 0.8, 0.9, 1.3, 1.7};
	
	Set<City> cities = new HashSet<City>();
	Pathogen pathogen = new Pathogen(20 /* potency */, 1 /* stage */);
	PathogenBusinessController controller = new PathogenBusinessController(cities, pathogen);
	MapCreator mapCreator = new MapCreator("background.png");
	
	private void execute(Integer nbrOfDays){
		runOnCity(CITY_NAMES[3], nbrOfDays);
	}
	
//	public void runOnListOfCities(Set<City> cities){
//		for(Integer i = 0; i < NBR_OF_CITIES; i++){
//			this.cities.add(new City(CITY_NAMES[i], POPULATIONS[i]/10, WEALTH_MODIFIERS[i], HEALTH_MODIFIERS[i], mapCreator.getImageHeight(), mapCreator.getImageWidth()));
//		}
//		run();
//	}
	
	public void runOnCity(String cityName, Integer nbrOfDays){
		for (Integer i = 0; i < NBR_OF_CITIES; i++) {
			if(CITY_NAMES[i].equals(cityName)){
				cities.add(new City(CITY_NAMES[i], POPULATIONS[i]/10, WEALTH_MODIFIERS[i], HEALTH_MODIFIERS[i], mapCreator.getImageHeight(), mapCreator.getImageWidth()));
			}
		}
		printStatistics(cityName, 0);
		for(Integer dayNbr = 1; dayNbr < nbrOfDays; dayNbr++){
			controller.runDay();
			printStatistics(cityName, dayNbr);
			
			mapCreator = new MapCreator("background.png");
			mapCreator.addPointsByList(controller.getListofHealthy());
			mapCreator.create("day" + dayNbr + ".png", "healthyMaps");
			
			mapCreator = new MapCreator("background.png");
			mapCreator.addPointsByList(controller.getListofInfected());
			mapCreator.create("day" + dayNbr + ".png", "infectedMaps");

			mapCreator = new MapCreator("background.png");
			mapCreator.addPointsByList(controller.getListofDead());
			mapCreator.create("day" + dayNbr + ".png", "deathMaps");
		}
	}
	
	private void printStatistics(String cityName, Integer dayNbr) {
		for (Integer i = 0; i < NBR_OF_CITIES; i++) {
			if(CITY_NAMES[i].equals(cityName)){
				System.out.println();
				System.out.println(cityName + ": day " + dayNbr);
				System.out.println("---------------------------");
				System.out.println("Healthy: " + controller.getNbrOfHealthy(cityName));
				System.out.println("Infected: " + controller.getNbrOfInfected(cityName));
				System.out.println("Dead: " + controller.getNbrOfDead(cityName));
				System.out.println();
			}
		}
	}
	
	public static void main(String args[]){
		PathogenRunner pR = new PathogenRunner();
		pR.execute(100);
	}
}
