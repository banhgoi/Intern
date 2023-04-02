import java.util.Arrays;

public class bubble_Sort {

    // max ben trai
    static void bubbleSortleft(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < (size - 1); i++) {
            for (int j = 0; j < (size - i - 1); j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    //max ben phai
    static void bubbleSortRight(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < (size - 1); i++) {
            for (int j = 0; j < (size - i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    static void bubbleSort2(int arr[]) {
        int size = arr.length;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < size - 1; i++)
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
        }
    }

    static void bubbleSort3(int arr[]) {
        int size = arr.length;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            while (size!=1) {
                size--;
                if (arr[size] < arr[size-1]) {
                    int temp = arr[size-1];
                    arr[size-1] = arr[size];
                    arr[size] = temp;
                    swapped = true;
                }
            }
        }
    }

//    static void bubSort4(int arr[]) {
//        int size = arr.length;
//
//        for (int i=0;i<size-1;i++) {
//            while (size!=1) {
//                size--;
//                if (arr[size] > arr[size-1]) {
//                    int temp = arr[size-1];
//                    arr[size-1] = arr[size];
//                    arr[size] = temp;
//                }
//            }
//        }
//    }


    public static void main(String args[]) {
        int[] a = {19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        bubbleSortRight(a);
        System.out.println(Arrays.toString(a));

    }
}

