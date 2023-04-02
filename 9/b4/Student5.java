package Collections;

import java.io.Serializable;
import java.util.Comparator;


public class Student5 implements Serializable, Comparable<Student5> {// {//,  Comparator<Student5> ,Comparable<Student5>
    private String hoTen, queQuan;
    private int namSinh;
    private float diemTB;

    public Student5() {
    }

    public Student5(String hoTen, String queQuan, int namSinh, float diemTB) {
        this.hoTen = hoTen;
        this.queQuan = queQuan;
        this.namSinh = namSinh;
        this.diemTB = diemTB;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Integer getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Integer namSinh) {
        this.namSinh = namSinh;
    }

    public Float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(Float diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "Student: " + this.getHoTen() + ", " + this.getQueQuan() + ", " + this.getNamSinh() + ", " + this.getDiemTB() + "\n";
    }


    @Override
    public int compareTo(Student5 o) {
        int c = this.getDiemTB().compareTo(o.getDiemTB());
        return c;
    }

}

