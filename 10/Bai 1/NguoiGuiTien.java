package Mappppp;

public class NguoiGuiTien implements Comparable<NguoiGuiTien>{ //
    private String code;
    private String HoTen;
    private String DiaChi;
    private Integer Sdt;
    private String DoB;

    public NguoiGuiTien() {
    }

    public NguoiGuiTien(String code, String hoTen, String diaChi, Integer sdt, String doB) {
        this.code = code;
        HoTen = hoTen;
        DiaChi = diaChi;
        Sdt = sdt;
        DoB = doB;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public Integer getSdt() {
        return Sdt;
    }

    public void setSdt(Integer sdt) {
        Sdt = sdt;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String toString() {
        return  code + "," + HoTen + ", " + DiaChi + ", " + Sdt + ", " + DoB;
    }
    public int compareTo(NguoiGuiTien other) {
        return code.compareTo(other.code);
    }
}
