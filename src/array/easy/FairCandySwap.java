package array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author songxianglong
 * @date 2019/11/5 16:12
 */
public class FairCandySwap {

    /**
     * 交换一个糖果,使他们糖果总量相同
     *
     * 思路：
     *      规律为：小朋友交换糖果的差值等于小朋友糖果总量差值的一半,推导过程这里不再赘述,简单的二元一次方程
     *      首先求出糖果总量及差值,并将其中一个小朋友的糖果放入Set集合
     *      根据重量大小进行不同遍历,当set包含其取值结果则认为成立,返回当前结果
     *      注：HashSet底层使用HashMap的hash运算+链表/红黑树查找,在平均情况下时间复杂度为O(1),极端情况下退化成O(n),所以这里时间复杂度极为O(A.length+B.length)
     *
     * @param A 第一个小朋友的糖果,包含不同大小的糖果
     * @param B 第二个小朋友的糖果,包含不同大小的糖果
     * @return 两个小朋友交换的糖果大小数组
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }

        int diff = Math.abs(sumA - sumB)/2;

        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }

        for (int b : B) {
            if (sumA > sumB) {
                if (set.contains(b + diff)) {
                    return new int[] {b, b + diff};
                }
            } else {
                if (set.contains(b - diff)) {
                    return new int[] {b, b - diff};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        new FairCandySwap().fairCandySwap(new int[] {32,38,8,1,9}, new int[] {68,92});
    }

}
