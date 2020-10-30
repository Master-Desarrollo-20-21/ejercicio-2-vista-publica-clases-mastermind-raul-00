import java.util.Random;

import io.IOManager;

public class Mastermind {

	private Combination secretCombination;
	private ProposedCombination[] proposedCombinations;

	public void play() {
		IOManager ioManager = new IOManager();
		boolean isResumed = false;

		do {
			newGame();

			ProposedCombination proposedCombination;

			do {
				printAttempt();
				proposedCombination = askForProposedCombination();
				saveProposedCombination(proposedCombination);
			} while (!isWinner(proposedCombination) && !isLoser());

			if (isWinner(proposedCombination)) {
				ioManager.outln("You've won!!! ;-)");
			} else if (isLoser()) {
				ioManager.outln("You've lost!!! :-(");
			}

			ioManager.out("RESUME? (y/n): ");
			String resume = ioManager.inString();
			if (resume.equalsIgnoreCase("y")) {
				isResumed = true;
			}
		} while (isResumed);
	}

	private void newGame() {
		IOManager ioManager = new IOManager();
		ioManager.outln("----- MASTERMIND -----");
		ioManager.outln();

		createSecretCombination();
		proposedCombinations = new ProposedCombination[11];
	}

	private void printAttempt() {
		IOManager ioManager = new IOManager();
		int numAttempt = getNumberOfAttempt();
		ioManager.outln();
		ioManager.outln(numAttempt + " attempt(s):");
		ioManager.outln("xxxx");
		if (numAttempt > 0) {
			getLastProposedCombination().show(secretCombination);
		}
	}

	private ProposedCombination askForProposedCombination() {
		IOManager ioManager = new IOManager();

		do {
			ioManager.out("Propose a combination: ");
			String input = ioManager.inString();

			ProposedCombination proposedCombination = new ProposedCombination(input);
			if (!proposedCombination.isValidLength()) {
				ioManager.outln("Wrong proposed combination length");
			} else if (!proposedCombination.isValidColors()) {
				ioManager.outln("Wrong colors, they must be: rbygop");
			} else {
				return proposedCombination;
			}
		} while (true);
	}

	private ProposedCombination getLastProposedCombination() {
		int index = getNumberOfAttempt();
		return proposedCombinations[index - 1];
	}

	private void saveProposedCombination(ProposedCombination combination) {
		int index = getNumberOfAttempt();
		proposedCombinations[index] = combination;
	}

	private boolean isWinner(ProposedCombination proposedCombination) {
		return proposedCombination.getBlacks(secretCombination) == 4;
	}

	private boolean isLoser() {
		return getNumberOfAttempt() == proposedCombinations.length;
	}

	private int getNumberOfAttempt() {
		for (int i = 0; i < proposedCombinations.length; i++) {
			if (proposedCombinations[i] == null) {
				return i;
			}
		}
		return proposedCombinations.length;
	}

	private void createSecretCombination() {
		Random r = new Random();
		String randomCombination = "";

		for (int i = 0; i < 4; i++) {
			Integer randomInt = r.nextInt(Color.values().length);
			Color randomColor = Color.values()[randomInt];
			randomCombination += randomColor.toString();
		}
		secretCombination = new Combination(randomCombination);
	}

	public static void main(String args[]) {
		new Mastermind().play();
	}
}
