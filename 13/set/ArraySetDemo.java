package buoi13.set;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ArraySetDemo {
    public static void main(String[] args) {

        Set<Integer> set = new CopyOnWriteArraySet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        new WriteThread("Writer", set).start();

        new ReadThread("Reader", set).start();

    }
}
