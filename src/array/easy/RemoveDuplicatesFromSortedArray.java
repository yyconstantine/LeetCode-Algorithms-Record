package array.easy;

/**
 * @author songxianglong
 * @date 2019/11/1 9:51
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 在原地删除重复出现的元素，使得每个元素只出现一次
     *
     * 思路：
     *      遍历数组,若当前元素不相同,则计数值+1,指针后移继续比较,遍历完成则获取不重复数组的长度
     *
     * @param nums 给定一个排序数组
     * @return 返回移除后数组的新长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
