package views;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ChatLieu;
import models.KichThuoc;
import models.LoaiSanPham;
import models.MauSac;
import models.SanPham;
import services.ChatLieuService;
import services.KichThuocService;
import services.LoaiSPService;
import services.MauSacService;
import services.SanPhamService;
import services.impl.ChatLieuServiceImpl;
import services.impl.KichThuocServiceImpl;
import services.impl.LoaiSPServiceImpl;
import services.impl.MauSacServiceImpl;
import services.impl.SanPhamServiceImpl;
import viewmodels.SanPhamViewModel;

public class SanPhamJPanel extends javax.swing.JPanel {
    
    DefaultTableModel tableModel = new DefaultTableModel();
    
    public SanPhamJPanel() {
        initComponents();
        init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboLoaiSP = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboChatLieu = new javax.swing.JComboBox<>();
        cboKichThuoc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnAn = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnDSDaAn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThuocTinh = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtMaTT = new javax.swing.JTextField();
        rdoLoaiSanPham = new javax.swing.JRadioButton();
        rdoMauSac = new javax.swing.JRadioButton();
        rdoKichThuoc = new javax.swing.JRadioButton();
        rdoChatLieu = new javax.swing.JRadioButton();
        btnThemTT = new javax.swing.JButton();
        btnSuaTT = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTenThuocTinh = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Loại sản phẩm", "Màu sắc", "Kích thước", "Chất liệu", "Đơn giá", "Số lượng"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel10.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý sản phẩm"));

        jLabel1.setText("Mã:");

        txtMa.setEditable(false);

        jLabel2.setText("Tên:");

        jLabel3.setText("Đơn giá:");

        jLabel4.setText("Số lượng:");

        jLabel5.setText("Loại sản phẩm:");

        jLabel6.setText("Màu sắc:");

        cboMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMauSacActionPerformed(evt);
            }
        });

        jLabel7.setText("Chất liệu:");

        jLabel8.setText("Kích thước:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)
                        .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cboKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnThem.setBackground(new java.awt.Color(204, 204, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(204, 204, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/updated.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnAn.setBackground(new java.awt.Color(204, 204, 255));
        btnAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnAn.setText("Ẩn");
        btnAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnActionPerformed(evt);
            }
        });

        btnMoi.setBackground(new java.awt.Color(204, 204, 255));
        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clean.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnDSDaAn.setBackground(new java.awt.Color(255, 204, 204));
        btnDSDaAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hidden.png"))); // NOI18N
        btnDSDaAn.setText("Danh sách sản phẩm đã ẩn");
        btnDSDaAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDSDaAnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDSDaAn))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAn, btnMoi, btnSua, btnThem});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnAn)
                        .addComponent(btnMoi)
                        .addComponent(btnDSDaAn)))
                .addGap(12, 12, 12))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAn, btnMoi, btnSua, btnThem});

        jTabbedPane1.addTab("Thông tin sản phẩm", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách thuộc tính"));

        tblThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Loại thuộc tính", "Tên thuộc tính"
            }
        ));
        tblThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblThuocTinh);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý thuộc tính"));

        jLabel9.setText("Mã thuộc tính:");

        txtMaTT.setEditable(false);

        buttonGroup1.add(rdoLoaiSanPham);
        rdoLoaiSanPham.setText("Loại sản phẩm");
        rdoLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoLoaiSanPhamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoMauSac);
        rdoMauSac.setText("Màu sắc");
        rdoMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMauSacActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoKichThuoc);
        rdoKichThuoc.setText("Kích thước");
        rdoKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKichThuocActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChatLieu);
        rdoChatLieu.setText("Chất liệu");
        rdoChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoChatLieuActionPerformed(evt);
            }
        });

        btnThemTT.setBackground(new java.awt.Color(204, 204, 255));
        btnThemTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnThemTT.setText("Thêm");
        btnThemTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTTActionPerformed(evt);
            }
        });

        btnSuaTT.setBackground(new java.awt.Color(204, 204, 255));
        btnSuaTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/updated.png"))); // NOI18N
        btnSuaTT.setText("Sửa");
        btnSuaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTTActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 204, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel11.setText("Tên thuộc tính:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnThemTT)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaTT)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaTT, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(txtTenThuocTinh))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoLoaiSanPham)
                    .addComponent(rdoMauSac))
                .addGap(42, 42, 42)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoKichThuoc)
                    .addComponent(rdoChatLieu))
                .addGap(57, 57, 57))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSuaTT, btnThemTT, btnXoa});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(rdoLoaiSanPham)
                            .addComponent(rdoKichThuoc)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoMauSac)
                            .addComponent(rdoChatLieu)
                            .addComponent(jLabel11)
                            .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnSuaTT)
                            .addComponent(btnThemTT))
                        .addGap(20, 20, 20))))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSuaTT, btnThemTT, btnXoa});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thông tin thuộc tính", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMauSacActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        clearSP();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnActionPerformed
        
        JOptionPane.showMessageDialog(this, sanPhamService.hide(1, txtMa.getText()));
        listSPVM = sanPhamService.getList(0);
        fillTableSanPham(listSPVM);
    }//GEN-LAST:event_btnAnActionPerformed

    private void btnSuaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTTActionPerformed
        if (rdoKichThuoc.isSelected()) {
            KichThuoc kt = new KichThuoc();
            kt.setTenKichThuoc(txtTenThuocTinh.getText());
            JOptionPane.showMessageDialog(this, kichThuocService.update(txtMaTT.getText(), kt));
            clearTT();
            listKT = kichThuocService.getList();
            fillTableKichThuoc(listKT);
            fillComboBoxKT(listKT);
        } else if (rdoLoaiSanPham.isSelected()) {
            LoaiSanPham lsp = new LoaiSanPham();
            lsp.setTenLoaiSP(txtTenThuocTinh.getText());
            JOptionPane.showMessageDialog(this, loaiSPService.update(txtMaTT.getText(), lsp));
            clearTT();
            listLSP = loaiSPService.getList();
            fillTableLoaiSanPham(listLSP);
            fillComboBoxLSP(listLSP);
        } else if (rdoChatLieu.isSelected()) {
            ChatLieu cl = new ChatLieu();
            cl.setTenChatLieu(txtTenThuocTinh.getText());
            JOptionPane.showMessageDialog(this, chatLieuService.update(txtMaTT.getText(), cl));
            clearTT();
            listCL = chatLieuService.getList();
            fillTableChatLieu(listCL);
            fillComboBoxCL(listCL);
        } else if (rdoMauSac.isSelected()) {
            MauSac ms = new MauSac();
            ms.setTenMauSac(txtTenThuocTinh.getText());
            JOptionPane.showMessageDialog(this, mauSacService.update(txtMaTT.getText(), ms));
            clearTT();
            listMS = mauSacService.getList();
            fillTableMauSac(listMS);
            fillComboBoxMS(listMS);
        }
    }//GEN-LAST:event_btnSuaTTActionPerformed

    private void btnDSDaAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDSDaAnActionPerformed
        new AnSanPhamJFrame().setVisible(true);

    }//GEN-LAST:event_btnDSDaAnActionPerformed

    private void rdoLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLoaiSanPhamActionPerformed
        
        fillTableLoaiSanPham(listLSP);
        clearTT();
    }//GEN-LAST:event_rdoLoaiSanPhamActionPerformed

    private void rdoMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMauSacActionPerformed
        fillTableMauSac(listMS);
        clearTT();
    }//GEN-LAST:event_rdoMauSacActionPerformed

    private void rdoChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoChatLieuActionPerformed
        fillTableChatLieu(listCL);
        clearTT();
    }//GEN-LAST:event_rdoChatLieuActionPerformed

    private void rdoKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKichThuocActionPerformed
        fillTableKichThuoc(listKT);
        clearTT();
    }//GEN-LAST:event_rdoKichThuocActionPerformed

    private void btnThemTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTTActionPerformed
        
        if (rdoKichThuoc.isSelected()) {
            KichThuoc kt = new KichThuoc();
            kt.setTenKichThuoc(txtTenThuocTinh.getText());
            JOptionPane.showMessageDialog(this, kichThuocService.add(kt));
            clearTT();
            listKT = kichThuocService.getList();
            fillTableKichThuoc(listKT);
            fillComboBoxKT(listKT);
        } else if (rdoLoaiSanPham.isSelected()) {
            LoaiSanPham lsp = new LoaiSanPham();
            lsp.setTenLoaiSP(txtTenThuocTinh.getText());
            JOptionPane.showMessageDialog(this, loaiSPService.add(lsp));
            clearTT();
            listLSP = loaiSPService.getList();
            fillTableLoaiSanPham(listLSP);
            fillComboBoxLSP(listLSP);
        } else if (rdoChatLieu.isSelected()) {
            ChatLieu cl = new ChatLieu();
            cl.setTenChatLieu(txtTenThuocTinh.getText());
            JOptionPane.showMessageDialog(this, chatLieuService.add(cl));
            clearTT();
            listCL = chatLieuService.getList();
            fillTableChatLieu(listCL);
            fillComboBoxCL(listCL);
        } else if (rdoMauSac.isSelected()) {
            MauSac ms = new MauSac();
            ms.setTenMauSac(txtTenThuocTinh.getText());
            JOptionPane.showMessageDialog(this, mauSacService.add(ms));
            clearTT();
            listMS = mauSacService.getList();
            fillTableMauSac(listMS);
            fillComboBoxMS(listMS);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại thuộc tính!");
        }
        

    }//GEN-LAST:event_btnThemTTActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        
        if (rdoKichThuoc.isSelected()) {
            JOptionPane.showMessageDialog(this, kichThuocService.delete(txtMaTT.getText()));
            clearTT();
            listKT = kichThuocService.getList();
            fillTableKichThuoc(listKT);
            fillComboBoxKT(listKT);
        } else if (rdoLoaiSanPham.isSelected()) {
            JOptionPane.showMessageDialog(this, loaiSPService.delete(txtMaTT.getText()));
            clearTT();
            listLSP = loaiSPService.getList();
            fillTableLoaiSanPham(listLSP);
            fillComboBoxLSP(listLSP);
        } else if (rdoChatLieu.isSelected()) {
            JOptionPane.showMessageDialog(this, chatLieuService.delete(txtMaTT.getText()));
            clearTT();
            listCL = chatLieuService.getList();
            fillTableChatLieu(listCL);
            fillComboBoxCL(listCL);
        } else if (rdoMauSac.isSelected()) {
            JOptionPane.showMessageDialog(this, mauSacService.delete(txtMaTT.getText()));
            clearTT();
            listMS = mauSacService.getList();
            fillTableMauSac(listMS);
            fillComboBoxMS(listMS);
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        index = tblSanPham.getSelectedRow();
        SanPhamViewModel spvm = listSPVM.get(index);
        txtMa.setText(String.valueOf(spvm.getMaSanPham()));
        txtTen.setText(spvm.getTenSanPham());
        cboLoaiSP.setSelectedItem(spvm.getTenLoaiSP());
        cboMauSac.setSelectedItem(spvm.getTenMauSac());
        cboKichThuoc.setSelectedItem(spvm.getTenKichThuoc());
        cboChatLieu.setSelectedItem(spvm.getTenChatLieu());
        txtSoLuong.setText(String.valueOf(spvm.getSoLuong()));
        txtDonGia.setText(String.valueOf(spvm.getGiaBan()));
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhMouseClicked
        
        index = tblThuocTinh.getSelectedRow();
        if (rdoKichThuoc.isSelected()) {
            KichThuoc kt = listKT.get(index);
            txtMaTT.setText(kt.getMaKichThuoc());
            txtTenThuocTinh.setText(kt.getTenKichThuoc());
            
        } else if (rdoLoaiSanPham.isSelected()) {
            LoaiSanPham lsp = listLSP.get(index);
            txtMaTT.setText(lsp.getMaLoaiSP());
            txtTenThuocTinh.setText(lsp.getTenLoaiSP());
            
        } else if (rdoChatLieu.isSelected()) {
            ChatLieu cl = listCL.get(index);
            txtMaTT.setText(cl.getMaChatLieu());
            txtTenThuocTinh.setText(cl.getTenChatLieu());
            
        } else if (rdoMauSac.isSelected()) {
            MauSac ms = listMS.get(index);
            txtMaTT.setText(ms.getMaMauSac());
            txtTenThuocTinh.setText(ms.getTenMauSac());
            
        }

    }//GEN-LAST:event_tblThuocTinhMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        JOptionPane.showMessageDialog(this, sanPhamService.add(getFrom()));
        listSPVM = sanPhamService.getList(0);
        fillTableSanPham(listSPVM);
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        listSPVM = sanPhamService.getSearch(txtTimKiem.getText());
        fillTableSanPham(listSPVM);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        JOptionPane.showMessageDialog(this, sanPhamService.update(txtMa.getText(), getFrom()));
        listSPVM = sanPhamService.getList(0);
        fillTableSanPham(listSPVM);
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAn;
    private javax.swing.JButton btnDSDaAn;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaTT;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemTT;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboKichThuoc;
    private javax.swing.JComboBox<String> cboLoaiSP;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoChatLieu;
    private javax.swing.JRadioButton rdoKichThuoc;
    private javax.swing.JRadioButton rdoLoaiSanPham;
    private javax.swing.JRadioButton rdoMauSac;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblThuocTinh;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaTT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenThuocTinh;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
    private int index = -1;
    private final LoaiSPService loaiSPService = new LoaiSPServiceImpl();// Gọi hàm loại sản phẩm
    private List<LoaiSanPham> listLSP = loaiSPService.getList();//Gán list cho loại sản phẩm
    private final MauSacService mauSacService = new MauSacServiceImpl();
    private List<MauSac> listMS = mauSacService.getList();
    private final ChatLieuService chatLieuService = new ChatLieuServiceImpl();
    private List<ChatLieu> listCL = chatLieuService.getList();
    private final KichThuocService kichThuocService = new KichThuocServiceImpl();
    private List<KichThuoc> listKT = kichThuocService.getList();
    private final SanPhamService sanPhamService = new SanPhamServiceImpl();
    private List<SanPhamViewModel> listSPVM = sanPhamService.getList(0);
    
    private void init() {
        fillComboBoxCL(listCL);
        fillComboBoxKT(listKT);
        fillComboBoxMS(listMS);
        fillComboBoxLSP(listLSP);
        fillTableSanPham(listSPVM);
    }
    
    public void fillTableSanPham(List<SanPhamViewModel> listSPVM) {
        this.tableModel = (DefaultTableModel) tblSanPham.getModel();
        tableModel.setRowCount(0);
        int i = 0;
        for (SanPhamViewModel spvm : listSPVM) {
            i++;
            tableModel.addRow(new Object[]{i, spvm.getMaSanPham(), spvm.getTenSanPham(), spvm.getTenLoaiSP(), spvm.getTenMauSac(),
                spvm.getTenKichThuoc(), spvm.getTenChatLieu(), spvm.getSoLuong(), spvm.getGiaBan()});
        }
    }
    
    private SanPham getFrom() {
        String ten = txtTen.getText();
        int maLoaiSanPham = cboLoaiSP.getSelectedIndex();
        LoaiSanPham lsp = listLSP.get(maLoaiSanPham);
        int maMauSac = cboMauSac.getSelectedIndex();
        MauSac ms = listMS.get(maMauSac);
        int maKichThuoc = cboKichThuoc.getSelectedIndex();
        KichThuoc kt = listKT.get(maKichThuoc);
        int maChatLieu = cboChatLieu.getSelectedIndex();
        ChatLieu cl = listCL.get(maChatLieu);
        double giaBan = Double.parseDouble(txtDonGia.getText());
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        return new SanPham(0,null, ten, lsp.getMaLoaiSP(), ms.getMaMauSac(), kt.getMaKichThuoc(), cl.getMaChatLieu(), giaBan, soLuong, 0, null);
    }
    
    private void fillTableLoaiSanPham(List<LoaiSanPham> listLSP) {
        this.tableModel = (DefaultTableModel) tblThuocTinh.getModel();
        tableModel.setRowCount(0);
        int i = 0;
        for (LoaiSanPham lsp : listLSP) {
            i++;
            tableModel.addRow(new Object[]{i, "Loại sản phẩm", lsp.getTenLoaiSP()});
        }
    }
    
    private void fillTableMauSac(List<MauSac> listMS) {
        this.tableModel = (DefaultTableModel) tblThuocTinh.getModel();
        tableModel.setRowCount(0);
        int i = 0;
        for (MauSac mauSac : listMS) {
            i++;
            tableModel.addRow(new Object[]{i, "Màu sắc", mauSac.getTenMauSac()});
        }
    }
    
    private void fillTableChatLieu(List<ChatLieu> listCL) {
        this.tableModel = (DefaultTableModel) tblThuocTinh.getModel();
        tableModel.setRowCount(0);
        int i = 0;
        for (ChatLieu chatLieu : listCL) {
            i++;
            tableModel.addRow(new Object[]{i, "Chất Liệu", chatLieu.getTenChatLieu()});
        }
    }

    // hàm load dữ liệu kích thước lên bảng
    private void fillTableKichThuoc(List<KichThuoc> listKT) {
        this.tableModel = (DefaultTableModel) tblThuocTinh.getModel();
        tableModel.setRowCount(0);
        int i = 0;
        for (KichThuoc kichThuoc : listKT) {
            i++;
            tableModel.addRow(new Object[]{i, "Kích thước", kichThuoc.getTenKichThuoc()});
        }
    }
    
    private void clearTT() {
        txtMaTT.setText(null);
        txtTenThuocTinh.setText(null);
    }
    
    private void fillComboBoxMS(List<MauSac> listMS) {
        DefaultComboBoxModel boxModelMS = (DefaultComboBoxModel) cboMauSac.getModel();
        boxModelMS.removeAllElements();
        for (MauSac ms : listMS) {
            boxModelMS.addElement(ms.getTenMauSac());
        }
    }
    
    private void fillComboBoxCL(List<ChatLieu> listCL) {
        DefaultComboBoxModel boxModelCL = (DefaultComboBoxModel) cboChatLieu.getModel();
        boxModelCL.removeAllElements();
        for (ChatLieu chatLieu : listCL) {
            boxModelCL.addElement(chatLieu.getTenChatLieu());
        }
    }
    
    private void fillComboBoxLSP(List<LoaiSanPham> listLSP) {
        DefaultComboBoxModel boxModelLSP = (DefaultComboBoxModel) cboLoaiSP.getModel();
        boxModelLSP.removeAllElements();
        for (LoaiSanPham loaiSanPham : listLSP) {
            boxModelLSP.addElement(loaiSanPham.getTenLoaiSP());
        }
    }
    
    private void fillComboBoxKT(List<KichThuoc> listKT) {
        DefaultComboBoxModel boxModelKT = (DefaultComboBoxModel) cboKichThuoc.getModel();
        boxModelKT.removeAllElements();
        for (KichThuoc kichThuoc : listKT) {
            boxModelKT.addElement(kichThuoc.getTenKichThuoc());
        }
    }
    
    private void clearSP() {
        txtMa.setText(null);
        txtTen.setText(null);
        cboLoaiSP.setSelectedIndex(0);
        cboMauSac.setSelectedIndex(0);
        cboKichThuoc.setSelectedIndex(0);
        cboChatLieu.setSelectedIndex(0);
        txtSoLuong.setText("");
        txtDonGia.setText("");
    }
}
