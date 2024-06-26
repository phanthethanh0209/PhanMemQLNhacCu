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
import ql_cuahang_nhaccu_form.Frm_KhachHang;

/**
 *
 * @author ASUS
 */
public class DSKhachHang {
    public ArrayList<KhachHang> layDSKhachHang(String where) {
        ArrayList<KhachHang> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from KhachHang where trangthai = 0 " + where;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                KhachHang kh = new KhachHang();
                kh.maKH = rs.getString("makh");
                kh.tenKH = rs.getString("tenkh");
                kh.diaChi = rs.getString("diachi");
                kh.sDT = rs.getString("sdt");
                ds.add(kh);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    //thêm nhà cung câp
    public void themKhachHang(KhachHang l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themKhachHang(?,?,?,?)}");
            st.setString(1, l.maKH);
            st.setString(2, l.tenKH);
            st.setString(3, l.diaChi);
            st.setString(4, l.sDT);
            
            st.executeUpdate();
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    //xóa nhà cung câp
    public void xoaKhachHang(KhachHang l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call delete_KhachHang(?)}");
            st.setString(1, l.maKH);
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public void suaKhachHang(KhachHang l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call update_KhachHang(?,?,?,?)}");
            st.setString(1, l.maKH);
            st.setString(2, l.tenKH);
            st.setString(3, l.diaChi);
            st.setString(4, l.sDT);
            
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSKhachHang.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public KhachHang timKhachHang(String where) {
        KhachHang kh = null;
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from KhachHang where trangthai = 0 and SDT = '" +where+ "'" ;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Kiểm tra xem ResultSet có hàng dữ liệu không
            if (rs.next()) {
                kh = new KhachHang();
                kh.maKH = rs.getString("makh");
                kh.tenKH = rs.getString("tenkh");
                kh.diaChi = rs.getString("diachi");
                kh.sDT = rs.getString("sdt");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kh;
    }

    public KhachHang layKhachHang(String where) {
        KhachHang kh = null;
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from KhachHang where trangthai = 0 and makh = '" +where+ "'" ;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Kiểm tra xem ResultSet có hàng dữ liệu không
            if (rs.next()) {
                kh = new KhachHang();
                kh.maKH = rs.getString("makh");
                kh.tenKH = rs.getString("tenkh");
                kh.diaChi = rs.getString("diachi");
                kh.sDT = rs.getString("sdt");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kh;
    }
}
