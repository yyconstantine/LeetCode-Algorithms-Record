package array.easy;

/**
 * @author songxianglong
 * @date 2019/11/1 10:34
 */
public class SearchInsertPosition {

    /**
     * 在数组中找到目标值,并返回其索引;如果目标值不存在,返回它将会被按顺序插入的位置
     * @param nums 排序数组
     * @param target 目标值
     * @return 返回目标索引或顺序插入的位置
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums[0] >= target) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > target && nums[i-1] < target || nums[i] == target) {
                return i;
            }
        }
        return nums.length;
    }

}
