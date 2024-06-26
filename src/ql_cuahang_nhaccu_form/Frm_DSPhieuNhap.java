
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
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import ql_cuahang_nhaccu_class.DSNhaCungCap;
import ql_cuahang_nhaccu_class.DSNhanVien;
import ql_cuahang_nhaccu_class.DSPhieuNhap;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.NhaCungCap;
import ql_cuahang_nhaccu_class.NhanVien;
import ql_cuahang_nhaccu_class.PhieuNhap;
import swing.textfield.SearchOptinEvent;
import swing.textfield.SearchOption;
import ql_cuahang_nhaccu_class.CTPhieuNhap;


public class Frm_DSPhieuNhap extends javax.swing.JPanel {

    DSPhieuNhap dslsp;
    ArrayList<PhieuNhap> dslsp_List;
    
    DSNhaCungCap dsncc; 
    DSNhanVien dsnv;
    
    int vitri = 0;
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public Frm_DSPhieuNhap() {
        initComponents();
        setOpaque(false);
        //tblLoaiSP.fixTable(jScrollPane1);
        dslsp = new DSPhieuNhap();
        dsncc= new DSNhaCungCap();
        dsnv= new DSNhanVien();
        
        dslsp_List = dslsp.layDSPhieuNhap("");
        btnXemCTPhieuNhap.setEnabled(false);
        
        hienThiTable();
        init_txtSearch();
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSPhieuNhap = new swing.table.Table();
        txtSearch = new swing.textfield.TextFieldSearchOption();
        btnXemCTPhieuNhap = new swing.Button();

        setBackground(new java.awt.Color(189, 237, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách phiếu nhập hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblDSPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu nhập", "Nhà cung cấp", "Nhân viên", "Ngày nhập", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSPhieuNhap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDSPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSPhieuNhap);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnXemCTPhieuNhap.setBackground(new java.awt.Color(123, 110, 255));
        btnXemCTPhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnXemCTPhieuNhap.setText("Xem chi tiết phiếu nhập");
        btnXemCTPhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXemCTPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemCTPhieuNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXemCTPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemCTPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                dslsp_List = dslsp.layDSPhieuNhap("");
                hienThiTable();
                txtSearch.setHint("Search by " + option.getName() + "...");
            }
        });
        txtSearch.addOption(new SearchOption("Name", new ImageIcon(getClass().getResource("/icon/user.png"))));
        txtSearch.setSelectedIndex(0);
    }
    
    private void hienThiTable() {
        
        String[] Header = {"Mã phiếu nhập", "Nhà cung cấp", "Nhân viên", "Ngày nhập"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        for(PhieuNhap l: dslsp_List) {
            
            //Lấy tên nhà cung cấp
            NhaCungCap ncc = dsncc.layNhaCungCap(l.maNCC);
            //Lấy tên nhân viên
            NhanVien nv = dsnv.layNhanVien(l.maNV);
            
//            String currentDate = dateFormat.format(new Date());
//            txtNgayLap.setText(currentDate);
        
            Object[] o = {l.maPNH, ncc.tenNCC, nv.tenNV, l.ngayNhap};
            model.addRow(o);
        } 
        tblDSPhieuNhap.setModel(model);
        //ktra dong trong list sau khi tim kiem
        if (dslsp_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dslsp_List.size() - 1);
            tblDSPhieuNhap.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
        }
    }
    
    static String mapn, mancc, tennv, sdtncc, tenncc;
    static String ngaynhap;
    
    private void layThongTinCTPN(int vitri) {
        PhieuNhap pn = dslsp_List.get(vitri);
        dsncc = new DSNhaCungCap();
        
        //lấy thông tin phiếu nhập trả về form phiếu nhập
        mapn= pn.maPNH;
        
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = dateFormat.format(pn.ngayNhap);
//        ngaynhap = formattedDate;
        
        String currentDate = dateFormat.format(new Date());
        ngaynhap= currentDate;
        
        NhaCungCap kh = dsncc.layNhaCungCap(pn.maNCC);
        sdtncc = kh.sDT;
        tenncc = kh.tenNCC;
        
        NhanVien nv = dsnv.layNhanVien(pn.maNV);
        tennv = nv.tenNV;
        
        
        
    }
    
     
    
     
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(txtSearch.isSelected()) {
            int opt = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText().trim() + "%";
            if(opt == 0) {
                dslsp_List = dslsp.layDSPhieuNhap("and MAPNH like N'"+text+"' ");
            }
        }
        hienThiTable();         
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblDSPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSPhieuNhapMouseClicked
        vitri = tblDSPhieuNhap.getSelectedRow();
        btnXemCTPhieuNhap.setEnabled(true);
        layThongTinCTPN(vitri);       
    }//GEN-LAST:event_tblDSPhieuNhapMouseClicked

    private void btnXemCTPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemCTPhieuNhapActionPerformed
        Window window = SwingUtilities.getWindowAncestor(this); // lấy cửa sổ hiện tại
        window.dispose(); // tắt form
    }//GEN-LAST:event_btnXemCTPhieuNhapActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnXemCTPhieuNhap;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.table.Table tblDSPhieuNhap;
    private swing.textfield.TextFieldSearchOption txtSearch;
    // End of variables declaration//GEN-END:variables
}
