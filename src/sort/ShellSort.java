package sort;

/**
 * 希尔排序,一种基于插入排序的更高效的排序算法
 * 性能表现只比更复杂的如快排、归并排序慢2倍左右,且不需要占用额外的内存空间
 */
public class ShellSort extends AbstractSort {

    @Override
    boolean less(Object var1, Object var2) {
        return Integer.parseInt(var1.toString()) < Integer.parseInt(var2.toString());
    }

    /**
     * 希尔排序的本质是每h个间隔的数组都是有序的
     */
    public void sort(Integer[] arr) {
        int len = arr.length;
        // 定义一个数组间隔
        int h = 1;
        // 将数组分成若干间隔
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 这里其实就是先分为若干间隔,再分别对每个间隔内的数组进行排序
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]) ; j--) {
                    exchange(arr, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 3, 7, 9 ,10, 2, 4};
        new ShellSort().sort(arr);
        new ShellSort().show(arr);
    }
}
