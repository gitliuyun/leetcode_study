package bitree;

public class NumArray {
    private int max;
    private int[] tree;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        max = nums.length + 1;
        tree = new int[max];
        tree[0] = 0;//占位
        //初始化树状数组
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    //以下部分为树状数组代码模板
    //add构造数组过程中不依赖原始数组
    public void add(int index, int val) {
        while (index < max) {
            tree[index] += val;
            index += lowbit(index);
        }
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    private int lowbit(int x){
        return x & (-x);
    }

    private int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= lowbit(index);
        }
        return sum;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
