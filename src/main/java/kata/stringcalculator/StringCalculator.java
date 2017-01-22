package kata.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

class StringCalculator {

	static int sumOf(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		return new Sum().conquer(0, input);
	}

	private static class Sum {

		private Pattern pattern;

		Sum() {
			this.pattern = compile("[,\\n]");
		}

		private static class Snake {

			final String head;
			final String tail;

			private Snake(String head, String tail) {
				this.head = head;
				this.tail = tail;
			}
		}

		int conquer(int sum, String input) {
			if (input.isEmpty()) {
				return sum;
			}
			Snake snake = divide(input);
			return conquer(sum + parsed(snake.head), snake.tail);
		}

		private Snake divide(String s) {
			Matcher matcher = pattern.matcher(s);
			String head, tail;
			if (matcher.find()) {
				head = s.substring(0, matcher.start());
				tail = s.substring(matcher.start() + 1);
			}
			else {
				head = s;
				tail = "";
			}
			return new Snake(head, tail);
		}

		private int parsed(String s) {
			if (s.startsWith("//")) {
				pattern = compile("[" + s.charAt(2) + "\\n]");
				return 0;
			}
			return parsedToInteger(s);
		}

		private int parsedToInteger(String s) {
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
