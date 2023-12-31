package Repositories;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Menu;
import views.BanHangJPanel;
import views.DoiMatKhauJPanel;
import views.HoaDonJPanel;
import views.KhachHangJPanel;
import views.KhuyenMaiJPanel;
import views.NhanVienJPanel;
import views.SanPhamJPanel;
import views.ThongKeJPanel;

public class ChuyenManHinhRepository {

    private String kindSelected;
    private JPanel jpnView;
    private List<Menu> listMenu = null;

    public ChuyenManHinhRepository(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public void setDashboard(JPanel jpnItem, JLabel lblItem) {
        kindSelected = "SanPham";
        jpnItem.setBackground(new Color(125, 229, 237));
        lblItem.setBackground(new Color(125, 229, 237));
        JPanel node = new SanPhamJPanel();
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(node);
        jpnView.validate();
        jpnView.repaint();

    }

//Hàm xử lý sự kiện khi nhấn vào Label bao gồm sự kiện nhấn chuột,
    // chuyển chuột vào và ra khỏi Label sẽ thay đổi màu nền của Panel.
    public void setEvent(List<Menu> listMenu) {
        this.listMenu = listMenu;
        for (Menu item : listMenu) {
            item.getJpn().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getLbl()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel lblItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel lblItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.lblItem = lblItem;
        }

        @Override //Được triệu hồi khi nút chuột đã được click (được nhấn và nhả ra) trên một thành phần
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "SanPham":
                    node = new SanPhamJPanel();
                    break;
                case "BanHang":
                    node = new BanHangJPanel();
                    break;
                case "HoaDon":
                    node = new HoaDonJPanel();
                    break;
                case "KhuyenMai":
                    node = new KhuyenMaiJPanel();
                    break;
                case "NhanVien":
                    node = new NhanVienJPanel();
                    break;
                case "KhachHang":
                    node = new KhachHangJPanel();
                    break;
                case "ThongKe":
                    node = new ThongKeJPanel();
                    break;
                case "DoiMatKhau":
                    node = new DoiMatKhauJPanel();
                    break;
                case "DangXuat":
//                    node = new DangNhapJPanel();
                    break;
                default:
                    node = new SanPhamJPanel();
                    break;
            }
            jpnView.removeAll();
            jpnView.setLayout(new BorderLayout());
            jpnView.add(node);
            jpnView.validate();
            jpnView.repaint();
            setChangeBackground(kind);
        }

        @Override  // Được triệu hồi khi một nút chuột đã được nhấn trên một thành phần.
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(125, 229, 237));
            lblItem.setBackground(new Color(125, 229, 237));
        }

        @Override  //Được triệu hồi khi một nút chuột đã được nhả ra trên một thành phần.
        public void mouseReleased(MouseEvent e) {
            jpnItem.setBackground(new Color(153, 204, 255));
            lblItem.setBackground(new Color(153, 204, 255));
        }

        @Override  //Được triệu hồi khi chuột nhập vào một thành phần.
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(125, 229, 237));
            lblItem.setBackground(new Color(125, 229, 237));
        }

        @Override  //Được triệu hồi khi chuột thoát ra khỏi một thành phần.
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(153, 204, 255));
                lblItem.setBackground(new Color(153, 204, 255));
            }
        }

        private void setChangeBackground(String kind) {
            for (Menu menu : listMenu) {
                if (menu.getKind().equalsIgnoreCase(kind)) {
                    jpnItem.setBackground(new Color(125, 229, 237));
                    lblItem.setBackground(new Color(125, 229, 237));
                } else {
                    jpnItem.setBackground(new Color(153, 204, 255));
                    lblItem.setBackground(new Color(153, 204, 255));
                }
            }
        }
    }
}
