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
public class QuidinhPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "IDQuiDinh")
    private String iDQuiDinh;
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

    public QuidinhPK() {
    }

    public QuidinhPK(String iDQuiDinh, String iDUser, String iDCuaHang) {
        this.iDQuiDinh = iDQuiDinh;
        this.iDUser = iDUser;
        this.iDCuaHang = iDCuaHang;
    }

    public String getIDQuiDinh() {
        return iDQuiDinh;
    }

    public void setIDQuiDinh(String iDQuiDinh) {
        this.iDQuiDinh = iDQuiDinh;
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
        hash += (iDQuiDinh != null ? iDQuiDinh.hashCode() : 0);
        hash += (iDUser != null ? iDUser.hashCode() : 0);
        hash += (iDCuaHang != null ? iDCuaHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuidinhPK)) {
            return false;
        }
        QuidinhPK other = (QuidinhPK) object;
        if ((this.iDQuiDinh == null && other.iDQuiDinh != null) || (this.iDQuiDinh != null && !this.iDQuiDinh.equals(other.iDQuiDinh))) {
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
        return "com.bmt.pojo.QuidinhPK[ iDQuiDinh=" + iDQuiDinh + ", iDUser=" + iDUser + ", iDCuaHang=" + iDCuaHang + " ]";
    }
    
}
