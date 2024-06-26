
package ql_cuahang_nhaccu_form;

import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import ql_cuahang_nhaccu_class.DSSanPham;
import ql_cuahang_nhaccu_class.SanPham;


public class Frm_DSSanPham extends javax.swing.JPanel {

    DSSanPham dssp;
    ArrayList<SanPham> dssp_List;
    
    //DSNhaCungCap dsncc; 
    
    int vitri = 0;
    
    //KHỞI TẠO BIẾN STATIC ĐỂ FORM PHIẾU NHẬP NHẬN THÔNG TIN TRẢ VỀ KHI ĐÓNG FORM
    private JFrame parentFrame;

   String[] Header = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng tồn", "Giá nhập"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
    
    
    public Frm_DSSanPham() {
        initComponents();
        setOpaque(false);
        //tblLoaiSP.fixTable(jScrollPane1);
        
        
        dssp = new DSSanPham();
        dssp_List = dssp.layDSSanPham("and MANCC= '"+Frm_PhieuNhap.maNCC_sent +"'"); //Lấy ds sp theo 1 nhà cung cấp
        
       
        //BAN ĐẦU
        btnChonSP.setEnabled(false);
        
        hienThiTable();
        init_txtSearch();
       
        if(Frm_PhieuNhap.maNCC_sent== "")
        {
            btnThemSP.setEnabled(false);
            btnChonSP.setEnabled(false);
        }
    }
   
     //KHỞI TẠO BIẾN ĐỂ GỬI MÃ NCC CHO FORM SẢN PHẨM TIẾP
    public static String maNCC_sent2= Frm_PhieuNhap.maNCC_sent;
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSSP = new swing.table.Table();
        txtSearch = new swing.textfield.TextFieldSearchOption();
        btnChonSP = new swing.Button();
        btnThemSP = new swing.Button();

        setBackground(new java.awt.Color(189, 237, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng tồn", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblDSSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSSP);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnChonSP.setBackground(new java.awt.Color(123, 110, 255));
        btnChonSP.setForeground(new java.awt.Color(255, 255, 255));
        btnChonSP.setText("Chọn sản phẩm");
        btnChonSP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnChonSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSPActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 355, Short.MAX_VALUE)
                        .addComponent(btnChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnThemSP.setBackground(new java.awt.Color(123, 110, 255));
        btnThemSP.setForeground(new java.awt.Color(255, 255, 255));
        btnThemSP.setText("Thêm sản phẩm mới");
        btnThemSP.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    //HIỂN THỊ DS SẢN PHẨM THUỘC NHÀ CUNG CẤP DỰA THEO MÃ NHÀ CUNG CẤP ĐƯỢC TRUYỀN TỪ FORM PHIẾU NHẬP
    private void hienThiTable() {
        
        
        String[] Header = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng tồn", "Giá nhập"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
    
        for(SanPham l: dssp_List) { //Hiển thị ds sp theo 1 nhà cung cấp (dssp_List)
            Object[] o = {l.maSP, l.tenSP, l.soLuong, l.giaNhap};
            model.addRow(o);
        } 
        
        tblDSSP.setModel(model);
        
        //ktra dong trong list sau khi tim kiem
        if (dssp_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dssp_List.size() - 1);
            tblDSSP.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
        }
    }
    
    public static String masp= "", tensp= "", hinhanh= "";
    public static int gianhap=0;
    
    //LẤY THÔNG TIN SẢN PHẨM TRẢ VỀ BẢNG PHIẾU NHẬP
    private void layThongTinSanPham(int vitri) {
        dssp_List = dssp.layDSSanPham("and MANCC= '"+Frm_PhieuNhap.maNCC_sent +"'");
        SanPham sp = dssp_List.get(vitri);
        dssp = new DSSanPham();
        
        masp = sp.maSP;
        tensp = sp.tenSP;
        gianhap= sp.giaNhap;
        hinhanh= sp.hinhAnh;
    }
    
    private void tblDSSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSPMouseClicked
        vitri = tblDSSP.getSelectedRow();
        btnChonSP.setEnabled(true);
        layThongTinSanPham(vitri);       
    }//GEN-LAST:event_tblDSSPMouseClicked

    private void btnChonSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSPActionPerformed
        Window window = SwingUtilities.getWindowAncestor(this); // lấy cửa sổ hiện tại
        window.dispose(); // tắt form
    }//GEN-LAST:event_btnChonSPActionPerformed

    private void init_txtSearch() {
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                // reset lại txt và table khi chọn mục tìm kiếm khác
                txtSearch.setText("");
                dssp_List = dssp.layDSSanPham("and MANCC= '"+Frm_PhieuNhap.maNCC_sent +"'");
                hienThiTable();
                txtSearch.setHint("Search by " + option.getName() + "...");
            }
        });
        txtSearch.addOption(new SearchOption("Name", new ImageIcon(getClass().getResource("/icon/user.png"))));
        txtSearch.setSelectedIndex(0);
    }
    
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(txtSearch.isSelected()) {
            int opt = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText().trim() + "%";
            if(opt == 0) {
                dssp_List = dssp.layDSSanPham("and MANCC= '"+Frm_PhieuNhap.maNCC_sent +"' and MASP like N'"+text+"' ");
            }
        }
        hienThiTable();    
    }//GEN-LAST:event_txtSearchKeyReleased

    
    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        JFrame panel = new JFrame();
        Frm_SanPham f = new Frm_SanPham(panel);
        panel.setSize(1280, 720);
        panel.getContentPane().add(f);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);

        
                    
        panel.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                
                //HIỂN THỊ LẠI DS SP CŨ
                for(SanPham l: dssp_List) { //Hiển thị ds sp theo 1 nhà cung cấp (dssp_List)
                    Object[] o = {l.maSP, l.tenSP, l.soLuong, l.giaNhap};
                    model.addRow(o);
                } 
                tblDSSP.setModel(model);
        
                //THÊM VÀO BẢNG SP MỚI THÊM
                if (Frm_SanPham.masp_new != null) {
                    //lấy masp, tensp, slton, dongia đưa vào table
                    //Thêm vào bảng model
                    Object[] o = {Frm_SanPham.masp_new, Frm_SanPham.tensp_new, Frm_SanPham.soluong_new, Frm_SanPham.gianhap_new};
                    model.addRow(o);
                    tblDSSP.setModel(model); 
                    
                }
            }
        });
    }//GEN-LAST:event_btnThemSPActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnChonSP;
    private swing.Button btnThemSP;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.table.Table tblDSSP;
    private swing.textfield.TextFieldSearchOption txtSearch;
    // End of variables declaration//GEN-END:variables
}
