public class Randomizer {

	public Integer random(Integer start, Integer end) {
		Integer rand = (int) ((Math.random()) * (end - start));
		
		if (rand > end) {
			rand = end;
		}
		return rand;
	}

	public Integer random(Integer start, Integer end, Double wealthModifier, Double healthModifier) {
		Integer rand = (int) ((Math.random()) * (end - start) * wealthModifier * healthModifier);

		if (rand > end) {
			rand = end;
		}
		return rand;
	}
}
