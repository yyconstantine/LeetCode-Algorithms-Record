package array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author songxianglong
 * @date 2019/11/6 13:22
 */
public class PascalsTriangle {

    /**
     * 给定一个非负整数numRows,生成杨辉三角的前numRows行
     *
     * 思路：
     *      每一行根据行数填充对应个数的数据,头尾部写死为1,中间部分取上一次循环结果加和填充
     *
     * @param numRows 非负整数
     * @return 杨辉三角前numRows行
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (i <= 2) {
                    rowList.add(1);
                } else {
                    if (j == 0 || j == i - 1) {
                        rowList.add(1);
                    } else {
                        rowList.add(result.get(i-2).get(j-1)+result.get(i-2).get(j));
                    }
                }
            }
            result.add(rowList);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5));
    }


}
