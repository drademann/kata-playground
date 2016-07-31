package kata.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculator {

	static int sum(String input) {
		return new Sum().calculate(input);
	}

	private static final class Sum {

		private Pattern pattern;

		private Sum() {
			this.pattern = Pattern.compile("[,\\n]");
		}

		private int calculate(String input) {
			if (input.isEmpty()) {
				return 0;
			}
			String[] partition = partition(input);
			return process(partition[0]) + calculate(partition[1]);
		}

		private String[] partition(String input) {
			Matcher matcher = pattern.matcher(input);
			if (matcher.find()) {
				return new String[] {
						input.substring(0, matcher.start()),
						input.substring(matcher.start() + 1)
				};
			}
			else {
				return new String[] { input, "" };
			}
		}

		private int process(String part) {
			if (part.startsWith("//")) {
				return parseCustomDelimiter(part);
			}
			else {
				return parseNumber(part);
			}
		}

		private int parseCustomDelimiter(String part) {
			pattern = Pattern.compile("[" + part.charAt(2) + "\\n]");
			return 0;
		}

		private int parseNumber(String part) {
			int number = Integer.parseInt(part);
			if (number < 0) {
				throw new IllegalArgumentException();
			}
			if (number > 1000) {
				return 0;
			}
			return number;
		}
	}
}
