import org.junit.jupiter.api.Test;

/**
 * Given an array nums.
 * We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 */
class SumOf1DArrayShould {

    private final SumOf1DArray run = new SumOf1DArray();

    @Test
    void return_an_array_with_the_sum_of_previous_positions_nums_case_1() {
        int[] ints = run.runningSum(new int[]{1, 2, 3, 4});

        assert ints[0] == 1;
        assert ints[1] == 3;
        assert ints[2] == 6;
        assert ints[3] == 10;
    }

    @Test
    void return_an_array_with_the_sum_of_previous_positions_nums_case_2() {
        int[] ints = run.runningSum(new int[]{1, 1, 1, 1, 1});

        assert ints[0] == 1;
        assert ints[1] == 2;
        assert ints[2] == 3;
        assert ints[3] == 4;
        assert ints[4] == 5;
    }

    @Test
    void return_an_array_with_the_sum_of_previous_positions_nums_case_3() {
        int[] ints = run.runningSum(new int[]{3, 1, 2, 10, 1});

        assert ints[0] == 3;
        assert ints[1] == 4;
        assert ints[2] == 6;
        assert ints[3] == 16;
        assert ints[4] == 17;
    }
}
