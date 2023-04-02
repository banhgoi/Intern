package buoi12.bai2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Bai2_2 {


    public static void searchOrderByIdCustomer(HashMap<Customer, TreeMap<Order, ArrayList<OrderDetail>>> hm, Customer cus) {
        TreeMap<Order, ArrayList<OrderDetail>> tm = hm.get(cus);
        if (tm != null)
            tm.keySet().forEach(System.out::println);
        else
            System.out.println("Không tìm thấy khách hàng có id " + cus.getIdCus());
    }

    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        HashMap<Customer, TreeMap<Order, ArrayList<OrderDetail>>> hm = new HashMap<>();
        Customer cus1, cus2;

        //<editor-fold desc="Khởi tạo giá trị Customer1">
        cus1 = new Customer("Cus1", "A", "Ha Noi", "0123456789");
        TreeMap<Order, ArrayList<OrderDetail>> tm1 = new TreeMap<>();
        ArrayList<OrderDetail> arrDetail1, arrDetail2, arrDetail3, arrDetail4;
        arrDetail1 = new ArrayList<>(2);
        arrDetail2 = new ArrayList<>(2);
        arrDetail3 = new ArrayList<>(2);
        arrDetail4 = new ArrayList<>(2);

        Order or1, or2, or3, or4;
        OrderDetail orDetail1, orDetail2, orDetail3, orDetail4, orDetail5, orDetail6, orDetail7, orDetail8;

        //<editor-fold desc="Khởi tạo giá trị Order1">
        or1 = new Order(1, dateFormat.parse("06/8/2020"), "Cus1");
        orDetail1 = new OrderDetail(1, 1, 1, 5, 30F);
        orDetail2 = new OrderDetail(1, 2, 5, 7, 20F);

        arrDetail1.add(orDetail1);
        arrDetail1.add(orDetail2);
        tm1.put(or1, arrDetail1);
        //</editor-fold>

        //<editor-fold desc="Khởi tạo giá trị Order2">
        or2 = new Order(2, dateFormat.parse("10/8/2020"), "Cus1");
        orDetail3 = new OrderDetail(2, 3, 3, 10, 50F);
        orDetail4 = new OrderDetail(2, 4, 7, 7, 30F);

        arrDetail2.add(orDetail3);
        arrDetail2.add(orDetail4);
        tm1.put(or2, arrDetail2);
        //</editor-fold>

        hm.put(cus1, tm1);
        //</editor-fold>

        //<editor-fold desc="Khởi tạo giá trị Customer2">
        cus2 = new Customer("Cus2", "B", "Nam Dinh", "0123443210");
        TreeMap<Order, ArrayList<OrderDetail>> tm2 = new TreeMap<>();

        //<editor-fold desc="Khởi tạo giá trị Order1">
        or3 = new Order(3, dateFormat.parse("07/8/2020"), "Cus2");
        orDetail5 = new OrderDetail(3, 5, 1, 10, 30F);
        orDetail6 = new OrderDetail(3, 6, 2, 3, 10F);

        arrDetail3.add(orDetail5);
        arrDetail3.add(orDetail6);
        tm2.put(or3, arrDetail3);
        //</editor-fold>

        //<editor-fold desc="Khởi tạo giá trị Order2">
        or4 = new Order(4, dateFormat.parse("10/8/2020"), "Cus2");
        orDetail7 = new OrderDetail(4, 7, 3, 5, 50F);
        orDetail8 = new OrderDetail(4, 8, 1, 7, 30F);

        arrDetail4.add(orDetail7);
        arrDetail4.add(orDetail8);
        tm2.put(or4, arrDetail4);
        //</editor-fold>

        hm.put(cus2, tm2);
        //</editor-fold>

        Customer cus3 = new Customer("Cus2");
        searchOrderByIdCustomer(hm, cus3);
        System.out.println("========================================================");
        Customer cus4 = new Customer("Cus3");
        searchOrderByIdCustomer(hm, cus4);
        System.out.println("========================================================");

//        Xác định khách hàng có tổng tiền mua hàng lớn nhất
//        Optional<Map.Entry<Customer, TreeMap<Order, ArrayList<OrderDetail>>>> max = hm.entrySet().stream()
//                        .max((x1, x2) -> TotalPaid(x1.getValue()).compareTo(TotalPaid(x2.getValue())));
//
//        if (max.isPresent()){
//            System.out.println("Khách hàng có tổng tiền mua hàng lớn nhất: " + max.get().getKey());
//            System.out.println("Tổng số tiền: " + TotalPaid(max.get().getValue()));
//        }
//        Cách 2
        hm.entrySet().stream().collect(Collectors.groupingBy(x -> TotalPaid(x.getValue()), TreeMap::new, Collectors.toList()))
                .lastEntry()
                .getValue()
                .forEach(x -> System.out.println(x.getKey()));
    }

    public static Double TotalPaid(TreeMap<Order, ArrayList<OrderDetail>> tm) {
        return tm.values().stream().mapToDouble(x -> sum(x)).sum();
    }

    public static Double sum(ArrayList<OrderDetail> details) {
        return details.stream().mapToDouble(t -> t.getPrice()*t.getAmount()).sum();
    }
}
