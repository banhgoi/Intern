package executorforkjoin.ForkJoin;

import java.util.concurrent.RecursiveTask;

public class ArrayCounter extends RecursiveTask<Integer> {

    int[] array;
    int number;
    int threshold = 10000000;
    int start;
    int end;

    public ArrayCounter(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start < threshold) {
            return  computeDirectly();
        } else {
            int middle = (end + start) / 2;
            ArrayCounter subTaskl = new ArrayCounter(array, start, middle);
            ArrayCounter subTask2 = new ArrayCounter(array, middle, end);
            invokeAll(subTaskl, subTask2);
            return subTaskl.join() + subTask2.join();
        }
    }

    protected Integer computeDirectly() {
        Integer count = 0;
        for (int i = start; i < end; i++) {
            if (array[i] % 2 == 0)
                count++;
        }
        return count;
    }


}
