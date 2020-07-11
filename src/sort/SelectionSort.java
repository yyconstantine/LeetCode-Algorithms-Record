package sort;

/**
 * 每次选择数组中最小的元素 放于当前数组的首部
 */
public class SelectionSort extends AbstractSort {

    @Override
    boolean less(Object var1, Object var2) {
        return Integer.parseInt(var1.toString()) < Integer.parseInt(var2.toString());
    }

    public void sort(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exchange(arr, i, min);
        }
    }

    public static void main(String[] args) {
        Object[] arr = {2, 7, 6, 4, 5, 1, 10};
        new SelectionSort().sort(arr);
        new SelectionSort().show(arr);
    }
}
