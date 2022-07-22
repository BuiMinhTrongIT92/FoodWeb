/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "cuahang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuahang.findAll", query = "SELECT c FROM Cuahang c"),
    @NamedQuery(name = "Cuahang.findByIDCuaHang", query = "SELECT c FROM Cuahang c WHERE c.cuahangPK.iDCuaHang = :iDCuaHang"),
    @NamedQuery(name = "Cuahang.findByTenCuaHang", query = "SELECT c FROM Cuahang c WHERE c.tenCuaHang = :tenCuaHang"),
    @NamedQuery(name = "Cuahang.findByDiaChi", query = "SELECT c FROM Cuahang c WHERE c.diaChi = :diaChi"),
    @NamedQuery(name = "Cuahang.findByIDUser", query = "SELECT c FROM Cuahang c WHERE c.cuahangPK.iDUser = :iDUser")})
public class Cuahang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuahangPK cuahangPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenCuaHang")
    private String tenCuaHang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DiaChi")
    private String diaChi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuahang")
    private Set<Donhang> donhangSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuahang")
    private Set<Binhluan> binhluanSet;
    @JoinColumn(name = "IDUser", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuahang")
    private Set<Quidinh> quidinhSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuahang")
    private Set<Danhgia> danhgiaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuahang")
    private Set<Monan> monanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuahang")
    private Set<Theodoi> theodoiSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuahang")
    private Set<Menuthucan> menuthucanSet;

    public Cuahang() {
    }

    public Cuahang(CuahangPK cuahangPK) {
        this.cuahangPK = cuahangPK;
    }

    public Cuahang(CuahangPK cuahangPK, String tenCuaHang, String diaChi) {
        this.cuahangPK = cuahangPK;
        this.tenCuaHang = tenCuaHang;
        this.diaChi = diaChi;
    }

    public Cuahang(String iDCuaHang, String iDUser) {
        this.cuahangPK = new CuahangPK(iDCuaHang, iDUser);
    }

    public CuahangPK getCuahangPK() {
        return cuahangPK;
    }

    public void setCuahangPK(CuahangPK cuahangPK) {
        this.cuahangPK = cuahangPK;
    }

    public String getTenCuaHang() {
        return tenCuaHang;
    }

    public void setTenCuaHang(String tenCuaHang) {
        this.tenCuaHang = tenCuaHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @XmlTransient
    public Set<Donhang> getDonhangSet() {
        return donhangSet;
    }

    public void setDonhangSet(Set<Donhang> donhangSet) {
        this.donhangSet = donhangSet;
    }

    @XmlTransient
    public Set<Binhluan> getBinhluanSet() {
        return binhluanSet;
    }

    public void setBinhluanSet(Set<Binhluan> binhluanSet) {
        this.binhluanSet = binhluanSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @XmlTransient
    public Set<Quidinh> getQuidinhSet() {
        return quidinhSet;
    }

    public void setQuidinhSet(Set<Quidinh> quidinhSet) {
        this.quidinhSet = quidinhSet;
    }

    @XmlTransient
    public Set<Danhgia> getDanhgiaSet() {
        return danhgiaSet;
    }

    public void setDanhgiaSet(Set<Danhgia> danhgiaSet) {
        this.danhgiaSet = danhgiaSet;
    }

    @XmlTransient
    public Set<Monan> getMonanSet() {
        return monanSet;
    }

    public void setMonanSet(Set<Monan> monanSet) {
        this.monanSet = monanSet;
    }

    @XmlTransient
    public Set<Theodoi> getTheodoiSet() {
        return theodoiSet;
    }

    public void setTheodoiSet(Set<Theodoi> theodoiSet) {
        this.theodoiSet = theodoiSet;
    }

    @XmlTransient
    public Set<Menuthucan> getMenuthucanSet() {
        return menuthucanSet;
    }

    public void setMenuthucanSet(Set<Menuthucan> menuthucanSet) {
        this.menuthucanSet = menuthucanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuahangPK != null ? cuahangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuahang)) {
            return false;
        }
        Cuahang other = (Cuahang) object;
        if ((this.cuahangPK == null && other.cuahangPK != null) || (this.cuahangPK != null && !this.cuahangPK.equals(other.cuahangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Cuahang[ cuahangPK=" + cuahangPK + " ]";
    }
    
}
