/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "theodoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theodoi.findAll", query = "SELECT t FROM Theodoi t"),
    @NamedQuery(name = "Theodoi.findByIDUser", query = "SELECT t FROM Theodoi t WHERE t.theodoiPK.iDUser = :iDUser"),
    @NamedQuery(name = "Theodoi.findByIDCuaHang", query = "SELECT t FROM Theodoi t WHERE t.theodoiPK.iDCuaHang = :iDCuaHang"),
    @NamedQuery(name = "Theodoi.findByTrangThai", query = "SELECT t FROM Theodoi t WHERE t.trangThai = :trangThai")})
public class Theodoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TheodoiPK theodoiPK;
    @Size(max = 45)
    @Column(name = "TrangThai")
    private String trangThai;
    @JoinColumn(name = "IDCuaHang", referencedColumnName = "IDCuaHang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuahang cuahang;
    @JoinColumn(name = "IDUser", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Theodoi() {
    }

    public Theodoi(TheodoiPK theodoiPK) {
        this.theodoiPK = theodoiPK;
    }

    public Theodoi(String iDUser, String iDCuaHang) {
        this.theodoiPK = new TheodoiPK(iDUser, iDCuaHang);
    }

    public TheodoiPK getTheodoiPK() {
        return theodoiPK;
    }

    public void setTheodoiPK(TheodoiPK theodoiPK) {
        this.theodoiPK = theodoiPK;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Cuahang getCuahang() {
        return cuahang;
    }

    public void setCuahang(Cuahang cuahang) {
        this.cuahang = cuahang;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (theodoiPK != null ? theodoiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theodoi)) {
            return false;
        }
        Theodoi other = (Theodoi) object;
        if ((this.theodoiPK == null && other.theodoiPK != null) || (this.theodoiPK != null && !this.theodoiPK.equals(other.theodoiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Theodoi[ theodoiPK=" + theodoiPK + " ]";
    }
    
}
