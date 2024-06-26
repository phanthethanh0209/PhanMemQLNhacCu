
package ql_cuahang_nhaccu_form;


import com.formdev.flatlaf.util.StringUtils;
import dialog.Message;
import dialog.MessageQuestion;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.text.Normalizer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import main.Main;
import ql_cuahang_nhaccu_class.DSLoaiSanPham;
import ql_cuahang_nhaccu_class.DSNhaCungCap;
import ql_cuahang_nhaccu_class.DSSanPham;
import ql_cuahang_nhaccu_class.DSThuongHieu;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.LoaiSanPham;
import ql_cuahang_nhaccu_class.NhaCungCap;
import ql_cuahang_nhaccu_class.SanPham;
import ql_cuahang_nhaccu_class.ThuongHieu;
import swing.icon.GoogleMaterialDesignIcons;

public class Frm_SanPham extends javax.swing.JPanel {
    DSSanPham dssp;
    ArrayList<SanPham> dssp_List;
    int vitri = 0;

    
    boolean flag_FrmSP;
    public Frm_SanPham() {
        initComponents();
        
        //cờ đánh dấu để phân biệt form riêng, không phải từ nhà cung cấp qua
        flag_FrmSP= true;
        
       
        setOpaque(false);
        tblDSSP.fixTable(jScrollPane1);
        dssp = new DSSanPham();
        dssp_List = dssp.layDSSanPham("");
        hienThiTable();
        hienThiCboNCC(); 
        hienThiCboLoai();
        hienThiCboTH();
        
        //LUÔN KHÓA
        txtMaSP.setEnabled(false);
        txtGiaBanLe.setEnabled(false);
        txtGiaDB.setEnabled(false);
        txtGiaSi.setEnabled(false);
        txtSoLuong.setEnabled(false);
        
        //BAN ĐẦU: tất cả đều bị khóa, không thể thao tác gì ngoài THÊM/XÓA/SỬA hoặc XEM
        txtTenSP.setEnabled(false);
        txtMau.setEnabled(false);
        txtGiaNhap.setEnabled(false);
        txtTGBH.setEnabled(false);
        cboMaNCC.setSelectedIndex(-1);
        cboMaLoai.setSelectedIndex(-1);
        cboMaTH.setSelectedIndex(-1);
        lblHinh.setIcon(null);
        
        cboMaLoai.setEnabled(false);
        cboMaTH.setEnabled(false);
        cboMaNCC.setEnabled(false);
         
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        btnThem.setEnabled(true);
        btnLuu.setEnabled(false);
        btnChonHinh.setEnabled(false);
        
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtMau.setText("");
        txtSoLuong.setText("");
        txtGiaBanLe.setText("");
        txtGiaDB.setText("");
        txtGiaNhap.setText("");
        txtGiaSi.setText("");
        txtTGBH.setText("");
        lbThongBao.setText("Hãy chọn 1 thao tác");
        
        
        
    }
    
    //KHỞI TẠO BIẾN STATIC ĐỂ FORM DS SẢN PHẨM NHẬN THÔNG TIN TRẢ VỀ KHI ĐÓNG FORM
    private JFrame parentFrame;
    public static String masp_new = "";
    public static String tensp_new = "";
    public static int soluong_new = 0;
    public static int gianhap_new = 0;
    
    //KHỞI TẠO 1 FORM KHI TỪ FORM PHIẾU NHẬP QUA
    public Frm_SanPham(JFrame parentFrame) {
        initComponents();
        
        //cờ đánh dấu để phân biệt form riêng,= false tức là từ phiếu nhập qua
        flag_FrmSP= false;
        
        //Không cho sửa và xóa
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        
        setOpaque(false);
        tblDSSP.fixTable(jScrollPane1);
        dssp = new DSSanPham();
        dssp_List = dssp.layDSSanPham("");
        hienThiTable();
        hienThiCboNCC();
        hienThiCboLoai();
        hienThiCboTH();
        
        //LUÔN KHÓA
        txtMaSP.setEnabled(false);
        txtGiaBanLe.setEnabled(false);
        txtGiaDB.setEnabled(false);
        txtGiaSi.setEnabled(false);
        txtSoLuong.setEnabled(false);
        
        //BAN ĐẦU: tất cả đều bị khóa, không thể thao tác gì ngoài THÊM/XÓA/SỬA hoặc XEM
        txtTenSP.setEnabled(false);
        txtMau.setEnabled(false);
        txtGiaNhap.setEnabled(false);
        txtTGBH.setEnabled(false);
        cboMaNCC.setSelectedIndex(-1);
        cboMaLoai.setSelectedIndex(-1);
        cboMaTH.setSelectedIndex(-1);
        lblHinh.setIcon(null);
        
        cboMaLoai.setEnabled(false);
        cboMaTH.setEnabled(false);
        cboMaNCC.setEnabled(false);
         
        btnThem.setEnabled(true);
        btnLuu.setEnabled(false);
        btnChonHinh.setEnabled(false);
        
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtMau.setText("");
        txtSoLuong.setText("");
        txtGiaBanLe.setText("");
        txtGiaDB.setText("");
        txtGiaNhap.setText("");
        txtGiaSi.setText("");
        txtTGBH.setText("");
        lbThongBao.setText("Hãy chọn 1 thao tác");
        
        
        this.parentFrame = parentFrame;
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMau = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTGBH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtGiaDB = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGiaBanLe = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtGiaSi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Hinh = new swing.ImageAvatar();
        lblHinh = new javax.swing.JLabel();
        btnChonHinh = new swing.Button();
        cboMaTH = new swing.combobox.ComboBoxSuggestion();
        cboMaLoai = new swing.combobox.ComboBoxSuggestion();
        cboMaNCC = new swing.combobox.ComboBoxSuggestion();
        btnLuu = new swing.Button();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSSP = new swing.table.Table();
        btnThem = new swing.Button();
        btnXoa = new swing.Button();
        btnHuy = new swing.Button();
        btnSua = new swing.Button();
        lbThongBao = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mã sản phẩm:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Tên sản phẩm:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Nhà cung cấp:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Thương hiệu:");

        txtMaSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTenSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTenSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenSPKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Màu sắc:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Loại sản phẩm:");

        txtMau.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMauKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Số lượng tồn:");

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Thời gian bảo hành:");

        txtTGBH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTGBH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTGBHKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Giá nhập:");

        txtGiaNhap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGiaNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaNhapActionPerformed(evt);
            }
        });
        txtGiaNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGiaNhapKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Giá đăng bài:");

        txtGiaDB.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGiaDB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGiaDBKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("Giá bán lẻ:");

        txtGiaBanLe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGiaBanLe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGiaBanLeKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText("Giá sỉ:");

        txtGiaSi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGiaSi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGiaSiKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setText("Hình ảnh:");

        Hinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblHinh.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblHinh.setForeground(new java.awt.Color(255, 0, 51));
        lblHinh.setText("...");
        Hinh.add(lblHinh);
        lblHinh.setBounds(20, 10, 260, 160);

        btnChonHinh.setBackground(new java.awt.Color(123, 110, 255));
        btnChonHinh.setForeground(new java.awt.Color(255, 255, 255));
        btnChonHinh.setText("Chọn hình");
        btnChonHinh.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnChonHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChonHinhMouseClicked(evt);
            }
        });
        btnChonHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonHinhActionPerformed(evt);
            }
        });

        cboMaTH.setEditable(false);
        cboMaTH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cboMaLoai.setEditable(false);
        cboMaLoai.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboMaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaLoaiActionPerformed(evt);
            }
        });

        cboMaNCC.setEditable(false);
        cboMaNCC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboMaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaNCCActionPerformed(evt);
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
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaSi, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                            .addComponent(txtGiaDB, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiaBanLe)
                            .addComponent(txtGiaNhap)
                            .addComponent(txtSoLuong)
                            .addComponent(txtMau)
                            .addComponent(txtTenSP)
                            .addComponent(txtMaSP))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTGBH)
                                    .addComponent(cboMaTH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboMaLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboMaNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Hinh, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                        .addComponent(btnChonHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(53, 53, 53))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(cboMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(cboMaTH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(cboMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(txtTGBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaBanLe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtGiaDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtGiaSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Hinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblDSSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Mã loại", "Mã thương hiệu", "Mã NCC", "Màu sắc", "Số lương", "Thời gian bảo hành", "Giá nhập", "Giá bán lẻ", "Giá đăng bài", "Giá sỉ", "Hình ảnh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true
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
        if (tblDSSP.getColumnModel().getColumnCount() > 0) {
            tblDSSP.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblDSSP.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblDSSP.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblDSSP.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblDSSP.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        btnHuy.setBackground(new java.awt.Color(123, 110, 255));
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(123, 110, 255));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        lbThongBao.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lbThongBao.setForeground(new java.awt.Color(255, 0, 51));
        lbThongBao.setText("Hãy chọn 1 thao tác");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private SanPham chuyenDoiTextBoxSangDoiTuong()
    {
        SanPham sp = new SanPham();
        sp.maSP= txtMaSP.getText();
        sp.tenSP= txtTenSP.getText();
        sp.mauSac= txtMau.getText();
        sp.soLuong= Integer.parseInt(txtSoLuong.getText()) ;
        sp.giaBanLe= Integer.parseInt(txtGiaBanLe.getText());
        sp.giaDangBai= Integer.parseInt(txtGiaDB.getText());
        sp.giaNhap= Integer.parseInt(txtGiaNhap.getText());
        sp.giaSi= Integer.parseInt(txtGiaSi.getText());
        sp.thoiGianBH= Integer.parseInt(txtTGBH.getText());
        sp.hinhAnh= hinh;
             
//        DSNhaCungCap dsncc = new DSNhaCungCap(); //Dựa vào tenNCC lấy mã nhà cung cấp tương ứng 
//        for (NhaCungCap ncc : dsncc.layDSNhaCC("")) {
//            if (ncc.tenNCC.equals(cboMaNCC.getSelectedItem())) {
//                sp.maNCC= ncc.maNCC; 
//                break;
//            }
//        }
        
        int index = -1;
        DSNhaCungCap dsncc = new DSNhaCungCap();
        for (NhaCungCap ncc : dsncc.layDSNhaCC("")) {
            ++index;
            if(index == cboMaNCC.getSelectedIndex()){
                sp.maNCC= ncc.maNCC; 
            }
        }
        
        int index2 = -1;
        DSLoaiSanPham dslsp = new DSLoaiSanPham();
        for (LoaiSanPham lsp : dslsp.layDSLoaiSanPham("")) {
            ++index2;
            if(index2 == cboMaLoai.getSelectedIndex()){
                sp.maLoai= lsp.maLoai;
            }
        }
        
//        DSLoaiSanPham dslsp = new DSLoaiSanPham();
//        for (LoaiSanPham lsp : dslsp.layDSLoaiSanPham("")) {
//            if (lsp.tenLoai.equals(cboMaLoai.getSelectedItem())) {
//                sp.maLoai= lsp.maLoai;
//                break; 
//            }
//        }

//        DSThuongHieu dsth = new DSThuongHieu();
//        for (ThuongHieu th : dsth.layDSThuongHieu("")) {
//            if (th.tenTH.equals(cboMaTH.getSelectedItem())) {
//                sp.maTH= th.maTH;
//                break; 
//            }
//        }
        
        int index3 = -1;
        DSThuongHieu dsth = new DSThuongHieu();
        for (ThuongHieu th : dsth.layDSThuongHieu("")) {
            ++index3;
            if(index3 == cboMaTH.getSelectedIndex()){
                sp.maTH= th.maTH;
            }
        }
        
        return sp;
    }
    
            
    private void hienThiTable() {
        //Reset model
        String[] Header = {"Mã sản phẩm", "Tên sản phẩm", "Mã loại", "Mã thương hiệu", "Mã nhà cung cấp"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        
        
        //DefaultTableModel model = (DefaultTableModel)tblDSSP.getModel();
        for(SanPham l: dssp_List) {
            Object[] o = {l.maSP, l.tenSP, l.maLoai, l.maTH, l.maNCC};
            model.addRow(o);
        } 
        tblDSSP.setModel(model);
    }
    
    private void hienThiCboNCC() {
        DefaultComboBoxModel modelcbo = (DefaultComboBoxModel)cboMaNCC.getModel();
        DSNhaCungCap dsncc = new DSNhaCungCap();
        for(NhaCungCap ncc: dsncc.layDSNhaCC("")) {
            Object o = ncc.tenNCC;
            modelcbo.addElement(o);
        }
    }
    
    //Lấy tất cả loại
    private void hienThiCboLoai() {
        DefaultComboBoxModel modelcbo = (DefaultComboBoxModel)cboMaLoai.getModel();
        DSLoaiSanPham dsncc = new DSLoaiSanPham();
        for(LoaiSanPham ncc: dsncc.layDSLoaiSanPham("")) {
            Object o = ncc.tenLoai;
            modelcbo.addElement(o);
        }
    }
    
    //Lấy tất cả thương hiệu
    private void hienThiCboTH() {
        DefaultComboBoxModel modelcbo = (DefaultComboBoxModel)cboMaTH.getModel();
        DSThuongHieu dsncc = new DSThuongHieu();
        for(ThuongHieu ncc: dsncc.layDSThuongHieu("")) {
            Object o = ncc.tenTH;
            modelcbo.addElement(o);
        }
    }  
    
//    private void anHienText(boolean t)
//    {
//        //txtMaNCC.setEnabled(t);
//        txtTenSP.setEnabled(t);
//        txtMau.setEnabled(t);
//        txtSoLuong.setEnabled(t);
////        txtGiaBanLe.setEnabled(t);
////        txtGiaDB.setEnabled(t);
////        txtGiaNhap.setEnabled(t);
////        txtGiaSi.setEnabled(t);
//        txtTGBH.setEnabled(t);  
//    }
    
//    private void anHienButton(boolean t)
//    {
//        btnLuu.setEnabled(!t);
//        btnSua.setEnabled(t);
//        btnXoa.setEnabled(t);
//        btnThem.setEnabled(t);
//    }
    
//    private void xoaTextBox()
//    {
//        txtMaSP.setText("");
//        txtTenSP.setText("");
//        txtMau.setText("");
//        txtSoLuong.setText("");
//        txtGiaBanLe.setText("");
//        txtGiaDB.setText("");
//        txtGiaNhap.setText("");
//        txtGiaSi.setText("");
//        txtTGBH.setText("");
//        
//        
//    }
     
    //XEM/SỬA/XÓA
    private void hienThiTextBox(int vitri) 
    {
        SanPham sp = dssp_List.get(vitri);
        txtMaSP.setText(sp.maSP);
        txtTenSP.setText(sp.tenSP);
        txtMau.setText(sp.mauSac);
        txtSoLuong.setText("" + sp.soLuong);
        txtGiaNhap.setText("" + sp.giaNhap);
        txtGiaBanLe.setText("" + sp.giaBanLe);
        txtTGBH.setText("" + sp.thoiGianBH);
        txtGiaDB.setText("" + sp.giaDangBai);
        txtGiaSi.setText("" + sp.giaSi);
        hinh= sp.hinhAnh;
        Uploadhinh(sp.hinhAnh);
        
        DSNhaCungCap dsncc = new DSNhaCungCap(); //Dựa vào maNCC hiển thị tên nhà cung cấp tương ứng lên combobox
        for (NhaCungCap ncc : dsncc.layDSNhaCC("")) {
            if (ncc.maNCC.equals(sp.maNCC)) {
                cboMaNCC.setSelectedItem(ncc.tenNCC); //--> kích hoạt actionPerformMaNCC
                break;
            }
        }

        DSLoaiSanPham dslsp = new DSLoaiSanPham();
        for (LoaiSanPham lsp : dslsp.layDSLoaiSanPham("")) {
            if (lsp.maLoai.equals(sp.maLoai)) {
                cboMaLoai.setSelectedItem(lsp.tenLoai);
                break; 
            }
        }

        DSThuongHieu dsth = new DSThuongHieu();
        for (ThuongHieu th : dsth.layDSThuongHieu("")) {
            if (th.maTH.equals(sp.maTH)) {
                cboMaTH.setSelectedItem(th.tenTH);
                break; 
            }
        }
        
        
    }
    
   
   //XEM/CHỌN DÒNG ĐỂ SỬA/XÓA
    private void tblDSSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSSPMouseClicked
       vitri = tblDSSP.getSelectedRow();
       hienThiTextBox(vitri);
       
       if(ktTacVu=="Sua")
       {
            txtTenSP.setEnabled(true);
            txtMau.setEnabled(true);
            txtGiaNhap.setEnabled(true);
            txtTGBH.setEnabled(true);
            txtSoLuong.setEnabled(true);
            //txtSoLuong.setText("0");

            cboMaNCC.setEnabled(true);
            cboMaLoai.setEnabled(true);
            cboMaTH.setEnabled(true);
            btnChonHinh.setEnabled(true);
            btnThem.setEnabled(false);
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            btnLuu.setEnabled(true);
            btnHuy.setEnabled(true);
       }
    }//GEN-LAST:event_tblDSSPMouseClicked

   
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        //RÀNG BUỘC
        if( flag_FrmSP== true)
        {
            cboMaNCC.setSelectedIndex(-1); //nếu là từ form NHÀ CUNG CẤP QUA thì khi ấn hủy cũng ko đc xóa nhà cung cấp trên cbo
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
            txtMaSP.setText("");
            //mã sp ko bị xóa
        }else
        {
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
        }
        
        txtTenSP.setEnabled(false);
        txtMau.setEnabled(false);
        txtGiaNhap.setEnabled(false);
        txtTGBH.setEnabled(false);
        cboMaLoai.setSelectedIndex(-1);
        cboMaTH.setSelectedIndex(-1);
        lblHinh.setIcon(null);
        
        cboMaLoai.setEnabled(false);
        cboMaTH.setEnabled(false);
        cboMaNCC.setEnabled(false);
         
        
        btnThem.setEnabled(true);
        btnLuu.setEnabled(false);
        btnChonHinh.setEnabled(false);
        
        
        txtTenSP.setText("");
        txtMau.setText("");
        txtSoLuong.setText("");
        txtGiaBanLe.setText("");
        txtGiaDB.setText("");
        txtGiaNhap.setText("");
        txtGiaSi.setText("");
        txtTGBH.setText("");
        lbThongBao.setText("Hãy chọn 1 thao tác");
       
        
    }//GEN-LAST:event_btnHuyActionPerformed
    

    
    
    private boolean kiemTraNhapDayDu()
    {
        if ( txtTenSP.getText().isEmpty() || txtMau.getText().isEmpty() || txtSoLuong.getText().isEmpty() || txtGiaBanLe.getText().isEmpty() || txtGiaDB.getText().isEmpty() || txtGiaSi.getText().isEmpty() || txtTGBH.getText().isEmpty())
        {
            //Thông báo nhập đầy đủ
            Message.showMessageError("Hãy nhập đầy đủ thông tin");
            return false;
        }
        else if( Integer.parseInt(txtSoLuong.getText()) < 0 || Integer.parseInt(txtGiaBanLe.getText()) <= 0 || Integer.parseInt(txtGiaDB.getText()) <= 0 || Integer.parseInt(txtGiaNhap.getText()) <= 0 || Integer.parseInt(txtGiaSi.getText()) <= 0 || Integer.parseInt(txtTGBH.getText()) < 0)
        {
            Message.showMessageError("Gía trị phải lớn hơn 0");
            return false;
        }else if( hinh.isEmpty())
        {
            Message.showMessageError("Hãy chọn hình ảnh");
            return false;
        }
        else
        {
            return true;
           
        }
            
    }
    
    
    private void checkInputValidity(javax.swing.JTextField textField, KeyEvent evt) {                                    
        char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự không phải là số (trừ nút xóa và nút Enter) hoặc độ dài vượt quá maxLength
        if ((!Character.isDigit(c) && c != evt.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER) ) {
            evt.consume(); // Hủy sự kiện nhập vào
            Message.showMessageError("Không nhập kí tự khác số vào trường này.");
        }
    }   // Biến để lưu trữ trạng thái của nút trước đó
    
    
    //TẠO MÃ TỰ ĐỘNG VỚI MÃ THỂ HIỂN SỐ LƯỢNG SP CỦA 1 NHÀ CUNG CẤP
    public String taoMaTuDong() {
        String key = "SP"; // Chuỗi bắt đầu của mã //SPNCC0010001   
        String maNCC = ""; // Mã nhà cung cấp

        if (cboMaNCC.getSelectedIndex() != -1) 
        {
            int vt= cboMaNCC.getSelectedIndex();

            DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaNCC.getModel(); // Lấy danh sách nhà cung cấp từ model của combobox
            String tenNCC = (String) model.getElementAt(vt);// Lấy tên nhà cung cấp từ model dựa trên chỉ mục đã chọn
            DSNhaCungCap dsncc = new DSNhaCungCap();
            for (NhaCungCap ncc : dsncc.layDSNhaCC("")) {
                if (ncc.getTenNCC().equals(tenNCC)) {
                    maNCC= ncc.getMaNCC();
                }
            }
        }

        key += maNCC.toString().trim();

        try {
            KetNoi kn = new KetNoi();
            String sql = "SELECT TOP 1 MASP FROM SANPHAM WHERE MASP LIKE '"+key+"%' ORDER BY MASP DESC";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (!rs.next()) {
                // Nếu không có mã khách hàng nào trong CSDL
                key += "0001";
            } else {
                // Nếu có mã khách hàng trong CSDL
                String maBanDau = rs.getString("MASP");
                String sott = maBanDau.substring(8);
                int num = Integer.parseInt(sott.trim()) + 1;
                // Thêm số thứ tự vào mã tự động
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
    
    
    String ktTacVu= "Xem"; //Mặc định là XEM
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        lbThongBao.setText("Chọn 1 nhà cung cấp để tạo mã. Hoặc bấm hủy để chọn thao tác khác");
        
        
        if(flag_FrmSP == false) //TRƯỜNG HỢP THÊM SP TỪ FORM PHIẾU NHẬP
        {
            DSNhaCungCap dsncc = new DSNhaCungCap(); //Dựa vào tenNCC lấy mã nhà cung cấp tương ứng 
            for (NhaCungCap ncc : dsncc.layDSNhaCC("")) {
                if (ncc.maNCC.equals(Frm_PhieuNhap.maNCC_sent)) {
                    cboMaNCC.setSelectedItem(ncc.tenNCC);
                    break;
                }
            }
            txtMaSP.setText(taoMaTuDong());
            cboMaNCC.setEnabled(false);
            
        }else //TRƯỜNG HỢP THÊM SP TỪ FORM SẢN PHẨM --> reset 
        { 
            txtMaSP.setText("");
            cboMaNCC.setEnabled(true);
            cboMaNCC.setSelectedIndex(-1); 
        }
        
        //RÀNG BUỘC
        //xoaTextBox();
        cboMaLoai.setSelectedIndex(-1);
        cboMaTH.setSelectedIndex(-1);
        lblHinh.setIcon(null);
        
        txtTenSP.setEnabled(true);
        txtMau.setEnabled(true);
        txtGiaNhap.setEnabled(true);
        txtTGBH.setEnabled(true);
        txtSoLuong.setText("0");
        
        cboMaLoai.setEnabled(true);
        cboMaTH.setEnabled(true);
        btnChonHinh.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(true);
        
        //Đánh dấu cờ thêm
        ktTacVu= "Them";
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        lbThongBao.setText("Hãy chọn dòng cần xóa. Hoặc bấm hủy để chọn thao tác khác");
        
      
        
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        txtTenSP.setEnabled(false);
        txtMau.setEnabled(false);
        txtGiaNhap.setEnabled(false);
        txtTGBH.setEnabled(false);
        cboMaNCC.setSelectedIndex(-1); 
        cboMaLoai.setSelectedIndex(-1);
        cboMaTH.setSelectedIndex(-1);
        lblHinh.setIcon(null);
        
        cboMaLoai.setEnabled(false);
        cboMaTH.setEnabled(false);
        cboMaNCC.setEnabled(false);
         
        
        btnThem.setEnabled(false);
        btnLuu.setEnabled(true);
        btnChonHinh.setEnabled(false);
        
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtMau.setText("");
        txtSoLuong.setText("");
        txtGiaBanLe.setText("");
        txtGiaDB.setText("");
        txtGiaNhap.setText("");
        txtGiaSi.setText("");
        txtTGBH.setText("");
        lbThongBao.setText("Hãy chọn 1 thao tác");
        
          ktTacVu= "Xoa";
        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        lbThongBao.setText("Hãy chọn dòng cần sửa. Hoặc bấm hủy để chọn thao tác khác");
        
        
        
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        txtTenSP.setEnabled(false);
        txtMau.setEnabled(false);
        txtGiaNhap.setEnabled(false);
        txtTGBH.setEnabled(false);
        cboMaNCC.setSelectedIndex(-1); 
        cboMaLoai.setSelectedIndex(-1);
        cboMaTH.setSelectedIndex(-1);
        lblHinh.setIcon(null);
        
        cboMaLoai.setEnabled(false);
        cboMaTH.setEnabled(false);
        cboMaNCC.setEnabled(false);
         
        
        btnThem.setEnabled(false);
        btnLuu.setEnabled(true);
        btnChonHinh.setEnabled(false);
        
        
        txtTenSP.setText("");
        txtMau.setText("");
        txtSoLuong.setText("");
        txtGiaBanLe.setText("");
        txtGiaDB.setText("");
        txtGiaNhap.setText("");
        txtGiaSi.setText("");
        txtTGBH.setText("");
        
        //Đánh dấu cờ sửa
        ktTacVu= "Sua";
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        //KIỂM TRA: Nhập đầy đủ các trường mới được lưu
        if ( kiemTraNhapDayDu() )
        {
            String message = "Bạn có chắc chắn muốn ";
            if (ktTacVu== "Them") {
                message += "thêm không?";
            }
            if (ktTacVu== "Xoa") {
                message += "xóa không?";
            }
            if (ktTacVu== "Sua") {
                message += "sửa không?";
            }

            MessageQuestion messquestion = new MessageQuestion(Main.getFrames()[0], true, GoogleMaterialDesignIcons.HELP);
            messquestion.showMessage(message);
            
            if (messquestion.isOk())
            {
                SanPham l = chuyenDoiTextBoxSangDoiTuong();
                if( ktTacVu == "Them" ) //THÊM
                {
                    //LƯU LẠI VÀO STATIC ĐỂ FORM DS SẢN PHẨM NHẬN BIẾN
                    masp_new= txtMaSP.getText();
                    tensp_new= txtTenSP.getText();
                    soluong_new= Integer.parseInt(txtSoLuong.getText());
                    gianhap_new= Integer.parseInt(txtGiaNhap.getText());
                                        
                    dssp.themSanPham(l);
                    ktTacVu= "Huy"; //Để bấm các tính năng khác
//                    //Xóa các textbox và cbo
//                    //xoaTextBox();
//                    txtMaSP.setText("");
//                    cboMaNCC.setSelectedIndex(-1);
//                    cboMaLoai.setSelectedIndex(-1);
//                    cboMaTH.setSelectedIndex(-1);
//                    lblHinh.setIcon(null);
//                    
                    btnLuu.setEnabled(false);
//                    //Trỏ đúng đối tg vừa thêm.    ????????????????????????????????????????????????????????????
//                    anHienButton(true); //Nút lưu khóa, các nút khác hiện.
//                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy (về chế độ XEM)
//                    txtGiaNhap.setEnabled(false);
//                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    Message.showMessageSuccess("Thêm thành công"); //cái này thêm ko dc nó vẫn chạy !!!
                
                    if (parentFrame != null) {
                        parentFrame.dispose();
                    }
                }

                if (ktTacVu == "Sua" )
                {
                    dssp.suaSanPham(l);
                    ktTacVu= "Huy"; //Để bấm các tính năng khác
                    //Xóa các textbox và cbo
                    //xoaTextBox();
//                    txtMaSP.setText("");
//                    cboMaNCC.setSelectedIndex(-1);
//                    cboMaLoai.setSelectedIndex(-1);
//                    cboMaTH.setSelectedIndex(-1);
//                    lblHinh.setIcon(null);
//                    //Khi vừa sửa xong 1. trỏ đúng đối tg vừa sửa ???????????????????????????????????????????
//                    anHienButton(true); //Nút lưu khóa, các nút khác hiện.
//                    anHienText(false); //Khóa textbox lại cho người dùng không sửa bậy
//                    lbThongBao.setText("Hãy chọn 1 thao tác");
                    btnLuu.setEnabled(false);
                    Message.showMessageSuccess("Sửa thành công");
                }

                if (ktTacVu == "Xoa")
                {
                    dssp.xoaSanPham(l);
                    //xoaTextBox();
//                    txtMaSP.setText("");
//                    cboMaNCC.setSelectedIndex(-1);
//                    cboMaLoai.setSelectedIndex(-1);
//                    cboMaTH.setSelectedIndex(-1);
//                    lblHinh.setIcon(null);
                    //Khi xóa xong, 1. Nút lưu vẫn mở, các nút khác vẫn khóa (cho ng dùng xóa tiếp đôi tg khác. (cho đến khi ấn hủy). 2.
                    //anHienText(true); //khi xóa xong thì vẫn còn hiện
                    btnLuu.setEnabled(true);
                    Message.showMessageSuccess("Xóa thành công");
                }
                
                cboMaNCC.setSelectedIndex(-1); 
                btnSua.setEnabled(true);
                btnXoa.setEnabled(true);
                txtMaSP.setText("");
                txtTenSP.setEnabled(false);
                txtMau.setEnabled(false);
                txtGiaNhap.setEnabled(false);
                txtTGBH.setEnabled(false);
                cboMaLoai.setSelectedIndex(-1);
                cboMaTH.setSelectedIndex(-1);
                lblHinh.setIcon(null);

                cboMaLoai.setEnabled(false);
                cboMaTH.setEnabled(false);
                cboMaNCC.setEnabled(false);


                btnThem.setEnabled(true);
                
                btnChonHinh.setEnabled(false);


                txtTenSP.setText("");
                txtMau.setText("");
                txtSoLuong.setText("");
                txtGiaBanLe.setText("");
                txtGiaDB.setText("");
                txtGiaNhap.setText("");
                txtGiaSi.setText("");
                txtTGBH.setText("");
                lbThongBao.setText("Hãy chọn 1 thao tác");
        
                //Tạo mới bảng
                dssp = new DSSanPham();
                dssp_List = dssp.layDSSanPham("");
                hienThiTable();
                
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    
     
    private void cboMaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaNCCActionPerformed

        if(ktTacVu== "Them") //là thêm
        {

            txtMaSP.setText(taoMaTuDong());


        }
                    
    }//GEN-LAST:event_cboMaNCCActionPerformed

    void Uploadhinh(String hinh)
    {
        ImageIcon image1=new ImageIcon("src\\Image\\"+hinh); //hinh= tenfile/tenhinh
        System.out.println("" + image1); //kết quả nó in ra là: src\Image\SPNCC0010002.png
        Image im=image1.getImage();
        ImageIcon icon=new ImageIcon(im.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), im.SCALE_SMOOTH));
        lblHinh.setIcon(icon);
    }
    
    private String ChonHinh() {
        JFileChooser open = new JFileChooser();
        //Đổi tiếng việt có dấu sang tiếng việt không dấu cho giống với tên thư mục
        String normalized = Normalizer.normalize(cboMaLoai.getSelectedItem().toString().trim(), Normalizer.Form.NFD);
        String mal= normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "").replaceAll("[^\\p{ASCII}]", "");
        
        // Thiết lập đường dẫn mặc định cho JFileChooser
        File defaultDirectory = new File("src\\Image\\" + mal);
        open.setCurrentDirectory(defaultDirectory);
        int kq = open.showOpenDialog(null);
        String hinh = "";
        if (kq == open.APPROVE_OPTION) {
            File f = open.getSelectedFile();
            String filename = f.getAbsolutePath();
            String[] chuoi = filename.split("\\\\");
            // Lấy tên thư mục cha (SPNCC0010001)
            String folderName = chuoi[chuoi.length - 2];
            // Lấy tên của tập tin hình ảnh (SPNCC0010001-0.png)
            String imageName = f.getName();
            // Kết hợp tên thư mục và tên hình ảnh để tạo biến hinh
            hinh = folderName + "\\" + imageName;
        }
         // In ra tên hình ảnh đã được lấy
        return hinh;
    }

    
    
    private void txtGiaSiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaSiKeyTyped
        checkInputValidity(txtGiaSi, evt);
    }//GEN-LAST:event_txtGiaSiKeyTyped

    private void txtGiaBanLeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaBanLeKeyTyped
        checkInputValidity(txtGiaBanLe, evt);
    }//GEN-LAST:event_txtGiaBanLeKeyTyped

    private void txtGiaDBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaDBKeyTyped
        checkInputValidity(txtGiaDB, evt);
    }//GEN-LAST:event_txtGiaDBKeyTyped

    private void txtGiaNhapKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaNhapKeyTyped
        checkInputValidity(txtGiaNhap, evt);
    }//GEN-LAST:event_txtGiaNhapKeyTyped

    private void txtTGBHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTGBHKeyTyped
        checkInputValidity(txtGiaSi, evt);
    }//GEN-LAST:event_txtTGBHKeyTyped

    private void txtSoLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyTyped
        checkInputValidity(txtSoLuong, evt);
    }//GEN-LAST:event_txtSoLuongKeyTyped

    private void txtMauKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMauKeyTyped
         char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự là chữ, hoặc space, hoặc nút xóa (ko chứa số, kí tự đặc biệt)
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER && c != ' ') {

            evt.consume();
            // Hiển thị thông báo lỗi
            Message.showMessageError("Tên màu chỉ được chứa chữ cái!");
        }
    }//GEN-LAST:event_txtMauKeyTyped

    private void txtTenSPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenSPKeyTyped
        char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự là chữ, hoặc space, hoặc nút xóa (ko chứa số, kí tự đặc biệt)
        if (!Character.isLetter(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER && c != ' ') {

            evt.consume();
            // Hiển thị thông báo lỗi
            Message.showMessageError("Tên sản phẩm chỉ được chứa chữ cái!");
        }
    }//GEN-LAST:event_txtTenSPKeyTyped

    private void btnChonHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChonHinhMouseClicked
       
    }//GEN-LAST:event_btnChonHinhMouseClicked
 String hinh;
    private void btnChonHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonHinhActionPerformed
        hinh= ChonHinh();
        Uploadhinh(hinh);
        
    }//GEN-LAST:event_btnChonHinhActionPerformed

    private void cboMaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaLoaiActionPerformed
        //Nếu chọn loại thì cho chọn hình
        btnChonHinh.setEnabled(true);
    }//GEN-LAST:event_cboMaLoaiActionPerformed

    private void txtGiaNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaNhapActionPerformed
        int giaNhap = Integer.parseInt(txtGiaNhap.getText());
        int giaBan = (int) Math.round(giaNhap / 0.7);
        int giaDB = (int) Math.round(giaBan + (giaBan * 0.1));
        int giaSi = (int) Math.round(giaBan - (giaBan * 0.1));

        //NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        txtGiaBanLe.setText(String.valueOf(giaBan));
        txtGiaDB.setText(String.valueOf(giaDB));
        txtGiaSi.setText(String.valueOf(giaSi));
    }//GEN-LAST:event_txtGiaNhapActionPerformed

    //SỐ LƯỢNG KO NHẬP --> DỰA VÀO PHIẾU NHẬP
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar Hinh;
    private swing.Button btnChonHinh;
    private swing.Button btnHuy;
    private swing.Button btnLuu;
    private swing.Button btnSua;
    private swing.Button btnThem;
    private swing.Button btnXoa;
    private swing.combobox.ComboBoxSuggestion cboMaLoai;
    private swing.combobox.ComboBoxSuggestion cboMaNCC;
    private swing.combobox.ComboBoxSuggestion cboMaTH;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JLabel lblHinh;
    private swing.table.Table tblDSSP;
    private javax.swing.JTextField txtGiaBanLe;
    private javax.swing.JTextField txtGiaDB;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtGiaSi;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMau;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTGBH;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
