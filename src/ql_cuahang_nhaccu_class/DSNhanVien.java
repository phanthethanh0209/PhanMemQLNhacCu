/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_cuahang_nhaccu_class;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class DSNhanVien {
    public ArrayList<NhanVien> layDSNhanVien(String where) {
        ArrayList<NhanVien> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from NhanVien where trangthai = 0 " + where;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                NhanVien kh = new NhanVien();
                kh.maNV = rs.getString("manv");
                kh.tenNV = rs.getString("tennv");
                kh.diaChi = rs.getString("diachi");
                kh.sDT = rs.getString("sdt");
                kh.luong = rs.getInt("luong");
                kh.chucVu = rs.getString("chucVu");
                ds.add(kh);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    //thêm nhà cung câp
    public void themNhanVien(NhanVien l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themNhanVien(?,?,?,?,?,?)}");
            st.setString(1, l.maNV);
            st.setString(2, l.tenNV);
            st.setString(3, l.diaChi);
            st.setString(4, l.sDT);
            st.setString(5, l.chucVu);
            st.setInt(6, l.luong);
            
            st.executeUpdate();
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    //xóa nhà cung câp
    public void xoaNhanVien(NhanVien l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call xoaNhanVien(?)}");
            st.setString(1, l.maNV);
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public void suaNhanVien(NhanVien l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call suaNhanVien(?,?,?,?,?,?)}");
            st.setString(1, l.maNV);
            st.setString(2, l.tenNV);
            st.setString(3, l.diaChi);
            st.setString(4, l.sDT);
            st.setString(5, l.chucVu);
            st.setInt(6, l.luong);
            
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public NhanVien layNhanVien(String where) {
        NhanVien kh = null;
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from NhanVien where trangthai = 0 and MANV = '" +where+ "'" ;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Kiểm tra xem ResultSet có hàng dữ liệu không
            if (rs.next()) {
                kh = new NhanVien();
                kh.maNV = rs.getString("manv");
                kh.tenNV = rs.getString("tennv");
                kh.diaChi = rs.getString("diachi");
                kh.sDT = rs.getString("sdt");
                kh.luong = rs.getInt("luong");
                kh.chucVu = rs.getString("chucVu");
            }

            rs.close(); // Đóng ResultSet sau khi sử dụng
            st.close(); // Đóng Statement sau khi sử dụng
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kh;
    }
    
    
    public NhanVien layNhanVienTheoMa(String where) {
        NhanVien kh = null;
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from NhanVien where trangthai = 0 and manv = '" +where+ "'" ;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Kiểm tra xem ResultSet có hàng dữ liệu không
            if (rs.next()) {
                kh = new NhanVien();
                kh.maNV = rs.getString("manv");
                kh.tenNV = rs.getString("tennv");
                kh.diaChi = rs.getString("diachi");
                kh.sDT = rs.getString("sdt");
                kh.luong = rs.getInt("luong");
                kh.chucVu = rs.getString("chucVu");
            }

            rs.close(); // Đóng ResultSet sau khi sử dụng
            st.close(); // Đóng Statement sau khi sử dụng
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kh;
    }
}
