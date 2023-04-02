public class Main {
//    public static int check(int a, int d, double c){
//        if(c<d)
//            return 1;
//        if(a%d==0)
//            return 0;
//        return check(a, d+1, (int) c);
//    }
//
//    public static int soNT(int n){
//        return check(n, 2, (int)Math.sqrt(n));
//    }


    public static void main(String[] args) {

///*-------- Slide 43 -------------
//        String[][] students={{"A","B","A","C","C","D","E","E","A","D"},
//                            {"D","B","A","B","C","C","E","E","A","D"},
//                            {"E","E","E","A","C","B","E","E","A","D"},
//                            {"C","B","A","E","D","C","E","E","A","D"},
//                            {"A","B","D","C","C","D","E","E","A","D"},
//                            {"B","B","E","C","C","D","E","E","A","D"},
//                            {"B","B","A","C","C","D","E","E","A","D"},
//                            {"E","B","E","C","C","D","E","E","A","D"}};
//
//        String[] answers ={"D","B","D","C","C","D","A","E","A","D"};
//
//        for (int i=0;i<students.length;i++) {
//            int diem = 0;
//            for (int j = 0; j < students[i].length; j++) {
//                if (students[i][j].equals(answers[j])) {
//                    diem++;
//                }
//            }
//            System.out.print("Diem cua hoc sinh thu "+ i +": " + diem);
//            System.out.println();
//        }
//*/


///* -------- Slide 50 -------------
//        String name ="Hoang Nguyen Tuan Anh";
//        name= name.trim();
//        String a =name.substring(name.lastIndexOf(" "),name.length());
//        name = name.replace(a,"");
//        name=String.join(" ",a,name);
//        System.out.println(name);
//*/


/*      -------- Slide 63 -------------
        String a = "ha hava , . havana.havanada ,";
        StringTokenizer tkz = new StringTokenizer(a, " ,.");
        int b= tkz.countTokens();
        int max= 0;
        String maxString="";
        while (b>0){
            try {
                int currentSize= tkz.nextToken().length();
                if(currentSize > max){
                    max = currentSize;
                    maxString=tkz.nextToken();
                }
            }catch (NoSuchElementException exception){};
           b--;
        }
        System.out.println("Xau con dai nhat la: "+maxString);

 */



//          Dang 1 bai 1
//        int [] A={5, 7, 9, 10,16};
//        boolean stonk = true;
//        for (int i=0;i<A.length-1;i++){
//                if (A[i+1]<=A[i]){
//                    stonk=false;
//                    break;
//                }
//        }System.out.println(stonk);


        //         Dang 1 bai 2
//        int [] A={5, -1, 7, -11, 17};
//        boolean x = true;
//        for (int i=0;i<A.length-1;i++) {
//            if ((A[i+1]>0&A[i]>0)||(A[i+1]<0)&(A[i]<0)||((A[i+1]==0)||(A[i]==0))) {
//                x = false;
//                break;
//            }
//        }System.out.println(x);


        //         Dang 1 bai 3
//        int [] A={5, 1, 7, 11, 17};
//        boolean x = true;
//        for (int i=0;i<A.length-1;i++) {
//            if (soNT(A[i])==0) {
//                x = false;
//                break;
//            }
//        }System.out.println(x);

    }
}