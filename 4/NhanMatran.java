package Matrix;

public class NhanMatran {

    static void print(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    static int[][] multiMatrix(int[][] X, int[][] Y) {
        int sum;
        int[][] C = new int[X.length][Y.length];

        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < Y.length; j++) {
                sum = 0;
                for (int k = 0; k < X.length; k++) {
                    sum = sum + X[i][k] * Y[k][j];
                }
                C[i][j] = sum;
            }
        }
        return C;
    }

    static int[][] multiMatrix2(int[][] X, int[][] Y) {
        int sum;
        int[][] C = new int[X.length][Y.length];
        int i=0;
        while (i<X.length) {
            for (int j = 0; j < Y.length; j++) {
                sum = 0;
                for (int k = 0; k < X.length; k++) {
                    sum = sum + X[i][k] * Y[k][j];
                }
                C[i][j] = sum;
            }
            i++;
        }
        return C;
    }
    static int[][] multiMatrix3(int[][] X, int[][] Y) {
        int sum;
        int[][] C = new int[X.length][Y.length];

        for (int i = 0; i < X.length; i++) {
            int j=0;
           while (j<Y.length){
                sum = 0;
                for (int k = 0; k < X.length; k++) {
                    sum = sum + X[i][k] * Y[k][j];
                }
                C[i][j] = sum;
                j++;
            }
        }
        return C;
    }



    public static void main(String args[]) {
        int[][] A = {
                {1, -2, 5, 6, 7},
                {1, 2, 3, 8, 9},
                {3, 1, 52, 12, 13},
                {13, 11, 2, 12, 13},
                {3, 1, 12, 12, 13}};

        int[][] B = {
                {3, -5, 7, 2, 4},
                {2, 2, 6, 3, 7},
                {1, 4, 5, 3, 9},
                {8, 2, 4, 6, 3},
                {13, 7, 2, 1, 4}};

        print(multiMatrix3(A, B));
    }
}
