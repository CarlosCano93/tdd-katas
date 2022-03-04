import org.junit.Test;

public class StatsCalculatorShould {

    public static final Integer[] INPUT_3_4_1 = {3, 4, 1};
    public static final Integer[] INPUT_5_7_8 = new Integer[]{5, 7, 8};
    public static final Integer[] INPUT_1_2_0_9 = {1, -2, 0, 9};

    @Test
    public void return_minimal_value() {
        var statsCalculatorWith1AsMin = new StatsCalculator(INPUT_3_4_1);
        var statsCalculatorWith5AsMin = new StatsCalculator(INPUT_5_7_8);
        var statsCalculatorWith2NegativeAsMin = new StatsCalculator(INPUT_1_2_0_9);

        assert 1 == statsCalculatorWith1AsMin.minimum();
        assert 5 == statsCalculatorWith5AsMin.minimum();
        assert -2 == statsCalculatorWith2NegativeAsMin.minimum();
    }

    @Test
    public void return_max_value() {
        var statsCalculatorWith4AsMax = new StatsCalculator(INPUT_3_4_1);
        var statsCalculatorWith8AsMax = new StatsCalculator(INPUT_5_7_8);
        var statsCalculatorWith9AsMax = new StatsCalculator(INPUT_1_2_0_9);

        assert 4 == statsCalculatorWith4AsMax.maximum();
        assert 8 == statsCalculatorWith8AsMax.maximum();
        assert 9 == statsCalculatorWith9AsMax.maximum();
    }

    @Test
    public void return_number_of_elements_in_array() {
        var statsCalculatorWith3Elements = new StatsCalculator(INPUT_3_4_1);
        var statsCalculatorWith4Elements = new StatsCalculator(INPUT_1_2_0_9);

        assert 3 == statsCalculatorWith3Elements.numberOfElements();
        assert 4 == statsCalculatorWith4Elements.numberOfElements();
    }

    @Test
    public void return_the_average() {
        var statsCalculatorOne = new StatsCalculator(INPUT_3_4_1);
        var statsCalculatorTwo = new StatsCalculator(INPUT_5_7_8);

        assert 2.6666666666666665 == statsCalculatorOne.average();
        assert 6.666666666666667 == statsCalculatorTwo.average();
    }
}
