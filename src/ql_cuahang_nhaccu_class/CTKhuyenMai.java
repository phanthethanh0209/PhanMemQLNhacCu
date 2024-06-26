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
public class CTKhuyenMai {
    public String maKM, maSP;

    public CTKhuyenMai() {
    }

    public CTKhuyenMai(String maKM, String maSP) {
        this.maKM = maKM;
        this.maSP = maSP;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    
}
