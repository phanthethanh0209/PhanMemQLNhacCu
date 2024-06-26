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
public class DSThuongHieu {
    public ArrayList<ThuongHieu> layDSThuongHieu(String where) {
        ArrayList<ThuongHieu> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from thuonghieu where trangthai = 0 " + where;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                ThuongHieu n = new ThuongHieu();
                n.maTH = rs.getString("mathuonghieu");
                n.tenTH = rs.getString("tenthuonghieu");
                n.trangThai = rs.getInt("trangthai");
                ds.add(n); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSThuongHieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
     //thêm loại sản phẩm
    public void themThuongHieu(ThuongHieu l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themThuongHieu(?,?)}");
            st.setString(1, l.maTH);
            st.setString(2, l.tenTH);
            st.executeUpdate();
            
        }catch(SQLException EX)
        {
            Logger.getLogger(DSThuongHieu.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    //xóa loại sản phẩm
    public void xoaThuongHieu(ThuongHieu l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call delete_ThuongHieu(?)}");
            st.setString(1, l.maTH);
            st.executeUpdate();
            
        }catch(SQLException EX)
        {
            Logger.getLogger(DSThuongHieu.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public void suaThuongHieu(ThuongHieu l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call update_ThuongHieu(?, ?)}");
            st.setString(1, l.maTH);
            st.setString(2, l.tenTH);
            st.executeUpdate();
            
        }catch(SQLException EX)
        {
            Logger.getLogger(DSThuongHieu.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public ArrayList<ThuongHieu> layDSThuongHieuTheoNCC(String maNcc)
    {
         ArrayList<ThuongHieu> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select distinct ThuongHieu.MATHUONGHIEU, ThuongHieu.TENTHUONGHIEU from NHACUNGCAP, SANPHAM, THUONGHIEU where NHACUNGCAP.MANCC= SANPHAM.MANCC and SANPHAM.MATHUONGHIEU= THUONGHIEU.MATHUONGHIEU and nhacungcap.MANCC= '" + maNcc + "'";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                ThuongHieu l = new ThuongHieu();
                l.maTH = rs.getString("mathuonghieu");
                l.tenTH = rs.getString("tenthuonghieu");
                ds.add(l);
                
            }
            kn.KetNoiDuLieu().close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ThuongHieu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
}
