package buoi13.set;

import java.util.Set;

public class WriteThread extends Thread {
    private Set<Integer> set;

    public WriteThread(String name, Set<Integer> set) {
        this.set = set;
        super.setName(name);
    }

    public void run() {
        int count = 6;

        while (true) {

            try {

                Thread.sleep(500);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            set.add(count++);

            System.out.println(super.getName() + " done");
        }
    }
}
