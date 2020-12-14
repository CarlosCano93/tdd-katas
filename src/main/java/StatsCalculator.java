import java.util.Arrays;

public class StatsCalculator {

    private final Integer[] inputNumbers;

    public StatsCalculator(final Integer[] inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public int minimum() {
        return Arrays.stream(inputNumbers)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public int maximum() {
        return Arrays.stream(inputNumbers)
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int numberOfElements() {
        return inputNumbers.length;
    }

    public double average() {
        double sumOfElements = Arrays.stream(inputNumbers)
                .mapToDouble(Integer::doubleValue).sum();
        double numOfElements = this.numberOfElements();

        return sumOfElements / numOfElements;
    }
}
