import java.util.Arrays;

public class Quick_sort {
    static int partition(int[] a, int L, int R) {
        int mid = (L + R) / 2;
        int pivot = a[mid];
        int temp = a[mid];
        a[mid]= a[R];
        a[R]=temp;
        int store = L;
        for (int i = L; i <= R-1; i++)
            if (a[i] < pivot) {
                int temp1 =a[store];
                a[store]=a[i];
                a[i]=temp1;
                store++;
            }
        int temp2 =a[store];
        a[store]=a[R];
        a[R]=temp2;

        return store;
    }

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }


    public static void main(String args[]) {

        int[] arr = {19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        int size = arr.length;

        Quick_sort.quickSort(arr, 0, size - 1);
        System.out.println(Arrays.toString(arr));
    }
}
