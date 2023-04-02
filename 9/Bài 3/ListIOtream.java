package Collections;

import java.io.*;
import java.util.*;


class StudentComparatorDiemTB implements Comparator<Student4> {
    public int compare(Student4 std1, Student4 std2) {
        int c;
        if (std1.getDiemTB() < std2.getDiemTB()) c = 1;
        else if (std1.getDiemTB() > std2.getDiemTB()) c = -1;
        else c = 0;
        return c;
    }
}


public class ListIOtream {


    public static void main(String[] a) throws IOException, ClassNotFoundException {
        BufferedReader br = null;
        StringTokenizer tkz;
        String hoten;
        String quequan;
        int namsinh;
        float diemTB;
        List<Student4> lst1 = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader("./student.txt"));
            //Scanner s = new Scanner(br.readLine()).useDelimiter(" ");
            for (int i = 0; i < 6; i++) {
                tkz = new StringTokenizer(br.readLine(), ",");
                hoten = tkz.nextToken();
                quequan = tkz.nextToken();
                namsinh = Integer.parseInt(tkz.nextToken());
                diemTB = Float.parseFloat(tkz.nextToken());
                lst1.add(new Student4(hoten, quequan, namsinh, diemTB));
            }
        } catch (IOException IOex) {
            throw IOex;
        } finally {
            if (br != null)
                br.close();
        }


        // sort an search by Hoten
        Collections.sort(lst1);
//        Student4 student = new Student4("Nguyen X B", "BN", 1935, 11.0F);
//        int i = Collections.binarySearch(lst1, student);
//        if (i >= 0) {
//            System.out.println("Found " + student.toString() + "   index:" + i);
//        } else System.out.println("Not found " + student.toString());

//        Collections.sort(lst1);
//        System.out.println(lst1.get(2));

//        Collections.sort(lst1, new StudentComparator());
//        int i = Collections.binarySearch(lst1, student);
//        if (i >= 0) {
//            System.out.println("Found " + student.toString() + "   index:" + i);
//        } else System.out.println("Not found " + student.toString());


        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("./FileStudents.dat"));
            for (int j = 0; j < lst1.size(); j++) {
                out.writeObject(lst1.get(j));
//                System.out.println(arr[i]);
            }

        } catch (IOException IOex) {
            throw IOex;
        } finally {
            if (out != null)
                out.close();
        }


        List<Student4> lst2 = new ArrayList<>();
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("./FileStudents.dat"));
            for (int j = 0; j < 6; j++) {
                lst2.add((Student4) in.readObject());
                //   System.out.print("\n" + lst2.get(j));
            }
        } finally {
            if (in != null)
                in.close();
        }


        //  search by Hoten
        Student4 student2 = new Student4("Nam X B", "HN", 1992, 10.0f);
        int k = Collections.binarySearch(lst2, student2);
        if (k >= 0) {
            System.out.println("Found " + student2.toString() + "   index:" + k);
        } else System.out.println("Not found " + student2.toString());

        // sort an search by DiemTB
        Collections.sort(lst2, new StudentComparatorDiemTB());
        System.out.println(lst2.get(0));
        Student4 student3 = new Student4("Nam X B", "HN", 1992, 10.0f);
        int z = Collections.binarySearch(lst2, student3);
        if (z >= 0) {
            System.out.println("Found " + student3.toString() + "   index:" + k);
        } else System.out.println("Not found " + student3.toString());
        for (Student4 i : lst2) {
            System.out.println(i);
        }
    }

}
