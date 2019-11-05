package array.easy;

import java.util.Arrays;

/**
 * @author songxianglong
 * @date 2019/11/5 15:39
 */
public class MergeSortedArray {

    /**
     * 给定两个有序整数数组nums1和nums2,将nums2合并到nums1中,使得num1成为一个有序数组
     * 设定m >> n
     *
     * 思路：
     *      由于给定nums1必定能装下nums2,所以直接nums1插入nums2,将合并后的nums1排序
     *
     * @param nums1 有序整数数组
     * @param m nums1.length
     * @param nums2 有序整数数组
     * @param n nums2.length
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (n-- > 0) {
            nums1[m++] = nums2[n];
        }
        Arrays.sort(nums1);
    }

}
