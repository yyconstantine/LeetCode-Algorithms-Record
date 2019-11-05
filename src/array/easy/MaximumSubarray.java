package array.easy;

/**
 * @author songxianglong
 * @date 2019/11/5 11:31
 */
public class MaximumSubarray {

    /**
     * 给定一个整数数组nums,找到一个具有最大和的连续子数组(子数组最少包含一个元素),返回其最大和
     *
     * 思路：
     *      将取和分为两部分：前面的一位/n位和后一位
     *      每次进行累加，取加和较大的值作为前置
     *      再将加和后的结果与当前求和进行比较，取较大的求和结果
     *
     * @param nums 一个整数数组
     * @return 最大子数组之和
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prev = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(nums[i], prev + nums[i]);
            sum = Math.max(prev, sum);
        }

        return sum;
    }

}
