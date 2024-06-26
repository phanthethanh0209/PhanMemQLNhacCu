
package ql_cuahang_nhaccu_form;

import dialog.Message;
import dialog.MessageQuestion;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import main.Main;
import ql_cuahang_nhaccu_class.DSKhachHang;
import ql_cuahang_nhaccu_class.DSNhanVien;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.KhachHang;
import ql_cuahang_nhaccu_class.NhanVien;
import swing.icon.GoogleMaterialDesignIcons;
import swing.textfield.SearchOptinEvent;
import swing.textfield.SearchOption;

public class Frm_NhanVien extends javax.swing.JPanel {

    DSNhanVien dslkh;
    ArrayList<NhanVien> dslkh_List;
    int vitri = 0;
    
    public Frm_NhanVien() {
        initComponents();
//        setOpaque(false);
        tblNhanVien.fixTable(jScrollPane1);
        dslkh = new DSNhanVien();
        dslkh_List = dslkh.layDSNhanVien("");
//        hienThiTextBox();
        hienThiTable();
        init_txtSearch();
        anHienButton(true);
        anHienText(false);
        txtMaNV.setEnabled(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMaNV = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnLuu = new swing.Button();
        jLabel6 = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new swing.table.Table();
        txtSearch = new swing.textfield.TextFieldSearchOption();
        btnSua = new swing.Button();
        btnXoa = new swing.Button();
        btnHuy = new swing.Button();
        btnThem = new swing.Button();
        lbThongBao = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        lblMaNV.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblMaNV.setText("Mã nhân viên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Tên nhân viên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("SĐT:");

        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTenNV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTenNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenNVKeyTyped(evt);
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Chức vụ:");

        txtChucVu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtChucVu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtChucVuKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Lương:");

        txtLuong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLuongKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtChucVu)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(txtTenNV))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addComponent(txtSDT)
                    .addComponent(txtLuong))
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(433, 433, 433)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaNV))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Địa chỉ", "SĐT", "Chức vụ", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
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
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

     private void init_txtSearch() {
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                // reset lại txt và table khi chọn mục tìm kiếm khác
                txtSearch.setText("");
                dslkh_List = dslkh.layDSNhanVien("");
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
        NhanVien lsp = dslkh_List.get(vitri);
        txtMaNV.setText(lsp.maNV);
        txtTenNV.setText(lsp.tenNV);
        txtSDT.setText(lsp.sDT);
        txtDiaChi.setText(lsp.diaChi);
        txtChucVu.setText(lsp.chucVu);
        txtLuong.setText("" + lsp.luong);
    }
    
    private void hienThiTable() {
        String[] Header = {"Mã NV", "Tên NV", "Địa Chỉ", "SĐT", "Chức vụ", "Lương"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        for(NhanVien l: dslkh_List) {
            Object[] o = {l.maNV, l.tenNV, l.diaChi, l.sDT, l.chucVu, l.luong};
            model.addRow(o);
        } 
        tblNhanVien.setModel(model);
//        tblNhanVien.setRowSelectionInterval(vitri, vitri);
        if (dslkh_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dslkh_List.size() - 1);
            tblNhanVien.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
        }
        
    }
    
     private NhanVien chuyenDoiTextBoxSangDoiTuong()
    {
        NhanVien ncc = new NhanVien();
        ncc.maNV= txtMaNV.getText();
        ncc.tenNV= txtTenNV.getText();
        ncc.diaChi= txtDiaChi.getText();
        ncc.sDT= txtSDT.getText();
        ncc.chucVu= txtChucVu.getText();
        ncc.luong= Integer.parseInt(txtLuong.getText());
       
        return ncc;
    }
    
     private void anHienText(boolean t)
    {
        //txtMaNCC.setEnabled(t);
        txtTenNV.setEnabled(t);
        txtDiaChi.setEnabled(t);
        txtSDT.setEnabled(t);
        txtChucVu.setEnabled(t);
        txtLuong.setEnabled(t);

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
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtChucVu.setText("");
        txtLuong.setText("");
        
    }
    
    private boolean kiemTraNhapDayDu()
    {
        if ( txtMaNV.getText().isEmpty() || txtTenNV.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtSDT.getText().isEmpty() || txtChucVu.getText().isEmpty() || txtLuong.getText().isEmpty())
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
        int flag = 0;
    // Biến để lưu trữ trạng thái của nút trước đó
    String previousAction = "";
    
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
         flag = 2;
        lbThongBao.setText("Hãy chọn dòng cần sửa. Hoặc bấm hủy để chọn thao tác khác");
        xoaTextBox(); //Phải xóa textbox trước 
        anHienButton(false); //Phải khóa các nút tính năng khác 
        anHienText(false);
        //Khi bấm sửa, textbox vẫn ko hiện, khi bấm chọn 1 dòng cần sửa thì textbox mới hiện lên cho sửa -->sự kiện mouseclick
        
        previousAction = "Sua";
    }//GEN-LAST:event_btnSuaActionPerformed

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

            MessageQuestion messquestion = new MessageQuestion(Main.getFrames()[0], true, GoogleMaterialDesignIcons.HELP);
            messquestion.showMessage(message);
            if (messquestion.isOk()) 
            {
                NhanVien l = chuyenDoiTextBoxSangDoiTuong();
                if( flag == 1 )
                {

                    dslkh.themNhanVien(l);
                    flag= 0; //Để bấm các tính năng khác
                    xoaTextBox();//Khi vừa thêm xong 1. trỏ đúng đối tg vừa thêm.    ????????????????????????????????????????
                    anHienButton(true); //2. Nút lưu khóa, các nút khác hiện. 
                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Thêm thành công"); //cái này thêm ko dc nó vẫn chạy !!!
                }

                if (flag == 2 )
                {
                    dslkh.suaNhanVien(l);
                    flag= 0;
                    xoaTextBox();//Khi vừa sửa xong 1. trỏ đúng đối tg vừa sửa. 
                    anHienButton(true); //2. Nút lưu khóa, các nút khác hiện. 
                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Sửa thành công");
                }

                if (flag == 3)
                {
                    dslkh.xoaNhanVien(l);
                    xoaTextBox();
                    //Khi xóa xong, 1. Nút lưu vẫn mở, các nút khác vẫn khóa (cho ng dùng xóa tiếp đôi tg khác. (cho đến khi ấn hủy). 2. 
                    //anHienText(true); //khi xóa xong thì vẫn còn hiện
                    Message.showMessageSuccess("Xóa thành công");
                }

                //flag= 0;
                //xoaTextBox();
                dslkh = new DSNhanVien();
                dslkh_List = dslkh.layDSNhanVien("");
                hienThiTable();
                //anHienText(true);
            }
        }
        
    }//GEN-LAST:event_btnLuuActionPerformed

     public static String taoMaTuDong() {
        String key = "NV";
        
        // Kết nối CSDL và thực hiện truy vấn
//        DBConnect db = new DBConnect();
//        ResultSet rs = db.executeQuery(sqlQuery);
        try {
            KetNoi kn = new KetNoi();
            String sql = "Select TOP 1 MANV from NHANVIEN WHERE MANV LIKE 'NV%' ORDER BY MANV DESC";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (!rs.next()) {
                key += "001";
            } else {
                String maBanDau = rs.getString("MANV");
                String sott = maBanDau.substring(2);
                int num = Integer.parseInt(sott.trim()) + 1;
                if (num < 10)
                    key += "00" + num;
                else if (num < 100)
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

    private void txtTenNVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenNVKeyTyped
         char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự là chữ, hoặc space, hoặc nút xóa (ko chứa số, kí tự đặc biệt)  
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER && c != ' ') {
           
            evt.consume();
            // Hiển thị thông báo lỗi
            Message.showMessageError("Tên nhân viên chỉ được chứa chữ cái!");
            
        }
    }//GEN-LAST:event_txtTenNVKeyTyped

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
         if(txtSearch.isSelected()) {
            int opt = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText().trim() + "%";
            if(opt == 0) {
                dslkh_List = dslkh.layDSNhanVien("and TENNV like N'"+text+"' ");
            }else if(opt == 1) {
                dslkh_List = dslkh.layDSNhanVien("and SDT like '"+text+"' ");
            }else if(opt == 2) {
                dslkh_List = dslkh.layDSNhanVien("and DIACHI like N'"+text+"' ");
            }
        }
        hienThiTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
       vitri = tblNhanVien.getSelectedRow();
        hienThiTextBox(vitri);
        
        //Khi bấm sửa, textbox vẫn ko hiện, khi bấm chọn 1 dòng cần sửa thì textbox mới hiện lên cho sửa
        if (flag == 2)
        {
            anHienText(true);
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        txtTenNV.requestFocus();
        flag = 1;
        String ma= taoMaTuDong();
        txtMaNV.setText(ma);
        //xoaTextBox(); //Phải xóa textbox trước (không xóa mã)
        txtTenNV.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtLuong.setText("");
        txtChucVu.setText("");
        
              
        lbThongBao.setText("Hãy nhập dữ liệu mới. Hoặc bấm hủy để chọn thao tác khác");
        anHienText(true); //Mở khóa textbox cho người nhập
        anHienButton(false); //Phải khóa các nút tính năng khác 
        
        previousAction = "Them";
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        //Khi bấm hủy: Nút lưu khóa, các nút thêm xóa sửa hiện lên. 
        anHienButton(true);
        anHienText(false);
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        lbThongBao.setText("Hãy chọn 1 thao tác");
        flag = 0;
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        flag = 3;
        lbThongBao.setText("Hãy chọn dòng cần xóa. Hoặc bấm hủy để chọn thao tác khác");
        xoaTextBox(); //Phải xóa textbox trước (để tránh liên kết còn hiện và người dùng xóa nhầm dòng)
        anHienText(false);//Phải khóa textbox không cho người nhập nhập
        anHienButton(false);//Phải khóa các nút tính năng khác 
        
        previousAction = "Xoa";
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtChucVuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChucVuKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChucVuKeyTyped

    private void txtLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongKeyTyped

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnHuy;
    private swing.Button btnLuu;
    private swing.Button btnSua;
    private swing.Button btnThem;
    private swing.Button btnXoa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JLabel lblMaNV;
    private swing.table.Table tblNhanVien;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private swing.textfield.TextFieldSearchOption txtSearch;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
