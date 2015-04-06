import java.util.HashSet;
import java.util.Set;

public class PathogenRunner {
	
	private static final Integer NBR_OF_CITIES = 6;
	private static final String[] CITY_NAMES = {"Detroit", "Ann Arbor", "Lansing", "Grand Rapids", "Kalamazoo", "Traverse City"};
	private static final Integer[] POPULATIONS = {688701, 117025, 113972, 192294, 75548, 15018};
	private static final Double[] WEALTH_MODIFIERS = {0.6, 1.4, 0.9, 1.1, 1.0, 1.3};
	private static final Double[] HEALTH_MODIFIERS = {0.4, 1.6, 0.8, 0.9, 1.3, 1.7};
	
	Set<City> cities = new HashSet<City>();
	Pathogen pathogen = new Pathogen(4 /* potency */, 1 /* stage */);
	PathogenBusinessController controller = new PathogenBusinessController(cities, pathogen);
	MapCreator mapCreator = new MapCreator("background2.png");
	
	private void execute(){
		runOnCity(CITY_NAMES[0]);
	}
	
	public void runOnListOfCities(Set<City> cities){
		for(Integer i = 0; i < NBR_OF_CITIES; i++){
			this.cities.add(new City(CITY_NAMES[i], POPULATIONS[i], WEALTH_MODIFIERS[i], HEALTH_MODIFIERS[i], mapCreator.getImageHeight(), mapCreator.getImageWidth()));
		}
		run();
	}
	
	public void runOnCity(String cityName){
		for (Integer i = 0; i < NBR_OF_CITIES; i++) {
			if(CITY_NAMES[i].equals(cityName)){
				cities.add(new City(CITY_NAMES[i], POPULATIONS[i], WEALTH_MODIFIERS[i], HEALTH_MODIFIERS[i], mapCreator.getImageHeight(), mapCreator.getImageWidth()));
			}
		}
		run();
	}
	
	private void run(){
		printStatistics();
		controller.runDays(1);
		printStatistics();
		
		mapCreator.addPointsByList(controller.getListofDead());
		mapCreator.create("check.png");
	}
	
	private void printStatistics() {
		System.out.println("Healthy: " + controller.getNbrOfHealty());
		System.out.println("Infected: " + controller.getNbrOfInfected());
		System.out.println("Dead: " + controller.getNbrOfDead());
		System.out.println();
	}
	
	//public Integer getNbrOfDays();
	
	public static void main(String args[]){
		PathogenRunner pR = new PathogenRunner();
		pR.execute();
	}
}
