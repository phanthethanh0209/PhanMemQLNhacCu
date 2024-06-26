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
 * @author ASUS
 */
public class DSNhaCungCap {
    public ArrayList<NhaCungCap> layDSNhaCC(String where) {
        ArrayList<NhaCungCap> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from nhacungcap where trangthai = 0 " + where;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                NhaCungCap n = new NhaCungCap();
                n.maNCC = rs.getString("mancc");
                n.tenNCC = rs.getString("tenncc");
                n.diaChi = rs.getString("diachi");
                n.email = rs.getString("email");
                n.sDT = rs.getString("sdt");
                n.website = rs.getString("website");
                n.trangThai = rs.getInt("trangthai");
                ds.add(n); 
            }
//            kn.KetNoiDuLieu().close();
        } catch (SQLException ex) {
            Logger.getLogger(DSNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
     //thêm nhà cung câp
    public void themNCC(NhaCungCap l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themNCC(?,?,?,?,?,?)}");
            st.setString(1, l.maNCC);
            st.setString(2, l.tenNCC);
            st.setString(3, l.diaChi);
            st.setString(4, l.email);
            st.setString(5, l.sDT);
            st.setString(6, l.website);
            
            st.executeUpdate();
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSNhaCungCap.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    //xóa nhà cung câp
    public void xoaNCC(NhaCungCap l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call delete_NCC(?)}");
            st.setString(1, l.maNCC);
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSNhaCungCap.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public void suaNCC(NhaCungCap l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call update_NCC(?, ?,?,?,?,?)}");
            st.setString(1, l.maNCC);
            st.setString(2, l.tenNCC);
            st.setString(3, l.diaChi);
            st.setString(4, l.email);
            st.setString(5, l.sDT);
            st.setString(6, l.website);
            
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSLoaiSanPham.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public NhaCungCap timNhaCungCap(String where) {
        NhaCungCap kh = null;
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from NhaCungCap where trangthai = 0 and SDT = '" +where+ "'" ;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Kiểm tra xem ResultSet có hàng dữ liệu không
            if (rs.next()) {
                kh = new NhaCungCap();
                kh.maNCC = rs.getString("mancc");
                kh.tenNCC = rs.getString("tenncc");
                kh.diaChi = rs.getString("diachi");
                kh.email = rs.getString("email");
                kh.sDT = rs.getString("sdt");
                kh.website = rs.getString("website");
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kh;
    }
    
    public NhaCungCap layNhaCungCap(String where) {
        NhaCungCap kh = null;
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from NhaCungCap where trangthai = 0 and MANCC = '" +where+ "'" ;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Kiểm tra xem ResultSet có hàng dữ liệu không
            if (rs.next()) {
                kh = new NhaCungCap();
                kh.maNCC = rs.getString("mancc");
                kh.tenNCC = rs.getString("tenncc");
                kh.diaChi = rs.getString("diachi");
                kh.sDT = rs.getString("sdt");
                kh.email = rs.getString("email");
                kh.website = rs.getString("website");
            }

            rs.close(); // Đóng ResultSet sau khi sử dụng
            st.close(); // Đóng Statement sau khi sử dụng
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(NhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kh;
    }
}
