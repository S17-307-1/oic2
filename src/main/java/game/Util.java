package game;

public class Util {

	private Util() {

	}

	public static float constrain(float value, float min, float max) {
		if (value <= min) {
			return min;
		} else if (value >= max) {
			return max;
		} else {
			return value;
		}
	}
}