
package ql_cuahang_nhaccu_form;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.dateTime;
import dialog.Message;
import dialog.MessageQuestion;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.DateTimeSyntax;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import main.Main;
import ql_cuahang_nhaccu_class.CTPhieuNhap;
import ql_cuahang_nhaccu_class.DSCTKhuyenMai;
import ql_cuahang_nhaccu_class.DSCTPhieuNhap;
import ql_cuahang_nhaccu_class.DSNhaCungCap;
import ql_cuahang_nhaccu_class.DSNhanVien;
import ql_cuahang_nhaccu_class.DSPhieuNhap;
import ql_cuahang_nhaccu_class.DSSanPham;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.NhaCungCap;
import ql_cuahang_nhaccu_class.NhanVien;
import ql_cuahang_nhaccu_class.PhieuNhap;
import ql_cuahang_nhaccu_class.SanPham;
import static ql_cuahang_nhaccu_form.Frm_DSSanPham.gianhap;
import static ql_cuahang_nhaccu_form.Frm_DSSanPham.hinhanh;
import static ql_cuahang_nhaccu_form.Frm_DSSanPham.masp;
import static ql_cuahang_nhaccu_form.Frm_DSSanPham.tensp;
import swing.icon.GoogleMaterialDesignIcons;

public class Frm_PhieuNhap extends javax.swing.JPanel {
    
    String[] Header = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá nhập"};
    DefaultTableModel model = new DefaultTableModel(Header, 0);
    
    DSCTPhieuNhap dsCTPNH;
    ArrayList<CTPhieuNhap> dsCTPNH_List;
    DSSanPham dssp;
    DSPhieuNhap dspn; 
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    int vitri = 0;
    String tacVu="Xem"; //đánh dấu chỉ mới load cbo chứ chưa chọn để tránh kích hoạt actionPerform 
    
    private FormMain main;
    public Frm_PhieuNhap() {
        initComponents();
        setOpaque(false);
        tblCTPhieuNhap.fixTable(jScrollPane1);
                
        //LOAD DỮ LIỆU LÊN CBO NHÂN VIÊN VÀ CBO NCC
        hienThiCboNhanVien();
        hienThiCboNCC();
        
        //CÁC TRƯỜNG LUÔN KHÓA
        txtMaPNH.setEnabled(false);
        txtSDT.setEnabled(false);
        txtNgayNhap.setEnabled(false);
        txtMaSP.setEnabled(false);
        txtTenSP.setEnabled(false);
        txtGiaNhap1.setEnabled(false);
        txtTongTien.setEnabled(false);
        
        //BAN ĐẦU: Chỉ có nút tạo phiếu, xem ds phiếu là mở; còn lại khóa hết      
        btnNCC.setEnabled(false);
        btnSanPham.setEnabled(false);
        btnThem.setEnabled(false);
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(false);
        btnIn.setEnabled(false);
        
        cboNCC.setEnabled(false);
        cboNCC.setSelectedIndex(-1);
        cboNhanVien.setEnabled(false);
        cboNhanVien.setSelectedIndex(-1);
        txtSoLuong.setEnabled(false);
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboSuggestionUI1 = new swing.combobox.ComboSuggestionUI();
        btnTaoPN = new swing.Button();
        btnXemDSPhieuNhap = new swing.Button();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaPNH = new javax.swing.JTextField();
        txtNgayNhap = new javax.swing.JTextField();
        btnNCC = new swing.Button();
        cboNCC = new swing.combobox.ComboBoxSuggestion();
        cboNhanVien = new swing.combobox.ComboBoxSuggestion();
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        imageAvatar1 = new swing.ImageAvatar();
        lbl_Hinh = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        btnSanPham = new swing.Button();
        txtSoLuong = new javax.swing.JTextField();
        btnThem = new swing.Button();
        btnXoa = new swing.Button();
        btnCapNhat = new swing.Button();
        txtGiaNhap1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTPhieuNhap = new swing.table.Table();
        btnLuu = new swing.Button();
        btnIn = new swing.Button();
        jLabel18 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();

        btnTaoPN.setBackground(new java.awt.Color(123, 110, 255));
        btnTaoPN.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoPN.setText("Tạo Phiếu Nhập");
        btnTaoPN.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTaoPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPNActionPerformed(evt);
            }
        });

        btnXemDSPhieuNhap.setBackground(new java.awt.Color(123, 110, 255));
        btnXemDSPhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnXemDSPhieuNhap.setText("Xem DS Phiếu Nhập");
        btnXemDSPhieuNhap.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXemDSPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDSPhieuNhapActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mã phiếu nhập:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Ngày lập:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Nhà cung cấp:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Nhân viên:");

        txtMaPNH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtNgayNhap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnNCC.setBackground(new java.awt.Color(123, 110, 255));
        btnNCC.setForeground(new java.awt.Color(255, 255, 255));
        btnNCC.setText("...");
        btnNCC.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNCCActionPerformed(evt);
            }
        });

        cboNCC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNCCActionPerformed(evt);
            }
        });

        cboNhanVien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("SĐT Nhà cung cấp:");

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaPNH)
                    .addComponent(txtNgayNhap)
                    .addComponent(cboNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDT))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(cboNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        imageAvatar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Hinh.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_Hinh.setText("...");
        imageAvatar1.add(lbl_Hinh);
        lbl_Hinh.setBounds(0, 0, 170, 160);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("Mã sản phẩm:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText("Tên sản phẩm:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setText("Giá nhập:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setText("Số lượng:");

        txtMaSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTenSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnSanPham.setBackground(new java.awt.Color(123, 110, 255));
        btnSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnSanPham.setText("Chọn sản phẩm");
        btnSanPham.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyTyped(evt);
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

        btnXoa.setBackground(new java.awt.Color(123, 110, 255));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(123, 110, 255));
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        txtGiaNhap1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(txtTenSP)
                    .addComponent(txtGiaNhap1)
                    .addComponent(txtMaSP))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtGiaNhap1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách sản phẩm của phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblCTPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTPhieuNhap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblCTPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTPhieuNhap);

        btnLuu.setBackground(new java.awt.Color(123, 110, 255));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnIn.setBackground(new java.awt.Color(123, 110, 255));
        btnIn.setForeground(new java.awt.Color(255, 255, 255));
        btnIn.setText("In");
        btnIn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setText("Tổng tiền:");

        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 632, Short.MAX_VALUE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTaoPN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXemDSPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemDSPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //HIỂN THỊ CBO NHÂN VIÊN
    private void hienThiCboNhanVien() {
        DefaultComboBoxModel modelcbo = (DefaultComboBoxModel)cboNhanVien.getModel();
        DSNhanVien dsnv = new DSNhanVien();
        for(NhanVien ncc: dsnv.layDSNhanVien("")) {
            Object o = ncc.tenNV;
            modelcbo.addElement(o);
        }
    }
    
    //HIỂN THỊ CBO NHÀ CUNG CẤP
    private void hienThiCboNCC() {
        DefaultComboBoxModel modelcbo = (DefaultComboBoxModel)cboNCC.getModel();
        DSNhaCungCap dsnv = new DSNhaCungCap();
        for(NhaCungCap ncc: dsnv.layDSNhaCC("")) {
            Object o = ncc.tenNCC;
            modelcbo.addElement(o);
        }
    }
    
    //TẠO MÃ TỰ ĐỘNG THEO PHIẾU NHẬP HÀNG --> THỂ HIỆN SỐ PHIẾU NHẬP CỦA 1 NHÀ CUNG CẤP
    public String taoMaTuDong(String maNCC_new) {
           
        String key = maNCC_new.trim();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String currentDate= dateFormat.format(new Date());
        key= key + '-' ; //NCC001-
        
        try {
            KetNoi kn = new KetNoi();
            String sql = "Select TOP 1 MAPNH from PHIEUNHAPHANG WHERE MAPNH LIKE '"+ maNCC_new.trim() + "%' ORDER BY MAPNH DESC"; //NCC001-240310-0008  
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (!rs.next()) {
                key += currentDate + "-0001";
            } else {
                String maBanDau = rs.getString("MAPNH");
                String sott = maBanDau.substring(14);
                int num = Integer.parseInt(sott.trim()) + 1;
                if (num < 10)
                    key += currentDate + "-000" + num;
                else if (num < 100)
                    key += currentDate + "-00" + num;
                else if (num <1000)
                    key += currentDate + "-0" + num; 
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
    
    //HIỂN THỊ CHI TIẾT PHIẾU NHẬP LÊN BẢNG
    private void hienThiTableCTPhieuNhap(String mapn) {
        dsCTPNH = new DSCTPhieuNhap();
        dsCTPNH_List = dsCTPNH.layDSCTPhieuNhap(mapn);  //Lấy chi tiết phiếu nhập 
        
        //Reset model
        String[] Header = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá nhập"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        
        for(CTPhieuNhap l: dsCTPNH_List) {
            //Dựa vào mã sp lấy được --> gọi hàm lấy ra 1 sp --> lấy ra tên sản phẩm
            DSSanPham dssp = new DSSanPham();
            SanPham sp = new SanPham();
            sp= dssp.laySanPham(l.maSP);
            
            Object[] o = {l.maSP, sp.tenSP , l.soLuong, l.donGia};
            model.addRow(o);
        } 
        
        //Tính tổng tiền --> duyệt từng dòng trên bảng và tính tổng tiền
        int tongTien= 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            int thanhTien = Integer.parseInt(model.getValueAt(i, 2).toString()) * Integer.parseInt(model.getValueAt(i, 3).toString());
            tongTien += thanhTien;
        }
        txtTongTien.setText(String.valueOf(tongTien));
                    
        tblCTPhieuNhap.setModel(model);
        if (dsCTPNH_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dsCTPNH_List.size() - 1);
            tblCTPhieuNhap.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
        }
        
    }

   // String maNCC_new;
    
    //KHI NHẤP VÀO NÚT ... NHÀ CUNG CẤP THÌ BẬT FORM NHÀ CUNG CẤP
    private void btnNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNCCActionPerformed
        JFrame panel = new JFrame();
        Frm_NhaCungCap f = new Frm_NhaCungCap(panel);
        panel.setSize(1280, 720);
        panel.getContentPane().add(f);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);

        panel.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) { //Khi frm đóng thì trả về mã, sđt và tên nhà cung cấp vừa tạo
                if (Frm_NhaCungCap.maNCC_new != null) {
                    txtMaPNH.setText(taoMaTuDong(Frm_NhaCungCap.maNCC_new)); //tạo mã tự động 
                    txtSDT.setText(Frm_NhaCungCap.sdt_new);
                    cboNCC.setSelectedItem(Frm_NhaCungCap.tenNCC_new);
                    
                }
            }
        });
    }//GEN-LAST:event_btnNCCActionPerformed
    
    public static String maNCC_sent=""; //gửi mã ncc đến form ds sản phẩm (chứa sp thuộc ncc đó) và frm sản phẩm (để tạo sp theo ncc đó)
    
    //KHI NHẤP VÀO NÚT ... SẢN PHẨM THÌ BẬT FORM DS SẢN PHẨM --> XEM DS SẢN PHẨM THUỘC NCC ĐÓ
    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        
        txtSoLuong.setText("");
        
        JFrame panel = new JFrame();
        
        
        //KHỞI TẠO BIẾN MANCC STATIC ĐỂ GỬI ĐẾN FORM DS SẢN PHẨM THUỘC NHÀ CUNG CẤP ĐÓ
        DSNhaCungCap dsncc = new DSNhaCungCap(); 
        for (NhaCungCap ncc : dsncc.layDSNhaCC("")) {
            if (ncc.tenNCC.equals(cboNCC.getSelectedItem())) { //Dựa vào tenNCC lấy mã nhà cung cấp tương ứng 
                maNCC_sent= ncc.maNCC; 
                break;
            }
        } 
        
        Frm_DSSanPham f = new Frm_DSSanPham();
        panel.setSize(1280, 720);
        panel.getContentPane().add(f);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);

        panel.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) { //Khi frm đóng thì trả về mã, tên, giá nhập sp mà mình vừa chọn ở frm trước
                if (Frm_DSSanPham.masp != null) {
                    txtMaSP.setText(Frm_DSSanPham.masp);
                    txtTenSP.setText(Frm_DSSanPham.tensp);
                    
                    int giaNhapInt = Frm_DSSanPham.gianhap;
                    txtGiaNhap1.setText(String.valueOf(giaNhapInt));
                    Uploadhinh(Frm_DSSanPham.hinhanh);
                    
                    //ẨN HIỆN
                    btnThem.setEnabled(true); //Nút thêm mở
                    btnCapNhat.setEnabled(false);
                    btnXoa.setEnabled(false);
                    btnLuu.setEnabled(false);
                    btnIn.setEnabled(false);

                    txtSoLuong.setEnabled(true); //Số lượng mở ra cho nhập
                }
            }
        });
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnTaoPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPNActionPerformed
        
        //đánh dấu tác vụ
        tacVu= "Tao";
                
        //Tạo ngày lập
        String currentDate = dateFormat.format(new Date()); 
        txtNgayNhap.setText(currentDate);
      
               
        // RÀNG BUỘC   
        btnNCC.setEnabled(true); //nút tạo ncc mở
        btnSanPham.setEnabled(true); //nút sp mở
        btnThem.setEnabled(false);
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(false);
        btnIn.setEnabled(true); //nút in mở
        cboNCC.setEnabled(true); //cbo ncc mở
        cboNCC.setSelectedIndex(-1);
        cboNhanVien.setEnabled(true); //cbo nhân viên mở
        cboNhanVien.setSelectedIndex(-1);
        txtSoLuong.setEnabled(false);
        //Xóa textbox
        txtMaPNH.setText("");
        txtSDT.setText("");
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGiaNhap1.setText("");
        txtSoLuong.setText("");
        txtTongTien.setText("");
        lbl_Hinh.setIcon(null);
        
        //Reset model
        String[] Header = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá nhập"};
        model = new DefaultTableModel(Header, 0);
        tblCTPhieuNhap.setModel(model);   
                
    }//GEN-LAST:event_btnTaoPNActionPerformed
                             
    //NÚT XEM DS TẤT CẢ PHIẾU NHẬP HIỆN CÓ
    private void btnXemDSPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDSPhieuNhapActionPerformed

        // RÀNG BUỘC   
        btnNCC.setEnabled(false);
        btnSanPham.setEnabled(false);
        btnThem.setEnabled(false);
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(false);
        btnIn.setEnabled(true); //nút in mở
        cboNCC.setEnabled(false);
        cboNCC.setSelectedIndex(-1);
        cboNhanVien.setEnabled(false);
        cboNhanVien.setSelectedIndex(-1);
        txtSoLuong.setEnabled(false);
        //Xóa textbox
        txtMaPNH.setText("");
        txtNgayNhap.setText("");
        txtSDT.setText("");
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGiaNhap1.setText("");
        txtSoLuong.setText("");
        txtTongTien.setText("");
        //Reset model
        String[] Header = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá nhập"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        tblCTPhieuNhap.setModel(model);
                
        
        tacVu= "Xem";
        
        //Gọi form DS PHIẾU NHẬP
        JFrame panel = new JFrame();
        Frm_DSPhieuNhap f = new Frm_DSPhieuNhap();
        panel.setSize(1280, 720);
        panel.getContentPane().add(f);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);

        //Khi form xem ds phiếu nhập đóng
        panel.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (Frm_DSPhieuNhap.mapn != null) {
                    txtMaPNH.setText(Frm_DSPhieuNhap.mapn);
                    txtNgayNhap.setText(Frm_DSPhieuNhap.ngaynhap);    
                    
                    //lấy thông tin từ form ds phiếu nhập đổ về các trưởng thông tin phiếu nhập
                    txtMaPNH.setText(Frm_DSPhieuNhap.mapn);
                    txtNgayNhap.setText(Frm_DSPhieuNhap.ngaynhap);
                    txtSDT.setText(Frm_DSPhieuNhap.sdtncc);   
                    cboNCC.setSelectedItem(Frm_DSPhieuNhap.tenncc);
                    cboNhanVien.setSelectedItem(Frm_DSPhieuNhap.tennv);
                    
                    hienThiTableCTPhieuNhap(Frm_DSPhieuNhap.mapn); //dựa vào mã pn lấy chi tiết phiếu nhập hiển thị bảng chi tiết
                    
                    
                
                }
            }
        });
    }//GEN-LAST:event_btnXemDSPhieuNhapActionPerformed

    //HÀM ĐỂ THÊM SẢN PHẨM XUỐNG BẢNG CHI TIẾT (CHƯA THÊM VÀO CSDL)
    int tongtien = 0;
    private void themSPXuongBang(String masp) {
        SanPham s;
        dssp = new DSSanPham();
        s = dssp.laySanPham(masp);
        //Thêm vào bảng model
        Object[] o = {s.maSP, s.tenSP, txtSoLuong.getText(), s.giaBanLe};
        model.addRow(o);
        
        tblCTPhieuNhap.setModel(model); 
        tongtien+= s.giaBanLe * Integer.parseInt(txtSoLuong.getText());
        txtTongTien.setText(String.valueOf(tongtien));
        
        //KHI THÊM VÀO BẢNG MODEL XONG, THÌ XÓA TEXT
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtTenSP.setText("");
        txtSoLuong.setText("");
        lbl_Hinh.setIcon(null);
    }
    
    //KIỂM TRA XEM SẢN PHẨM ĐÃ NHẬP ĐẦY ĐỦ THÔNG TIN CHƯA
    private boolean checkFrmSanPham()
    {
        if ( txtTenSP.getText().isEmpty() || txtMaSP.getText().isEmpty() || txtSoLuong.getText().isEmpty() || txtGiaNhap1.getText().isEmpty() )
        {
            //Thông báo nhập đầy đủ
            Message.showMessageError("Hãy nhập đầy đủ thông tin sản phẩm");
            return false;
        }
        else if( Integer.parseInt(txtSoLuong.getText()) < 0 || Integer.parseInt(txtGiaNhap1.getText()) < 0)
        {
            Message.showMessageError("Giá trị phải lớn hơn 0");
            return false;
        }
        else if(lbl_Hinh.getIcon() == null)
        {
            Message.showMessageError("Hình ảnh trống!");
            return false;
        }
        else
        {
            return true;
           
        }
    }
    
    //NÚT THÊM SẢN PHẨM XUỐNG BẢNG CHI TIẾT
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        //flag = 1;
        tacVu= "Them";
        if(checkFrmSanPham()== true)
        {
            //kiểm tra mã sản phẩm (txtSP.getText() ) có nằm trong model chưa, nếu có thì
            //số lượng + số lượng mới
            //ngược lại thfi thêm mới
            
            //THỰC THI HÀM THÊM SẢN PHẨM XUỐNG BẢNG
            int soLuongMoi = Integer.parseInt(txtSoLuong.getText());
            boolean exists = false;

            // Duyệt qua các hàng trong bảng để kiểm tra mã sản phẩm có tồn tại chưa
            for (int i = 0; i < model.getRowCount(); i++) {

                String maSPTrongBang = model.getValueAt(i, 0).toString().trim();
                if (maSPTrongBang.equals(txtMaSP.getText().trim())) {
                   
                    // Nếu mã sản phẩm đã tồn tại, cập nhật số lượng 
                    int soLuongHienTai = Integer.parseInt(model.getValueAt(i, 2).toString());
                    int soLuongTong = soLuongHienTai + soLuongMoi;

                    model.setValueAt(soLuongTong, i, 2);
                    int giaBanLe = Integer.parseInt(model.getValueAt(i, 3).toString().trim());
                    tongtien += giaBanLe * soLuongMoi;
                    txtTongTien.setText(String.valueOf(tongtien));
                    btnLuu.setEnabled(true); //Mở nút Lưu
                    exists = true;
                    break;
                }
            }

            // Nếu mã sản phẩm chưa tồn tại, thêm sản phẩm mới vào bảng
            if (!exists) {
                themSPXuongBang(txtMaSP.getText().trim());
                
                //xóa hết txt
                txtMaSP.setText("");
                txtTenSP.setText("");
                txtGiaNhap1.setText("");
                txtSoLuong.setText("");
                btnLuu.setEnabled(true); //Mở nút Lưu
            }
        }
        
        

    }//GEN-LAST:event_btnThemActionPerformed

    private void suaSPTuBang(String masp, int vitri) {
        model.setValueAt(masp, vitri, 0);
        model.setValueAt(txtTenSP.getText(), vitri, 1);
        model.setValueAt(txtSoLuong.getText(), vitri, 2);
        model.setValueAt(txtGiaNhap1.getText(), vitri, 3);      
    }
     
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if(checkFrmSanPham()== true)
        {
            //THỰC THI HÀM CẬP NHẬT LẠI SẢN PHẨM XUỐNG BẢNG
            int vitri= tblCTPhieuNhap.getSelectedRow();
            suaSPTuBang(txtMaSP.getText(), vitri);
            
            //xóa hết txt
            txtMaSP.setText("");
            txtTenSP.setText("");
            txtGiaNhap1.setText("");
            txtSoLuong.setText("");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed


//--------------------------------HÀM HIỂN THỊ THÔNG TIN SẢN PHẨM KHI MOUSE CLICK DÒNG TRÊN MODEL----------------------------------------

    //HIỂN THỊ THÔNG TIN SẢN PHẨM DỰA VÀO BẢNG (TỨC LÀ CÁC SP CHƯA CÓ TRONG CHI TIẾT PHIẾU NHẬP, CHỈ LÀ DỮ LIỆU TẠM TRÊN BẢNG)
    private void hienThiThongTinSPTheoBang(int vitri) 
    {
        txtMaSP.setText(model.getValueAt(vitri, 0).toString());
        txtTenSP.setText(model.getValueAt(vitri, 1).toString());
        txtSoLuong.setText(model.getValueAt(vitri, 2).toString());
        txtGiaNhap1.setText(model.getValueAt(vitri, 3).toString());
        
        //Dựa vào mã sp lấy được --> gọi hàm lấy ra 1 sp --> lấy ra hình ảnh
        DSSanPham dssp = new DSSanPham();
        SanPham sp = new SanPham();
        sp= dssp.laySanPham(model.getValueAt(vitri, 0).toString()); //truyền vào mã sp, lấy ra sp
        Uploadhinh(sp.hinhAnh);
        
    }
    
    //HIỂN THỊ THÔNG TIN SẢN PHẨM DỰA VÀO CHI TIẾT PHIẾU NHẬP (TỨC LÀ CÁC SP ĐÃ ĐƯỢC THÊM VÀO CT PHIẾU NHẬP RỒI)
    private void hienThiThongTinSPTheoCTPhieuNhap(int vitri) {
        
        CTPhieuNhap ctpn = dsCTPNH_List.get(vitri);
        
        txtMaSP.setText(ctpn.maSP);
        txtGiaNhap1.setText(String.valueOf(ctpn.donGia));
        txtSoLuong.setText(String.valueOf(ctpn.soLuong));
        
        dssp = new DSSanPham();
        SanPham sp = dssp.laySanPham(ctpn.maSP);
        txtTenSP.setText(sp.tenSP);
        Uploadhinh(sp.hinhAnh);
    }
    
    private void tblCTPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPhieuNhapMouseClicked
        
        if( tacVu== "Xem") //TH1: xem sp trong phiếu nhập được lấy từ nút XEM DS Phiếu nhập
        {
            vitri = tblCTPhieuNhap.getSelectedRow();
            hienThiThongTinSPTheoCTPhieuNhap(vitri);

        }else //TH2: xem những sp chưa lưu vào phiếu nhập
        {
            vitri = tblCTPhieuNhap.getSelectedRow();
            hienThiThongTinSPTheoBang(vitri);

            //Nếu có chọn dòng thì hiện nút sửa xóa
            btnCapNhat.setEnabled(true);
            btnXoa.setEnabled(true);
            btnThem.setEnabled(false);
        }
        
        
        
    }//GEN-LAST:event_tblCTPhieuNhapMouseClicked

    //HÀM ĐỂ HIỂN THỊ HÌNH LÊN FORM
    void Uploadhinh(String hinh)
    {
        ImageIcon image1=new ImageIcon("src\\Image\\"+hinh); //hinh= tenfile/tenhinh
        //System.out.println("" + image1); //kết quả nó in ra là: src\Image\SPNCC0010002.png
        Image im=image1.getImage();
        ImageIcon icon=new ImageIcon(im.getScaledInstance(lbl_Hinh.getWidth(), lbl_Hinh.getHeight(), im.SCALE_SMOOTH));
        lbl_Hinh.setIcon(icon);
    }
    
    //KIỂM TRA XEM FORM ĐÃ NHẬP ĐẦY ĐỦ THÔNG TIN CHƯA
    private boolean checkFrm()
    {
        if ( txtMaPNH.getText().isEmpty() || txtNgayNhap.getText().isEmpty() || cboNhanVien.getSelectedIndex() == -1 || model.getRowCount() == 0 )
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
    
    private PhieuNhap chuyenDoiTextBoxSangDoiTuong()
    {
        PhieuNhap pn = new PhieuNhap();
        pn.maPNH = txtMaPNH.getText();
       
        DSNhaCungCap dskh = new DSNhaCungCap();
        NhaCungCap k = dskh.timNhaCungCap(txtSDT.getText());
        pn.maNCC = k.maNCC;
        
        int index = -1;
        DSNhanVien dsnv = new DSNhanVien();
        for(NhanVien ncc: dsnv.layDSNhanVien("")) {
            ++index;
            if(index == cboNhanVien.getSelectedIndex()){
                pn.maNV = ncc.maNV;
            }
        }
                  
        try {
            Date parsedDate = dateFormat.parse(txtNgayNhap.getText());
            pn.ngayNhap = new Timestamp(parsedDate.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Frm_PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return pn;
    }
    
    //NÚT LƯU XUỐNG DATABASE
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        tacVu= "Luu";
        //KIỂM TRA: Nhập đầy đủ các trường mới được lưu
        if ( checkFrm() )
        {
            String message = "Bạn có chắc chắn muốn thêm không ";
            
            MessageQuestion mess = new MessageQuestion(Main.getFrames()[0], true, GoogleMaterialDesignIcons.HELP);
            mess.showMessage(message);
            
            if (mess.isOk()) {
                // Thực hiện hành động lưu
                PhieuNhap pn = chuyenDoiTextBoxSangDoiTuong();
                dspn = new DSPhieuNhap();
                dspn.themPhieuNhap(pn);

                CTPhieuNhap ctpn;
                dsCTPNH = new DSCTPhieuNhap();
                for(int i = 0; i < model.getRowCount(); i++) {
                    String masp = model.getValueAt(i, 0).toString();
                    int soluong = Integer.parseInt(model.getValueAt(i, 2).toString());
                    int dongia = Integer.parseInt(model.getValueAt(i, 3).toString());
                    dsCTPNH.themCTPhieuNhap(txtMaPNH.getText(), masp, soluong, dongia);
                }
                
                mess.showMessageSuccess("Thêm thành công");
                //Ẩn Hiện    
                btnNCC.setEnabled(false);
                btnSanPham.setEnabled(false);
                btnThem.setEnabled(false);
                btnCapNhat.setEnabled(false);
                btnXoa.setEnabled(false);
                btnLuu.setEnabled(false);
                btnIn.setEnabled(false);

                cboNCC.setEnabled(false);
                cboNCC.setSelectedIndex(-1);
                cboNhanVien.setEnabled(false);
                cboNhanVien.setSelectedIndex(-1);
                txtSoLuong.setEnabled(false);
                
                //Xóa textbox
                txtMaPNH.setText("");
                txtNgayNhap.setText("");
                txtSDT.setText("");
                txtMaSP.setText("");
                txtTenSP.setText("");
                txtGiaNhap1.setText("");
                txtSoLuong.setText("");
                txtTongTien.setText("");
                
                //Reset model
                String[] Header = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá nhập"};
                DefaultTableModel model = new DefaultTableModel(Header, 0);
                tblCTPhieuNhap.setModel(model);
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    
    private void xoaSPTuBang(int vitri) {
        if (vitri >= 0 && vitri < model.getRowCount()) {
            // Lấy giá trị số lượng và đơn giá từ dòng cần xóa
            int soLuong = Integer.parseInt(model.getValueAt(vitri, 2).toString().trim());
            int donGia = Integer.parseInt(model.getValueAt(vitri, 3).toString().trim());

            // Cập nhật tổng tiền
            tongtien -= soLuong * donGia;
            txtTongTien.setText(String.valueOf(tongtien));

            // Xóa dòng khỏi model
            model.removeRow(vitri);

            tblCTPhieuNhap.setModel(model);
        } else {
            System.out.println("Vị trí không hợp lệ");
        }
    }
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        tacVu="XoaSP";
        
        xoaSPTuBang(tblCTPhieuNhap.getSelectedRow());
        
        //xóa hết txt
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGiaNhap1.setText("");
        txtSoLuong.setText("");
        
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void cboNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNCCActionPerformed
        //Tạo mã phiếu nhập và sdt
        if(tacVu == "Tao")
        {
            DSNhaCungCap dsncc = new DSNhaCungCap(); //Dựa vào tenNCC lấy mã nhà cung cấp tương ứng 
            for (NhaCungCap ncc : dsncc.layDSNhaCC("")) {
                if (ncc.tenNCC.equals(cboNCC.getSelectedItem())) {
                    txtMaPNH.setText(taoMaTuDong(ncc.maNCC)); //tạo mã
                    txtSDT.setText(ncc.sDT);
                    break;
                }
            }
            
            
        }
        
        //Xóa textbox
        //txtMaPNH.setText("");
        //txtSDT.setText("");
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGiaNhap1.setText("");
        txtSoLuong.setText("");
        txtTongTien.setText("");
        
        //Reset model
        String[] Header = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá nhập"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        tblCTPhieuNhap.setModel(model); 
               
    }//GEN-LAST:event_cboNCCActionPerformed

    private void txtSoLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyTyped
        char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự không phải là số (trừ nút xóa) hoặc độ dài vượt quá 11 ký tự
        if ((!Character.isDigit(c) && c != evt.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER)) {
            
            evt.consume(); // Hủy sự kiện nhập vào
            // Đặt biên đỏ cho trường văn bản
            //txtSDT.setBorder(BorderFactory.createLineBorder(Color.RED));
            Message.showMessageError("Số lượng không hợp lệ.");
            
        }
    }//GEN-LAST:event_txtSoLuongKeyTyped
    
    //XEM DS 
    //int checkUpdateTable;

    //String previousAction = "";
    private boolean showMessageQuestion(String message) {
        Message obj = new Message(Main.getFrames()[0], true, GoogleMaterialDesignIcons.CHECK_CIRCLE);
        obj.showMessage(message);
        return obj.isOk();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnCapNhat;
    private swing.Button btnIn;
    private swing.Button btnLuu;
    private swing.Button btnNCC;
    private swing.Button btnSanPham;
    private swing.Button btnTaoPN;
    private swing.Button btnThem;
    private swing.Button btnXemDSPhieuNhap;
    private swing.Button btnXoa;
    private swing.combobox.ComboBoxSuggestion cboNCC;
    private swing.combobox.ComboBoxSuggestion cboNhanVien;
    private swing.combobox.ComboSuggestionUI comboSuggestionUI1;
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Hinh;
    private swing.table.Table tblCTPhieuNhap;
    private javax.swing.JTextField txtGiaNhap1;
    private javax.swing.JTextField txtMaPNH;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
