import java.util.Arrays;

public class selection_Sort {

    static void selectionSort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }



    public static void main(String args[]) {
        int[] a = {19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

}
