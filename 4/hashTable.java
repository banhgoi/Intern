
import java.util.Arrays;
import java.util.Hashtable;

public class hashTable {

    public static void main(String args[]) {
        int a[] = {19, 21, 9, 12, 6, 18, 4, 20, 7, 14};
        int b[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < a.length; i++) {
            int k = a[i] % 7;
            if (b[k] == 0)
                b[k] = a[i];
            else {
                for (int j = 1; j < a.length; j++) {
                    if (b[(i + j) % a.length] == 0) {
                        b[(i + j) % a.length] = a[i];
                        break;
                    }
                }
            }

            System.out.println(Arrays.toString(b));
        }
    }
}

