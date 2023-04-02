
import java.util.Arrays;

public class InsertionSort {
    static void insertion_sort(int a[]) {
        for (int k = 1; k < a.length; k++) {
            int last = a[k], j = k;
            while (j > 0 && a[j - 1] > last) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = last;
        }
    }

    static void insertion_sort2(int a[]) {

            for (int k = 1; k < a.length; k++) {
                int last = a[k], j=k;
                for(j=a.length;j>=0;j--){
                 //   a[j];
                }
            }
    }

    public static void main(String args[]) {
        int a[] = {19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        int b = a.length;
        insertion_sort(a);
        System.out.println(Arrays.toString(a));
    }
}

