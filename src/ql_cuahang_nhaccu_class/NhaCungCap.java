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
public class NhaCungCap {
    public String maNCC, tenNCC, diaChi, email, sDT, website;
    public int trangThai;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String email, String sDT, String website, int trangThai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.email = email;
        this.sDT = sDT;
        this.website = website;
        this.trangThai = trangThai;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
