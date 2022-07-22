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
public class MenuthucanPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDMenuThucAn")
    private String iDMenuThucAn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDCuaHang")
    private String iDCuaHang;

    public MenuthucanPK() {
    }

    public MenuthucanPK(String iDMenuThucAn, String iDCuaHang) {
        this.iDMenuThucAn = iDMenuThucAn;
        this.iDCuaHang = iDCuaHang;
    }

    public String getIDMenuThucAn() {
        return iDMenuThucAn;
    }

    public void setIDMenuThucAn(String iDMenuThucAn) {
        this.iDMenuThucAn = iDMenuThucAn;
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
        hash += (iDMenuThucAn != null ? iDMenuThucAn.hashCode() : 0);
        hash += (iDCuaHang != null ? iDCuaHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuthucanPK)) {
            return false;
        }
        MenuthucanPK other = (MenuthucanPK) object;
        if ((this.iDMenuThucAn == null && other.iDMenuThucAn != null) || (this.iDMenuThucAn != null && !this.iDMenuThucAn.equals(other.iDMenuThucAn))) {
            return false;
        }
        if ((this.iDCuaHang == null && other.iDCuaHang != null) || (this.iDCuaHang != null && !this.iDCuaHang.equals(other.iDCuaHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojos.MenuthucanPK[ iDMenuThucAn=" + iDMenuThucAn + ", iDCuaHang=" + iDCuaHang + " ]";
    }
    
}
