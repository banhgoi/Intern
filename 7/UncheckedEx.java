package OOP.Excep;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UncheckedEx {

    public void A() throws Exception {
        System.out.println("Method A");
        try {
            B();
        } catch (Exception ExA) {
            throw new Exception();
        }
        System.out.println("Sau method A");
    }

    public void B() throws ArithmeticException {
        System.out.println("Method B");
        try {
            double b = 1 / 0;
        } catch (ArithmeticException alEx) {
            System.out.println(alEx.toString());
            throw new ArithmeticException();
        }
        System.out.println("Sau method B");
    }

    public static void main(String args[]) throws Exception {
        try {
            UncheckedEx un = new UncheckedEx();
            un.A();
//            Files.createFile(Paths.get("student.txt"));
//            int[] a = new int[0];
//            System.out.println(a[4]);
        } catch (ArrayIndexOutOfBoundsException array) {
            System.out.println("Truy cap ngoai phan tu mang");
            // throw array;
        } catch (FileAlreadyExistsException e1) {
            System.out.println("File exits");
            //     throw new IOException("File exits");
        } catch (Exception Exmain) {
            System.out.println(Exmain.toString());
        } finally {
            System.out.println("Finally");
        }
        System.out.println("Sau try catch");

    }

}
