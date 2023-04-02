package IOstream;

import java.io.Serializable;

public class HocSinh implements Serializable {
    private String hoten;
    private String quequan;
    private int namsinh;
    private float diemTB;

    public HocSinh() {
    }

    public HocSinh(String hoTen, String queQuan, int namSinh, float diemTB) {
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

    public String toString() {
        return "Student: " + this.getHoTen() + ", " + this.getQueQuan() + ", " + this.getNamSinh() + ", " + this.getDiemTB()+"\n";
    }

}
