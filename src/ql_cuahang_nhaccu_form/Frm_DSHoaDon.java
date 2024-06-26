
package ql_cuahang_nhaccu_form;

import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import ql_cuahang_nhaccu_class.CTHoaDon;
import ql_cuahang_nhaccu_class.DSHoaDon;
import ql_cuahang_nhaccu_class.DSKhachHang;
import ql_cuahang_nhaccu_class.DSNhanVien;
import ql_cuahang_nhaccu_class.HoaDon;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.KhachHang;
import ql_cuahang_nhaccu_class.NhanVien;
import swing.textfield.SearchOptinEvent;
import swing.textfield.SearchOption;


public class Frm_DSHoaDon extends javax.swing.JPanel {
    DSHoaDon dslsp;
    ArrayList<HoaDon> dslsp_List;
    
    DSKhachHang dskh;
    
    int vitri = 0;
    
    public Frm_DSHoaDon() {
        initComponents();
        setOpaque(false);
        tblDSHD.fixTable(jScrollPane1);
        dslsp = new DSHoaDon();
        dslsp_List = dslsp.layDSHoaDon("");
        btnXemCTHD.setEnabled(false);
        
        hienThiTable();
        init_txtSearch();
    }
    
    private void init_txtSearch() {
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                // reset lại txt và table khi chọn mục tìm kiếm khác
                txtSearch.setText("");
                dslsp_List = dslsp.layDSHoaDon("");
                hienThiTable();
                txtSearch.setHint("Search by " + option.getName() + "...");
            }
        });
        txtSearch.addOption(new SearchOption("Name", new ImageIcon(getClass().getResource("/icon/user.png"))));
        txtSearch.setSelectedIndex(0);
    }
    
    private void hienThiTable() {
        String[] Header = {"Mã hóa đơn", "Tên nhân viên", "Tên khách hàng", "Ngày lập"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        // Định dạng ngày giờ
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        for(HoaDon l: dslsp_List) {
            String formattedDate = dateFormat.format(l.ngayLap);
            
            // lấy tên kh dựa trên mã kh của hd
            dskh = new DSKhachHang();
            KhachHang kh = dskh.layKhachHang(l.maKH);
            
            // lấy tên nv dựa trên mã nv của hd
            DSNhanVien dsnv = new DSNhanVien();
            NhanVien nv = dsnv.layNhanVienTheoMa(l.tenTKNV);
            
            Object[] o = {l.maHD, nv.tenNV, kh.tenKH, formattedDate};
            model.addRow(o);
        } 
        tblDSHD.setModel(model);
        //ktra dong trong list sau khi tim kiem
        if (dslsp_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dslsp_List.size() - 1);
            tblDSHD.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSHD = new swing.table.Table();
        txtSearch = new swing.textfield.TextFieldSearchOption();
        btnXemCTHD = new swing.Button();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Tên TKNV", "Ngày lập", "Trang thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSHD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSHD);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnXemCTHD.setBackground(new java.awt.Color(123, 110, 255));
        btnXemCTHD.setForeground(new java.awt.Color(255, 255, 255));
        btnXemCTHD.setText("Xem chi tiết hóa đơn");
        btnXemCTHD.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXemCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemCTHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    static String mahd, tentknv, sdtkh, tenkh = "";
    static String ngaylap;
    static int tong;
    
    private void layThongTinCTHD(int vitri) {
        HoaDon hd = dslsp_List.get(vitri);
        dskh = new DSKhachHang();
        KhachHang kh = dskh.layKhachHang(hd.maKH);
        
        DSNhanVien dsnv = new DSNhanVien();
        NhanVien nv = dsnv.layNhanVienTheoMa(hd.tenTKNV);
        
        mahd = hd.maHD;
        tong = hd.tongtien;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(hd.ngayLap);
        ngaylap = formattedDate;
        tentknv = nv.tenNV;
        sdtkh = kh.sDT;
        tenkh = kh.tenKH;
    }

    private void tblDSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSHDMouseClicked
        vitri = tblDSHD.getSelectedRow();
        btnXemCTHD.setEnabled(true);
        layThongTinCTHD(vitri);
    }//GEN-LAST:event_tblDSHDMouseClicked

    
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(txtSearch.isSelected()) {
            int opt = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText().trim() + "%";
            if(opt == 0) {
                dslsp_List = dslsp.layDSHoaDon("and MAHD like N'"+text+"' ");
            }
        }
        hienThiTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnXemCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemCTHDActionPerformed
        // TODO add your handling code here:
        Window window = SwingUtilities.getWindowAncestor(this); // lấy cửa sổ hiện tại
        window.dispose(); // tắt form
    }//GEN-LAST:event_btnXemCTHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnXemCTHD;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.table.Table tblDSHD;
    private swing.textfield.TextFieldSearchOption txtSearch;
    // End of variables declaration//GEN-END:variables
}
