
package ql_cuahang_nhaccu_form;

import dialog.Message;
import dialog.MessageQuestion;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import ql_cuahang_nhaccu_class.DSNhaCungCap;
import ql_cuahang_nhaccu_class.LoaiSanPham;
import ql_cuahang_nhaccu_class.NhaCungCap;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import main.Main;
import ql_cuahang_nhaccu_class.KetNoi;
import swing.icon.GoogleMaterialDesignIcons;
import swing.textfield.SearchOptinEvent;
import swing.textfield.SearchOption;

public class Frm_NhaCungCap extends javax.swing.JPanel {
    DSNhaCungCap dsncc;
    ArrayList<NhaCungCap> dsncc_List;
    int vitri = 0;
    
    public Frm_NhaCungCap() {
        initComponents();
        tblNhaCC.fixTable(jScrollPane1);
        setOpaque(false);
        dsncc = new DSNhaCungCap();
        dsncc_List = dsncc.layDSNhaCC("");
        hienThiTable();
        init_txtSearch();
        anHienButton(true);
        anHienText(false);
        txtMaNCC.setEnabled(false);
    }
    
    //KHỞI TẠO BIẾN STATIC ĐỂ FORM PHIẾU NHẬP NHẬN THÔNG TIN TRẢ VỀ KHI ĐÓNG FORM
    private JFrame parentFrame;
    public static String maNCC_new = "";
    public static String tenNCC_new = "";
    public static String sdt_new = "";
    
    public Frm_NhaCungCap(JFrame parentFrame) {
        initComponents();
        tblNhaCC.fixTable(jScrollPane1);
        dsncc = new DSNhaCungCap();
        dsncc_List = dsncc.layDSNhaCC("");
        hienThiTable();
        init_txtSearch();
        anHienButton(true);
        anHienText(false);
        txtMaNCC.setEnabled(false);
        this.parentFrame = parentFrame;
    }
    
    private void init_txtSearch() {
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                // reset lại txt và table khi chọn mục tìm kiếm khác
                txtSearch.setText("");
                dsncc_List = dsncc.layDSNhaCC("");
                hienThiTable();
                txtSearch.setHint("Search by " + option.getName() + "...");
            }
        });
        txtSearch.addOption(new SearchOption("Name", new ImageIcon(getClass().getResource("/icon/user.png"))));
        txtSearch.addOption(new SearchOption("Address", new ImageIcon(getClass().getResource("/icon/address.png"))));
        txtSearch.addOption(new SearchOption("Email", new ImageIcon(getClass().getResource("/icon/email.png"))));
        txtSearch.addOption(new SearchOption("Tel", new ImageIcon(getClass().getResource("/icon/tel.png"))));
        txtSearch.addOption(new SearchOption("Website", new ImageIcon(getClass().getResource("/icon/address.png"))));
        txtSearch.setSelectedIndex(0);
    }
    
    private void hienThiTextBox(int vitri) {
        NhaCungCap lsp = dsncc_List.get(vitri);
        txtMaNCC.setText(lsp.maNCC);
        txtTenNCC.setText(lsp.tenNCC);
        txtDiaChi.setText(lsp.diaChi);
        txtEmail.setText(lsp.email);
        txtSDT.setText(lsp.sDT);
        txtWeb.setText(lsp.website.trim());
    }
    
    private void hienThiTable() {
        String[] Header = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "SĐT", "Email", "Website"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        for(NhaCungCap l: dsncc_List) {
            Object[] o = {l.maNCC, l.tenNCC, l.diaChi, l.sDT, l.email, l.website};
            model.addRow(o);
        } 
        tblNhaCC.setModel(model);
        //ktra dong trong list sau khi tim kiem
        if (dsncc_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dsncc_List.size() - 1);
            tblNhaCC.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
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
        txtMaNCC = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTenNCC = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtWeb = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnLuu = new swing.Button();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhaCC = new swing.table.Table();
        txtSearch = new swing.textfield.TextFieldSearchOption();
        btnSua = new swing.Button();
        btnXoa = new swing.Button();
        btnHuy = new swing.Button();
        btnThem = new swing.Button();
        lbThongBao = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin nhà cung cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mã nhà cung cấp:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Tên nhà cung cấp:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("SĐT:");

        txtMaNCC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTenNCC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTenNCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenNCCKeyTyped(evt);
            }
        });

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSDTKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Website:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Email:");

        txtWeb.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

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
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(txtTenNCC)
                    .addComponent(txtWeb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(txtSDT)
                    .addComponent(txtEmail))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNCC)
                    .addComponent(jLabel4)
                    .addComponent(txtDiaChi)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNCC)
                    .addComponent(jLabel5)
                    .addComponent(txtSDT)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWeb)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách nhà cung cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblNhaCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "SĐT", "Email", "Website"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhaCC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhaCC);
        if (tblNhaCC.getColumnModel().getColumnCount() > 0) {
            tblNhaCC.getColumnModel().getColumn(0).setPreferredWidth(2);
            tblNhaCC.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblNhaCC.getColumnModel().getColumn(2).setPreferredWidth(220);
            tblNhaCC.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblNhaCC.getColumnModel().getColumn(4).setPreferredWidth(30);
            tblNhaCC.getColumnModel().getColumn(5).setPreferredWidth(30);
        }

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1155, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lbThongBao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        txtWeb.setText("");
        lbThongBao.setText("Hãy chọn 1 thao tác");
        flag = 0;
        
        
    }//GEN-LAST:event_btnHuyActionPerformed

    private void tblNhaCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCCMouseClicked
        vitri = tblNhaCC.getSelectedRow();
        hienThiTextBox(vitri);
        
        //Khi bấm sửa, textbox vẫn ko hiện, khi bấm chọn 1 dòng cần sửa thì textbox mới hiện lên cho sửa
        if (flag == 2)
        {
            anHienText(true); 
        }
        
    }//GEN-LAST:event_tblNhaCCMouseClicked

    int flag = 0;
    private NhaCungCap chuyenDoiTextBoxSangDoiTuong()
    {
        NhaCungCap ncc = new NhaCungCap();
        ncc.maNCC= txtMaNCC.getText();
        ncc.tenNCC= txtTenNCC.getText();
        ncc.diaChi= txtDiaChi.getText();
        ncc.sDT= txtSDT.getText();
        ncc.email= txtEmail.getText();
        ncc.website= txtWeb.getText();
        
       
        return ncc;
    }
    
     private void anHienText(boolean t)
    {
        //txtMaNCC.setEnabled(t);
        txtTenNCC.setEnabled(t);
        txtDiaChi.setEnabled(t);
        txtEmail.setEnabled(t);
        txtWeb.setEnabled(t);
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
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtWeb.setText("");
    }
    
     // Phương thức kiểm tra xem email có đúng định dạng không
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
     // Phương thức kiểm tra xem URL có đúng định dạng không
    public static boolean isValidURL(String url) {
        String urlRegex = "^(http(s)?://)?([\\w-]+\\.)+[\\w-]+(/[\\w- ;,./?%&=]*)?$";
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
    
     private boolean kiemTraNhapDayDu()
    {
        //Kiểm tra nhập đầy đủ chưa
        if ( txtMaNCC.getText().isEmpty() || txtTenNCC.getText().isEmpty() || txtDiaChi.getText().isEmpty() || txtEmail.getText().isEmpty() || txtSDT.getText().isEmpty() || txtWeb.getText().isEmpty())
        {
            Message.showMessageError("Hãy nhập đầy đủ thông tin");
            return false;
        }
        else if (!isValidURL(txtWeb.getText())) //Kiểm tra web hợp lệ
        {
            Message.showMessageError("Website không hợp lệ.");
            txtWeb.requestFocusInWindow(); 
            return false;
        }
        else if (txtSDT.getText().length() < 10) // Kiểm tra KHI RỜI ĐI nếu số điện thoại có ít hơn 11 số
        {
           
            Message.showMessageError( "Số điện thoại không hợp lệ");
            txtSDT.requestFocusInWindow();
            return false;
        }
        else if(!isValidEmail(txtEmail.getText())) //Kiểm tra email hợp lệ
        {
            Message.showMessageError("Email không hợp lệ.");
            txtEmail.requestFocusInWindow();
            return false;
        }
        else 
            return true;
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

            MessageQuestion messquestion = new MessageQuestion(Main.getFrames()[0], true, GoogleMaterialDesignIcons.HELP);
            messquestion.showMessage(message);
            
            if (messquestion.isOk()) 
            {
                NhaCungCap l = chuyenDoiTextBoxSangDoiTuong();
                if( flag == 1 )
                {
                    //Lấy mã nhà cung cấp để trả về form trước
                    maNCC_new= txtMaNCC.getText();
                    sdt_new= txtSDT.getText();
                    tenNCC_new= txtTenNCC.getText();
                    
                    dsncc.themNCC(l);
                    flag= 0; //Để bấm các tính năng khác
                    xoaTextBox();//Khi vừa thêm xong 1. trỏ đúng đối tg vừa thêm.    ????????????????????????????????????????
                    anHienButton(true); //2. Nút lưu khóa, các nút khác hiện. 
                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Thêm thành công");
                    
                    if (parentFrame != null) {
                        parentFrame.dispose();
                    }
                }

                if (flag == 2 )
                {
                    dsncc.suaNCC(l);
                    flag= 0;
                    xoaTextBox();//Khi vừa sửa xong 1. trỏ đúng đối tg vừa sửa. 
                    anHienButton(true); //2. Nút lưu khóa, các nút khác hiện. 
                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Sửa thành công");
                }

                if (flag == 3)
                {
                    dsncc.xoaNCC(l);
                    xoaTextBox();
                    //Khi xóa xong, 1. Nút lưu vẫn mở, các nút khác vẫn khóa (cho ng dùng xóa tiếp đôi tg khác. (cho đến khi ấn hủy). 2. 
                    //anHienText(true); //khi xóa xong thì vẫn còn hiện
                    Message.showMessageSuccess( "Xóa thành công");
                }

                //flag= 0;
                //xoaTextBox();
                dsncc = new DSNhaCungCap();
                dsncc_List = dsncc.layDSNhaCC("");
                hienThiTable();
                //anHienText(true);
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    public static String taoMaTuDong() {
        String key = "NCC";
        
        try {
            KetNoi kn = new KetNoi();
            String sql = "Select TOP 1 MANCC from NHACUNGCAP WHERE MANCC LIKE 'NCC%' ORDER BY MANCC DESC";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (!rs.next()) {
                key += "001";
            } else {
                String maBanDau = rs.getString("MANCC");
                String sott = maBanDau.substring(3);
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

        txtTenNCC.requestFocus();
        flag = 1;
        String ma= taoMaTuDong();
        txtMaNCC.setText(ma);
        //xoaTextBox(); //Phải xóa textbox trước (không xóa mã)
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtWeb.setText("");
        
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

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(txtSearch.isSelected()) {
            int opt = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText().trim() + "%";
            if(opt == 0) {
                dsncc_List = dsncc.layDSNhaCC("and TENNCC like N'"+text+"' ");
            }else if(opt == 1) {
                dsncc_List = dsncc.layDSNhaCC("and DIACHI like N'"+text+"' ");
            }else if(opt == 2) {
                dsncc_List = dsncc.layDSNhaCC("and EMAIL like N'"+text+"' ");
            }else if(opt == 3) {
                dsncc_List = dsncc.layDSNhaCC("and SDT like N'"+text+"' ");
            }else if(opt == 4) {
                dsncc_List = dsncc.layDSNhaCC("and WEBSITE like N'"+text+"' ");
            }
        }
        hienThiTable();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtTenNCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenNCCKeyTyped
        char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự là chữ, hoặc space, hoặc nút xóa (ko chứa số, kí tự đặc biệt)  
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER && c != ' ') {
           
            evt.consume();
            // Hiển thị thông báo lỗi
            Message.showMessageError("Tên nhà cung cấp chỉ được chứa chữ cái!");
        }
        
    }//GEN-LAST:event_txtTenNCCKeyTyped


    
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private swing.table.Table tblNhaCC;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSDT;
    private swing.textfield.TextFieldSearchOption txtSearch;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables
}
