
public enum Color {
	RED('r'), BLUE('b'), YELLOW('y'), GREEN('g'), ORANGE('o'), PURPLE('p');

	private char value;

	Color(char value) {
		this.value = value;
	}

	public static Color valueOf(char character) {
		for (Color color : values()) {
			if (color.value == character) {
				return color;
			}
		}
		return null;
	}

	public static boolean isValid(char color) {
		if (color == RED.value || color == BLUE.value || color == YELLOW.value || color == GREEN.value
				|| color == ORANGE.value || color == PURPLE.value) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}
