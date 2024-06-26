
package ql_cuahang_nhaccu_form;

import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import dialog.Message;
import dialog.MessageQuestion;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import main.Main;
import org.omg.CORBA.INTERNAL;
import ql_cuahang_nhaccu_class.CTKhuyenMai;
import ql_cuahang_nhaccu_class.CTPhieuNhap;
import ql_cuahang_nhaccu_class.DSCTKhuyenMai;
import ql_cuahang_nhaccu_class.DSKhuyenMai;
import ql_cuahang_nhaccu_class.DSLoaiSanPham;
import ql_cuahang_nhaccu_class.DSNhaCungCap;
import ql_cuahang_nhaccu_class.DSNhanVien;
import ql_cuahang_nhaccu_class.DSSanPham;
import ql_cuahang_nhaccu_class.DSThuongHieu;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.KhachHang;
import ql_cuahang_nhaccu_class.KhuyenMai;
import ql_cuahang_nhaccu_class.LoaiSanPham;
import ql_cuahang_nhaccu_class.NhaCungCap;
import ql_cuahang_nhaccu_class.NhanVien;
import ql_cuahang_nhaccu_class.PhieuNhap;
import ql_cuahang_nhaccu_class.SanPham;
import ql_cuahang_nhaccu_class.ThuongHieu;
import swing.icon.GoogleMaterialDesignIcons;

public class Frm_KhuyenMai extends javax.swing.JPanel {
    DSCTKhuyenMai dsctkm;
    DSSanPham dssp;
    DSKhuyenMai dskm;
    ArrayList<CTKhuyenMai> dsctkm_List;
    int vitri = 0;
    
    String[] Header = {"Mã sản phẩm", "Tên sản phẩm"};
    DefaultTableModel model = new DefaultTableModel(Header, 0);
    
    
    private DateChooser chDate = new DateChooser();
    public Frm_KhuyenMai() {
        initComponents();
        setOpaque(false);
            
        initButtonCal(btnCalendarStart, txtNgayBD); // tạo btn cho ngaybd
        initButtonCal(btnCalendarEnd, txtNgayKT); // tạo btn cho ngaykt
        
        hienThiCboSP();
        cboSP.setSelectedIndex(-1);
        txtMaSP.setText("");
        txtGiaBan.setText("");
        
        txtMaSP.setEnabled(false);
        txtGiaBan.setEnabled(false);
 
    }

    private void initButtonCal(JButton button, JTextField textField) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chDate.setTextField(textField);
                chDate.setDateSelectionMode(DateChooser.DateSelectionMode.SINGLE_DATE_SELECTED);
                chDate.setBackground(Color.WHITE);
                
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                chDate.setDateFormat(dateformat);
                
                chDate.showPopup();
            }
        });
    }
    
    private void hienThiTextBox() {
        CTKhuyenMai km = dsctkm_List.get(vitri);
        txtMaKM.setText(km.maKM);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboNCC = new swing.combobox.ComboBoxSuggestion();
        comboSuggestionUI1 = new swing.combobox.ComboSuggestionUI();
        btnTaoKM = new swing.Button();
        btnXemDSKM = new swing.Button();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtNgayBD = new javax.swing.JTextField();
        txtTenKM = new javax.swing.JTextField();
        txtPhanTramGiam = new javax.swing.JTextField();
        txtNgayKT = new javax.swing.JTextField();
        btnCalendarStart = new swing.Button();
        btnCalendarEnd = new swing.Button();
        jPanel2 = new javax.swing.JPanel();
        imageAvatar1 = new swing.ImageAvatar();
        lblHinh = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnThem = new swing.Button();
        btnXoa = new swing.Button();
        cboSP = new swing.combobox.ComboBoxSuggestion();
        tb = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTKM = new swing.table.Table();
        btnLuu = new swing.Button();

        cboNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNCCActionPerformed(evt);
            }
        });

        btnTaoKM.setBackground(new java.awt.Color(123, 110, 255));
        btnTaoKM.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoKM.setText("Tạo khuyến mãi");
        btnTaoKM.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTaoKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoKMActionPerformed(evt);
            }
        });

        btnXemDSKM.setBackground(new java.awt.Color(123, 110, 255));
        btnXemDSKM.setForeground(new java.awt.Color(255, 255, 255));
        btnXemDSKM.setText("Xem DS Khuyến Mãi");
        btnXemDSKM.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXemDSKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDSKMActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin khuyến mãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mã khuyến mãi:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Tên khuyến mãi:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Ngày bắt đầu:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Ngày kết thúc:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Phần trăm giảm:");

        txtMaKM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtNgayBD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTenKM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtPhanTramGiam.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtNgayKT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnCalendarStart.setBackground(new java.awt.Color(123, 110, 255));
        btnCalendarStart.setForeground(new java.awt.Color(255, 255, 255));
        btnCalendarStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/8.png"))); // NOI18N
        btnCalendarStart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnCalendarEnd.setBackground(new java.awt.Color(123, 110, 255));
        btnCalendarEnd.setForeground(new java.awt.Color(255, 255, 255));
        btnCalendarEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/8.png"))); // NOI18N
        btnCalendarEnd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtNgayBD, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCalendarStart, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalendarEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtPhanTramGiam)
                    .addComponent(txtMaKM)
                    .addComponent(txtTenKM))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalendarStart, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(btnCalendarEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtPhanTramGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        imageAvatar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblHinh.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblHinh.setText("...");
        imageAvatar1.add(lblHinh);
        lblHinh.setBounds(10, 10, 150, 150);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("Mã sản phẩm:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText("Tên sản phẩm:");

        txtMaSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtGiaBan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setText("Giá bán:");

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

        cboSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(221, 221, 221))
                    .addComponent(cboSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tb.setBackground(new java.awt.Color(255, 255, 255));
        tb.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "DS sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblCTKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTKM.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblCTKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTKMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCTKM);

        btnLuu.setBackground(new java.awt.Color(123, 110, 255));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tbLayout = new javax.swing.GroupLayout(tb);
        tb.setLayout(tbLayout);
        tbLayout.setHorizontalGroup(
            tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        tbLayout.setVerticalGroup(
            tbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTaoKM, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXemDSKM, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemDSKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //HIỂN THỊ CHI TIẾT KM LÊN BẢNG
    private void hienThiTableCTPhieuNhap(String mapn) {
        dsctkm = new DSCTKhuyenMai();
        dsctkm_List= dsctkm.layDSCTKhuyenMai(mapn);
        //dsCTPNH_List = dsCTPNH.layDSCTPhieuNhap(mapn);  //Lấy chi tiết phiếu nhập 
        
        //Reset model
//        String[] Header = {"Mã sản phẩm", "Tên sản phẩm"};
//        DefaultTableModel model = new DefaultTableModel(Header, 0);
        
        for(CTKhuyenMai l: dsctkm_List) {
            //Dựa vào mã sp lấy được --> gọi hàm lấy ra 1 sp --> lấy ra tên sản phẩm
            DSSanPham dssp = new DSSanPham();
            SanPham sp = new SanPham();
            sp= dssp.laySanPham(l.maSP);
            
            
            Object[] o = {l.maSP, sp.tenSP };
            model.addRow(o);
        } 
        tblCTKM.setModel(model);
//        //Tính tổng tiền --> duyệt từng dòng trên bảng và tính tổng tiền
//        int tongTien= 0;
//        for (int i = 0; i < model.getRowCount(); i++) {
//            int thanhTien = Integer.parseInt(model.getValueAt(i, 2).toString()) * Integer.parseInt(model.getValueAt(i, 3).toString());
//            tongTien += thanhTien;
//        }
//        txtTongTien.setText(String.valueOf(tongTien));
//                    
//        tblCTPhieuNhap.setModel(model);
//        if (dsCTPNH_List.size() > 0) {
//            int selectedRowIndex = Math.min(vitri, dsCTPNH_List.size() - 1);
//            tblCTPhieuNhap.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
//        }
        
    }
    
    
    String tacVu= "Xem";
    private void btnXemDSKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDSKMActionPerformed
        
        flag_kmnew= false;
        
        //Reset model
        String[] Header = {"Mã sản phẩm", "Tên sản phẩm"};
        model = new DefaultTableModel(Header, 0);
        tblCTKM.setModel(model);
            
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        //XÓA TEXTBOX
        txtMaKM.setText("");
        txtTenKM.setText("");
        txtNgayBD.setText("");
        txtNgayKT.setText("");
        txtPhanTramGiam.setText("");
        txtMaSP.setText("");
        txtGiaBan.setText("");
        cboSP.setSelectedIndex(-1);
        lblHinh.setIcon(null);
        
        tacVu= "Xem";
        
        //Gọi form DS KHUYẾN MÃI
        JFrame panel = new JFrame();
        Frm_DSKhuyenMai f = new Frm_DSKhuyenMai();
        panel.setSize(1280, 720);
        panel.getContentPane().add(f);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);

        //Khi form xem ds phiếu nhập đóng
        panel.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (Frm_DSKhuyenMai.makm != null) {
                    txtMaKM.setText(Frm_DSKhuyenMai.makm);
                    txtTenKM.setText(Frm_DSKhuyenMai.tenkm);
                    txtNgayBD.setText(Frm_DSKhuyenMai.ngayBD);
                    txtNgayKT.setText(Frm_DSKhuyenMai.ngayKT);
                    txtPhanTramGiam.setText(String.valueOf(Frm_DSKhuyenMai.phanTramGiam));
                    
                    hienThiTableCTPhieuNhap(Frm_DSKhuyenMai.makm); //dựa vào mã pn lấy chi tiết phiếu nhập hiển thị bảng chi tiết

                }
            }
        });
    }//GEN-LAST:event_btnXemDSKMActionPerformed

    //HÀM ĐỂ HIỂN THỊ HÌNH LÊN FORM
    void Uploadhinh(String hinh)
    {
        ImageIcon image1=new ImageIcon("src\\Image\\"+hinh); //hinh= tenfile/tenhinh
        //System.out.println("" + image1); //kết quả nó in ra là: src\Image\SPNCC0010002.png
        Image im=image1.getImage();
        ImageIcon icon=new ImageIcon(im.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), im.SCALE_SMOOTH));
        lblHinh.setIcon(icon);
    }
    
    private void hienThiThongTinSPTheoCTPhieuNhap(int vitri) {
        
        CTKhuyenMai ctpn = dsctkm_List.get(vitri);

        txtMaSP.setText(ctpn.maSP);

        dssp = new DSSanPham();
        SanPham sp = dssp.laySanPham(ctpn.maSP);
        txtGiaBan.setText(String.valueOf(sp.giaBanLe));
        cboSP.setSelectedItem(sp.tenSP);
        
        Uploadhinh(sp.hinhAnh);
    }
    
     private void hienThiThongTinSPTheoBang(int vitri) 
    {
        txtMaSP.setText(model.getValueAt(vitri, 0).toString());
        cboSP.setSelectedItem(model.getValueAt(vitri, 1).toString());
        
        //Dựa vào mã sp lấy được --> gọi hàm lấy ra 1 sp --> lấy ra hình ảnh
        DSSanPham dssp = new DSSanPham();
        SanPham sp = new SanPham();
        sp= dssp.laySanPham(model.getValueAt(vitri, 0).toString()); //truyền vào mã sp, lấy ra sp
        Uploadhinh(sp.hinhAnh);
        
    }
     
    
    private void tblCTKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTKMMouseClicked
        if(tacVu== "xem")
        {
            vitri = tblCTKM.getSelectedRow();
            hienThiThongTinSPTheoCTPhieuNhap(vitri);
        }
        else //TH2: xem những sp chưa lưu vào phiếu nhập
        {
            vitri = tblCTKM.getSelectedRow();
            hienThiThongTinSPTheoBang(vitri);

            //Nếu có chọn dòng thì hiện nút sửa xóa
            btnXoa.setEnabled(true);
            btnThem.setEnabled(false);
        }
    }//GEN-LAST:event_tblCTKMMouseClicked

    //HIỂN THỊ CBO SẢN PHẨM
    private void hienThiCboSP() {
        DefaultComboBoxModel modelcbo = (DefaultComboBoxModel)cboSP.getModel();
        DSSanPham dsnv = new DSSanPham();
        for(SanPham ncc: dsnv.layDSSanPham("")) {
            Object o = ncc.tenSP;
            modelcbo.addElement(o);
        }
    }
    
    private void themSPXuongBang(String masp) {
        SanPham s;
        dssp = new DSSanPham();
        s = dssp.laySanPham(masp);
        //Thêm vào bảng model
        Object[] o = {s.maSP, s.tenSP};
        model.addRow(o);
        
        tblCTKM.setModel(model); 
        
        
        //KHI THÊM VÀO BẢNG MODEL XONG, THÌ XÓA TEXT
        txtMaSP.setText("");
        txtGiaBan.setText("");
        lblHinh.setIcon(null);
        cboSP.setSelectedIndex(-1);
    }
    
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        //flag = 1;
//        tacVu= "Them";
//        if(checkFrmSanPham()== true)
//        {
//            //kiểm tra mã sản phẩm (txtSP.getText() ) có nằm trong model chưa, nếu có thì
//            //số lượng + số lượng mới
//            //ngược lại thfi thêm mới
//
//            //THỰC THI HÀM THÊM SẢN PHẨM XUỐNG BẢNG
//            int soLuongMoi = Integer.parseInt(txtSoLuong.getText());
            boolean exists = false;
            // Duyệt qua các hàng trong bảng để kiểm tra mã sản phẩm có tồn tại chưa
            for (int i = 0; i < model.getRowCount(); i++) {

                String maSPTrongBang = model.getValueAt(i, 0).toString().trim();
                if (maSPTrongBang.equals(txtMaSP.getText().trim())) {

                    // Nếu mã sản phẩm đã tồn tại, cập nhật số lượng
                    Message.showMessageError("Sản phẩm đã thuộc khuyến mãi rồi");
                    exists = true;
                    break;
                }
            }

            // Nếu mã sản phẩm chưa tồn tại, thêm sản phẩm mới vào bảng
            if (!exists) {
                themSPXuongBang(txtMaSP.getText().trim());

                btnLuu.setEnabled(true); //Mở nút Lưu
            }

            //XÓA TEXTBOX SP
            txtMaSP.setText("");
            cboSP.setSelectedIndex(-1);
            txtGiaBan.setText("");
            lblHinh.setIcon(null);
//        }

    }//GEN-LAST:event_btnThemActionPerformed

        
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

       //xóa trong csdl (trg hợp mã km đã tồn tại)
       // list khác null tức là mã km này đã tồn tại trong csdl thì mới đem đi xóa đc
       if(dsctkm_List != null) {
            for(CTKhuyenMai l: dsctkm_List) {

                //Dựa vào mã sp lấy được --> gọi hàm lấy ra 1 sp --> lấy ra tên sản phẩm
                if(txtMaSP.getText().equals(l.maSP))
                { 
                    dsctkm.xoaCTKhuyenMai(l);
                }
            }
       }
        
        // Xóa dòng khỏi model
        for(int i = 0; i < model.getRowCount(); i++) {
            if(txtMaSP.getText().equals(model.getValueAt(i, 0)))
            {
                model.removeRow(i);
                tblCTKM.setModel(model);
                break;
            }
        } 
        
        //XÓA TEXTBOX SP
        txtMaSP.setText("");
        cboSP.setSelectedIndex(-1);
        txtGiaBan.setText("");
        lblHinh.setIcon(null);

    }//GEN-LAST:event_btnXoaActionPerformed

    private void cboNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNCCActionPerformed

    }//GEN-LAST:event_cboNCCActionPerformed

    private void cboSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSPActionPerformed
        if(cboSP.getSelectedIndex() >=0 )
        {
            DSSanPham dsncc = new DSSanPham(); 
            for (SanPham ncc : dsncc.layDSSanPham("")) {
                if (ncc.tenSP.equals(cboSP.getSelectedItem())) { //Dựa vào tenNCC lấy mã nhà cung cấp tương ứng 
                    txtMaSP.setText(ncc.maSP);
                    txtGiaBan.setText(String.valueOf(ncc.giaNhap));
                    Uploadhinh(ncc.hinhAnh);
                    break;
                }
            } 
            
            btnThem.setEnabled(true);
        }
        
    }//GEN-LAST:event_cboSPActionPerformed

    public static String taoMaTuDong() {
        String key = "KM";
        
        try {
            KetNoi kn = new KetNoi();
            String sql = "Select TOP 1 MAKM from KHUYENMAI WHERE MAKM LIKE 'KM%' ORDER BY MAKM DESC";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (!rs.next()) {
                key += "001";
            } else {
                String maBanDau = rs.getString("MAKM");
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
    
    boolean flag_kmnew= false;
    
    private void btnTaoKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoKMActionPerformed
        flag_kmnew=true;
        
        //Reset model
        String[] Header = {"Mã sản phẩm", "Tên sản phẩm"};
        model = new DefaultTableModel(Header, 0);
        tblCTKM.setModel(model);
            
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        //XÓA TEXTBOX
        txtMaKM.setText(taoMaTuDong());
        txtTenKM.setText("");
        txtNgayBD.setText("");
        txtNgayKT.setText("");
        txtPhanTramGiam.setText("");
        txtMaSP.setText("");
        txtGiaBan.setText("");
        cboSP.setSelectedIndex(-1);
        lblHinh.setIcon(null);
    }//GEN-LAST:event_btnTaoKMActionPerformed

    private KhuyenMai chuyenDoiTextBoxSangDoiTuong()
    {
        KhuyenMai km = new KhuyenMai();
        km.maKM = txtMaKM.getText();
        km.tenKM= txtTenKM.getText();
        km.ngayBD= txtNgayBD.getText();
        km.ngayKT= txtNgayKT.getText();
        km.phanTramGiam= Integer.parseInt(txtPhanTramGiam.getText());
        
        return km;
    }
    
    private void resetText() {
        // xóa textbox
        txtTenKM.setText("");
        txtNgayBD.setText("");
        txtNgayKT.setText("");
        txtPhanTramGiam.setText("");
        txtMaSP.setText("");
        txtGiaBan.setText("");
        cboSP.setSelectedIndex(-1);
        lblHinh.setIcon(null);
        model = new DefaultTableModel(Header, 0); // reset model
    }
    
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        MessageQuestion messquestion = new MessageQuestion(Main.getFrames()[0], true, GoogleMaterialDesignIcons.HELP);
        if(flag_kmnew)
        {
            String message = "Bạn có chắc chắn muốn thêm khuyến mãi không ?";
            messquestion.showMessage(message);

            if(messquestion.isOk()) {
                KhuyenMai km = chuyenDoiTextBoxSangDoiTuong();
                dskm = new DSKhuyenMai();
                dskm.themKhuyenMai(km);
                
                dsctkm = new DSCTKhuyenMai();
                for(int i = 0; i < model.getRowCount(); i++) {
                    CTKhuyenMai ctpn= new CTKhuyenMai();
                    ctpn.maKM = txtMaKM.getText();
                    ctpn.maSP= model.getValueAt(i, 0).toString().trim();
                    dsctkm.themCTKhuyenMai(ctpn);
                }                
                flag_kmnew = false; 
                Message.showMessageSuccess("Thêm thành công");
                
                resetText();
            }
            //Thêm bảng khuyến mãi
            
            //thêm sp vào bảng khuyến mãi
            
        }else
        {
            String message = "Bạn có muốn cập nhật khuyến mãi không ?";
            messquestion.showMessage(message);
            //Cập nhật bảng khuyến mãi
            if(messquestion.isOk()) {
                KhuyenMai km = chuyenDoiTextBoxSangDoiTuong();

                dskm = new DSKhuyenMai();
                dskm.suaKhuyenMai(km);

                //duyệt dòng trên model CT KM, dòng nào chưa có thì insert
                boolean flag=true;
                dsctkm = new DSCTKhuyenMai();
                for(int i = 0; i < model.getRowCount(); i++) {
                    flag = true;
                    String masp = model.getValueAt(i, 0).toString().trim();
                    System.out.println("Mã sp trong model: " + masp );
                    for(CTKhuyenMai l: dsctkm_List) {
                        System.out.println("Mã sp trong csdl: " + l.maSP );
                        if(masp.equals(l.maSP.trim()) && txtMaKM.getText().equals(l.maKM) ) //nếu mã sp trong 1 dòng của table = 1 dòng nào đó trong ct km của csdl
                        { 
                            //bỏ qua
                            System.out.println("Bỏ qua " );
                            flag= false;
                            break;
                        }

                    } 

                    if( flag)
                    {
                        CTKhuyenMai ctpn= new CTKhuyenMai();
                            ctpn.maKM = txtMaKM.getText();
                            ctpn.maSP= model.getValueAt(i, 0).toString().trim();

                            dsctkm.themCTKhuyenMai(ctpn);
                    }
                }
            }
            
        } 
        
    }//GEN-LAST:event_btnLuuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button btnCalendarEnd;
    private swing.Button btnCalendarStart;
    private swing.Button btnLuu;
    private swing.Button btnTaoKM;
    private swing.Button btnThem;
    private swing.Button btnXemDSKM;
    private swing.Button btnXoa;
    private swing.combobox.ComboBoxSuggestion cboNCC;
    private swing.combobox.ComboBoxSuggestion cboSP;
    private swing.combobox.ComboSuggestionUI comboSuggestionUI1;
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JPanel tb;
    private swing.table.Table tblCTKM;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgayBD;
    private javax.swing.JTextField txtNgayKT;
    private javax.swing.JTextField txtPhanTramGiam;
    private javax.swing.JTextField txtTenKM;
    // End of variables declaration//GEN-END:variables
}
