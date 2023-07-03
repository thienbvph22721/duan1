package views;

import controller.ThongKeController;
import java.text.SimpleDateFormat;
import java.util.List;
import services.ThongKeService;

import services.impl.ThongKeServiceImpl;
import viewmodels.ThongKeView;

public class ThongKeJPanel extends javax.swing.JPanel {

    private ThongKeService thongKeService = new ThongKeServiceImpl();
    private SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");

    ThongKeController controller = new ThongKeController();

    public ThongKeJPanel() {
        initComponents();

        lblNBD.setVisible(false);
        lblNKT.setVisible(false);
        txtNBD.setVisible(false);
        txtNKT.setVisible(false);
        txtTimKiem.setVisible(false);
        lblTDT.setVisible(false);
        jLabel4.setVisible(false);
        controller.setDataToChart1(jpnView, 2022);
        String ngay = date.format(new java.util.Date());
        List<ThongKeView> listTC = thongKeService.getTongDonHang(ngay, ngay);
        for (ThongKeView tk : listTC) {
            lblTongDonHang.setText(String.valueOf(tk.getSoLuongDon()));
        }
        List<ThongKeView> listTKDTT = thongKeService.getTongDonHangByTrangThai(ngay, ngay, "Đã thanh toán");
        for (ThongKeView tk : listTKDTT) {
            lblTC.setText(String.valueOf(tk.getSoLuongDon()));
            lblTC1.setText(String.valueOf(tk.getSoLuongDon()));
        }
        List<ThongKeView> listTKDH = thongKeService.getTongDonHangByTrangThai(ngay, ngay, "Đã hủy");
        for (ThongKeView tk : listTKDH) {
            lblHuy.setText(String.valueOf(tk.getSoLuongDon()));
            lblHuy1.setText(String.valueOf(tk.getSoLuongDon()));
        }
        List<ThongKeView> listTKDTN = thongKeService.doanhThuNgay(ngay, ngay);
        for (ThongKeView tk : listTKDTN) {
            lblDoanhThuNgay.setText(String.valueOf(tk.getDoanhThu()) + "  VND");
        }

        date = new SimpleDateFormat("yyyy");
        String nam = date.format(new java.util.Date());
        date = new SimpleDateFormat("MM");
        String thang = date.format(new java.util.Date());
        List<ThongKeView> listTKDTTT = thongKeService.doanhThuThang(nam, thang);
        for (ThongKeView tk : listTKDTTT) {
            lblDoanhThuThang.setText(String.valueOf(tk.getDoanhThu()) + "  VND");
        }
        List<ThongKeView> listTDHT = thongKeService.getDonHangThang(nam, thang, "Đã thanh toán");
        for (ThongKeView tk : listTDHT) {
            lblTC2.setText(String.valueOf(tk.getSoLuongDon()));
        }
        List<ThongKeView> listTDHH = thongKeService.getDonHangThang(nam, thang, "Đã hủy");
        for (ThongKeView tk : listTDHH) {
            lblHuy2.setText(String.valueOf(tk.getSoLuongDon()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTongDonHang = new javax.swing.JLabel();
        lblTC = new javax.swing.JLabel();
        lblHuy = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblDoanhThuNgay = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblTC1 = new javax.swing.JLabel();
        lblHuy1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblDoanhThuThang = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblTC2 = new javax.swing.JLabel();
        lblHuy2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTDT = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();
        lblNBD = new javax.swing.JLabel();
        lblNKT = new javax.swing.JLabel();
        txtNBD = new com.toedter.calendar.JDateChooser();
        txtNKT = new com.toedter.calendar.JDateChooser();
        txtTimKiem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cboLTG = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tổng đơn hàng");

        jLabel9.setText("Đơn hàng:");

        jLabel10.setText("Thành công:");

        jLabel11.setText("Bị hủy:");

        lblTongDonHang.setText("0");

        lblTC.setText("0");

        lblHuy.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblTongDonHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblTC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblHuy))
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tổng doanh thu ngày");

        lblDoanhThuNgay.setText("0 VND");

        jLabel14.setText("Thành công: ");

        jLabel15.setText("Bị hủy: ");

        lblTC1.setText("0");

        lblHuy1.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDoanhThuNgay)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTC1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHuy1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lblDoanhThuNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblTC1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lblHuy1))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tổng doanh thu tháng");

        lblDoanhThuThang.setText("0 VND");

        jLabel18.setText("Thành công: ");

        jLabel19.setText("Bị hủy: ");

        lblTC2.setText("0");

        lblHuy2.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDoanhThuThang)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTC2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addContainerGap(72, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHuy2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblDoanhThuThang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblTC2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblHuy2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Năm:");

        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2021", "2020" }));
        cboNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNamActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Tổng doanh thu:");

        lblTDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTDT.setForeground(new java.awt.Color(255, 51, 51));
        lblTDT.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTDT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Doanh thu", jPanel5);

        lblNBD.setText("Ngày bắt đầu:");

        lblNKT.setText("Ngày kết thúc:");

        txtNBD.setDateFormatString("yyyyMMdd");

        txtNKT.setDateFormatString("yyyyMMdd");

        txtTimKiem.setBackground(new java.awt.Color(204, 204, 255));
        txtTimKiem.setText("Tìm kiếm");
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel2.setText("Loại thời gian:");

        cboLTG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hôm nay", "Theo ngày" }));
        cboLTG.setMaximumSize(new java.awt.Dimension(89, 22));
        cboLTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLTGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboLTG, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNBD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNBD, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNKT)
                        .addGap(18, 18, 18)
                        .addComponent(txtNKT, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel1, jPanel2, jPanel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNBD)
                        .addComponent(jLabel2)
                        .addComponent(cboLTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblNKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel2, jPanel3});

    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        SimpleDateFormat date1 = new SimpleDateFormat("yyyyMMdd");
        List<ThongKeView> listTC = thongKeService.getTongDonHang(date1.format(txtNBD.getDate()), date1.format(txtNKT.getDate()));
        for (ThongKeView tk : listTC) {
            lblTongDonHang.setText(String.valueOf(tk.getSoLuongDon()));
        }
        List<ThongKeView> listSearchHuy = thongKeService.getTongDonHangByTrangThai(date1.format(txtNBD.getDate()), date1.format(txtNKT.getDate()), "Đã hủy");
        for (ThongKeView thongKeView : listSearchHuy) {
            lblHuy.setText(String.valueOf(thongKeView.getSoLuongDon()));
            lblHuy1.setText(String.valueOf(thongKeView.getSoLuongDon()));
        }
        List<ThongKeView> listSearchThanhCong = thongKeService.getTongDonHangByTrangThai(date1.format(txtNBD.getDate()), date1.format(txtNKT.getDate()), "Đã thanh toán");
        for (ThongKeView thongKeView : listSearchThanhCong) {
            lblTC.setText(String.valueOf(thongKeView.getSoLuongDon()));
            lblTC1.setText(String.valueOf(thongKeView.getSoLuongDon()));
        }
        List<ThongKeView> listTKDTN = thongKeService.doanhThuNgay(date1.format(txtNBD.getDate()), date1.format(txtNKT.getDate()));
        for (ThongKeView tk : listTKDTN) {
            lblDoanhThuNgay.setText(String.valueOf(tk.getDoanhThu()) + "  VND");
        }
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cboNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNamActionPerformed
        controller.setDataToChart1(jpnView, Integer.parseInt(cboNam.getSelectedItem().toString()));
        List<ThongKeView> listTDT = thongKeService.doanhThuNam(cboNam.getSelectedItem().toString());
        
        for (ThongKeView tk : listTDT) {
            lblTDT.setText(String.valueOf(tk.getDoanhThu())+"  VND");
        }
        lblTDT.setVisible(true);
        jLabel4.setVisible(true);
    }//GEN-LAST:event_cboNamActionPerformed

    private void cboLTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLTGActionPerformed
        if (cboLTG.getSelectedItem().equals("Hôm nay")) {
            SimpleDateFormat date1 = new SimpleDateFormat("yyyyMMdd");
            String ngay = date1.format(new java.util.Date());
            List<ThongKeView> listTC = thongKeService.getTongDonHang(ngay, ngay);
            for (ThongKeView tk : listTC) {
                lblTongDonHang.setText(String.valueOf(tk.getSoLuongDon()));
            }
            List<ThongKeView> listTKDTT = thongKeService.getTongDonHangByTrangThai(ngay, ngay, "Đã thanh toán");
            for (ThongKeView tk : listTKDTT) {
                lblTC.setText(String.valueOf(tk.getSoLuongDon()));
                lblTC1.setText(String.valueOf(tk.getSoLuongDon()));
            }
            List<ThongKeView> listTKDH = thongKeService.getTongDonHangByTrangThai(ngay, ngay, "Đã hủy");
            for (ThongKeView tk : listTKDH) {
                lblHuy.setText(String.valueOf(tk.getSoLuongDon()));
                lblHuy1.setText(String.valueOf(tk.getSoLuongDon()));
            }
            List<ThongKeView> listTKDTN = thongKeService.doanhThuNgay(ngay, ngay);
            for (ThongKeView tk : listTKDTN) {
                lblDoanhThuNgay.setText(String.valueOf(tk.getDoanhThu()) + "  VND");
            }
        } else {
            lblNBD.setVisible(true);
            lblNKT.setVisible(true);
            txtNBD.setVisible(true);
            txtNKT.setVisible(true);
            txtTimKiem.setVisible(true);
        }
    }//GEN-LAST:event_cboLTGActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLTG;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpnView;
    private javax.swing.JLabel lblDoanhThuNgay;
    private javax.swing.JLabel lblDoanhThuThang;
    private javax.swing.JLabel lblHuy;
    private javax.swing.JLabel lblHuy1;
    private javax.swing.JLabel lblHuy2;
    private javax.swing.JLabel lblNBD;
    private javax.swing.JLabel lblNKT;
    private javax.swing.JLabel lblTC;
    private javax.swing.JLabel lblTC1;
    private javax.swing.JLabel lblTC2;
    private javax.swing.JLabel lblTDT;
    private javax.swing.JLabel lblTongDonHang;
    private com.toedter.calendar.JDateChooser txtNBD;
    private com.toedter.calendar.JDateChooser txtNKT;
    private javax.swing.JButton txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
