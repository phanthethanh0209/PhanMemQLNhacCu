
package ql_cuahang_nhaccu_class;

import com.sun.istack.internal.logging.Logger;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author ASUS
 */
public class DSKhuyenMai {
    
    public ArrayList<KhuyenMai> layDSKhuyenMai(String where) {
        ArrayList<KhuyenMai> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from khuyenmai where trangthai= 0";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                KhuyenMai k = new KhuyenMai();
                k.maKM = rs.getString("makm");
                k.tenKM = rs.getString("tenkm");
                k.ngayBD = rs.getString("ngaybd");
                k.ngayKT = rs.getString("ngaykt");
                k.phanTramGiam = rs.getInt("phantramgiam");
                k.trangThai = rs.getInt("trangthai");
                ds.add(k);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DSKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public KhuyenMai layKhuyenMai(String makm) {
        KhuyenMai k = new KhuyenMai();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from khuyenmai where makm = '"+ makm +"' and trangthai = 0";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                k.maKM = rs.getString("makm");
                k.tenKM = rs.getString("tenkm");
                k.ngayBD = rs.getString("ngaybd");
                k.ngayKT = rs.getString("ngaykt");
                k.phanTramGiam = rs.getInt("phantramgiam");
                k.trangThai = rs.getInt("trangthai");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DSKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }
    
    //thêm loại sản phẩm
    public void themKhuyenMai(KhuyenMai l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themKM(?,?,?,?,?)}");
            st.setString(1, l.maKM);
            st.setString(2, l.tenKM);
            st.setString(3, l.ngayBD);
            st.setString(4, l.ngayKT);
            st.setInt(5, l.phanTramGiam);
            
            st.executeUpdate();
            
        }catch(SQLException EX)
        {
            java.util.logging.Logger.getLogger(DSKhuyenMai.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    //xóa loại sản phẩm
    public void xoaKhuyenMai(KhuyenMai l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call delete_KM(?)}");
            st.setString(1, l.maKM);
            st.executeUpdate();
            
        }catch(SQLException EX)
        {
            java.util.logging.Logger.getLogger(DSKhuyenMai.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public void suaKhuyenMai(KhuyenMai l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call update_KM(?,?,?,?,?)}");
            st.setString(1, l.maKM);
            st.setString(2, l.tenKM);
            st.setString(3, l.ngayBD);
            st.setString(4, l.ngayKT);
            st.setInt(5, l.phanTramGiam);
            st.executeUpdate();
            
        }catch(SQLException EX)
        {
            java.util.logging.Logger.getLogger(DSKhuyenMai.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
}
