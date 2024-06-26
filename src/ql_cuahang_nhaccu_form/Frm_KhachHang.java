
package ql_cuahang_nhaccu_form;

import dialog.Message;
import dialog.MessageQuestion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import main.Main;
import ql_cuahang_nhaccu_class.DSKhachHang;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.KhachHang;
import swing.icon.GoogleMaterialDesignIcons;
import swing.textfield.SearchOptinEvent;
import swing.textfield.SearchOption;

public class Frm_KhachHang extends javax.swing.JPanel {

    DSKhachHang dslkh;
    ArrayList<KhachHang> dslkh_List;
    int vitri = 0;
    
    public Frm_KhachHang() {
        initComponents();
//        setOpaque(false);
        tblKhachHang.fixTable(jScrollPane1);
        dslkh = new DSKhachHang();
        dslkh_List = dslkh.layDSKhachHang("");
//        hienThiTextBox();
        hienThiTable();
        init_txtSearch();
        anHienButton(true);
        anHienText(false);
        txtMaKH.setEnabled(false);
    }
    
    private JFrame parentFrame;
    public static String sdt_new = "";
    public static String tenKH_new = "";

    public Frm_KhachHang(JFrame parentFrame) {
        initComponents();
        tblKhachHang.fixTable(jScrollPane1);
        dslkh = new DSKhachHang();
        dslkh_List = dslkh.layDSKhachHang("");
        hienThiTable();
        init_txtSearch();
        anHienButton(true);
        anHienText(false);
        txtMaKH.setEnabled(false);
        this.parentFrame = parentFrame;
    }
    
    private void init_txtSearch() {
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                // reset lại txt và table khi chọn mục tìm kiếm khác
                txtSearch.setText("");
                dslkh_List = dslkh.layDSKhachHang("");
                hienThiTable();
                txtSearch.setHint("Search by " + option.getName() + "...");
            }
        });
        txtSearch.addOption(new SearchOption("Name", new ImageIcon(getClass().getResource("/icon/user.png"))));
        txtSearch.addOption(new SearchOption("Tel", new ImageIcon(getClass().getResource("/icon/tel.png"))));
        txtSearch.addOption(new SearchOption("Address", new ImageIcon(getClass().getResource("/icon/address.png"))));
        txtSearch.setSelectedIndex(0);
    }
    
    private void hienThiTextBox(int vitri) {
        KhachHang lsp = dslkh_List.get(vitri);
        txtMaKH.setText(lsp.maKH);
        txtTenKH.setText(lsp.tenKH);
        txtSDT.setText(lsp.sDT);
        txtDiaChi.setText(lsp.diaChi);
    }
    
    private void hienThiTable() {
        String[] Header = {"Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "SĐT"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        for(KhachHang l: dslkh_List) {
            Object[] o = {l.maKH, l.tenKH, l.diaChi, l.sDT};
            model.addRow(o);
        } 
        tblKhachHang.setModel(model);
//        tblKhachHang.setRowSelectionInterval(vitri, vitri);
        if (dslkh_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dslkh_List.size() - 1);
            tblKhachHang.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnLuu = new swing.Button();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new swing.table.Table();
        txtSearch = new swing.textfield.TextFieldSearchOption();
        btnSua = new swing.Button();
        btnXoa = new swing.Button();
        btnHuy = new swing.Button();
        btnThem = new swing.Button();
        lbThongBao = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mã khách hàng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Tên khách hàng:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("SĐT:");

        txtMaKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTenKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenKHKeyTyped(evt);
            }
        });

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSDTKeyTyped(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(123, 110, 255));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Thực thi");
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                            .addComponent(txtTenKH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                    .addComponent(txtSDT))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "SĐT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSua.setBackground(new java.awt.Color(123, 110, 255));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(123, 110, 255));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(123, 110, 255));
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(123, 110, 255));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        lbThongBao.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lbThongBao.setForeground(new java.awt.Color(255, 0, 51));
        lbThongBao.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lbThongBao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbThongBao, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    int flag = 0;
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        //Khi bấm hủy: Nút lưu khóa, các nút thêm xóa sửa hiện lên. 
        anHienButton(true);
        anHienText(false);
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        lbThongBao.setText("Hãy chọn 1 thao tác");
        flag = 0;
    }//GEN-LAST:event_btnHuyActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        vitri = tblKhachHang.getSelectedRow();
        hienThiTextBox(vitri);
        
        //Khi bấm sửa, textbox vẫn ko hiện, khi bấm chọn 1 dòng cần sửa thì textbox mới hiện lên cho sửa
        if (flag == 2)
        {
            anHienText(true);
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(txtSearch.isSelected()) {
            int opt = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText().trim() + "%";
            if(opt == 0) {
                dslkh_List = dslkh.layDSKhachHang("and TENKH like N'"+text+"' ");
            }else if(opt == 1) {
                dslkh_List = dslkh.layDSKhachHang("and SDT like '"+text+"' ");
            }else if(opt == 2) {
                dslkh_List = dslkh.layDSKhachHang("and DIACHI like N'"+text+"' ");
            }
        }
        hienThiTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSDTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyTyped
        char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự không phải là số (trừ nút xóa) hoặc độ dài vượt quá 11 ký tự
        if ((!Character.isDigit(c) && c != evt.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER) || txtSDT.getText().length() >= 11) {
           
            evt.consume(); // Hủy sự kiện nhập vào
            // Đặt biên đỏ cho trường văn bản
            //txtSDT.setBorder(BorderFactory.createLineBorder(Color.RED));
            Message.showMessageError("Số điện thoại không hợp lệ.");
            
        }
    }//GEN-LAST:event_txtSDTKeyTyped

    private void txtTenKHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKHKeyTyped
        char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự là chữ, hoặc space, hoặc nút xóa (ko chứa số, kí tự đặc biệt)  
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER && c != ' ') {
           
            evt.consume();
            // Hiển thị thông báo lỗi
            Message.showMessageError("Tên khách hàng chỉ được chứa chữ cái!");
            
        }
    }//GEN-LAST:event_txtTenKHKeyTyped

     private KhachHang chuyenDoiTextBoxSangDoiTuong()
    {
        KhachHang ncc = new KhachHang();
        ncc.maKH= txtMaKH.getText();
        ncc.tenKH= txtTenKH.getText();
        ncc.diaChi= txtDiaChi.getText();
        ncc.sDT= txtSDT.getText();
       
        return ncc;
    }
    
     private void anHienText(boolean t)
    {
        //txtMaNCC.setEnabled(t);
        txtTenKH.setEnabled(t);
        txtDiaChi.setEnabled(t);
        txtSDT.setEnabled(t);

    }
    
     private void anHienButton(boolean t)
    {
        btnLuu.setEnabled(!t);
        btnSua.setEnabled(t);
        btnXoa.setEnabled(t);
        btnThem.setEnabled(t);
        //btnThoat.setEnabled(t);
    }
     
    private void xoaTextBox()
    {
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        
    }
    
    private boolean kiemTraNhapDayDu()
    {
        if ( txtMaKH.getText().isEmpty() || txtTenKH.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtSDT.getText().isEmpty())
        {
            //Thông báo nhập đầy đủ
            Message.showMessageError("Hãy nhập đầy đủ thông tin");
            return false;
        }
        else if(txtSDT.getText().length() < 10 || txtSDT.getText().length() > 11)
        {
            Message.showMessageError("Sđt không hợp lệ");
            return false;
        }
        else
        {
            return true;
           
        }
            
    }
    // Biến để lưu trữ trạng thái của nút trước đó
    String previousAction = "";    
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        
        //KIỂM TRA: Nhập đầy đủ các trường mới được lưu
        if ( kiemTraNhapDayDu() )
        {
            String message = "Bạn có chắc chắn muốn ";
            if (previousAction.equals("Them")) {
                message += "thêm không?";
            } 
            if (previousAction.equals("Xoa")) {
                message += "xóa không?";
            }
            if (previousAction.equals("Sua")) {
                message += "sửa không?";
            } 

//            int confirm = JOptionPane.showConfirmDialog(btnLuu, message, "Xác nhận", JOptionPane.YES_NO_OPTION);
            MessageQuestion messquestion = new MessageQuestion(Main.getFrames()[0], true, GoogleMaterialDesignIcons.HELP);
            messquestion.showMessage(message);
            
            if (messquestion.isOk()) 
            {
                KhachHang l = chuyenDoiTextBoxSangDoiTuong();
                if( flag == 1 )
                {
                    sdt_new = txtSDT.getText();
                    tenKH_new = txtTenKH.getText();
                    dslkh.themKhachHang(l);
                    flag= 0; //Để bấm các tính năng khác
                    xoaTextBox();//Khi vừa thêm xong 1. trỏ đúng đối tg vừa thêm.    ????????????????????????????????????????
                    anHienButton(true); //2. Nút lưu khóa, các nút khác hiện. 
                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Thêm thành công"); //cái này thêm ko dc nó vẫn chạy !!!  
                    if (parentFrame != null) {
                        parentFrame.dispose();
                    }
                }

                if (flag == 2 )
                {
                    dslkh.suaKhachHang(l);
                    flag= 0;
                    xoaTextBox();//Khi vừa sửa xong 1. trỏ đúng đối tg vừa sửa. 
                    anHienButton(true); //2. Nút lưu khóa, các nút khác hiện. 
                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Sửa thành công");
                }

                if (flag == 3)
                {
                    dslkh.xoaKhachHang(l);
                    xoaTextBox();
                    //Khi xóa xong, 1. Nút lưu vẫn mở, các nút khác vẫn khóa (cho ng dùng xóa tiếp đôi tg khác. (cho đến khi ấn hủy). 2. 
                    //anHienText(true); //khi xóa xong thì vẫn còn hiện
                    Message.showMessageSuccess("Xóa thành công");
                }

                //flag= 0;
                //xoaTextBox();
                dslkh = new DSKhachHang();
                dslkh_List = dslkh.layDSKhachHang("");
                hienThiTable();
                //anHienText(true);
            }
        }
        
    }//GEN-LAST:event_btnLuuActionPerformed

    public static String taoMaTuDong() {
        String key = "KH";
        
        // Kết nối CSDL và thực hiện truy vấn
//        DBConnect db = new DBConnect();
//        ResultSet rs = db.executeQuery(sqlQuery);
        try {
            KetNoi kn = new KetNoi();
            String sql = "Select TOP 1 MAKH from KHACHHANG WHERE MAKH LIKE 'KH%' ORDER BY MAKH DESC";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (!rs.next()) {
                key += "0001";
            } else {
                String maBanDau = rs.getString("MAKH");
                String sott = maBanDau.substring(2);
                int num = Integer.parseInt(sott.trim()) + 1;
                if (num < 10)
                    key += "000" + num;
                else if (num < 100)
                    key += "00" + num;
                else if (num < 1000)
                    key += "0" + num;
                else
                    key += num; 
            }
            // Đóng tài nguyên
            rs.close();
            st.close();
            kn.KetNoiDuLieu().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return key;
    }
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        txtTenKH.requestFocus();
        flag = 1;
        String ma= taoMaTuDong();
        txtMaKH.setText(ma);
        //xoaTextBox(); //Phải xóa textbox trước (không xóa mã)
        txtTenKH.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
              
        lbThongBao.setText("Hãy nhập dữ liệu mới. Hoặc bấm hủy để chọn thao tác khác");
        anHienText(true); //Mở khóa textbox cho người nhập
        anHienButton(false); //Phải khóa các nút tính năng khác 
        
        previousAction = "Them";
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        flag = 2;
        lbThongBao.setText("Hãy chọn dòng cần sửa. Hoặc bấm hủy để chọn thao tác khác");
        xoaTextBox(); //Phải xóa textbox trước 
        anHienButton(false); //Phải khóa các nút tính năng khác 
        anHienText(false);
        //Khi bấm sửa, textbox vẫn ko hiện, khi bấm chọn 1 dòng cần sửa thì textbox mới hiện lên cho sửa -->sự kiện mouseclick
        
        previousAction = "Sua";
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        flag = 3;
        lbThongBao.setText("Hãy chọn dòng cần xóa. Hoặc bấm hủy để chọn thao tác khác");
        xoaTextBox(); //Phải xóa textbox trước (để tránh liên kết còn hiện và người dùng xóa nhầm dòng)
        anHienText(false);//Phải khóa textbox không cho người nhập nhập
        anHienButton(false);//Phải khóa các nút tính năng khác 
        
        previousAction = "Xoa";
    }//GEN-LAST:event_btnXoaActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnHuy;
    private swing.Button btnLuu;
    private swing.Button btnSua;
    private swing.Button btnThem;
    private swing.Button btnXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private swing.table.Table tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private swing.textfield.TextFieldSearchOption txtSearch;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
