public class Fibonacci {

    public int run(int position) {
        if (position == 0) return 0;
        if (position == 1) return 1;

        return run(position - 1) + run(position - 2);
    }
}
