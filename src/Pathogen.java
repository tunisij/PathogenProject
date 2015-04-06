public class Pathogen {
	
	private static final Integer DEFAULT_POTENCY = 1;
	private static final Integer DEFAULT_STAGE = 1;

	private Integer potency;
	private Integer stage;

	public Pathogen(Integer potency, Integer stage) {
		this.potency = potency;
		this.stage = stage;
	}
	
	public Pathogen() {
		potency = DEFAULT_POTENCY;
		stage = DEFAULT_STAGE;
	}

	public Integer getPotency() {
		return potency;
	}

	public void setPotency(Integer potency) {
		this.potency = potency;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}
}
