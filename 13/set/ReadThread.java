package buoi13.set;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ReadThread extends Thread{
    private Set<Integer> set;

    public ReadThread(String name, Set<Integer> set) {
        this.set = set;
        super.setName(name);
    }

    public void run() {

        while (true) {

            String output = "\n" + super.getName() + ":";

            Iterator<Integer> iterator = set.iterator();

            while (iterator.hasNext()) {
                Integer next = iterator.next();
                output += " " + next;

                // fake processing time
                try {

                    Thread.sleep(10);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println(output);
        }
    }
}
