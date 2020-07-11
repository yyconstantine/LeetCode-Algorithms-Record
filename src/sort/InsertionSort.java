package sort;

/**
 * 插入排序,对于存在部分有序的数组,排序效率较选择排序更高效
 */
public class InsertionSort extends AbstractSort {
    @Override
    boolean less(Object var1, Object var2) {
        return Integer.parseInt(var1.toString()) < Integer.parseInt(var2.toString());
    }

    public void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]) ; j--) {
                exchange(arr, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 3, 7, 9 ,10, 2, 4};
        new InsertionSort().sort(arr);
        new InsertionSort().show(arr);
    }
}
