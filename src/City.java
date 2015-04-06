import java.util.ArrayList;
import java.util.List;

public class City {

	private static final Integer DEFAULT_POPULATION = 1000;

	/* Keep between 0 and 2 */
	private static final Double DEFAULT_WEALTH_MODIFIER = 1.0;
	private static final Double DEFAULT_HEALTH_MODIFIER = 1.0;

	private String name;
	private List<Person> population;
	private Double wealthModifier;
	private Double healthModifier;
	private Integer imageHeight;
	private Integer imageWidth;

	public City(String name, List<Person> population, Double wealthModifier, Double healthModifier, Integer imageHeight, Integer imageWidth) {
		this.name = name;
		this.wealthModifier = wealthModifier;
		this.healthModifier = healthModifier;
		this.population = population;
		this.imageHeight = imageHeight;
		this.imageWidth = imageWidth;
	}

	public City(String name, Integer population, Double wealthModifier, Double healthModifier, Integer imageHeight, Integer imageWidth) {
		this.name = name;
		this.wealthModifier = wealthModifier;
		this.healthModifier = healthModifier;
		this.imageHeight = imageHeight;
		this.imageWidth = imageWidth;
		this.population = new ArrayList<Person>();
		populate(population);
		
	}

	public City(String name, Integer population, Integer imageHeight, Integer imageWidth) {
		this.name = name;
		wealthModifier = DEFAULT_WEALTH_MODIFIER;
		healthModifier = DEFAULT_HEALTH_MODIFIER;
		this.imageHeight = imageHeight;
		this.imageWidth = imageWidth;
		this.population = new ArrayList<Person>();
		populate(population);
	}

	public City(String name, Integer imageHeight, Integer imageWidth) {
		this.name = name;
		wealthModifier = DEFAULT_WEALTH_MODIFIER;
		healthModifier = DEFAULT_HEALTH_MODIFIER;
		this.imageHeight = imageHeight;
		this.imageWidth = imageWidth;
		this.population = new ArrayList<Person>();
		populate(DEFAULT_POPULATION);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopulationSize() {
		return population.size();
	}

	public List<Person> getPopulationAsList() {
		return population;
	}

	public void setPopulation(List<Person> population) {
		this.population = population;
	}

	public void populate(Integer population) {
		Randomizer randomizer = new Randomizer();

		while (this.population.size() < population) {
			Double health = (double) randomizer.random(0, 10, wealthModifier, healthModifier);
			Integer xLocation = randomizer.random(0, imageWidth);
			Integer yLocation = randomizer.random(0, imageHeight);
			Integer income = randomizer.random(0, 10, wealthModifier, healthModifier);
			Integer medicineAvailable = randomizer.random(0, 10, wealthModifier, healthModifier);
			Integer education = randomizer.random(0, 10, wealthModifier, healthModifier);
			Integer proximityToPathogen = randomizer.random(0, 10);
			Double infectionLevel = (double) randomizer.random(0, 10, wealthModifier, healthModifier);

			Person person = new Person(health, xLocation, yLocation, income, name, medicineAvailable, education, proximityToPathogen, infectionLevel);
			this.population.add(person);
		}
	}
}
