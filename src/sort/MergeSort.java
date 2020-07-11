package sort;

/**
 * 自顶向下的归并排序
 */
public class MergeSort extends AbstractSort {

    @Override
    boolean less(Object var1, Object var2) {
        return Integer.parseInt(var1.toString()) < Integer.parseInt(var2.toString());
    }

    private Integer[] aux;

    public void merge(Integer[] arr, int left, int middle, int right) {
        int i = left, j = middle + 1;

        // 先进行数组复制
        for (int k = left; k <= right; k++) {
            aux[k] = arr[k];
        }

        for (int k = left; k <= right; k++) {
            if (i > middle) {
                arr[k] = aux[j++];
            } else if (j > right) {
                arr[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }
    }

    public void sort(Integer[] arr) {
        aux = new Integer[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Integer[] arr, int left, int right) {
        if (right <= left) {
            return;
        }
        int middle = left + (right - left) / 2;
        sort(arr, left, middle);
        sort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 3, 7, 9 ,10, 2, 4};
        new MergeSort().sort(arr);
        new MergeSort().show(arr);
    }

}
