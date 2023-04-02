package buoi12.bai2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Bai2_3 {
    public static void searchByIdSupplier(HashMap<Supplier, TreeMap<Purchase, ArrayList<PurchaseDetail>>> hm, Supplier sup) {
        TreeMap<Purchase, ArrayList<PurchaseDetail>> tm = hm.get(sup);
        if (tm != null)
            tm.keySet().forEach(System.out::println);
        else
            System.out.println("Không tìm thấy nhà cung cấp có id " + sup.getIdSup());

    }

    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        HashMap<Supplier, TreeMap<Purchase, ArrayList<PurchaseDetail>>> hm = new HashMap<>();
        Supplier sup1, sup2;

        //<editor-fold desc="Khởi tạo giá trị Supplier1">
        sup1 = new Supplier("Sup1", "AAA", "Ha Noi", "0123456789");
        TreeMap<Purchase, ArrayList<PurchaseDetail>> tm1 = new TreeMap<>();
        ArrayList<PurchaseDetail> arrPur1, arrPur2, arrPur3, arrPur4;
        arrPur1 = new ArrayList<>(2);
        arrPur2 = new ArrayList<>(2);
        arrPur3 = new ArrayList<>(2);
        arrPur4 = new ArrayList<>(2);

        Purchase pur1, pur2, pur3, pur4;
        PurchaseDetail detail1, detail2, detail3, detail4, detail5, detail6, detail7, detail8;

        //<editor-fold desc="Khởi tạo giá trị Purchase1">
        pur1 = new Purchase(1, dateFormat.parse("05/05/2022"), "Sup1");
        detail1 = new PurchaseDetail(1, 1, 3, 100, 10F);
        detail2 = new PurchaseDetail(1, 2, 5, 50, 80F);

        arrPur1.add(detail1);
        arrPur1.add(detail2);
        tm1.put(pur1, arrPur1);
        //</editor-fold>

        //<editor-fold desc="Khởi tạo giá trị Purchase2">
        pur2 = new Purchase(2, dateFormat.parse("06/05/2022"), "Sup1");
        detail3 = new PurchaseDetail(2, 3, 2, 60, 20F);
        detail4 = new PurchaseDetail(2, 4, 3, 60, 30F);

        arrPur2.add(detail3);
        arrPur2.add(detail4);
        tm1.put(pur2, arrPur2);
        //</editor-fold>
        hm.put(sup1, tm1);
        //</editor-fold>

        //<editor-fold desc="Khởi tạo giá trị Supplier2">
        sup2 = new Supplier("Sup2", "BBB", "Ninh Binh", "0123443210");
        TreeMap<Purchase, ArrayList<PurchaseDetail>> tm2 = new TreeMap<>();

        //<editor-fold desc="Khởi tạo giá trị Purchase1">
        pur3 = new Purchase(3, dateFormat.parse("08/05/2022"), "Sup2");
        detail5 = new PurchaseDetail(3, 5, 6, 200, 20F);
        detail6 = new PurchaseDetail(3, 6, 7, 50, 80F);

        arrPur3.add(detail5);
        arrPur3.add(detail6);
        tm2.put(pur3, arrPur3);
        //</editor-fold>

        //<editor-fold desc="Khởi tạo giá trị Purchase2">
        pur4 = new Purchase(4, dateFormat.parse("20/05/2022"), "Sup2");
        detail7 = new PurchaseDetail(4, 7, 8, 50, 30F);
        detail8 = new PurchaseDetail(4, 8, 9, 60, 20F);

        arrPur4.add(detail7);
        arrPur4.add(detail8);
        tm2.put(pur4, arrPur4);
        //</editor-fold>
        hm.put(sup2, tm2);
        //</editor-fold>

        //Thực hành tìm kiếm các đơn nhập hàng theo mã nhà cung cấp
        Supplier sup3 = new Supplier("Sup1");
        searchByIdSupplier(hm, sup3);
        System.out.println("========================================================");
        Supplier sup4 = new Supplier("Sup3");
        searchByIdSupplier(hm, sup4);
        System.out.println("========================================================");


        //Xác định nhà nhà cung cấp có tổng tiền hàng lớn nhất
//        Optional<Map.Entry<Supplier, TreeMap<Purchase, ArrayList<PurchaseDetail>>>> max = hm.entrySet().stream()
//                .max((x1, x2) -> TotalPaid(x1.getValue()).compareTo(TotalPaid(x2.getValue())));
//
//        if (max.isPresent()) {
//            System.out.println("Nhà cung cấp có tổng tiền hàng lớn nhất là: " + max.get().getKey());
//            System.out.println("Tổng số tiền: " + TotalPaid(max.get().getValue()));
//        }
//        Cách 2
        hm.entrySet().stream().collect(Collectors.groupingBy(x -> TotalPaid(x.getValue()), TreeMap::new, Collectors.toList()))
                .lastEntry()
                .getValue()
                .forEach(x -> System.out.println(x.getKey()));
    }

    public static Double TotalPaid(TreeMap<Purchase, ArrayList<PurchaseDetail>> tm) {
        return tm.values().stream().mapToDouble(x -> sum(x)).sum();
    }

    public static Double sum(ArrayList<PurchaseDetail> details) {
        return details.stream().mapToDouble(t -> t.getPrice() * t.getAmount()).sum();
    }
}
