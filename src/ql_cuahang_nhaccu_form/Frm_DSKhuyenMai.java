
package ql_cuahang_nhaccu_form;

import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import ql_cuahang_nhaccu_class.DSNhaCungCap;
import ql_cuahang_nhaccu_class.DSNhanVien;
import ql_cuahang_nhaccu_class.DSKhuyenMai;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.NhaCungCap;
import ql_cuahang_nhaccu_class.NhanVien;
import ql_cuahang_nhaccu_class.PhieuNhap;
import swing.textfield.SearchOptinEvent;
import swing.textfield.SearchOption;
import ql_cuahang_nhaccu_class.CTPhieuNhap;
import ql_cuahang_nhaccu_class.KhuyenMai;


public class Frm_DSKhuyenMai extends javax.swing.JPanel {

    ArrayList<KhuyenMai> dskm_List;
    
    DSKhuyenMai dskm; 
    
    int vitri = 0;
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public Frm_DSKhuyenMai() {
        initComponents();
        setOpaque(false);
        //tblLoaiSP.fixTable(jScrollPane1);
        dskm = new DSKhuyenMai();
        
        dskm_List = dskm.layDSKhuyenMai("");
        btnXemCTKM.setEnabled(false);
        
        hienThiTable();
        init_txtSearch();
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSKM = new swing.table.Table();
        txtSearch = new swing.textfield.TextFieldSearchOption();
        btnXemCTKM = new swing.Button();

        setBackground(new java.awt.Color(189, 237, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblDSKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Ngày BĐ", "Ngày KT", "Phần trăm giảm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSKM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDSKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSKMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSKM);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnXemCTKM.setBackground(new java.awt.Color(123, 110, 255));
        btnXemCTKM.setForeground(new java.awt.Color(255, 255, 255));
        btnXemCTKM.setText("Xem chi tiết khuyến mãi");
        btnXemCTKM.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXemCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemCTKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXemCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

     private void init_txtSearch() {
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                // reset lại txt và table khi chọn mục tìm kiếm khác
                txtSearch.setText("");
                dskm_List = dskm.layDSKhuyenMai("");
                hienThiTable();
                txtSearch.setHint("Search by " + option.getName() + "...");
            }
        });
        txtSearch.addOption(new SearchOption("Name", new ImageIcon(getClass().getResource("/icon/user.png"))));
        txtSearch.setSelectedIndex(0);
    }
    
    private void hienThiTable() {
        String[] Header = {"Mã khuyến mãi", "Tên khuyến mãi", "Ngày BD", "Ngày KT", "Phần trăm giảm"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        
        for(KhuyenMai l: dskm_List) {
            Object[] o = {l.maKM, l.tenKM, l.ngayBD, l.ngayKT, l.phanTramGiam};
            model.addRow(o);
        } 
        tblDSKM.setModel(model);
        
        //ktra dong trong list sau khi tim kiem
        if (dskm_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dskm_List.size() - 1);
            tblDSKM.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
        }
    }
    
    static String makm, tenkm, ngayBD, ngayKT;
    static int phanTramGiam;
    
    private void layThongTinCTPN(int vitri) {
        KhuyenMai pn = dskm_List.get(vitri);
        dskm = new DSKhuyenMai();
        
        //lấy thông tin km trả về form km
        makm= pn.maKM;
        tenkm= pn.tenKM;
        ngayBD= pn.ngayBD;
        ngayKT= pn.ngayKT;
        phanTramGiam= pn.phanTramGiam;
        
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = dateFormat.format(pn.ngayNhap);
//        ngaynhap = formattedDate;
        
//        String currentDate = dateFormat.format(new Date());
//        ngaynhap= currentDate;
        
        
        
    }
    
     
    
     
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(txtSearch.isSelected()) {
            int opt = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText().trim() + "%";
            if(opt == 0) {
                dskm_List = dskm.layDSKhuyenMai("and MAKM like N'"+text+"' ");
            }
        }
        hienThiTable();         
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblDSKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSKMMouseClicked
        vitri = tblDSKM.getSelectedRow();
        btnXemCTKM.setEnabled(true);
        layThongTinCTPN(vitri);       
    }//GEN-LAST:event_tblDSKMMouseClicked

    private void btnXemCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemCTKMActionPerformed
        Window window = SwingUtilities.getWindowAncestor(this); // lấy cửa sổ hiện tại
        window.dispose(); // tắt form
    }//GEN-LAST:event_btnXemCTKMActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnXemCTKM;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.table.Table tblDSKM;
    private swing.textfield.TextFieldSearchOption txtSearch;
    // End of variables declaration//GEN-END:variables
}
