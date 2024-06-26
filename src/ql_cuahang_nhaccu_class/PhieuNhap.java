/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_cuahang_nhaccu_class;

import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS
 */
public class PhieuNhap {
     public String maPNH, maNV, maNCC;
    public Timestamp ngayNhap;
    public int trangThai;
    

    public PhieuNhap() {
    }

    public PhieuNhap(String maPNH, String maNV, String maNCC, Timestamp ngayNhap, int trangThai) {
        this.maPNH = maPNH;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
    }

    public PhieuNhap(java.util.Date exampleDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaPNH() {
        return maPNH;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Timestamp ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    public String formatNgayNhap() {
        SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return outputFormatter.format(ngayNhap);
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
    
}
