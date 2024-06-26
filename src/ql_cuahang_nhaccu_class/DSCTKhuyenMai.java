
package ql_cuahang_nhaccu_class;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSCTKhuyenMai {
    
    public ArrayList<CTKhuyenMai> layDSCTKhuyenMai(String makm) {
        ArrayList<CTKhuyenMai> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select makm, masp from ctkhuyenmai where trangthai= 0 and makm = '"+ makm +"'";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                CTKhuyenMai l = new CTKhuyenMai();
                l.maKM = rs.getString("makm");
                l.maSP = rs.getString("masp");
                ds.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public CTKhuyenMai layCTKhuyenMai(String masp) {
        CTKhuyenMai l = new CTKhuyenMai();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from ctkhuyenmai where trangthai= 0 and masp = '" + masp + "'";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                l.maKM = rs.getString("makm");
                l.maSP = rs.getString("masp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    public CTKhuyenMai layKhuyenMai(String masp) {
        CTKhuyenMai s = new CTKhuyenMai();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select makm from ctkhuyenmai where trangthai= 0 and masp = '" + masp + "'";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                s.maKM = rs.getString("makm");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTKhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    //thêm 
    public void themCTKhuyenMai(CTKhuyenMai l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themCTKM(?,?)}");
            st.setString(1, l.maKM);
            st.setString(2, l.maSP);
                        
            st.executeUpdate();
            
        }catch(SQLException EX)
        {
            java.util.logging.Logger.getLogger(DSCTKhuyenMai.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    //xóa nhà cung câp
    public void xoaCTKhuyenMai(CTKhuyenMai l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call xoaCTKhuyenMai(?,?)}");
            st.setString(1, l.maKM);
            st.setString(2, l.maSP);
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSCTKhuyenMai.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
}
