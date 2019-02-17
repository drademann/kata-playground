package kata.fizzbuzz;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

final class FizzBuzz {

    public static String[] map(int... numbers) {
        return new FizzBuzz(IntStream.of(numbers)).mapInts();
    }

    //<editor-fold desc="implementation">
    private final IntStream intStream;

    private FizzBuzz(IntStream intStream) {
        this.intStream = intStream;
    }

    private String[] mapInts() {
        return intStream.mapToObj(this::mapToString)
                        .collect(toList())
                        .toArray(String[]::new);
    }

    private String mapToString(int number) {
        if (isFizz(number))
            return "Fizz";
        else if (isBuzz(number))
            return "Buzz";
        else
            return Integer.toString(number);
    }

    private boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    private boolean isFizz(int number) {
        return number % 3 == 0;
    }
    //</editor-fold>
}
