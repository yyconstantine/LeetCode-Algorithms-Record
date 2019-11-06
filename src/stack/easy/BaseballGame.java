package stack.easy;

/**
 * @author songxianglong
 * @date 2019/11/6 11:05
 */
public class BaseballGame {

    /**
     * 给定一个字符串列表,每个字符串可以是以下四种类型：
     *      1.整数(一轮的得分)：直接表示您在本轮中获得的积分数
     *      2."+"(一轮的得分):表示本轮获得的得分是前两轮有效 回合得分的总和。
     *      3."D"(一轮的得分):表示本轮获得的得分是前一轮有效 回合得分的两倍。
     *      4."C"(一个操作,这不是一个回合的分数):表示您获得的最后一个有效回合的分数是无效的,应该被移除。
     *
     * 思路：
     *      将每次执行的结果放入一个int数组,在完成后将整个int数组遍历求和
     *      注意操作执行到"C"时,将上一位元素置为0的同时进行退位,保证后面的操作覆盖掉上一次的操作,确保结果的正确
     *
     * @param ops 输入的字符串列表
     * @return 返回的求和结果
     */
    public static int calPoints(String[] ops) {
        int[] opsInt = new int[ops.length];

        int i = 0;
        for (String score : ops) {
            switch (score) {
                case "D":
                    opsInt[i] = opsInt[i - 1] * 2;
                    i++;
                    continue;
                case "C":
                    opsInt[i - 1] = 0;
                    i--;
                    continue;
                case "+":
                    opsInt[i] = opsInt[i - 1] + opsInt[i - 2];
                    i++;
                    continue;
                default:
                    opsInt[i++] = Integer.parseInt(score);
            }
        }

        int sum = 0;
        for (int score : opsInt) {
            sum += score;
        }

        return sum;
    }

    public static void main(String[] args) {
        String ops[] = new String[] {"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }

}
