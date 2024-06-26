/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_cuahang_nhaccu_class;

import java.sql.CallableStatement;
import java.util.Date;
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
public class DSHoaDon {
    public ArrayList<HoaDon> layDSHoaDon(String where) {
        ArrayList<HoaDon> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from HoaDon where trangthai = 0 " + where;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                HoaDon hd = new HoaDon();
                hd.maHD = rs.getString("mahd");
                hd.maKH = rs.getString("makh");
                hd.tenTKNV = rs.getString("tentknv");
                hd.ngayLap = rs.getTimestamp("ngaylap");
                hd.tongtien = rs.getInt("tongtien");
                hd.trangThai = rs.getInt("trangthai");
                ds.add(hd);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public HoaDon layHoaDon(String mahd) {
        HoaDon hd = new HoaDon();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from HoaDon where trangthai = 0 and mahd = '" + mahd + "'";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                hd.maHD = rs.getString("mahd");
                hd.maKH = rs.getString("makh");
                hd.tenTKNV = rs.getString("tentknv");
                hd.ngayLap = rs.getTimestamp("ngayLap");
                hd.trangThai = rs.getInt("trangthai");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hd;
    }
    
    //thêm hóa đơn
    public void themHoaDon(HoaDon l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themHoaDon(?,?,?,?,?)}");
            st.setString(1, l.maHD);
            st.setString(2, l.tenTKNV);
            st.setString(3, l.maKH);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedDate = dateFormat.format(l.ngayLap);
            st.setString(4, formattedDate);
            st.setInt(5, l.tongtien);
            
            st.executeUpdate();
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSHoaDon.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
}
