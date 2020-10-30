import io.IOManager;

public class ProposedCombination extends Combination {

	public ProposedCombination(String combination) {
		super(combination);
	}

	public int getWhites(Combination secretCombination) {
		int whites = 0;
		for (int i = 0; i < this.colors.length; i++) {
			for (int j = 0; j < secretCombination.colors.length; j++) {
				if (this.colors[i] == secretCombination.colors[j] && i != j) {
					whites++;
					break;
				}
			}
		}
		return whites;
	}

	public int getBlacks(Combination secretCombination) {
		int blacks = 0;
		for (int i = 0; i < this.colors.length; i++) {
			if (this.colors[i] == secretCombination.colors[i]) {
				blacks++;
			}
		}
		return blacks;
	}

	public void show(Combination secretCombination) {
		String blacksText = this.getBlacks(secretCombination) + " blacks";
		String whitesText = this.getWhites(secretCombination) + " whites";
		new IOManager().outln(this.toString() + " ---> " + blacksText + " and " + whitesText);
	}
}
