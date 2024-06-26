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
public class DSCTHoaDon {
    public ArrayList<CTHoaDon> layDSCTHoaDon(String where) {
        ArrayList<CTHoaDon> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from CTHoaDon cthd, hoadon hd where hd.mahd = cthd.mahd and hd.mahd = '"+ where +"' " ;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                CTHoaDon hd = new CTHoaDon();
                hd.maHD = rs.getString("mahd");
                hd.maSP = rs.getString("masp");
                hd.donGia = rs.getInt("dongia");
                hd.soLuong = rs.getInt("soluong");
                ds.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    //thêm hóa đơn
    public void themCTHoaDon(String mahd, String masp, int soluong, int dongia)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themCTHoaDon(?,?,?,?)}");
            st.setString(1, mahd);
            st.setString(2, masp);
            st.setInt(3, soluong);
            st.setInt(4, dongia);
            
            st.executeUpdate();
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSCTHoaDon.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
}
