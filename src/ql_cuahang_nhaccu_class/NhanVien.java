/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_cuahang_nhaccu_class;

/**
 *
 * @author ASUS
 */
public class NhanVien {
     public String maNV, tenNV, diaChi, sDT, chucVu;
    public int trangThai, luong;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String diaChi, String sDT, String chucVu, int luong) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.diaChi = diaChi;
        this.sDT = sDT;
        this.chucVu= chucVu;
        this.luong= luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }
    
    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    
    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
    
    
    
    
}
