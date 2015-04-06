
public class Person {

	private Double infectionLevel;
	private Double health;
	private Integer income;
	private Integer medicineAvailable;
	private Integer education;
	private Integer proximityToPathogen;
	private Integer xLocation;
	private Integer yLocation;
	private boolean isInfected = false;
	private boolean isDead = false;
	private String city;

	public Person(Double health, Integer xLocation, Integer yLocation, Integer income, String city, Integer medicineAvailable, Integer education, Integer proximityToPathogen, Double infectionLevel) {
		this.infectionLevel = infectionLevel;
		this.health = health;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.income = income;
		this.city = city;
		this.medicineAvailable = medicineAvailable;
		this.education = education;
		this.proximityToPathogen = proximityToPathogen;
	}

	public Double getInfectionLevel() {
		return infectionLevel;
	}


	public void setInfectionLevel(Double infectionLevel) {
		this.infectionLevel = infectionLevel;
	}


	public Double getHealth() {
		return health;
	}

	public void setHealth(Double health) {
		this.health = health;
	}

	public Integer getMedicineAvailable() {
		return medicineAvailable;
	}

	public void setMedicineAvailable(Integer medicineAvailable) {
		this.medicineAvailable = medicineAvailable;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public Integer getProximityToPathogen() {
		return proximityToPathogen;
	}

	public void setProximityToPathogen(Integer proximityToPathogen) {
		this.proximityToPathogen = proximityToPathogen;
	}

	public Integer getxLocation() {
		return xLocation;
	}

	public void setxLocation(Integer xLocation) {
		this.xLocation = xLocation;
	}

	public Integer getyLocation() {
		return yLocation;
	}

	public void setyLocation(Integer yLocation) {
		this.yLocation = yLocation;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public boolean isInfected() {
		if(infectionLevel < 0){
			return isInfected = true;
		}
		return isInfected;
	}

	public void setInfected(boolean isInfected) {
		this.isInfected = isInfected;
	}

	public boolean isDead() {
		if(health < 0){
			return isDead = true;
		}
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
