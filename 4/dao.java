package Matrix;

public class dao {

    static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
    static int[][] doiCho(int[][] X) {
        int maxId = 0;
        int max = Math.abs(X[0][0]);
        for (int i = 0; i < X.length; i++) {
            if (Math.abs(X[i][0]) > max)
                maxId = i;
        }
        for (int i = 0; i < X.length; i++) {
            int temp =X[0][i];
            X[0][i]=X[maxId][i];
            X[maxId][i]= temp;
        }
        return X;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, -2, 5, 6, 7},
                {1, 2, 3, 8, 9},
                {3, 1, 52, 12, 13},
                {13, 11, 2, 12, 13},
                {3, 1, 12, 12, 13}};

        for (int i = 0; i < A.length; i++) {
            doiCho(A);
        }

        print(A);
        System.out.println("====================");

    }
}

