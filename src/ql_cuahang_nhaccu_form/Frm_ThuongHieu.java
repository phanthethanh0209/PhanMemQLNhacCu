
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
import ql_cuahang_nhaccu_class.DSThuongHieu;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.NhaCungCap;
import ql_cuahang_nhaccu_class.ThuongHieu;
import swing.icon.GoogleMaterialDesignIcons;
import swing.textfield.SearchOptinEvent;
import swing.textfield.SearchOption;

public class Frm_ThuongHieu extends javax.swing.JPanel {
    DSThuongHieu dsth;
    ArrayList<ThuongHieu> dsth_List;
    int vitri = 0;
    
    public Frm_ThuongHieu() {
        initComponents();
        setOpaque(false);
        tblThuongHieu.fixTable(jScrollPane1);
        dsth = new DSThuongHieu();
        dsth_List = dsth.layDSThuongHieu("");
        hienThiTable();
        init_txtSearch();
        anHienButton(true);
        anHienText(false);
        txtMaTH.setEnabled(false);
    }
    
    private void init_txtSearch() {
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                // reset lại txt và table khi chọn mục tìm kiếm khác
                txtSearch.setText("");
                dsth_List = dsth.layDSThuongHieu("");
                hienThiTable();
                txtSearch.setHint("Search by " + option.getName() + "...");
            }
        });
        txtSearch.addOption(new SearchOption("Name", new ImageIcon(getClass().getResource("/icon/user.png"))));
//        txtSearch.addOption(new SearchOption("Tel", new ImageIcon(getClass().getResource("/icon/tel.png"))));
//        txtSearch.addOption(new SearchOption("Address", new ImageIcon(getClass().getResource("/icon/address.png"))));
        txtSearch.setSelectedIndex(0);
    }
    
    private void hienThiTextBox(int vitri) {
        ThuongHieu th = dsth_List.get(vitri);
        txtMaTH.setText(th.maTH);
        txtTenTH.setText(th.tenTH);
    }
    
    private void hienThiTable() {
//        DefaultTableModel model = (DefaultTableModel)tblThuongHieu.getModel();
//        for(ThuongHieu l: dsth_List) {
//            Object[] o = {l.maTH, l.tenTH};
//            model.addRow(o);
//        } 
//        
        
        String[] Header = {"Mã Thương Hiệu", "Tên Thương Hiệu"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        for(ThuongHieu l: dsth_List) {
            Object[] o = {l.maTH, l.tenTH};
            model.addRow(o);
        } 
        tblThuongHieu.setModel(model);
        //tblThuongHieu.setRowSelectionInterval(vitri, vitri);
        
        //ktra dong trong list sau khi tim kiem
        if (dsth_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dsth_List.size() - 1);
            tblThuongHieu.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaTH = new javax.swing.JTextField();
        txtTenTH = new javax.swing.JTextField();
        btnLuu = new swing.Button();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThuongHieu = new swing.table.Table();
        txtSearch = new swing.textfield.TextFieldSearchOption();
        btnSua = new swing.Button();
        btnXoa = new swing.Button();
        btnHuy = new swing.Button();
        btnThem = new swing.Button();
        lbThongBao = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin thương hiệu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mã thương hiệu:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Tên thương hiệu:");

        txtMaTH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTenTH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTenTH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenTHKeyTyped(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(123, 110, 255));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Thực Thi");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(txtMaTH, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtTenTH, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách thương hiệu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblThuongHieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thương hiệu", "Tên thương hiệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThuongHieu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuongHieuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThuongHieu);

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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
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
                        .addGap(49, 49, 49)
                        .addComponent(lbThongBao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbThongBao)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    int flag = 0;
    private ThuongHieu chuyenDoiTextBoxSangDoiTuong()
    {
        ThuongHieu l = new ThuongHieu(txtMaTH.getText(), txtTenTH.getText());
        
        return l;
    }
    
     private void anHienText(boolean t)
    {
        //txtMaNCC.setEnabled(t);
        txtTenTH.setEnabled(t);
       
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
        txtMaTH.setText("");
        txtTenTH.setText("");
        
    }
    
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        //Khi bấm hủy: Nút lưu khóa, các nút thêm xóa sửa hiện lên. 
        anHienButton(true);
        anHienText(false);
        txtMaTH.setText("");
        txtTenTH.setText("");
        lbThongBao.setText("Hãy chọn 1 thao tác");
        flag = 0;
    }//GEN-LAST:event_btnHuyActionPerformed

    private void tblThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuongHieuMouseClicked
        vitri = tblThuongHieu.getSelectedRow();
        hienThiTextBox(vitri);
                
        //Khi bấm sửa, textbox vẫn ko hiện, khi bấm chọn 1 dòng cần sửa thì textbox mới hiện lên cho sửa
        if (flag == 2)
        {
            anHienText(true);
        }
    }//GEN-LAST:event_tblThuongHieuMouseClicked

    private boolean kiemTraNhapDayDu()
    {
        if ( txtTenTH.getText().isEmpty() )
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
            if (messquestion.isOk()) 
            {
                ThuongHieu l = chuyenDoiTextBoxSangDoiTuong();
                if( flag == 1 )
                {
                    dsth.themThuongHieu(l);
                    flag= 0; //Để bấm các tính năng khác
                    xoaTextBox();//Khi vừa thêm xong 1. trỏ đúng đối tg vừa thêm.    ????????????????????????????????????????
                    anHienButton(true); //2. Nút lưu khóa, các nút khác hiện. 
                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Thêm thành công");
                }



                if (flag == 2 )
                {
                    dsth.suaThuongHieu(l);
                    flag= 0;
                    xoaTextBox();//Khi vừa sửa xong 1. trỏ đúng đối tg vừa sửa. 
                    anHienButton(true); //2. Nút lưu khóa, các nút khác hiện. 
                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Sửa thành công");
                }

                if (flag == 3)
                {
                    dsth.xoaThuongHieu(l);
                    xoaTextBox();
                    //Khi xóa xong, 1. Nút lưu vẫn mở, các nút khác vẫn khóa (cho ng dùng xóa tiếp đôi tg khác. (cho đến khi ấn hủy). 2. 
                    //anHienText(true); //khi xóa xong thì vẫn còn hiện
                    Message.showMessageSuccess("Xóa thành công");
                }

                //flag= 0;
                dsth = new DSThuongHieu();
                dsth_List = dsth.layDSThuongHieu("");
                hienThiTable();
            }
            
            
            
        }

    }//GEN-LAST:event_btnLuuActionPerformed

     public static String taoMaTuDong() {
        String key = "TH";
        
        // Kết nối CSDL và thực hiện truy vấn
//        DBConnect db = new DBConnect();
//        ResultSet rs = db.executeQuery(sqlQuery);
        try {
            KetNoi kn = new KetNoi();
            String sql = "Select TOP 1 MATHUONGHIEU from THUONGHIEU WHERE MATHUONGHIEU LIKE 'TH%' ORDER BY MATHUONGHIEU DESC";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (!rs.next()) {
                key += "001";
            } else {
                String maBanDau = rs.getString("MATHUONGHIEU");
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
     
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
         txtTenTH.requestFocus();
        flag = 1;
        String ma= taoMaTuDong();
        txtMaTH.setText(ma);
        //xoaTextBox(); //Phải xóa textbox trước (không xóa mã)
        txtTenTH.setText("");
                
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
    
    
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(txtSearch.isSelected()) {
            int opt = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText().trim() + "%";
            if(opt == 0) {
                dsth_List = dsth.layDSThuongHieu("and TENTHUONGHIEU like N'"+text+"' ");
            }
//            else if(opt == 1) {
//                dsth_List = dsth.layDSThuongHieu("and SDT like '"+text+"' ");
//            }
        }
        hienThiTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    
    private void txtTenTHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenTHKeyTyped
        char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự là chữ, hoặc space, hoặc nút xóa (ko chứa số, kí tự đặc biệt)  
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER && c != ' ') {
            
            evt.consume();
            // Hiển thị thông báo lỗi
            Message.showMessageSuccess("Tên thương hiệu chỉ được chứa chữ cái!");
        }
        
    }//GEN-LAST:event_txtTenTHKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnHuy;
    private swing.Button btnLuu;
    private swing.Button btnSua;
    private swing.Button btnThem;
    private swing.Button btnXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private swing.table.Table tblThuongHieu;
    private javax.swing.JTextField txtMaTH;
    private swing.textfield.TextFieldSearchOption txtSearch;
    private javax.swing.JTextField txtTenTH;
    // End of variables declaration//GEN-END:variables
}
