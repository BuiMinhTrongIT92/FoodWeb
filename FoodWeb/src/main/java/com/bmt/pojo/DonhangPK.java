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
public class DonhangPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDDonHang")
    private String iDDonHang;
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

    public DonhangPK() {
    }

    public DonhangPK(String iDDonHang, String iDUser, String iDCuaHang) {
        this.iDDonHang = iDDonHang;
        this.iDUser = iDUser;
        this.iDCuaHang = iDCuaHang;
    }

    public String getIDDonHang() {
        return iDDonHang;
    }

    public void setIDDonHang(String iDDonHang) {
        this.iDDonHang = iDDonHang;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDDonHang != null ? iDDonHang.hashCode() : 0);
        hash += (iDUser != null ? iDUser.hashCode() : 0);
        hash += (iDCuaHang != null ? iDCuaHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonhangPK)) {
            return false;
        }
        DonhangPK other = (DonhangPK) object;
        if ((this.iDDonHang == null && other.iDDonHang != null) || (this.iDDonHang != null && !this.iDDonHang.equals(other.iDDonHang))) {
            return false;
        }
        if ((this.iDUser == null && other.iDUser != null) || (this.iDUser != null && !this.iDUser.equals(other.iDUser))) {
            return false;
        }
        if ((this.iDCuaHang == null && other.iDCuaHang != null) || (this.iDCuaHang != null && !this.iDCuaHang.equals(other.iDCuaHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.DonhangPK[ iDDonHang=" + iDDonHang + ", iDUser=" + iDUser + ", iDCuaHang=" + iDCuaHang + " ]";
    }
    
}
