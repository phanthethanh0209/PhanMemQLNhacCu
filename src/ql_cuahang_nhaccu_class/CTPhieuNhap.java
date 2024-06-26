/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_cuahang_nhaccu_class;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class CTPhieuNhap {
    public String maPNH, maSP;
    public int soLuong, donGia ,trangThai;

    public CTPhieuNhap() {
    }

    public CTPhieuNhap(String maPNH, String maSP, int soLuong, int donGia, int trangThai) {
        this.maPNH = maPNH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public String getMaPNH() {
        return maPNH;
    }

    public void setMaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
    
}
