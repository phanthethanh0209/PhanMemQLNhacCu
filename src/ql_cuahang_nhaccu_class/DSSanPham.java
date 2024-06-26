
package ql_cuahang_nhaccu_class;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSSanPham {
    public ArrayList<SanPham> layDSSanPham(String where) {
        ArrayList<SanPham> ds = new ArrayList<>();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from sanpham where trangthai = 0"+ where;
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                SanPham s = new SanPham();
                s.maSP = rs.getString("masp");                
                s.tenSP = rs.getString("tensp");
                s.maNCC = rs.getString("mancc");
                s.maLoai = rs.getString("maloai");
                s.maTH = rs.getString("mathuonghieu");
                s.mauSac = rs.getString("mausac");
                s.hinhAnh = rs.getString("hinhanh");
                s.soLuong = rs.getInt("soluong");
                s.thoiGianBH = rs.getInt("thoigianbh");
                s.giaNhap = rs.getInt("gianhap");
                s.giaBanLe = rs.getInt("giabanle");
                s.giaDangBai = rs.getInt("giadangbai");
                s.giaSi = rs.getInt("giasi");
                s.trangThai = rs.getInt("trangthai");
                ds.add(s); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public SanPham laySanPham(String masp) {
        SanPham s = new SanPham();
        try {
            KetNoi kn = new KetNoi();
            String sql = "select * from sanpham where masp =  '" + masp + "' ";
            Statement st = kn.KetNoiDuLieu().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                s.maSP = rs.getString("masp");                
                s.tenSP = rs.getString("tensp");
                s.maNCC = rs.getString("mancc");
                s.maLoai = rs.getString("maloai");
                s.maTH = rs.getString("mathuonghieu");
                s.mauSac = rs.getString("mausac");
                s.hinhAnh = rs.getString("hinhanh");
                s.soLuong = rs.getInt("soluong");
                s.thoiGianBH = rs.getInt("thoigianbh");
                s.giaNhap = rs.getInt("gianhap");
                s.giaBanLe = rs.getInt("giabanle");
                s.giaDangBai = rs.getInt("giadangbai");
                s.giaSi = rs.getInt("giasi");
                s.trangThai = rs.getInt("trangthai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    //thêm nhà cung câp
    public void themSanPham(SanPham l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call themSanPham(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            st.setString(1, l.maSP);
            st.setString(2, l.tenSP);
            st.setString(3, l.maLoai);
            st.setString(4, l.maNCC);
            st.setString(5, l.mauSac);
            st.setInt(6, l.giaBanLe);
            st.setInt(7, l.giaDangBai);
            st.setInt(8, l.giaNhap);
            st.setInt(9, l.giaSi);
            st.setInt(10, l.thoiGianBH);
            st.setInt(11, l.soLuong);
            st.setString(12, l.maTH);
            st.setString(13, l.hinhAnh);
            
            st.executeUpdate();
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    //xóa nhà cung câp
    public void xoaSanPham(SanPham l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call xoaSanPham(?)}");
            st.setString(1, l.maSP);
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
    
    public void suaSanPham(SanPham l)
    {
        try{
            KetNoi kn = new KetNoi();
            kn.KetNoiDuLieu();
            CallableStatement st= kn.KetNoiDuLieu().prepareCall("{call suaSanPham(?,?,?,?,?,?,?,?,?,?,?,?,?)}"); 
            st.setString(1, l.maSP);
            st.setString(2, l.tenSP);
            st.setString(3, l.maLoai);
            st.setString(4, l.maNCC);
            st.setString(5, l.mauSac);
            st.setInt(6, l.giaBanLe);
            st.setInt(7, l.giaDangBai);
            st.setInt(8, l.giaNhap);
            st.setInt(9, l.giaSi);
            st.setInt(10, l.thoiGianBH);
            st.setInt(11, l.soLuong);
            st.setString(12, l.maTH);
            st.setString(13, l.hinhAnh);
                        
            st.executeUpdate();
            
            kn.KetNoiDuLieu().close();
        }catch(SQLException EX)
        {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, EX);
        }
    }
}
