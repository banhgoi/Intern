package TH9.Mappppp;


import TH9.Mappppp.NguoiGuiTien;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMaptest {

    public static void main(String[] arrgs) {
        Map<NguoiGuiTien, Double> acc = new TreeMap<>();
        acc.put(new NguoiGuiTien("A06338", "Phuong", "HN", 147258, "1999"), 150.0);
        acc.put(new NguoiGuiTien("A05726-1", "Nam", "HP", 237524, "1973"), 10.0);
        acc.put(new NguoiGuiTien("A05379", "Thanh", "BN", 544362, "1942"), 20.7);
        acc.put(new NguoiGuiTien("A05726-2", "Hoa", "QN", 26654, "1374"), 44.8);
        acc.put(new NguoiGuiTien("A05726-7", "Yen", "DN", 855632, "1734"), 15.3);

        Set<NguoiGuiTien> result = acc.keySet();
        Iterator<NguoiGuiTien> iter = result.iterator();
        NguoiGuiTien x = new NguoiGuiTien("A05379", "Thanh", "BN", 544362, "1942");
        boolean kt = acc.containsKey(x);//
        if (kt) {
            System.out.println("========Found key");
            acc.put(x, (acc.get(x) + 100));
          //  System.out.println(x+": "+acc.get(x)+"\n");
        } else {
            acc.put(x, 100.0);
        }

        System.out.println("\nAfter update========");
        while (iter.hasNext()) {
            NguoiGuiTien ntg = iter.next();
            System.out.println(ntg + ": " + acc.get(ntg));
        }
    }
}
