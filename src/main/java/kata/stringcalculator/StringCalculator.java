package kata.stringcalculator;

import java.util.stream.Stream;

class StringCalculator {

	static int sum(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		return new StringCalculatorSum(input).calculate();
	}

	private static class StringCalculatorSum {

		private final String input;
		private String delimiters;

		StringCalculatorSum(String input) {
			this.input = input;
			this.delimiters = ",\\n";
		}

		int calculate() {
			return Stream.of(splitted(preprocessedInput()))
					.mapToInt(this::toInt)
					.sum();
		}

		private String[] splitted(String s) {
			return s.split("[" + delimiters + "]");
		}

		private String preprocessedInput() {
			if (input.startsWith("//")) {
				delimiters += input.charAt(2);
				return input.substring(4);
			}
			return input;
		}

		private int toInt(String s) {
			int n = Integer.parseInt(s);
			if (n < 0) {
				throw new IllegalArgumentException();
			}
			if (n > 1000) {
				return 0;
			}
			return n;
		}

	}

}
