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
public class ThuongHieu {
    public String maTH, tenTH;
    public int trangThai;

    public ThuongHieu() {
    }

    public ThuongHieu(String maTH, String tenTH) {
        this.maTH = maTH;
        this.tenTH = tenTH;
    }

    public String getMaTH() {
        return maTH;
    }

    public void setMaTH(String maTH) {
        this.maTH = maTH;
    }

    public String getTenTH() {
        return tenTH;
    }

    public void setTenTH(String tenTH) {
        this.tenTH = tenTH;
    }
    
    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
