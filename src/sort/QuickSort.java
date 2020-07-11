package sort;

/**
 * 快速排序
 */
public class QuickSort extends AbstractSort {

    @Override
    boolean less(Object var1, Object var2) {
        return Integer.parseInt(var1.toString()) < Integer.parseInt(var2.toString());
    }

    public void sort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Integer[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int j = partition(arr, left, right);
        sort(arr, left, j - 1);
        sort(arr, j + 1, right);
    }

    private int partition(Integer[] arr, int left, int right) {
        int i = left, j = right + 1;

        int tmp = arr[left];
        while (true) {
            while (less(arr[++i], tmp)) {
                if (i == right) {
                    break;
                }
            }

            while (less(tmp, arr[--j])) {
                if (j == left) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exchange(arr, i, j);
        }
        exchange(arr, left, j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 3, 7, 9 ,10, 2, 4};
        new QuickSort().sort(arr);
        new QuickSort().show(arr);
    }

}
