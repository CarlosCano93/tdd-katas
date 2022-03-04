import org.junit.Test;


/**
 * The simplest iterations
 * RED - GREEN - REPEAT
 */
public class FizzBuzzShould {

    private FizzBuzz fizzBuzz;

    @Test
    public void
    return_fizz_when_divisible_by_3_or_buzz_when_divisible_by_5_or_when_divisble_by_both_fizzbuz_otherwise_number_as_string() {
        fizzBuzz = new FizzBuzz();

        assert fizzBuzz.playGame(1).equals("1");
        assert fizzBuzz.playGame(2).equals("2");
        assert fizzBuzz.playGame(3).equals("Fizz");
        assert fizzBuzz.playGame(4).equals("4");
        assert fizzBuzz.playGame(5).equals("Buzz");

        assert fizzBuzz.playGame(9).equals("Fizz");
        assert fizzBuzz.playGame(18).equals("Fizz");
        assert fizzBuzz.playGame(36).equals("Fizz");
        assert fizzBuzz.playGame(10).equals("Buzz");
        assert fizzBuzz.playGame(20).equals("Buzz");
        assert fizzBuzz.playGame(25).equals("Buzz");
        assert fizzBuzz.playGame(15).equals("FizzBuzz");
        assert fizzBuzz.playGame(30).equals("FizzBuzz");
        assert fizzBuzz.playGame(45).equals("FizzBuzz");

        assert fizzBuzz.playGame(101).equals("KO");

    }
}
