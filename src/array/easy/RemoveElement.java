package array.easy;

/**
 * @author songxianglong
 * @date 2019/11/1 10:04
 */
public class RemoveElement {

    /**
     * 原地移除所有数值等于val的元素
     *
     * 思路：
     *      遍历数组,如果数组当前元素不等于val,则用下一个节点覆盖当前节点的值,移动指针继续比较
     *
     * @param nums 数组nums
     * @param val 值val
     * @return 返回移除后数组的长度
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

}
