package Collections;

import java.io.Serializable;
import java.util.Comparator;

public class Student4 implements Serializable, Comparable<Student4>,Comparator<Student4> {

    private String hoten;
    private String quequan;
    private int namsinh;
    private float diemTB;

    public Student4() {
    }

    public Student4(String hoTen, String queQuan, int namSinh, float diemTB) {
        this.hoten = hoTen;
        this.quequan = queQuan;
        this.namsinh = namSinh;
        this.diemTB = diemTB;
    }

    public String getHoTen() {
        return hoten;
    }

    public void setHoTen(String hoten) {
        this.hoten = hoten;
    }

    public String getQueQuan() {
        return quequan;
    }

    public void setQueQuan(String quequan) {
        this.quequan = quequan;
    }

    public int getNamSinh() {
        return namsinh;
    }

    public void setNamSinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "Student: " + this.getHoTen() + ", " + this.getQueQuan() + ", " + this.getNamSinh() + ", " + this.getDiemTB() + "\n";
    }


    @Override
    public int compareTo(Student4 o) {
        int compare;
        compare=this.getNamSinh()-(o.getNamSinh());
        if (compare==0){
            return  this.getHoTen().compareTo(o.getHoTen());
        }
        return compare;
    }

    @Override
    public int compare(Student4 o1, Student4 o2) {


        int compare2;
        if(this.getDiemTB()< o2.getDiemTB()==true) compare2= 1;
        else if(this.getDiemTB()> o2.getDiemTB()==false) compare2=-1;
        else{
            compare2=0;
        }
        return compare2;
    }


}

