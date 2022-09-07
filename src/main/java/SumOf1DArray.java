public class SumOf1DArray {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                num += nums[j];
            }
            result[i] = num;
            num=0;
        }

        return result;
    }
}
