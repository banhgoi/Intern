package IOstream;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ObjectIO {


    public static void insertSort(HocSinh[] a)  {

        for (int i = 1; i < a.length; i++) {
            HocSinh last = a[i];
            int j = i;
            while (j > 0 && a[j - 1].getNamSinh() > last.getNamSinh()) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = last;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader br = null;
        StringTokenizer tkz;
        String hoten;
        String quequan;
        int namsinh;
        float diemTB;
        HocSinh[] hocSinhs = new HocSinh[6];
        try {
            br = new BufferedReader(new FileReader("D:\\\\\\Luvina\\HOCSINH.txt"));
            //Scanner s = new Scanner(br.readLine()).useDelimiter(" ");
            for (int i = 0; i < 6; i++) {
                tkz = new StringTokenizer(br.readLine(), " ,");
                hoten = tkz.nextToken();
                quequan = tkz.nextToken();
                namsinh = Integer.parseInt(tkz.nextToken());
                diemTB = Float.parseFloat(tkz.nextToken());
                hocSinhs[i] = new HocSinh(hoten, quequan, namsinh, diemTB);
            }
        } catch (IOException IOex) {
            throw IOex;
        } finally {
            if (br != null)
                br.close();
        }


        insertSort(hocSinhs);

        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new FileOutputStream("D:\\\\\\Luvina\\FileStudents.dat"));
            for (int i = 0; i < hocSinhs.length; i++) {
                out.writeObject(hocSinhs[i]);
//                System.out.println(arr[i]);
            }

        } catch (IOException IOex) {
            throw IOex;
        } finally {
            if (out != null)
                out.close();
        }
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("D:\\\\\\Luvina\\FileStudents.dat"));
            HocSinh c;
            for (int i = 0; i < hocSinhs.length; i++) {
                c = (HocSinh) in.readObject();
                System.out.print("\n"+c );
            }
        } catch (  IOException E ) {
            throw  E;
        } finally {
            if (in != null)
                in.close();
        }
//        System.out.println(Arrays.toString(hocSinhs));
    }
}
