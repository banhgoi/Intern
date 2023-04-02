package executorforkjoin.ForkJoin;

import executorforkjoin.ForkJoin.ArrayTransform;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinRecursiveActionTest {
    static final int size = 1000000;
    static int[] array = randomArray();

    private static int[] randomArray() {
        Random rd = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++)
            a[i] = rd.nextInt(1000) + 1;
        return  a;
    }

    public static void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int number = 10;
        System.out.println("First 10 el of array before: ");
        print();
        ArrayTransform mainTask = new ArrayTransform(array,number,0,size);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);

        System.out.println("==============\nFirst 10 el of array after: ");
        print();

    }

}
