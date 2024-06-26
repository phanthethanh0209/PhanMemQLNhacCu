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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DSPhieuNhap {
    public ArrayList<PhieuNhap> layDSPhieuNhap(String where) {
        ArrayList<PhieuNhap> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from PhieuNhapHang where trangthai = 0 " + where;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                PhieuNhap hd = new PhieuNhap();
                hd.maPNH = rs.getString("mapnh");
                hd.maNCC = rs.getString("mancc");
                hd.maNV = rs.getString("manv");
                hd.ngayNhap = rs.getTimestamp("ngaynhap");
                hd.trangThai = rs.getInt("trangthai");
                ds.add(hd);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public PhieuNhap layPhieuNhap(String mapn) {
        PhieuNhap pn = new PhieuNhap();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from PHIEUNHAPHANG where trangthai = 0 and mapn = '" + mapn + "'";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                pn.maPNH = rs.getString("mapnh");
                pn.maNCC = rs.getString("mancc");
                pn.maNV = rs.getString("manv");
                pn.ngayNhap = rs.getTimestamp("ngaynhap");
                pn.trangThai = rs.getInt("trangthai");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pn;
    }
    
    //thêm nhà cung câp
    public void themPhieuNhap(PhieuNhap l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themPhieuNhap(?,?,?,?)}");
            st.setString(1, l.maPNH);
            st.setString(2, l.maNCC);
            st.setString(3, l.maNV);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(l.ngayNhap);
            st.setString(4, formattedDate);
            //st.setDate(4, l.ngayNhap);
            
            st.executeUpdate();
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSPhieuNhap.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    //xóa nhà cung câp
    public void xoaPhieuNhap(PhieuNhap l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call delete_PhieuNhap(?)}");
            st.setString(1, l.maPNH);
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSPhieuNhap.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public void suaPhieuNhap(PhieuNhap l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call update_PhieuNhap(?,?,?,?)}");
            st.setString(1, l.maPNH);
            st.setString(2, l.maNCC);
            st.setString(3, l.maNV);
            //st.setDate(4, l.ngayNhap);
            
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSPhieuNhap.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
}
