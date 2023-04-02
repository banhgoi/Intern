package buoi13.list;

import java.util.List;

public class WriteThread extends Thread {
    private List<Integer> list;

    public WriteThread(String name, List<Integer> list) {
        this.list = list;
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

            list.add(count++);

            System.out.println(super.getName() + " done");
        }
    }
}
