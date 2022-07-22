/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ACER
 */
@Embeddable
public class DanhgiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDanhGia")
    private int iDDanhGia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDMonAn")
    private String iDMonAn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDCuaHang")
    private String iDCuaHang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDUser")
    private String iDUser;

    public DanhgiaPK() {
    }

    public DanhgiaPK(int iDDanhGia, String iDMonAn, String iDCuaHang, String iDUser) {
        this.iDDanhGia = iDDanhGia;
        this.iDMonAn = iDMonAn;
        this.iDCuaHang = iDCuaHang;
        this.iDUser = iDUser;
    }

    public int getIDDanhGia() {
        return iDDanhGia;
    }

    public void setIDDanhGia(int iDDanhGia) {
        this.iDDanhGia = iDDanhGia;
    }

    public String getIDMonAn() {
        return iDMonAn;
    }

    public void setIDMonAn(String iDMonAn) {
        this.iDMonAn = iDMonAn;
    }

    public String getIDCuaHang() {
        return iDCuaHang;
    }

    public void setIDCuaHang(String iDCuaHang) {
        this.iDCuaHang = iDCuaHang;
    }

    public String getIDUser() {
        return iDUser;
    }

    public void setIDUser(String iDUser) {
        this.iDUser = iDUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDDanhGia;
        hash += (iDMonAn != null ? iDMonAn.hashCode() : 0);
        hash += (iDCuaHang != null ? iDCuaHang.hashCode() : 0);
        hash += (iDUser != null ? iDUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhgiaPK)) {
            return false;
        }
        DanhgiaPK other = (DanhgiaPK) object;
        if (this.iDDanhGia != other.iDDanhGia) {
            return false;
        }
        if ((this.iDMonAn == null && other.iDMonAn != null) || (this.iDMonAn != null && !this.iDMonAn.equals(other.iDMonAn))) {
            return false;
        }
        if ((this.iDCuaHang == null && other.iDCuaHang != null) || (this.iDCuaHang != null && !this.iDCuaHang.equals(other.iDCuaHang))) {
            return false;
        }
        if ((this.iDUser == null && other.iDUser != null) || (this.iDUser != null && !this.iDUser.equals(other.iDUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojos.DanhgiaPK[ iDDanhGia=" + iDDanhGia + ", iDMonAn=" + iDMonAn + ", iDCuaHang=" + iDCuaHang + ", iDUser=" + iDUser + " ]";
    }
    
}
