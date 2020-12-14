import org.junit.Test;

public class FibonacciTest {

    Fibonacci fibonacci = new Fibonacci();

    @Test
    public void given_a_position_return_the_number_in_the_fibonacci_sequence() {
        assert 0 == fibonacci.run(0);
        assert 1 == fibonacci.run(1);
        assert 1 == fibonacci.run(2);
        assert 2 == fibonacci.run(3);
        assert 3 == fibonacci.run(4);
        assert 5 == fibonacci.run(5);
        assert 8 == fibonacci.run(6);
    }
}