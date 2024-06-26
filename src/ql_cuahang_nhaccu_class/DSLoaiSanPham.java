/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_cuahang_nhaccu_class;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DSLoaiSanPham {
    
    public ArrayList<LoaiSanPham> layDSLoaiSanPham(String where) {
        ArrayList<LoaiSanPham> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from loaisanpham where trangthai = 0 " + where;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                LoaiSanPham l = new LoaiSanPham();
                l.maLoai = rs.getString("maloai");
                l.tenLoai = rs.getString("tenloai");
                l.trangThai = rs.getInt("trangthai");
                ds.add(l);
                
            }
            kn.KetNoiDuLieu().close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(LoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    
    //thêm loại sản phẩm
    public void themLoaiSP(LoaiSanPham l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themLoaiSP(?,?)}");
            st.setString(1, l.maLoai);
            st.setString(2, l.tenLoai);
            st.executeUpdate();
            
        }catch(SQLException EX)
        {
            Logger.getLogger(DSLoaiSanPham.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    //xóa loại sản phẩm
    public void xoaLoaiSP(LoaiSanPham l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call delete_LoaiSP(?)}");
            st.setString(1, l.maLoai);
            st.executeUpdate();
            
        }catch(SQLException EX)
        {
            Logger.getLogger(DSLoaiSanPham.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public void suaLoaiSP(LoaiSanPham l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call update_LoaiSP(?, ?)}");
            st.setString(1, l.maLoai);
            st.setString(2, l.tenLoai);
            st.executeUpdate();
            
        }catch(SQLException EX)
        {
            Logger.getLogger(DSLoaiSanPham.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public ArrayList<LoaiSanPham> layDSLoaiSPTheoNCC(String maNcc)
    {
         ArrayList<LoaiSanPham> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select distinct LOAISANPHAM.MALOAI, LOAISANPHAM.TENLOAI from NHACUNGCAP, SANPHAM, LOAISANPHAM where NHACUNGCAP.MANCC= SANPHAM.MANCC and SANPHAM.MALOAI= LOAISANPHAM.MALOAI and nhacungcap.MANCC= '" + maNcc + "'";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                LoaiSanPham l = new LoaiSanPham();
                l.maLoai = rs.getString("maloai");
                l.tenLoai = rs.getString("tenloai");
                ds.add(l);
                
            }
            kn.KetNoiDuLieu().close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(LoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
}
