/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_cuahang_nhaccu_class;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class HoaDon {
    public String maHD, tenTKNV, maKH;
    public Date ngayLap;
    public int trangThai, tongtien;

    public HoaDon() {
    }

    public HoaDon(String maHD, String tenTKNV, String maKH, Date ngayLap, int trangThai, int tongtien) {
        this.maHD = maHD;
        this.tenTKNV = tenTKNV;
        this.maKH = maKH;
        this.ngayLap = ngayLap;
        this.trangThai = trangThai;
        this.tongtien = tongtien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenTKNV() {
        return tenTKNV;
    }

    public void setTenTKNV(String tenTKNV) {
        this.tenTKNV = tenTKNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
    
}
