import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PathogenBusinessController {

	private Pathogen pathogen;
	private Set<City> cities;
	private Randomizer randomizer;

	public PathogenBusinessController(Set<City> cities, Pathogen pathogen) {
		this.cities = cities;
		this.pathogen = pathogen;
		randomizer = new Randomizer();
	}
	
	public void runDays(Integer days){
		for(Integer i = 0; i < days; i++){
			runDay();
		}
	}
	
	public void runDay(){
		runInfectionAlgorithmOnAll();
		runKillAlgorithmOnAll();
		
		/* 25% hit ratio */
		if(randomizer.random(0, 3) == 0){
			pathogen.setPotency(pathogen.getPotency() + 1);
		}
	}
	
	public void runInfectionAlgorithmOnAll() {
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				person.setInfectionLevel(person.getMedicineAvailable() * (1 + person.getIncome()) + .15 * person.getEducation() - (.3 * pathogen.getPotency()) - .5 * person.getProximityToPathogen());
			}
		}
	}

	public void runInfectionAlgorithmOnCity(City city) {
		for (Person person : city.getPopulationAsList()) {
			person.setInfectionLevel(person.getMedicineAvailable() * (1+ person.getIncome()) + .15 * person.getEducation() - (.3 * pathogen.getPotency()) - .5 * person.getProximityToPathogen());
		}
	}
	
	public void runKillAlgorithmOnAll() {
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				if(person.isInfected()){
					person.setHealth(person.getMedicineAvailable() * (1 + person.getIncome()) + .15 * person.getEducation() - (.3 * pathogen.getPotency() * pathogen.getStage()) - .15 * person.getProximityToPathogen());
				}
			}
		}
	}

	public void runKillAlgorithmOnCity(City city) {
		for (Person person : city.getPopulationAsList()) {
			if(person.isInfected()){
				person.setHealth(person.getMedicineAvailable() * (1 + person.getIncome()) + .15 * person.getEducation() - (.3 * pathogen.getPotency() * pathogen.getStage()) - .15 * person.getProximityToPathogen());
			}
		}
	}
	
	public void killAll() {
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				person.setDead(true);
			}
		}
	}

	public void killCity(City city) {
		for (Person person : city.getPopulationAsList()) {
			person.setDead(true);
		}
	}
	
	public void infectAll() {
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				person.setInfected(true);
			}
		}
	}

	public void infectCity(City city) {
		for (Person person : city.getPopulationAsList()) {
			person.setInfected(true);
		}
	}

	public void cureAll() {
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				person.setInfected(false);
			}
		}
	}
	
	public void cureCity(City city) {
		for (Person person : city.getPopulationAsList()) {
			person.setInfected(false);
		}
	}
	
	public City findCityByName(String cityName) {
		for (City city : cities) {
			if (city.getName().equals(cityName)) {
				return city;
			}
		}
		return null;
	}
	
	public Integer getNbrOfInfected(){
		Integer nbrOfInfected = 0;
		
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				if((person.isInfected()) && (!person.isDead())){
					nbrOfInfected++;
				}
			}
		}
		return nbrOfInfected;
	}
	
	public Integer getNbrOfDead(){
		Integer nbrOfDead = 0;
		
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				if(person.isDead()){
					nbrOfDead++;
				}
			}
		}
		return nbrOfDead;
	}
	
	public Integer getNbrOfHealty(){
		Integer nbrOfHealthy = 0;
		
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				if((!person.isInfected()) && (!person.isDead())){
					nbrOfHealthy++;
				}
			}
		}
		return nbrOfHealthy;
	}
	
	public List<Person> getListofInfected(){
		List<Person> infected = new ArrayList<Person>();
		
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				if(person.isInfected()){
					infected.add(person);
				}
			}
		}
		return infected;
	}
	
	public List<Person> getListofDead(){
		List<Person> dead = new ArrayList<Person>();
		
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				if(person.isDead()){
					dead.add(person);
				}
			}
		}
		return dead;
	}
	
	public List<Person> getListofHealthy(){
		List<Person> healthy = new ArrayList<Person>();
		
		for (City city : cities) {
			for (Person person : city.getPopulationAsList()) {
				if((!person.isInfected()) && (!person.isDead())){
					healthy.add(person);
				}
			}
		}
		return healthy;
	}
}
