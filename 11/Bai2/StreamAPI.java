package TH10.Bai2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {

        Customer cus01 = new Customer("Nam", "HN");
        Customer cus02 = new Customer("Hoang", "BN");
        Customer cus03 = new Customer("Van", "HCM");
        Customer cus04 = new Customer("Phuong", "HCM");
        Customer cus05 = new Customer("Linh", "HCM");
        Customer cus06 = new Customer("Phuong", "HCM");

        Transaction ts01 = new Transaction(cus01, 2021, "Cola", 20);
        Transaction ts12 = new Transaction(cus01, 2021, "Nuoc ep", 20);
        Transaction ts03 = new Transaction(cus03, 2021, "Dep", 4);
        Transaction ts02 = new Transaction(cus02, 2021, "Balo", 7);
        Transaction ts04 = new Transaction(cus05, 1940, "Dieu hoa", 10);
        Transaction ts05 = new Transaction(cus05, 2021, "Quan", 15);
        Transaction ts06 = new Transaction(cus05, 2021, "Sach", 10);
        Transaction ts07 = new Transaction(cus04, 1940, "But", 2);
        Transaction ts08 = new Transaction(cus05, 1940, "Ghe", 1);
        Transaction ts09 = new Transaction(cus01, 2000, "pate", 6);
        Transaction ts10 = new Transaction(cus01, 2006, "sua", 3);
        Transaction ts11 = new Transaction(cus01, 2008, "Chuoi", 2);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(ts01);
        transactions.add(ts09);
        transactions.add(ts10);
        transactions.add(ts11);
        transactions.add(ts04);
        transactions.add(ts05);
        transactions.add(ts06);
        transactions.add(ts08);
        transactions.add(ts02);
        transactions.add(ts03);
        transactions.add(ts04);
        transactions.add(ts07);
        transactions.add(ts12);

        List<Customer> customers = new ArrayList<>();
        customers.add(cus01);
        customers.add(cus02);
        customers.add(cus03);
        customers.add(cus04);
        customers.add(cus05);
        customers.add(cus06);

        // 2.1
        transactions.stream()
                .filter(y->y.getYear()
                .equals(2021))
                .sorted((t1,t2)->t1.getAmount().compareTo(t2.getAmount()))
                .forEach(System.out::println);
//        2.2
        customers.stream()
                .map(y -> y.getCity())
                .distinct()
                .forEach(System.out::println);
//          2.2.1
        customers.stream()
                .map(y -> y.getCity())
                .forEach(System.out::println);

        //2.2.2
        customers.stream()
                .sorted((x,y)->x.getCity().compareTo(x.getCity()))
                .map(x->x.getName()).distinct()
                .forEach(cus->System.out.println(cus));
        //2.3
        String ad = "HCM";
        customers.stream()
                .filter(y->y.getCity().equals(ad))
                .sorted((t1,t2)->t1.getName().compareTo(t2.getName()))
                .forEach(y->System.out.println(y));
//        //2.4
        customers.stream()
                .sorted((t1,t2)->t1.getName().compareTo(t2.getName()))
                .forEach(y->System.out.println(y));

        //2.5
        System.out.println(customers.stream()
                .anyMatch(y->y.getCity().equals(ad)));
        //2.6
        System.out.println(transactions.stream()
                .max(Comparator.comparingInt(s->s.getAmount())));

        //so luong lon nhat
        System.out.println(transactions.stream()
                .sorted((t1, t2) -> t2.getAmount().compareTo(t1.getAmount()))
                .findFirst().map(x->x.getAmount()));


        // 2.6.1 trans co so luong lon nhat
        System.out.println(transactions.stream()
                .sorted((t1, t2) -> t2.getAmount().compareTo(t1.getAmount()))
                .findFirst());


        //2.6.2 tat ca trans co so luong lon nhat
        Optional<Transaction> max =transactions.stream()
                .max(Comparator.comparingInt(s->s.getAmount()));

        transactions.stream()
                .filter(x->x.getAmount().equals(max.get().getAmount()))
                .forEach(System.out::println);
        

        //2.6.3
        transactions.stream()
                .max(Comparator.comparingInt(s->s.getAmount()));


        //2.7 ra tổng số lượng trong các giao dịch của các khách hàng ở HCM

        System.out.println(transactions.stream()
                .filter(y->y.getCustomer().getCity().equals(ad))
                .mapToInt(Transaction::getAmount).sum());

        //2.8
                System.out.println(transactions.stream()
                .min(Comparator.comparingInt(s->s.getAmount())));
    }

}
