
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
import ql_cuahang_nhaccu_class.DSLoaiSanPham;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.LoaiSanPham;
import swing.icon.GoogleMaterialDesignIcons;
import swing.textfield.SearchOptinEvent;
import swing.textfield.SearchOption;


public class Frm_LoaiSP extends javax.swing.JPanel {
    DSLoaiSanPham dslsp;
    ArrayList<LoaiSanPham> dslsp_List;
    int vitri = 0;
    
    public Frm_LoaiSP() {
        initComponents();
        setOpaque(false);
        tblLoaiSP.fixTable(jScrollPane1);
        dslsp = new DSLoaiSanPham();
        dslsp_List = dslsp.layDSLoaiSanPham("");
//        hienThiTextBox();
        hienThiTable();
        init_txtSearch();
        anHienButton(true);
        anHienText(false);
        txtMaLoai.setEnabled(false);
        
    }
    
    private void init_txtSearch() {
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                // reset lại txt và table khi chọn mục tìm kiếm khác
                txtSearch.setText("");
                dslsp_List = dslsp.layDSLoaiSanPham("");
                hienThiTable();
                txtSearch.setHint("Search by " + option.getName() + "...");
            }
        });
        txtSearch.addOption(new SearchOption("Name", new ImageIcon(getClass().getResource("/icon/user.png"))));
        txtSearch.setSelectedIndex(0);
    }
    
    private void hienThiTextBox(int vitri) {
        LoaiSanPham lsp = dslsp_List.get(vitri);
        txtMaLoai.setText(lsp.maLoai);
        txtTenLoai.setText(lsp.tenLoai);
    }
    
    private void hienThiTable() {
//        String[] Header = {"Mã Loại", "Tên Loại"};
//        DefaultTableModel model = new DefaultTableModel(Header, 0);
//        for(LoaiSanPham l: dslsp_List) {
//            Object[] o = {l.maLoai, l.tenLoai};
//            model.addRow(o);
//        } 
//        tblLoaiSP.setModel(model);
//        tblLoaiSP.setRowSelectionInterval(vitri, vitri);

        String[] Header = {"Mã Loại", "Tên Loại"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        for(LoaiSanPham l: dslsp_List) {
            Object[] o = {l.maLoai, l.tenLoai};
            model.addRow(o);
        } 
        tblLoaiSP.setModel(model);
        //ktra dong trong list sau khi tim kiem
        if (dslsp_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dslsp_List.size() - 1);
            tblLoaiSP.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaLoai = new javax.swing.JTextField();
        txtTenLoai = new javax.swing.JTextField();
        btnLuu = new swing.Button();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoaiSP = new swing.table.Table();
        txtSearch = new swing.textfield.TextFieldSearchOption();
        btnSua = new swing.Button();
        btnXoa = new swing.Button();
        btnThoat = new swing.Button();
        btnHuy = new swing.Button();
        btnThem = new swing.Button();
        lbThongBao = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin loại sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mã loại:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Tên loại:");

        txtMaLoai.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTenLoai.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTenLoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenLoaiKeyTyped(evt);
            }
        });

        btnLuu.setText("Thực thi");
        btnLuu.setEnabled(false);
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
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách loại sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã loại", "Tên loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoaiSP);

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
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
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

        btnThoat.setBackground(new java.awt.Color(123, 110, 255));
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

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
                        .addGap(43, 43, 43)
                        .addComponent(lbThongBao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbThongBao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
         //Khi bấm hủy: Nút lưu khóa, các nút thêm xóa sửa hiện lên. 
        anHienButton(true);
        anHienText(false);
        txtMaLoai.setText("");
        txtTenLoai.setText("");
        lbThongBao.setText("Hãy chọn 1 thao tác");
        flag = 0;
    }//GEN-LAST:event_btnHuyActionPerformed

    
    int flag = 0;
    private void tblLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSPMouseClicked
        vitri = tblLoaiSP.getSelectedRow();
        hienThiTextBox(vitri);
        
         //Khi bấm sửa, textbox vẫn ko hiện, khi bấm chọn 1 dòng cần sửa thì textbox mới hiện lên cho sửa
        if (flag == 2)
        {
            anHienText(true);
        }
    }//GEN-LAST:event_tblLoaiSPMouseClicked

    private LoaiSanPham chuyenDoiTextBoxSangDoiTuong()
    {
        LoaiSanPham l = new LoaiSanPham(txtMaLoai.getText(), txtTenLoai.getText());
        
        return l;
    }
    
    private void anHienText(boolean t)
    {
        //txtMaNCC.setEnabled(t);
        txtTenLoai.setEnabled(t);
       
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
        txtMaLoai.setText("");
        txtTenLoai.setText("");
       
    }
    
    private boolean kiemTraNhapDayDu()
    {
        if ( txtTenLoai.getText().isEmpty() )
        {
            //Thông báo nhập đầy đủ
            Message.showMessageError("Hãy nhập đầy đủ thông tin");
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
        if ( kiemTraNhapDayDu())
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
            
            if (messquestion.isOk()) {

                LoaiSanPham l = chuyenDoiTextBoxSangDoiTuong();
                if( flag == 1 )
                {
                    dslsp.themLoaiSP(l);
                    flag= 0; //Để bấm các tính năng khác
                    xoaTextBox();//Khi vừa thêm xong 1. trỏ đúng đối tg vừa thêm.    ????????????????????????????????????????
                    anHienButton(true); //2. Nút lưu khóa, các nút khác hiện. 
                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Thêm thành công");
                }



                if (flag == 2 )
                {
                    dslsp.suaLoaiSP(l);
                    flag= 0;
                    xoaTextBox();//Khi vừa sửa xong 1. trỏ đúng đối tg vừa sửa. 
                    anHienButton(true); //2. Nút lưu khóa, các nút khác hiện. 
                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Sửa thành công");
                }

                if (flag == 3)
                {
                    dslsp.xoaLoaiSP(l);
                    xoaTextBox();
                    //Khi xóa xong, 1. Nút lưu vẫn mở, các nút khác vẫn khóa (cho ng dùng xóa tiếp đôi tg khác. (cho đến khi ấn hủy). 2. 
                    //anHienText(true); //khi xóa xong thì vẫn còn hiện
                    Message.showMessageSuccess("Xóa thành công");
                }

                //flag= 0;
                dslsp = new DSLoaiSanPham();
                dslsp_List = dslsp.layDSLoaiSanPham("");
                hienThiTable();

            }
        }
                
        

    }//GEN-LAST:event_btnLuuActionPerformed

    public static String taoMaTuDong() {
        String key = "L";
        
        try {
            KetNoi kn = new KetNoi();
            String sql = "Select TOP 1 MALOAI from LOAISANPHAM WHERE MALOAI LIKE 'L%' ORDER BY MALOAI DESC";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (!rs.next()) {
                key += "001";
            } else {
                String maBanDau = rs.getString("MALOAI");
                String sott = maBanDau.substring(1);
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
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        
        txtTenLoai.requestFocus();
        flag = 1;
        String ma= taoMaTuDong();
        txtMaLoai.setText(ma);
        //xoaTextBox(); //Phải xóa textbox trước (không xóa mã)
        txtTenLoai.setText("");
                
        lbThongBao.setText("Hãy nhập dữ liệu mới. Hoặc bấm hủy để chọn thao tác khác");
        anHienText(true); //Mở khóa textbox cho người nhập
        anHienButton(false); //Phải khóa các nút tính năng khác 
        
        previousAction = "Them";
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        flag = 3;
        lbThongBao.setText("Hãy chọn dòng cần xóa. Hoặc bấm hủy để chọn thao tác khác");
        xoaTextBox(); //Phải xóa textbox trước (để tránh liên kết còn hiện và người dùng xóa nhầm dòng)
        anHienText(false);//Phải khóa textbox không cho người nhập nhập
        anHienButton(false);//Phải khóa các nút tính năng khác 
        
        previousAction = "Xoa";
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        flag = 2;
        lbThongBao.setText("Hãy chọn dòng cần sửa. Hoặc bấm hủy để chọn thao tác khác");
        xoaTextBox(); //Phải xóa textbox trước 
        anHienButton(false); //Phải khóa các nút tính năng khác 
        anHienText(false);
        //Khi bấm sửa, textbox vẫn ko hiện, khi bấm chọn 1 dòng cần sửa thì textbox mới hiện lên cho sửa -->sự kiện mouseclick
        
        previousAction = "Sua";
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(txtSearch.isSelected()) {
            int opt = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText().trim() + "%";
            if(opt == 0) {
                dslsp_List = dslsp.layDSLoaiSanPham("and TENLOAI like N'"+text+"' ");
            }
        }
        hienThiTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtTenLoaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenLoaiKeyTyped
        
        char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự là chữ, hoặc space, hoặc nút xóa (ko chứa số, kí tự đặc biệt)  
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER && c != ' ') {
            
            evt.consume();
            // Hiển thị thông báo lỗi
            Message.showMessageError("Tên loại chỉ được chứa chữ cái!");
        }
    }//GEN-LAST:event_txtTenLoaiKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnHuy;
    private swing.Button btnLuu;
    private swing.Button btnSua;
    private swing.Button btnThem;
    private swing.Button btnThoat;
    private swing.Button btnXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private swing.table.Table tblLoaiSP;
    private javax.swing.JTextField txtMaLoai;
    private swing.textfield.TextFieldSearchOption txtSearch;
    private javax.swing.JTextField txtTenLoai;
    // End of variables declaration//GEN-END:variables
}
