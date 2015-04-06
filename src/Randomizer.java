public class Randomizer {

	public Integer random(Integer start, Integer end) {
		return (int) ((Math.random() + .1) * (end - start));
	}

	public Integer random(Integer start, Integer end, Double wealthModifier, Double healthModifier) {
		Integer rand = (int) ((Math.random() + .1) * (end - start) * wealthModifier * healthModifier);

		if (rand > end) {
			rand = end;
		}
		return rand;
	}
}
