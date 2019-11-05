package array.easy;

import java.util.Arrays;

/**
 * @author songxianglong
 * @date 2019/11/5 14:00
 */
public class MaximumProductOfThreeNumbers {

    /**
     * 给定一个整数数组，找到三个数乘积的最大值
     *
     * 思路：
     *      若存在两个及以上负数,则可能存在负负得正的乘积大于正数的乘积,否则,最大乘积为三个最大数的乘积
     *
     * @param nums 整数数组
     * @return 三个数的乘积的最大值
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

}
