package kata.stringcalculator;

import java.util.stream.Stream;

class StringCalculator {

	private final String input;

	private String separators = ",\n";

	StringCalculator(String input) {
		this.input = input;
	}

	int sum() {
		if (hasInput()) {
			return Stream.of(splittedInput()).mapToInt(Integer::parseInt).sum();
		}
		else {
			return 0;
		}
	}

	private boolean hasInput() {
		return !input.isEmpty();
	}

	private String[] splittedInput() {
		return parsedInput().split(bySeparators());
	}

	private String parsedInput() {
		if (inputContainsCustomDelimiter()) {
			extractCustomerDelimiter();
			return plainNumberString();
		}
		return input;
	}

	private String bySeparators() {
		return "[" + separators + "]";
	}

	private boolean inputContainsCustomDelimiter() {
		return input.startsWith("//");
	}

	private void extractCustomerDelimiter() {
		separators += input.charAt(2);
	}

	private String plainNumberString() {
		return input.substring(4);
	}

}
