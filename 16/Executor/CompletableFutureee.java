package executorforkjoin.Executor;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureee {
    public static void main(String[] args) {

        //Khong dong bo
//        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
//            System.out.println("in run Async");
//        });
//        try {
//            System.out.println("Hello"); //Hello
//        }catch (Exception e){}


        // Dong bo voi kq truoc do
        Employee epl = new Employee("Hung", "Nguyễn");
        CompletableFuture<String> cf1 = CompletableFuture.completedFuture(epl).thenApply(s -> {
            return s.firstname.toUpperCase();
        });
        System.out.println(cf1.getNow(null));   //Hung




//        Khong dong bo voi k   truoc do
//        Employee ep1 = new Employee("Hungi", "Nguyễni");
//        CompletableFuture<String> cf2 = CompletableFuture.completedFuture(ep1).thenApplyAsync(s -> {
//            System.out.println("in run thenApplyAsync");
//            return s.firstname.toUpperCase();
//        });
//
//        System.out.println("Befoze join: " + cf2.getNow(null));
//        cf2.join();             // đợi đến khi thực hiện xong thenAapplyAsync
//        System.out.println("Join:" + cf2.getNow(null));

        //    in run thenApplyAsync
        //    Befoze join: null
        //    Join:HUNGI

    }

}


