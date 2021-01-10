package bit;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i: nums) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,3};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}
