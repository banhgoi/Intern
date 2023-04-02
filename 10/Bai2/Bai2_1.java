package TH9.Mappppp.Bai2;

import TH9.Mappppp.NguoiGuiTien;

import java.util.*;

public class Bai2_1 {
    public static void main(String[] args) {
        Customer cus01 = new Customer("Cus01", "Nam", "HN", "0142458");
        Customer cus02 = new Customer("Cus02", "Hoang", "BN", "1472583");

        Oder od11 = new Oder(11, new Date(2020, 4, 8), "Cus01");
        Oder od12 = new Oder(12, new Date(2021, 7, 3), "Cus02");
        //    Oder od21 = new Oder(21, new Date(2020, 2, 15), "Cus02");
//        Oder od22 = new Oder(22, new Date(2019, 6, 20), "Cus02");
//        Oder od23 = new Oder(23, new Date(2021, 1, 17), "Cus02");
//        Oder od24 = new Oder(24, new Date(2022, 1, 3), "Cus02");

        OderDetail od1 = new OderDetail(11, 011, 10, 5, 651.0F);
        OderDetail od2 = new OderDetail(11, 012, 7, 25, 321.3f);
        OderDetail od3 = new OderDetail(11, 021, 15, 35, 48f);
        OderDetail od4 = new OderDetail(21, 022, 26, 15, 89f);
        OderDetail od5 = new OderDetail(21, 023, 30, 35, 158f);
        OderDetail od6 = new OderDetail(21, 024, 5, 15, 951f);

//        Bai 2.2
        List<OderDetail> b21 = new ArrayList<>();
        b21.add(od1);
        b21.add(od2);
        b21.add(od3);
        List<OderDetail> b22 = new ArrayList<>();
        b22.add(od4);
        b22.add(od5);
        b22.add(od6);

        TreeMap<Oder, List<OderDetail>> map21 = new TreeMap<>();
        map21.put(od11, b21);
        map21.put(od12, b22);


        List<Oder> k1 = new ArrayList<>();
        List<Oder> k2 = new ArrayList<>();
        k1.add(od11);
        k1.add(od12);

        TreeMap<Customer, List<Oder>> map212 = new TreeMap<>();
        map212.put(cus01, k1);
        map212.put(cus02, k2);

//      Tim kiem OdDetail theo IdOder
        int id = 12;
        Set<Oder> result = map21.keySet();
        Iterator<Oder> iter = result.iterator();
        while (iter.hasNext()) {
            Oder od = iter.next();
            if (od.getIdOder() == id) {
                System.out.println(map21.get(od));
                break;
            }
        }

//      Tim kiem theo tong tien
        float max = 0;
        Oder c = new Oder();
        for (Map.Entry<Oder, List<OderDetail>> entry : map21.entrySet()) {
            float sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i).getPrice();
            }
            sum = sum > max ? sum : max;
            c = entry.getKey();
            if (sum > max) {
                max = sum;
            }
        }System.out.println(c + " " + max);



//      Tim kiem theo ma khach
        Set<Customer> rs = map212.keySet();
        Iterator<Customer> iter2 = rs.iterator();
        String idCus = "Cus02";
        while (iter2.hasNext()) {
            Customer customer = iter2.next();
            if (customer.getIdCus() == idCus) {
                System.out.println(map212.get(customer));
//                break;
            }
        }


    }
}
