package executorforkjoin.ForkJoin;


import executorforkjoin.ForkJoin.ArrayCounter;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinRecursiveTaskTest {
    static final int size = 10000000;
    static int[] array = randomArray();

    private static int[] randomArray() {
        Random rd = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++)
            a[i] = rd.nextInt(1000) + 1;
        return  a;
    }

    public static void main(String[] args){
        ArrayCounter mainTask = new ArrayCounter(array,0,size);
        ForkJoinPool pool= new ForkJoinPool();
        Integer eventNumCount =pool.invoke(mainTask);
        System.out.println("Number of event number: "+ eventNumCount);
    }

}

