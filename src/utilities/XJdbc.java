package utilities;

import java.sql.*;

public class XJdbc {

    static String user = "sa";
    static String pass = "12345678";
    static String myURL = "jdbc:sqlserver://localhost:1433;databaseName=DuAnMau";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection c = DriverManager.getConnection(myURL, user, pass);
        PreparedStatement ps;
        ps = c.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);

        }
        return ps;
    }

    public static ResultSet Query(String sql, Object... args) throws SQLException {
        PreparedStatement ps = XJdbc.getStmt(sql, args);
        return ps.executeQuery();
    }

    public static int Update(String sql, Object... args) throws SQLException {
        try {
            PreparedStatement ps = XJdbc.getStmt(sql, args);
            try {
                return ps.executeUpdate();
            } finally {
                ps.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}


















//    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {                                        
//        if (validateFrom()) {
//            int choose = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm sản phảm không?", "Thông báo", JOptionPane.YES_NO_OPTION);
//            if (choose == JOptionPane.YES_OPTION) {
//                String mess = ctspSPService.insert(getFrom());
//                JOptionPane.showMessageDialog(this, mess);
//                listCTSP = ctspSPService.selectAll();
//                fillTable(listCTSP);
//                clearFrom();
//            }
//
//        }
//
//    }                                       
//                                          
//
//    private void tblChiTietSPMouseClicked(java.awt.event.MouseEvent evt) {                                          
//        if (evt.getClickCount() == 2) {
//            row = tblChiTietSP.getSelectedRow();
//            ChiTietSPViewModel ctsp = listCTSP.get(row);
//            txtId.setText(ctsp.getId());
//            cboSP.setSelectedItem(ctsp.getTenSanPham());
//            cboNXB.setSelectedItem(ctsp.getTenNSX());
//            cboMauSac.setSelectedItem(ctsp.getTenMauSac());
//            cboDongSP.setSelectedItem(ctsp.getTenDongSP());
//            txtNam.setText(String.valueOf(ctsp.getNamBH()));
//            txtMoTa.setText(ctsp.getMoTa());
//            txtSLTon.setText(String.valueOf(ctsp.getSoLuongTon()));
//            txtGiaNhap.setText(String.valueOf(ctsp.getGiaNhap()));
//            txtGiaBan.setText(String.valueOf(ctsp.getGiaBan()));
//            tabs.setSelectedIndex(0);
//            this.updateStatus();
//        }
//    }                                         
//

//    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {                                       
//        if (validateFrom()) {
//            int choose = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa sản phảm không?", "Thông báo", JOptionPane.YES_NO_OPTION);
//            if (choose == JOptionPane.YES_OPTION) {
//                String mess = ctspSPService.update(txtId.getText(), getFrom());
//                JOptionPane.showMessageDialog(this, mess);
//                listCTSP = ctspSPService.selectAll();
//                fillTable(listCTSP);
//                clearFrom();
//            }
//        }
//    }                                      
//
//    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {                                       
//        int choose = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa sản phảm không?", "Thông báo", JOptionPane.YES_NO_OPTION);
//        if (choose == JOptionPane.YES_OPTION) {
//            String mess = ctspSPService.delete(txtId.getText());
//            JOptionPane.showMessageDialog(this, mess);
//            listCTSP = ctspSPService.selectAll();
//            fillTable(listCTSP);
//            clearFrom();
//        }
//    }                                      
//

//    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {                                           
//        int nam = cboNam.getSelectedIndex();
//        listCTSP = ctspSPService.searchByNamBH(nam);
//        fillTable(listCTSP);
//    }                                          
//
//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ViewChiTietSP().setVisible(true);
//            }
//        });
//    }
//                 
//     int row = -1;
//    ChiTietSPService ctspSPService = new ChiTietSPServiceImpl();
//    SanPhamService sp = new SanPhamServiceImpl();
//    NSXService nsx = new NSXServiceImpl();
//    DongSPService dsp = new DongSPServiceImpl();
//    MauSacService ms = new MauSacServiceImpl();
//    List<ChiTietSPViewModel> listCTSP;
//    List<SanPham> listSP;
//    List<NSX> listNSX;
//    List<MauSac> listMS;
//    List<DongSP> listDSP;
//
//    private void init() {
//        setLocationRelativeTo(null);
//        this.row = -1;
//        listSP = sp.selectAll();
//        listNSX = nsx.selectAll();
//        listMS = ms.selectAll();
//        listDSP = dsp.selectAll();
//        listCTSP = ctspSPService.selectAll();
//        fillComboBoxNSX(listNSX);
//        fillComboBoxDSP(listDSP);
//        fillComboBoxMS(listMS);
//        fillComboBoxSP(listSP);
//        fillTable(listCTSP);
//        this.updateStatus();
//    }

//    private void fillComboBoxMS(List<MauSac> listMS) {
//        DefaultComboBoxModel boxModelMS = (DefaultComboBoxModel) cboMauSac.getModel();
//        for (MauSac ms : listMS) {
//            boxModelMS.addElement(ms.getTenMauSac());
//        }
//    }
//
//    private void fillComboBoxDSP(List<DongSP> listDSP) {
//        DefaultComboBoxModel boxModelDSP = (DefaultComboBoxModel) cboDongSP.getModel();
//        for (DongSP dongSP : listDSP) {
//            boxModelDSP.addElement(dongSP.getTenDongSP());
//        }
//    }
//
//    private void fillComboBoxNSX(List<NSX> listNSX) {
//        DefaultComboBoxModel boxModelNSX = (DefaultComboBoxModel) cboNXB.getModel();
//        for (NSX n : listNSX) {
//            boxModelNSX.addElement(n.getTenNSX());
//        }
//    }
//
//    private void fillComboBoxSP(List<SanPham> listSP) {
//        DefaultComboBoxModel boxModelSP = (DefaultComboBoxModel) cboSP.getModel();
//        for (SanPham sp : listSP) {
//            boxModelSP.addElement(sp.getTenSanPham());
//        }
//    }
//
//    private void fillTable(List<ChiTietSPViewModel> listCTSP) {
//        DefaultTableModel tableModel = (DefaultTableModel) tblChiTietSP.getModel();
//        tableModel.setRowCount(0);
//        for (ChiTietSPViewModel ct : listCTSP) {
//            tableModel.addRow(new Object[]{ct.getId(), ct.getTenSanPham(), ct.getTenNSX(),
//                ct.getTenMauSac(), ct.getTenDongSP(), ct.getNamBH(),
//                ct.getMoTa(), ct.getSoLuongTon(), ct.getGiaNhap(), ct.getGiaBan()});
//        }
//    }
//
//    private ChiTietSP getFrom() {
//        int idSanPham = cboSP.getSelectedIndex();
//        SanPham sp = listSP.get(idSanPham);
//        int idNSX = cboNXB.getSelectedIndex();
//        NSX nsx = listNSX.get(idNSX);
//        int idMauSac = cboMauSac.getSelectedIndex();
//        MauSac ms = listMS.get(idMauSac);
//        int idDongSP = cboDongSP.getSelectedIndex();
//        DongSP dsp = listDSP.get(idDongSP);
//        int NamBH = Integer.parseInt(txtNam.getText());
//        String moTa = txtMoTa.getText();
//        int soLuongTon = Integer.parseInt(txtSLTon.getText());
//        double giaNhap = Double.parseDouble(txtGiaBan.getText());
//        double giaBan = Double.parseDouble(txtGiaNhap.getText());
//        return new ChiTietSP(null, sp.getIdSanPham(), nsx.getIdNSX(), ms.getIdMauSac(), dsp.getIdDongSP(), NamBH, moTa, soLuongTon, giaNhap, giaBan);
//    }
//
//    public void clearFrom() {
//        txtGiaBan.setText(null);
//        txtGiaNhap.setText(null);
//        txtId.setText(null);
//        txtMoTa.setText(null);
//        txtNam.setText(null);
//        txtSLTon.setText(null);
//        cboDongSP.setSelectedIndex(0);
//        cboMauSac.setSelectedIndex(0);
//        cboNXB.setSelectedIndex(0);
//        cboSP.setSelectedIndex(0);
//        this.row = -1;
//        this.updateStatus();
//    }
//
//    public void updateStatus() {
//        boolean edit = (this.row >= 0);
//        btnThem.setEnabled(!edit);
//        btnSua.setEnabled(edit);
//        btnXoa.setEnabled(edit);
//    }
//
//    private boolean validateFrom() {
//        if (txtNam.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Năm bảo hành không được để trống!");
//            txtNam.requestFocus();
//            return false;
//        }
//        if (txtMoTa.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Mô tả không được để trống!");
//            txtMoTa.requestFocus();
//            return false;
//        }
//        if (txtSLTon.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Sô lượng không được để trống!");
//            txtSLTon.requestFocus();
//            return false;
//        }
//        if (txtGiaNhap.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Giá nhập không được để trống!");
//            txtGiaNhap.requestFocus();
//            return false;
//        }
//        if (txtGiaBan.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Giá bán không được để trống!");
//            txtGiaBan.requestFocus();
//            return false;
//        }
//        return true;
//    }
//
//}

