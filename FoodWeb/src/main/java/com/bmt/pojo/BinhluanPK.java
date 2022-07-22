/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

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
public class BinhluanPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDBinhLuan")
    private String iDBinhLuan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDUser")
    private String iDUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDCuaHang")
    private String iDCuaHang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDMonAn")
    private String iDMonAn;

    public BinhluanPK() {
    }

    public BinhluanPK(String iDBinhLuan, String iDUser, String iDCuaHang, String iDMonAn) {
        this.iDBinhLuan = iDBinhLuan;
        this.iDUser = iDUser;
        this.iDCuaHang = iDCuaHang;
        this.iDMonAn = iDMonAn;
    }

    public String getIDBinhLuan() {
        return iDBinhLuan;
    }

    public void setIDBinhLuan(String iDBinhLuan) {
        this.iDBinhLuan = iDBinhLuan;
    }

    public String getIDUser() {
        return iDUser;
    }

    public void setIDUser(String iDUser) {
        this.iDUser = iDUser;
    }

    public String getIDCuaHang() {
        return iDCuaHang;
    }

    public void setIDCuaHang(String iDCuaHang) {
        this.iDCuaHang = iDCuaHang;
    }

    public String getIDMonAn() {
        return iDMonAn;
    }

    public void setIDMonAn(String iDMonAn) {
        this.iDMonAn = iDMonAn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDBinhLuan != null ? iDBinhLuan.hashCode() : 0);
        hash += (iDUser != null ? iDUser.hashCode() : 0);
        hash += (iDCuaHang != null ? iDCuaHang.hashCode() : 0);
        hash += (iDMonAn != null ? iDMonAn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BinhluanPK)) {
            return false;
        }
        BinhluanPK other = (BinhluanPK) object;
        if ((this.iDBinhLuan == null && other.iDBinhLuan != null) || (this.iDBinhLuan != null && !this.iDBinhLuan.equals(other.iDBinhLuan))) {
            return false;
        }
        if ((this.iDUser == null && other.iDUser != null) || (this.iDUser != null && !this.iDUser.equals(other.iDUser))) {
            return false;
        }
        if ((this.iDCuaHang == null && other.iDCuaHang != null) || (this.iDCuaHang != null && !this.iDCuaHang.equals(other.iDCuaHang))) {
            return false;
        }
        if ((this.iDMonAn == null && other.iDMonAn != null) || (this.iDMonAn != null && !this.iDMonAn.equals(other.iDMonAn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.BinhluanPK[ iDBinhLuan=" + iDBinhLuan + ", iDUser=" + iDUser + ", iDCuaHang=" + iDCuaHang + ", iDMonAn=" + iDMonAn + " ]";
    }
    
}
