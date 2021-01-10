package bit;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int mask = 1 << nums.length;
        for (int i=0; i< mask; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j=0; j< nums.length; j++) {
                if ((i & 1<<j) != 0) {
                    tmp.add(nums[j]);
                }
            }
            resList.add(tmp);
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new SubSet().subsets(nums));

    }
}
