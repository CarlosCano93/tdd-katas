public class FizzBuzz {

    public String playGame(int number) {
        if (number > 100)
            return "KO";

        if (number % 15 == 0)
            return "FizzBuzz";

        if (number % 3 == 0)
            return "Fizz";

        if (number % 5 == 0)
            return "Buzz";

        return String.valueOf(number);
    }
}
