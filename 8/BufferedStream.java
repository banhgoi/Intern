package IOstream;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BufferedStream {

    public static void insertSort(int[] a) {

        for (int key = 1; key < a.length; key++) {
            int last = a[key], j = key;
            while (j > 0 && a[j - 1] > last) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = last;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = null;
        StringTokenizer tkz;
        try {
            br = new BufferedReader(new FileReader("D:\\\\\\Luvina\\Buffered.txt"));
            //Scanner s = new Scanner(br.readLine()).useDelimiter(" ");
            tkz = new StringTokenizer(br.readLine());

        } catch (IOException IOex) {
            throw IOex;
        } finally {
            if (br != null)
                br.close();
        }
        int[] arr = new int[tkz.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = parseInt(tkz.nextToken());
//            System.out.println(arr[i]);
        }
        insertSort(arr);

        DataOutputStream pw = null;
        DataInputStream input = null;
        try {
            pw = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\\\\\Luvina\\Numbers.dat")));
            for (int i = 0; i < arr.length; i++) {
                pw.writeInt(arr[i]);
//                System.out.println(arr[i]);
            }
//            pw.println(Arrays.toString(arr));

//            int i=0;
//            while (i<arr.length) {
//                pw.print((arr[i])+" ");
//                i++;
//            }
        } catch (IIOException IOex) {
            throw IOex;
        } finally {
            if (pw != null)
                pw.close();
        }

        try {
            input = new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\\\\\Luvina\\Numbers.dat")));
            int c = 0;
            for (int i = 0; i < arr.length; i++) {
                c = input.readInt();
                System.out.print(c+" ");
            }
        } catch (IIOException IOex) {
            throw IOex;
        } finally {
            if (input != null)
                input.close();
        }

//        System.out.println(Arrays.toString(arr));
    }
}
