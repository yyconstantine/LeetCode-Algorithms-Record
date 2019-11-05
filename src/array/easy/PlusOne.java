package array.easy;

/**
 * @author songxianglong
 * @date 2019/11/5 14:32
 */
public class PlusOne {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字
     * 你可以假设除了整数 0 之外，这个整数不会以零开头
     *
     * @see #plusOne(int[])
     * 思路：
     *      判断最后一位是不是9,是9则进位,同时置flag为true并进入循环
     *      每当flag为true,判断下一位进位后是否继续进位,不进位则将flag置为false,不参与循环
     *      循环完成后,需要判断第一位是否多进一位,手动补充
     *
     * @see #plusOneInEasyWay(int[])
     * 更简单的思路：
     *      直接进1,若取模结果为0则证明已进位,继续下一位进位,若取模结果不为0则进位结束
     *      循环完成后,需要判断第一位是否多进一位,手动补充
     *
     * @param digits 非空非负数组
     * @return 加一后的数组
     */
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        if (digits[digits.length - 1] == 9) {
            digits[digits.length - 1] = 0;
            flag = true;
        } else {
            digits[digits.length - 1] += 1;
        }
        for (int i = digits.length - 2; i >= 0; i--) {
            if (flag) {
                if ((digits[i] = digits[i] + 1) == 10) {
                    digits[i] = 0;
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }
        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public int[] plusOneInEasyWay(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        if (digits[0] == 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

}
