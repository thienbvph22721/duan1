package views;

import models.HoaDon;
import models.SanPham;
import services.ChiTietHoaDonService;
import services.HoaDonService;
import services.KhachHangService;
import services.SanPhamService;
import services.impl.ChiTietHoaDonServiceImpl;
import services.impl.HoaDonServiceImpl;
import services.impl.KhachHangServiceImpl;
import services.impl.SanPhamServiceImpl;
import utilities.Auth;
import viewmodels.ChiTietHoaDonView;
import viewmodels.KhachHangView;
import viewmodels.SanPhamViewModel;

import javax.swing.text.Document;
import models.ChiTietHoaDon;
import viewmodels.HoaDonView;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;

public class BanHangJPanel extends javax.swing.JPanel implements Runnable, ThreadFactory {

    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public BanHangJPanel() {
        initComponents();
        init();
        initWebcam();
//        lblMaKH.setVisible(false);
//        lblMa.setVisible(false);
    }

    private void initWebcam() {
//        webcam.close();
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
//        webcam.open();
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        panelWC.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 140));

        executor.execute(this);
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void issueInvoice() {
//        row = tblHoaDon.getSelectedRow();
        if (tblHoaDon.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Mời Bạn Chọn Hóa Đơn Cần Xuất");
        } else {

            String parth = "";
            JFileChooser choose = new JFileChooser();
            choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int x = choose.showSaveDialog(this);
            if (x == JFileChooser.APPROVE_OPTION) {
                parth = choose.getSelectedFile().getPath();
            }

            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            int dongChonIDHD = tblHoaDon.getSelectedRow();
            HoaDonView hoaDonVM = hoaDonService.getList().get(dongChonIDHD);
            try {

                PdfWriter.getInstance(doc, new FileOutputStream(parth + "\\HoaDon " + hoaDonVM.getMaHoaDon() + ".pdf"));
                doc.open();

                PdfPTable tbl = new PdfPTable(9);
                //Create hearder
                doc.add(new Paragraph("                                    Hello, " + hoaDonVM.getTenKhachHang() + "!!! "
                        + "Cam on da den cua hang chung toi!"));
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" "));
                doc.add(new Paragraph(" Hoa don cua ban gom: "));
                doc.add(new Paragraph(" "));
                tbl.addCell("STT");
                tbl.addCell("Ma SP");
                tbl.addCell("Ten SP");
                tbl.addCell("So Luong");
                tbl.addCell("Don Gia");
                tbl.addCell("Thanh tien");

                //Create data
                for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                    String stt = tblGioHang.getValueAt(i, 0).toString();
                    String maSP = tblGioHang.getValueAt(i, 1).toString();
                    String tenSP = tblGioHang.getValueAt(i, 2).toString();
                    String SoLuong = tblGioHang.getValueAt(i, 3).toString();
                    String DonGia = tblGioHang.getValueAt(i, 4).toString();
                    String ThanhTien = tblGioHang.getValueAt(i, 5).toString();

                    //Add data
                    tbl.addCell(stt);
                    tbl.addCell(maSP);
                    tbl.addCell(tenSP);
                    tbl.addCell(SoLuong);
                    tbl.addCell(DonGia);
                    tbl.addCell(ThanhTien);

                }
                doc.add(tbl);
                doc.add(new Paragraph("                                                     Tong Tien Cua Hoa Don: " + lblTongTien.getText()));
                doc.add(new Paragraph("                                                     So Tien Can Tra: " + lblTienThua.getText()));
                doc.add(new Paragraph("                                                     Hen Gap Lai Ban!!!"));
                JOptionPane.showMessageDialog(this, "Xuất dữ liệu thành công!!!");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Không Tìm Thấy Đường Dẫn!!!");
            } catch (DocumentException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi Xuất Dữ Liệu");
            }
            openFile(parth + "\\HoaDon " + hoaDonVM.getMaHoaDon()+ ".pdf");
            doc.close();

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtTKKH = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();
        lblMa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTongTien = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblKhachCanTra = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboHTThanhToan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnThanhToan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnTHD = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        panelWC = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Loại SP", "Màu sắc", "Kích thước", "Chất liệu", "Số lượng ", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSanPham);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel16.setText("Tìm kiếm:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtTKKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTKKHKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loupe.png"))); // NOI18N

        jLabel3.setText("Ten KH:");

        lblTen.setForeground(new java.awt.Color(255, 102, 102));

        jLabel10.setText("SDT");

        lblSDT.setForeground(new java.awt.Color(255, 102, 102));

        lblMaKH.setForeground(new java.awt.Color(255, 102, 102));
        lblMaKH.setText("KH001");

        lblMa.setText("Mã KH");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTKKH))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(lblMa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTKKH)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTen, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel4.setText("Tổng tiền:");

        lblTongTien.setText("0");

        jLabel5.setText("Khách cần trả:");

        lblKhachCanTra.setText("0");

        jLabel6.setText("HT thanh toán:");

        cboHTThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Quẹt thẻ", "Chuyển khoản" }));

        jLabel7.setText("Tiền khách đưa:");

        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel8.setText("Tiền thừa:");

        lblTienThua.setText("0");

        btnThanhToan.setBackground(new java.awt.Color(204, 204, 255));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/money.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(204, 204, 255));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete_1.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnTHD.setBackground(new java.awt.Color(204, 204, 255));
        btnTHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bill_1.png"))); // NOI18N
        btnTHD.setText("Tạo HD");
        btnTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(lblKhachCanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboHTThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienKhachDua))
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(7, 7, 7)
                        .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuy, btnTHD});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblKhachCanTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboHTThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnHuy, btnTHD});

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Tên NV", "Tên KH", "Ngày tạo", "Trạng thái"
            }
        ));
        jScrollPane8.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng ", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane7.setViewportView(tblGioHang);

        btnXoa.setBackground(new java.awt.Color(204, 204, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnXoa)
                .addGap(0, 482, Short.MAX_VALUE))
            .addComponent(jScrollPane7)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa))
        );

        panelWC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelWC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(panelWC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelWC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked

        row = tblSanPham.getSelectedRow();

        String soLuong = JOptionPane.showInputDialog(this, "Mời nhập số lượng!!!");
        Pattern input = Pattern.compile("[1-9][0-9]*");
        if (soLuong == null) {
            return;
        } else {
            if (!input.matcher(soLuong).matches() || soLuong.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số");
            } else {
                SanPham sp = sanPhamService.getSanPhamByMa(tblSanPham.getValueAt(row, 1).toString());
                int data = Integer.parseInt(soLuong);
                int layGiaTri = (int) sp.getSoLuong();
                if (data > layGiaTri) {
                    JOptionPane.showMessageDialog(this, "Số lượng trong kho không đủ!");
                } else if (data <= 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng sản phẩm lớn hơn 0");
                } else {
                    sanPhamService.updateSLSP(tblSanPham.getValueAt(row, 1).toString(), Integer.parseInt(soLuong));
                    fillTabaleGH(sp, soLuong);
                    listSPVM = sanPhamService.getList(0);
                    fillTableSanPham(listSPVM);
                }
                lblTongTien.setText(String.valueOf(tinhTongTien()));
                lblKhachCanTra.setText(String.valueOf(tinhTongTien()));

            }

        }

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        listSPVM = sanPhamService.getSearch(txtSearch.getText());
        fillTableSanPham(listSPVM);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        DefaultTableModel tableModelGH = (DefaultTableModel) tblGioHang.getModel();
        row = tblGioHang.getSelectedRow();
        if (row >= 0) {
            sanPhamService.updateSLGH(tblGioHang.getValueAt(row, 1).toString(), Integer.parseInt(tblGioHang.getValueAt(row, 3).toString()));
            tableModelGH.removeRow(row);

            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                tblGioHang.setValueAt(i + 1, i, 0);
            }
        }
        listSPVM = sanPhamService.getList(0);
        fillTableSanPham(listSPVM);
        lblTongTien.setText(String.valueOf(tinhTongTien()));
        lblKhachCanTra.setText(String.valueOf(tinhTongTien()));


    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtTKKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTKKHKeyReleased
        listKH = khachHangService.getSearch(txtTKKH.getText(), txtTKKH.getText());
        for (KhachHangView kh : listKH) {
            lblTen.setText(kh.getTenKhachHang());
            lblMaKH.setText(kh.getMaKhachHang());
            lblSDT.setText(kh.getSoDienThoai());
        }
        if (txtTKKH.getText().equals("")) {
            lblTen.setText(null);
            lblMaKH.setText(null);
            lblSDT.setText(null);

        }
    }//GEN-LAST:event_txtTKKHKeyReleased

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        double tienthua = Double.parseDouble(txtTienKhachDua.getText()) - Double.parseDouble(lblTongTien.getText());
        lblTienThua.setText(String.valueOf(tienthua));
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

        row = tblHoaDon.getSelectedRow();
        if (Double.parseDouble(lblTienThua.getText()) < 0) {
            JOptionPane.showMessageDialog(this, "Tiền khách đưa chưa đủ ");
        } else {
            int chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thanh toán hóa đơn này?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (chon == 0) {
                HoaDon hd = new HoaDon();
                hd.setMaNhanVien(Auth.user.getMaNhanVien());
                hd.setMaKhachHang(lblMaKH.getText());
                hd.setNgayTao(new java.util.Date());
                hd.setTongTien(Double.parseDouble(lblTongTien.getText()));
                hd.sethTThanhToan(String.valueOf(cboHTThanhToan.getSelectedItem()));
                hd.setGhiChu("Not");
                hd.setTinhTrang("Đã thanh toán");
                this.hoaDonService.update(tblHoaDon.getValueAt(row, 1).toString(), hd);
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaHoaDon(tblHoaDon.getValueAt(row, 1).toString());
                for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                    cthd.setMaSanPham(tblGioHang.getValueAt(i, 1).toString());
                    cthd.setSoLuong(Integer.parseInt(tblGioHang.getValueAt(i, 3).toString()));
                    cthd.setDonGia(Double.parseDouble(tblGioHang.getValueAt(i, 4).toString()));
                    cthd.setThanhTien(Double.parseDouble(tblGioHang.getValueAt(i, 5).toString()));
                    chiTietHoaDonService.add(cthd);
                    int choose = JOptionPane.showConfirmDialog(this, "Bạn Có Muốn Xuất Hóa Đơn Không???", "Xác Nhập", JOptionPane.YES_NO_OPTION);
                    if (choose == JOptionPane.YES_OPTION) {
                        issueInvoice();
                    }
                }
                listSPVM = sanPhamService.getList(0);
                fillTableSanPham(listSPVM);
                JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
                clear();
                this.fillTableHD();
            }
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTHDActionPerformed
        int choose = JOptionPane.showConfirmDialog(this, "Bạn Có muốn tạo hóa đơn mới???", "Xác Nhập", JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            HoaDon hd = new HoaDon();
            hd.setMaNhanVien(Auth.user.getMaNhanVien());
            hd.setMaKhachHang("KH001");
            hd.setNgayTao(new java.util.Date());
            hd.setTinhTrang("Chưa thanh toán");
            hoaDonService.add(hd);
            fillTableHD();
        }

    }//GEN-LAST:event_btnTHDActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        row = tblHoaDon.getSelectedRow();
        String ghiChu = JOptionPane.showInputDialog(this, "Lý do hủy");
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn hủy hóa đơn này?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (chon == 0) {
            HoaDon hd = new HoaDon();
            hd.setMaNhanVien(Auth.user.getMaNhanVien());
            hd.setMaKhachHang(lblMaKH.getText());
            hd.setNgayTao(new java.util.Date());
            hd.setTongTien(Double.parseDouble(lblTongTien.getText()));
            hd.sethTThanhToan(String.valueOf(cboHTThanhToan.getSelectedItem()));
            hd.setGhiChu(ghiChu);
            hd.setTinhTrang("Đã hủy");
            this.hoaDonService.update(tblHoaDon.getValueAt(row, 1).toString(), hd);
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.setMaHoaDon(tblHoaDon.getValueAt(row, 1).toString());
            for (int i = 0; i < tblGioHang.getRowCount(); i++) {
                cthd.setMaSanPham(tblGioHang.getValueAt(i, 1).toString());
                cthd.setSoLuong(Integer.parseInt(tblGioHang.getValueAt(i, 3).toString()));
                cthd.setDonGia(Double.parseDouble(tblGioHang.getValueAt(i, 4).toString()));
                cthd.setThanhTien(Double.parseDouble(tblGioHang.getValueAt(i, 5).toString()));
                sanPhamService.updateSLGH(tblGioHang.getValueAt(i, 1).toString(), Integer.parseInt(tblGioHang.getValueAt(i, 3).toString()));
                chiTietHoaDonService.add(cthd);

            }
            listSPVM = sanPhamService.getList(0);
            fillTableSanPham(listSPVM);
            clear();
            this.fillTableHD();
            JOptionPane.showMessageDialog(this, "Đã hủy!");
        }

    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnTHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboHTThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblKhachCanTra;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel panelWC;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTKKH;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables
    private int row = -1;
    SanPhamService sanPhamService = new SanPhamServiceImpl();
    List<SanPhamViewModel> listSPVM = sanPhamService.getList(0);
    DefaultTableModel tableModel = new DefaultTableModel();
    ChiTietHoaDonService chiTietHoaDonService = new ChiTietHoaDonServiceImpl();
    List<ChiTietHoaDonView> listCTHDV;
    KhachHangService khachHangService = new KhachHangServiceImpl();
    List<KhachHangView> listKH;
    HoaDonService hoaDonService = new HoaDonServiceImpl();
    List<HoaDon> listHD;

    private void init() {
        this.fillTableSanPham(listSPVM);
        this.fillTableHD();
    }

    private void fillTableSanPham(List<SanPhamViewModel> listSPVM) {
        this.tableModel = (DefaultTableModel) tblSanPham.getModel();
        tableModel.setRowCount(0);
        int i = 0;
        for (SanPhamViewModel spvm : listSPVM) {
            i++;
            tableModel.addRow(new Object[]{i, spvm.getMaSanPham(), spvm.getTenSanPham(), spvm.getTenLoaiSP(), spvm.getTenMauSac(),
                spvm.getTenKichThuoc(), spvm.getTenChatLieu(), spvm.getSoLuong(), spvm.getGiaBan()});
        }
    }

    private void fillTableHD() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String ngay = format.format(new java.util.Date());
        List<HoaDonView> listHD = hoaDonService.getByTT(ngay, "Chưa thanh toán");
        this.tableModel = (DefaultTableModel) tblHoaDon.getModel();
//        model.setRowCount(0);
        int i = 1;
        for (HoaDonView item : listHD) {
            tableModel.addRow(new Object[]{i++, item.getMaHoaDon(), item.getTenNhanVien(), item.getTenKhachHang(), item.getNgayTao(), item.getTinhTrang()});
        }
    }
    DefaultTableModel tableModelGH;

    private void fillTabaleGH(SanPham sp, String soLuong) {
        tableModelGH = (DefaultTableModel) tblGioHang.getModel();
        Object obj[] = new Object[6];
        obj[0] = tableModelGH.getRowCount() + 1;
        obj[1] = sp.getMaSanPham();
        obj[2] = sp.getTenSanPham();
        obj[3] = soLuong;
        obj[4] = sp.getDonGia();
        obj[5] = Double.parseDouble(soLuong) * sp.getDonGia();
        tableModelGH.addRow(obj);

    }

    private double tinhTongTien() {
        double tongTien = 0;
        for (int i = 0; i < tblGioHang.getRowCount(); i++) {
            tongTien += Double.parseDouble(tblGioHang.getValueAt(i, 5).toString());
        }
        return tongTien;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BanHangJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
//                Logger.getLogger(JFormBanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (result != null) {

                String soLuong = JOptionPane.showInputDialog(this, "Mời nhập số lượng!!!");
                Pattern input = Pattern.compile("[1-9][0-9]*");
                if (soLuong == null) {
                    return;
                } else if (!input.matcher(soLuong).matches() || soLuong.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên");
                } else {
                    SanPham sp = sanPhamService.getSanPhamByMa(result.getText());
                    int data = Integer.parseInt(soLuong);
                    int layGiaTri = (int) sp.getSoLuong();
                    if (data > layGiaTri) {
                        JOptionPane.showMessageDialog(this, "Số lượng trong kho không đủ!");
                    } else if (data <= 0) {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng sản phẩm lớn hơn 0");
                    } else {
                        sanPhamService.updateSLSP(result.getText(), Integer.parseInt(soLuong));
                        fillTabaleGH(sp, soLuong);
                        listSPVM = sanPhamService.getList(0);
                        fillTableSanPham(listSPVM);
                    }
                    lblTongTien.setText(String.valueOf(tinhTongTien()));
                    lblKhachCanTra.setText(String.valueOf(tinhTongTien()));
                }

            }

        } while (true);
    }

    private void clear() {
        lblTienThua.setText("0");
        lblKhachCanTra.setText("0");
        lblTongTien.setText("0");
        lblTen.setText(null);
        lblMaKH.setText("KH001");
        txtTienKhachDua.setText(null);
        cboHTThanhToan.setSelectedIndex(0);
        tableModelGH.setRowCount(0);
       
    }
}
