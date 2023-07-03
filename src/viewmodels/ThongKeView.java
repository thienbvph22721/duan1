
package viewmodels;


public class ThongKeView {
    private String thang;
    private double doanhThu;
    private int soLuongDon;
    public ThongKeView() {
    }

    public ThongKeView(String thang, double doanhThu) {
        this.thang = thang;
        this.doanhThu = doanhThu;
    }

    public ThongKeView(int soLuongDon) {
        this.soLuongDon = soLuongDon;
    }
    
    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public int getSoLuongDon() {
        return soLuongDon;
    }

    public void setSoLuongDon(int soLuongDon) {
        this.soLuongDon = soLuongDon;
    }
    
}
