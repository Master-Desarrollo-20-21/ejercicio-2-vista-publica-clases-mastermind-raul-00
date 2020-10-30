
public class Combination {

	protected Color[] colors;
	private boolean isValidColors = true;
	private boolean isValidLength = true;

	public Combination(String combination) {
		validateLength(combination);
		validateColors(combination);

		if (isValidLength() && isValidColors()) {
			generateColors(combination);
		}
	}

	private void validateLength(String combination) {
		isValidLength = combination.length() == 4;
	}

	private void validateColors(String combination) {
		for (int i = 0; i < combination.length(); i++) {
			if (!Color.isValid(combination.charAt(i))) {
				isValidColors = false;
				break;
			}
		}
	}

	private void generateColors(String combination) {
		colors = new Color[4];

		for (int i = 0; i < colors.length; i++) {
			colors[i] = Color.valueOf(combination.charAt(i));
		}
	}

	public boolean isValidColors() {
		return isValidColors;
	}

	public boolean isValidLength() {
		return isValidLength;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < colors.length; i++) {
			result += colors[i].toString();
		}
		return result;
	}
}
