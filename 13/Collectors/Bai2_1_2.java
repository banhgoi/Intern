package buoi12.bai2;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Bai2_1_2 {

    public static void searchOrderByIdCustomer(TreeMap<Customer, ArrayList<Order>> tm, Customer cus) {
        ArrayList<Order> arr = tm.get(cus);
        if (arr != null)
            arr.stream().forEach(System.out::println);
        else
            System.out.println("Không tìm thấy khách hàng có id " + cus.getIdCus());
    }

    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        TreeMap<Customer, ArrayList<Order>> tm = new TreeMap<>();
        ArrayList<Order> arrOrder1, arrOrder2;
        arrOrder1 = new ArrayList<>(2);
        arrOrder2 = new ArrayList<>(3);

        Customer cus1, cus2;
        Order or1, or2, or3, or4, or5;

        //<editor-fold desc="Khởi tạo giá trị Customer1">
        cus1 = new Customer("Cus1", "A", "Ha Noi", "0123456789");
        or1 = new Order(1, dateFormat.parse("06/8/2020"), "Cus01");
        or2 = new Order(2, dateFormat.parse("07/8/2020"), "Cus01");

        arrOrder1.add(or1);
        arrOrder1.add(or2);
        tm.put(cus1, arrOrder1);
        //</editor-fold>

        //<editor-fold desc="Khởi tạo giá trị Customer2">
        cus2 = new Customer("Cus2", "B", "Nam Dinh", "0123443210");
        or3 = new Order(3, dateFormat.parse("25/9/2020"), "Cus02");
        or4 = new Order(4, dateFormat.parse("30/9/2020"), "Cus02");
        or5 = new Order(5, dateFormat.parse("5/10/2020"), "Cus02");

        arrOrder2.add(or3);
        arrOrder2.add(or4);
        arrOrder2.add(or5);
        tm.put(cus2, arrOrder2);
        //</editor-fold>

//        Tìm kiếm hóa đơn dựa vào IdCustomer
        Customer cus3 = new Customer("Cus2");
        searchOrderByIdCustomer(tm, cus3);
        System.out.println("========================================================");
        Customer cus4 = new Customer("Cus3");
        searchOrderByIdCustomer(tm, cus4);
        System.out.println("========================================================");

//        Khách hàng có nhiều hóa đơn nhất
//        Optional<Map.Entry<Customer, ArrayList<Order>>> max = tm.entrySet().stream()
//                .max((x1, x2) -> count(x1.getValue()).compareTo(count(x2.getValue())));
//
//        if (max.isPresent()) {
//            System.out.println("Khách hàng có nhiều hóa đơn nhất: " + max.get().getKey());
//            System.out.println("Số lượng hóa đơn: " + count(max.get().getValue()));
//        }

//        Cách 2
        tm.entrySet().stream().collect(Collectors.groupingBy(x -> count(x.getValue()), TreeMap::new, Collectors.toList()))
                .lastEntry()
                .getValue()
                .forEach(x -> System.out.println(x.getKey()));
    }

    public static Integer count(ArrayList<Order> orders) {
        return orders.size();
    }
}
