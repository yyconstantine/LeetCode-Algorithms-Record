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
     * @param numRows 非负整数
     * @return 杨辉三角前numRows行
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                rowList.add(i);
            }
            rowList.add(i);
            result.add(rowList);
        }

        return result;
    }


}
