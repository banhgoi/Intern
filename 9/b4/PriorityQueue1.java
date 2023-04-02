package Collections;

import javax.imageio.IIOException;
import java.io.*;
import java.util.*;


class StudentComparatorNamSinh implements Comparator<Student5> {
    public int compare(Student5 std1, Student5 std2) {
        return std1.getNamSinh().compareTo(std2.getNamSinh());
    }
}


public class PriorityQueue1 {

    public static void main(String[] a) throws IOException, ClassNotFoundException, ClassCastException {
        BufferedReader br = null;
        StringTokenizer tkz;
        String hoTen;
        String queQuan;
        int namSinh;
        float diemTB;
        Queue<Student5> queue1 = new PriorityQueue<>(6);
        try {
            br = new BufferedReader(new FileReader("./student.txt"));
            for (int i = 0; i < 6; i++) {
                tkz = new StringTokenizer(br.readLine(), ",");
                hoTen = tkz.nextToken();
                queQuan = tkz.nextToken();
                namSinh = Integer.parseInt(tkz.nextToken());
                diemTB = Float.parseFloat(tkz.nextToken());
                queue1.add(new Student5(hoTen, queQuan, namSinh, diemTB));
            }
        } catch (IOException IOex) {
            throw IOex;
        } finally {
            if (br != null) br.close();
        }

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("./FileStudents.dat"));
            for (Student5 el : queue1) {
                out.writeObject(el);
//                System.out.println(el);
            }
        } catch (IOException IOex) {
            throw IOex;
        } finally {
            if (out != null) out.close();
        }

        for (Student5 el : queue1) {
            System.out.println(el);
        }
        
        
        ObjectInputStream in = null;
        Queue<Student5> queue2 = new PriorityQueue<>(6,new StudentComparatorNamSinh());
        try {
            in = new ObjectInputStream(new FileInputStream("./FileStudents.dat"));

            for (Student5 el : queue1) {
                queue2.add((Student5) in.readObject());
//                System.out.print("\n" + queue2.peek());
            }
        } catch (IIOException E) {
            E.toString();
        } finally {
            if (in != null) in.close();
        }
        while (queue2.peek() != null) {
            System.out.println(queue2.poll().toString());
        }

    }
}
