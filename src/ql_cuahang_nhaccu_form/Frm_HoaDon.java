
package ql_cuahang_nhaccu_form;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import ql_cuahang_nhaccu_class.CTHoaDon;
import ql_cuahang_nhaccu_class.CTKhuyenMai;
import ql_cuahang_nhaccu_class.DSCTHoaDon;
import ql_cuahang_nhaccu_class.DSCTKhuyenMai;
import ql_cuahang_nhaccu_class.DSHoaDon;
import ql_cuahang_nhaccu_class.DSKhachHang;
import ql_cuahang_nhaccu_class.DSKhuyenMai;
import ql_cuahang_nhaccu_class.DSNhanVien;
import ql_cuahang_nhaccu_class.DSSanPham;
import ql_cuahang_nhaccu_class.HoaDon;
import ql_cuahang_nhaccu_class.KetNoi;
import ql_cuahang_nhaccu_class.KhachHang;
import ql_cuahang_nhaccu_class.KhuyenMai;
import ql_cuahang_nhaccu_class.NhanVien;
import ql_cuahang_nhaccu_class.SanPham;
import dialog.Message;
import dialog.MessageQuestion;
import java.awt.Image;
import javax.swing.ImageIcon;
import main.Main;
import swing.icon.GoogleMaterialDesignIcons;

public class Frm_HoaDon extends javax.swing.JPanel {
    DSCTHoaDon dslhd; // sửa
    ArrayList<CTHoaDon> dslhd_List;// sửa
    
    // sửa
    DSSanPham dssp;
    DSCTKhuyenMai dsctkm;
    DSHoaDon dshd;
    DSCTHoaDon dscthd;
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    int vitri = 0;
    
    public Frm_HoaDon() {
        initComponents();
        setOpaque(false);
        tblHoaDon.fixTable(jScrollPane1);
                
        anHienTextBox(false);
        btnThem.setEnabled(false);
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(false);        
        btnTimKH.setEnabled(false);
        btnHuy.setEnabled(false);
    }
    
    // sửa
    private void hienThiTable(String mahd) {
        dslhd = new DSCTHoaDon();// sửa
        dslhd_List = dslhd.layDSCTHoaDon(mahd);
        String[] Header = {"Mã sản phẩm", "Số lượng", "Đơn giá"};
        DefaultTableModel model = new DefaultTableModel(Header, 0);
        for(CTHoaDon l: dslhd_List) {
            Object[] o = {l.maSP, l.soLuong, l.donGia};
            model.addRow(o);
        } 
        tblHoaDon.setModel(model);
//        tblKhachHang.setRowSelectionInterval(vitri, vitri);
        if (dslhd_List.size() > 0) {
            int selectedRowIndex = Math.min(vitri, dslhd_List.size() - 1);
            tblHoaDon.setRowSelectionInterval(selectedRowIndex, selectedRowIndex);
        }
        
    }

    public static String taoMaTuDong() {
        String key = "HD";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String currentDate = dateFormat.format(new Date());
        key= key + currentDate;
        
        try {
            KetNoi kn = new KetNoi();
            String sql = "Select TOP 1 MAHD from HOADON WHERE MAHD LIKE 'HD%' ORDER BY MAHD DESC";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (!rs.next()) {
                key += "-0001";
            } else {
                String maBanDau = rs.getString("MAHD");
                String sott = maBanDau.substring(9);
                int num = Integer.parseInt(sott.trim()) + 1;
                if (num < 10)
                    key += "-000" + num;
                else if (num < 100)
                    key += "-00" + num;
                else if (num <1000)
                    key += "-0" + num; 
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboSuggestionUI1 = new swing.combobox.ComboSuggestionUI();
        btnTaoHD = new swing.Button();
        btnXemDSHD = new swing.Button();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        btnTimKH = new swing.Button();
        cboNV = new swing.combobox.ComboBoxSuggestion();
        jPanel2 = new javax.swing.JPanel();
        avatar = new swing.ImageAvatar();
        lblHinh = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        button10 = new swing.Button();
        txtKhuyenMai = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new swing.table.Table();
        btnLuu = new swing.Button();
        button5 = new swing.Button();
        jLabel18 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        btnThem = new swing.Button();
        btnXoa = new swing.Button();
        btnCapNhat = new swing.Button();
        btnHuy = new swing.Button();

        setBackground(new java.awt.Color(101, 200, 255));

        btnTaoHD.setBackground(new java.awt.Color(123, 110, 255));
        btnTaoHD.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHD.setText("Tạo Hóa Đơn");
        btnTaoHD.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnXemDSHD.setBackground(new java.awt.Color(123, 110, 255));
        btnXemDSHD.setForeground(new java.awt.Color(255, 255, 255));
        btnXemDSHD.setText("Xem danh sách Hóa Đơn");
        btnXemDSHD.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnXemDSHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemDSHDActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mã hóa đơn:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Ngày lập:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("SĐT khách hàng:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Khách hàng:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Nhân viên:");

        txtMaHD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSDTKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSDTKeyTyped(evt);
            }
        });

        txtNgayLap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnTimKH.setBackground(new java.awt.Color(123, 110, 255));
        btnTimKH.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKH.setText("Tìm");
        btnTimKH.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnTimKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(btnTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaHD)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(txtTenKH)
                    .addComponent(cboNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblHinh.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        lblHinh.setForeground(new java.awt.Color(255, 0, 51));
        avatar.add(lblHinh);
        lblHinh.setBounds(10, 10, 140, 120);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("Mã sản phẩm:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText("Tên sản phẩm:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setText("Giá bán:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setText("Số lượng mua:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setText("Khuyến mãi:");

        txtMaSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        txtDonGia.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTenSP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        button10.setBackground(new java.awt.Color(123, 110, 255));
        button10.setForeground(new java.awt.Color(255, 255, 255));
        button10.setText("...");
        button10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        button10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button10ActionPerformed(evt);
            }
        });

        txtKhuyenMai.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDonGia)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(txtKhuyenMai))
                .addGap(32, 32, 32)
                .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addComponent(button10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKhuyenMai)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)), "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Số lượng", "Đơn giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnLuu.setBackground(new java.awt.Color(123, 110, 255));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        button5.setBackground(new java.awt.Color(123, 110, 255));
        button5.setForeground(new java.awt.Color(255, 255, 255));
        button5.setText("In");
        button5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setText("Thành tiền:");

        txtTongTien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTongTien.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTongTien)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(13, 13, 13))
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

        btnCapNhat.setBackground(new java.awt.Color(123, 110, 255));
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(123, 110, 255));
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy thao tác");
        btnHuy.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnXemDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemDSHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    boolean check = false;
    
    private void timKhachHang() {
        check = true;
        KhachHang k = new KhachHang();
        DSKhachHang dskh = new DSKhachHang();
        if(txtSDT.getText() != "") {
            k = dskh.timKhachHang(txtSDT.getText());
            if (k != null) {
                txtTenKH.setText(k.tenKH);
            } else {
                JFrame panel = new JFrame();
                Frm_KhachHang f = new Frm_KhachHang(panel);
                panel.setSize(1280, 720);
                panel.getContentPane().add(f);
                panel.setLocationRelativeTo(null);
                panel.setVisible(true);
                
                panel.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        if (Frm_KhachHang.sdt_new != null) {
                            txtSDT.setText(Frm_KhachHang.sdt_new);
                            txtTenKH.setText(Frm_KhachHang.tenKH_new);
                        }
                    }
                });
            }
        }
    }
    private void btnTimKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKHActionPerformed
        // TODO add your handling code here:
        timKhachHang();
    }//GEN-LAST:event_btnTimKHActionPerformed

    private void button10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button10ActionPerformed
    
    private void anHienTextBox(boolean t){
//        Mahd, ngaylap, tenkh. tensp, giaban, khuyenmai luôn ẩn
//          khi xem chi tiết hd thì các trg đều ẩn
        txtMaHD.setEnabled(false);
        txtNgayLap.setEnabled(false);
        txtSDT.setEnabled(t);
        txtTenKH.setEnabled(t);
        cboNV.setEnabled(t);
        txtMaSP.setEnabled(t);
        txtTenSP.setEnabled(false);
        txtDonGia.setEnabled(false);
        txtSoLuong.setEnabled(t);
        txtKhuyenMai.setEnabled(false);
        txtTenKH.setEnabled(false);
    }
    
    // sửa
    private void txtSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyReleased
        if(check) txtTenKH.setText("");
    }//GEN-LAST:event_txtSDTKeyReleased
    
    KhuyenMai km;
    private void hienThiTextBox(int vitri) {
        // kết 2 bảng CTHD và sp bằng cách gọi hàm lấy 1 sp và truyền vào tham số masp
        CTHoaDon cthd = dslhd_List.get(vitri);
        dssp = new DSSanPham();
        dsctkm = new DSCTKhuyenMai();
        dshd = new DSHoaDon();
        
        SanPham sp = dssp.laySanPham(cthd.maSP);
        CTKhuyenMai ctkm = dsctkm.layCTKhuyenMai(cthd.maSP);
        
        DSKhuyenMai dskm = new DSKhuyenMai();
        km = dskm.layKhuyenMai(ctkm.maKM);
        
        txtMaSP.setText(cthd.maSP);
        txtTenSP.setText(sp.tenSP);
        txtDonGia.setText(String.valueOf(cthd.donGia));
        txtSoLuong.setText(String.valueOf(cthd.soLuong));
        txtKhuyenMai.setText(String.valueOf(km.phanTramGiam) + "%");
        Uploadhinh(sp.hinhAnh);
    }
    
    int checkUpdateTable;
    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        vitri = tblHoaDon.getSelectedRow();
        // hiện nút xóa sửa sau khi đc click
        if(flag <=3) {
            hienThiTextBoxCapNhat(vitri);
            anHienButton(false);
            flag = 2;
        }else {
            hienThiTextBox(vitri);
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnXemDSHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemDSHDActionPerformed
        // TODO add your handling code here:
//        check = true;
        flag = 5;
        JFrame panel = new JFrame();
        Frm_DSHoaDon f = new Frm_DSHoaDon();
        panel.setSize(1280, 720);
        panel.getContentPane().add(f);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);

        panel.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (Frm_DSHoaDon.mahd != null) {
                    txtMaHD.setText(Frm_DSHoaDon.mahd);
                    txtNgayLap.setText(Frm_DSHoaDon.ngaylap);                    
                    cboNV.setSelectedItem(Frm_DSHoaDon.tentknv);
                    txtSDT.setText(Frm_DSHoaDon.sdtkh);
                    txtTenKH.setText(Frm_DSHoaDon.tenkh);
                    txtTongTien.setText(String.valueOf(Frm_DSHoaDon.tong));
                    
                    hienThiTable(Frm_DSHoaDon.mahd);
                    xoaTextSP();
                    anHienTextBox(false);
                    btnThem.setEnabled(false);
                    btnHuy.setEnabled(false);
                    btnXoa.setEnabled(false);
                    btnCapNhat.setEnabled(false);
                    btnLuu.setEnabled(false);
                }
            }
        });
    }//GEN-LAST:event_btnXemDSHDActionPerformed

    private void xoaTextSP() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtDonGia.setText("");
        txtSoLuong.setText("");
        txtKhuyenMai.setText("");
        lblHinh.setIcon(null);
    }
    
    int flag = 0;
    
    String[] Header = {"Mã sản phẩm", "Số lượng", "Đơn giá", "Giá giảm", "Tổng tiền"};
    DefaultTableModel model;
    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // khi click nút tạo thì nút thêm hiện
        // khi click vào 1 dòng trong table thì hiện nút xóa, sửa
        // nút lưu sẽ báo lỗi khi kh có dòng nào trong table
        
        anHienButton(true);
        anHienTextBox(true);
        String currentDate = dateFormat.format(new Date());
        txtNgayLap.setText(currentDate);
        txtMaHD.setText(taoMaTuDong());
        txtSDT.setText("");
        txtTenKH.setText("");
        txtTongTien.setText("");
        hienThiCboNhanVien();
        cboNV.setSelectedIndex(-1);

        xoaTextSP();
        
        // reset table
        model = new DefaultTableModel(Header, 0);
        tblHoaDon.setModel(model);
        btnLuu.setEnabled(true);
        btnHuy.setEnabled(true);
        btnTimKH.setEnabled(true);
    }//GEN-LAST:event_btnTaoHDActionPerformed
    
    private void anHienButton(boolean t)
    {
        btnCapNhat.setEnabled(!t);
        btnXoa.setEnabled(!t);
        btnThem.setEnabled(t);
    }
    
    void Uploadhinh(String hinh)
    {
        ImageIcon image1=new ImageIcon("src\\Image\\"+hinh); //hinh= tenfile/tenhinh
        System.out.println("" + image1); //kết quả nó in ra là: src\Image\SPNCC0010002.png
        Image im=image1.getImage();
        ImageIcon icon=new ImageIcon(im.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), im.SCALE_SMOOTH));
        lblHinh.setIcon(icon);
    }
    
    KhuyenMai k;  
    void loadDataInfoSP() {
        dssp = new DSSanPham();
        SanPham sp = dssp.laySanPham(txtMaSP.getText());
        dsctkm = new DSCTKhuyenMai();
        CTKhuyenMai ctkm = dsctkm.layCTKhuyenMai(sp.maSP);
        
        DSKhuyenMai dskm = new DSKhuyenMai();
        k = dskm.layKhuyenMai(ctkm.maKM);
        
        txtTenSP.setText(sp.tenSP);
        txtDonGia.setText(String.valueOf(sp.giaBanLe));
        txtKhuyenMai.setText(String.valueOf(k.phanTramGiam) + "%");
        Uploadhinh(sp.hinhAnh);
    }
      
    int tongtien = 0;
    int giagiam, tong = 0;
    private void setDataInTable(String masp) {
        SanPham s;
        dssp = new DSSanPham();
        s = dssp.laySanPham(masp);
        
        dsctkm = new DSCTKhuyenMai();
        CTKhuyenMai ctkm = dsctkm.layCTKhuyenMai(s.maSP);
        
        DSKhuyenMai dskm = new DSKhuyenMai();
        k = dskm.layKhuyenMai(ctkm.maKM);
        
        giagiam = (int) ((k.phanTramGiam / 100.0) * s.giaBanLe);
        
        tong = (s.giaBanLe - giagiam)*Integer.parseInt(txtSoLuong.getText());
        Object[] o = {s.maSP, txtSoLuong.getText(), s.giaBanLe, giagiam, tong};

        model.addRow(o);
        
        tblHoaDon.setModel(model);
        
        // lấy khuyến mãi của 1 sp để binding lên textbox   
        
//        tongtien+= tong;
//        txtTongTien.setText(String.valueOf(tongtien));
        tinhThanhTien();
    }
    
    DSSanPham ds;
    ArrayList<SanPham> dssp_List;// sửa
    private void hienThiTextBoxCapNhat(int vitri) {
        txtMaSP.setText(model.getValueAt(vitri, 0).toString());
        txtMaSP.setEnabled(false);
        SanPham s;
        DSSanPham dssp = new DSSanPham();
        s = dssp.laySanPham(txtMaSP.getText());
        
        txtTenSP.setText(s.tenSP);
        txtSoLuong.setText(model.getValueAt(vitri, 1).toString());
        txtDonGia.setText(model.getValueAt(vitri, 2).toString());
        
        KhuyenMai k;
        DSKhuyenMai dskm = new DSKhuyenMai();
        CTKhuyenMai ctkm = dsctkm.layCTKhuyenMai(txtMaSP.getText());
        
        k = dskm.layKhuyenMai(ctkm.maKM);
        txtKhuyenMai.setText(String.valueOf(k.phanTramGiam) + "%");
        Uploadhinh(s.hinhAnh);
    }
    
    String previousAction = "";
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        flag = 1;
        if(kiemTraNhapDayDu()){
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
                    int soLuongHienTai = Integer.parseInt(model.getValueAt(i, 1).toString());
                    int soLuongTong = soLuongHienTai + soLuongMoi;
                    
                    exists = true;
                    
                    SanPham s;
                    DSSanPham dssp = new DSSanPham();
                    s = dssp.laySanPham(txtMaSP.getText());
                    if(soLuongTong <= s.soLuong){
                        model.setValueAt(soLuongTong, i, 1);
                        
                        dsctkm = new DSCTKhuyenMai();
                        CTKhuyenMai ctkm = dsctkm.layCTKhuyenMai(txtMaSP.getText());

                        DSKhuyenMai dskm = new DSKhuyenMai();
                        KhuyenMai k = dskm.layKhuyenMai(ctkm.maKM);

                        int dongia = Integer.parseInt(txtDonGia.getText());
                        giagiam = (int) ((k.phanTramGiam / 100.0) * dongia);

                        tong = (dongia - giagiam)*soLuongTong;
                        model.setValueAt(tong, i, 4);
                        tinhThanhTien();


                        //xóa hết txt
                        xoaTextSP();
                        break;
                    }
                    else {
                        Message.showMessageError("Số lượng của sp không đủ");
                    }
                }
            }

            // Nếu mã sản phẩm chưa tồn tại, thêm sản phẩm mới vào bảng
            if (!exists) {
                setDataInTable(txtMaSP.getText().trim());
                
                //xóa hết txt
                xoaTextSP();
                
            }
            
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tinhThanhTien() {
        int thanhtien = 0;
        for(int i = 0; i < model.getRowCount(); i++) {
            thanhtien+= Integer.parseInt(model.getValueAt(i, 4).toString());
        }
        txtTongTien.setText(String.valueOf(thanhtien));
    }
    
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        if(vitri!=-1) 
        {
            if(kiemTraNhapDayDu()){
                SanPham s;
                DSSanPham dssp = new DSSanPham();
                s = dssp.laySanPham(txtMaSP.getText());
                int sl = Integer.parseInt(txtSoLuong.getText());
                if(sl <= s.soLuong){
                    KhuyenMai k;
                    DSKhuyenMai dskm = new DSKhuyenMai();
                    CTKhuyenMai ctkm = dsctkm.layCTKhuyenMai(txtMaSP.getText());
                    k = dskm.layKhuyenMai(ctkm.maKM);

                    giagiam = (int) ((k.phanTramGiam / 100.0) * Integer.parseInt(txtDonGia.getText()));
                    tong = (Integer.parseInt(txtDonGia.getText()) - giagiam)*Integer.parseInt(txtSoLuong.getText());

                    model.setValueAt(txtMaSP.getText(), vitri, 0);
                    model.setValueAt(txtSoLuong.getText(), vitri, 1);
                    model.setValueAt(txtDonGia.getText(), vitri, 2);
                    model.setValueAt(giagiam, vitri, 3);
                    model.setValueAt(tong, vitri, 4);

                    txtMaSP.setEnabled(false);
                    tinhThanhTien();
                    vitri = -1;
                }
                else {
                    Message.showMessageError("Số lượng của sản phẩm không đủ");
                }
            }
        }
        else {            
            Message.showMessageError("Hãy chọn dòng dữ liệu cần cập nhật!");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        if(flag == 2) {
            btnThem.setEnabled(true);
            btnCapNhat.setEnabled(false);
            btnXoa.setEnabled(false);
            txtMaSP.setEnabled(true);
        }
        flag = 0;
    }//GEN-LAST:event_btnHuyActionPerformed

//HIỂN THỊ CBO NHÂN VIÊN
    private void hienThiCboNhanVien() {
        DefaultComboBoxModel modelcbo = (DefaultComboBoxModel)cboNV.getModel();
        modelcbo.removeAllElements();
        DSNhanVien dsnv = new DSNhanVien();
        for(NhanVien ncc: dsnv.layDSNhanVien("")) {
            Object o = ncc.tenNV;
            modelcbo.addElement(o);
        }
    }
    
    private HoaDon chuyenDoiTextBoxSangDoiTuong()
    {
        String maNV = "";
        int index = -1;
        DSNhanVien dsnv = new DSNhanVien();
        for(NhanVien ncc: dsnv.layDSNhanVien("")) {
            ++index;
            if(index == cboNV.getSelectedIndex()){
                maNV = ncc.maNV;
            }
        }
        
        HoaDon hd = new HoaDon();
        hd.maHD = txtMaHD.getText();
        hd.tenTKNV = maNV;

        DSKhachHang dskh = new DSKhachHang();
        KhachHang k = dskh.timKhachHang(txtSDT.getText());

        hd.maKH = k.maKH;
        hd.tongtien = Integer.parseInt(txtTongTien.getText());
        try {
            Date parsedDate = dateFormat.parse(txtNgayLap.getText());
            hd.ngayLap = new Timestamp(parsedDate.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Frm_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return hd;
    }
    
    private boolean kiemTraNhapDayDuHD()
    {
        if ( txtSDT.getText().isEmpty())
        {
            //Thông báo nhập đầy đủ
            Message.showMessageError("Hãy nhập đầy đủ thông tin");
            return false;
        }
        else if(txtSDT.getText().length() < 10 || txtSDT.getText().length() > 10){
            Message.showMessageError("Sđt không hợp lệ");
            return false;
        }
        else if(txtTenKH.getText().isEmpty()) {
            Message.showMessageError("Vui lòng tìm khách hàng");
            return false;
        }
        else if(cboNV.getSelectedIndex() == -1){
            Message.showMessageError("Hãy chọn nhân viên xuất hóa đơn!");
            return false;
        }
        return true; 
    }
    
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if (model.getRowCount() > 0) {
            if(kiemTraNhapDayDuHD()) {
                String message = "Bạn có muốn lưu hóa đơn ?";
                
                MessageQuestion messquestion = new MessageQuestion(Main.getFrames()[0], true, GoogleMaterialDesignIcons.HELP);
                messquestion.showMessage(message);
                
                if(messquestion.isOk()) {
                    HoaDon hd = chuyenDoiTextBoxSangDoiTuong();
                    dshd = new DSHoaDon();
                    dshd.themHoaDon(hd);

                    dscthd = new DSCTHoaDon();
                    for(int i = 0; i < model.getRowCount(); i++) {
                        String masp = model.getValueAt(i, 0).toString();
                        int soluong = Integer.parseInt(model.getValueAt(i, 1).toString());
                        int dongia = Integer.parseInt(model.getValueAt(i, 2).toString());
                        dscthd.themCTHoaDon(txtMaHD.getText(), masp, soluong, dongia);

    //                    update lại số lượng của sp

                    }
                    Message.showMessageSuccess("Thêm hóa đơn thành công");
    //                reset các textbox và button, table
                    xoaTextSP();
                    anHienTextBox(false);
                    txtMaHD.setText("");
                    txtNgayLap.setText("");
                    txtSDT.setText("");
                    txtTenKH.setText("");
                    cboNV.setSelectedIndex(-1);
                    btnHuy.setEnabled(false);
                    btnXoa.setEnabled(false);
                    btnCapNhat.setEnabled(false);
                    btnLuu.setEnabled(false);
                    txtTongTien.setText("");
    //                reset table
                    model = new DefaultTableModel(Header, 0);
                    tblHoaDon.setModel(model);
                }
            }
        } else {
            Message.showMessageError("Hãy thêm dữ liệu vào!");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if(vitri!=-1) 
        {
            model.removeRow(vitri);  
            xoaTextSP();
            tinhThanhTien();
        }
        else {            
            Message.showMessageError("Hãy chọn dòng dữ liệu cần xóa!");
        }
        vitri = -1;
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
        loadDataInfoSP();
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void txtSDTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        // Kiểm tra nếu ký tự không phải là số (trừ nút xóa) hoặc độ dài vượt quá 11 ký tự
        if ((!Character.isDigit(c) && c != evt.VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER) || txtSDT.getText().length() >= 10) {
            evt.consume(); // Hủy sự kiện nhập vào
            Message.showMessageError("Số điện thoại không hợp lệ!");
        }
    }//GEN-LAST:event_txtSDTKeyTyped

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
//        timKhachHang();
    }//GEN-LAST:event_txtSDTActionPerformed

    private boolean kiemTraNhapDayDu()
    {
        SanPham s;
        dssp = new DSSanPham();
        s = dssp.laySanPham(txtMaSP.getText());
//        int soluongnhap = Integer.parseInt(txtSoLuong.getText());
        
        if ( txtSDT.getText().isEmpty() || txtMaSP.getText().isEmpty() || txtSoLuong.getText().isEmpty())
        {
            //Thông báo nhập đầy đủ
            Message.showMessageError("Hãy nhập đầy đủ thông tin");
            return false;
        }
        else if(txtTenKH.getText().isEmpty()) {
            Message.showMessageError("Vui lòng tìm khách hàng");
            return false;
        }
        else if(txtSDT.getText().length() < 10 || txtSDT.getText().length() > 10)
        {
            Message.showMessageError("Sđt không hợp lệ");
            return false;
        }else if(cboNV.getSelectedIndex() == -1){
            Message.showMessageError("Hãy chọn nhân viên xuất hóa đơn!");
            return false;
        }
        else if(txtTenSP.getText().isEmpty()){
            Message.showMessageError("Không có sản phẩm trong cơ sở dữ liệu!");
            return false;
        }
        else if(Integer.parseInt(txtSoLuong.getText()) > s.soLuong){
            Message.showMessageError("Số lượng của sản phẩm không đủ");
            return false;
        }
        return true; 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar avatar;
    private swing.Button btnCapNhat;
    private swing.Button btnHuy;
    private swing.Button btnLuu;
    private swing.Button btnTaoHD;
    private swing.Button btnThem;
    private swing.Button btnTimKH;
    private swing.Button btnXemDSHD;
    private swing.Button btnXoa;
    private swing.Button button10;
    private swing.Button button5;
    private swing.combobox.ComboBoxSuggestion cboNV;
    private swing.combobox.ComboSuggestionUI comboSuggestionUI1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel lblHinh;
    private swing.table.Table tblHoaDon;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtKhuyenMai;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
