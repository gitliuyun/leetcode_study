package sort;

import java.util.Arrays;

/**
 * 0,1,2ÈýÉ«ÅÅÐò
 */
public class Color {
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        new Color().sortColors(nums);
        System.out.printf(Arrays.toString(nums));
    }

    private void sortColors(int[] nums) {
        int p0 = 0, i = 0, p2 = nums.length - 1;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0 ++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }
}
