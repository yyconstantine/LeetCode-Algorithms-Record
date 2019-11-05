package array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author songxianglong
 * @date 2019/11/1 9:30
 */
public class TwoSum {

    /**
     * 给定随机数组和目标值,获取数组中可加和成目标值的下标数组
     * 经过两边遍历,耗时较久,不推荐
     * 时间复杂度 => O(n2)
     * @param nums 随机数组
     * @param target 目标值
     * @return 可加和成目标值的下标数组
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    /**
     * 给定随机数组和目标值,获取数组中可加和成目标值的下标数组
     * 使用Map存储数组中数据,空间换时间,减少遍历次数
     * 时间复杂度 => O(n)
     * @param nums 随机数组
     * @param target 目标值
     * @return 可加和成目标值的下标数组
     */
    public static int[] twoSumWithMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another) && map.get(another) != i) {
                return new int[] {i, map.get(another)};
            }
        }
        return null;
    }

    /**
     * 给定随机数组和目标值,获取数组中可加和成目标值的下标数组
     * 要求返回两数之和的下标数组,则第一个数据必定不会直接返回,然后在遍历中做判断,在达到目标加和之前将之前的元素put进map
     * 时间复杂度 => O(n)
     * @param nums 随机数组
     * @param target 目标值
     * @return 可加和成目标值的下标数组
     */
    public static int[] twoSumWithMapMoreFast(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                return new int[] {i, map.get(another)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] sum = twoSum(nums, target);
        for (int i : sum) {
            System.out.println(i);
        }
    }

}
