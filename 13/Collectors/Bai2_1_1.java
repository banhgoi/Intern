package buoi12.bai2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Bai2_1_1 {

    public static void searchByIdOrder(TreeMap<Order, ArrayList<OrderDetail>> tm, Order or){
        ArrayList<OrderDetail> arr = tm.get(or);
        if (arr != null)
            arr.stream().forEach(System.out::println);
        else
            System.out.println("Không tìm thấy hóa đơn có id = " + or.getIdOrder());
    }

    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        TreeMap<Order, ArrayList<OrderDetail>> tm = new TreeMap<>();

        ArrayList<OrderDetail> arrDetail1, arrDetail2;
        arrDetail1 = new ArrayList<>(2);
        arrDetail2 = new ArrayList<>(2);

        Order or1, or2;
        OrderDetail orDetail1, orDetail2, orDetail3, orDetail4;

        //<editor-fold desc="Khởi tạo giá trị Order1">
        or1 = new Order(1,dateFormat.parse("06/8/2020"), "Cus01");
        orDetail1  = new OrderDetail(1, 1, 1, 10, 100F);
        orDetail2 = new OrderDetail(1, 2, 5, 7, 20F);

        arrDetail1.add(orDetail1);
        arrDetail1.add(orDetail2);
        tm.put(or1, arrDetail1);
        //</editor-fold>

        //<editor-fold desc="Khởi tạo giá trị Order2">
        or2 = new Order(2,dateFormat.parse("06/8/2020"), "Cus02");
        orDetail3 = new OrderDetail(2, 3, 3, 10, 30F);
        orDetail4 = new OrderDetail(2, 4, 7, 7, 50F);

        arrDetail2.add(orDetail3);
        arrDetail2.add(orDetail4);
        tm.put(or2, arrDetail2);
        //</editor-fold>

//        Tìm hóa đơn bằng ID
        Order or3 = new Order(2);
        searchByIdOrder(tm, or3);
        System.out.println("=====================================");
        Order or4 = new Order(3);
        searchByIdOrder(tm, or4);
        System.out.println("=====================================");

//        Tìm hóa đơn có tổng tiền lớn nhất
//        Optional<Map.Entry<Order, ArrayList<OrderDetail>>> max = tm.entrySet().stream()
//                .max((x1, x2) -> sum(x1.getValue()).compareTo(sum(x2.getValue())));
//        System.out.println("Tổng tiền lớn nhất là: ");
//        if (max.isPresent()){
//            System.out.println("Hóa đơn có tổng tiền lớn nhất là: " + max.get().getKey());
//            System.out.println("Giá tiền: " + sum(max.get().getValue()));
//        }
//        Cách 2
        tm.entrySet().stream().collect(Collectors.groupingBy(x -> sum(x.getValue()), TreeMap::new, Collectors.toList()))
                .lastEntry()
                .getValue()
                .forEach(x -> System.out.println(x.getKey()));
    }

    public static Double sum(ArrayList<OrderDetail> details) {
        return details.stream().mapToDouble(t -> t.getPrice()*t.getAmount()).sum();
    }
}


