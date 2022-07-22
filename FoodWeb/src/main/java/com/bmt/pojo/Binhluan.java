/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "binhluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Binhluan.findAll", query = "SELECT b FROM Binhluan b"),
    @NamedQuery(name = "Binhluan.findByIDBinhLuan", query = "SELECT b FROM Binhluan b WHERE b.binhluanPK.iDBinhLuan = :iDBinhLuan"),
    @NamedQuery(name = "Binhluan.findByNoiDung", query = "SELECT b FROM Binhluan b WHERE b.noiDung = :noiDung"),
    @NamedQuery(name = "Binhluan.findByIDUser", query = "SELECT b FROM Binhluan b WHERE b.binhluanPK.iDUser = :iDUser"),
    @NamedQuery(name = "Binhluan.findByIDCuaHang", query = "SELECT b FROM Binhluan b WHERE b.binhluanPK.iDCuaHang = :iDCuaHang"),
    @NamedQuery(name = "Binhluan.findByIDMonAn", query = "SELECT b FROM Binhluan b WHERE b.binhluanPK.iDMonAn = :iDMonAn")})
public class Binhluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BinhluanPK binhluanPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "NoiDung")
    private String noiDung;
    @JoinColumn(name = "IDCuaHang", referencedColumnName = "IDCuaHang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuahang cuahang;
    @JoinColumn(name = "IDMonAn", referencedColumnName = "IDMonAn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Monan monan;
    @JoinColumn(name = "IDUser", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Binhluan() {
    }

    public Binhluan(BinhluanPK binhluanPK) {
        this.binhluanPK = binhluanPK;
    }

    public Binhluan(BinhluanPK binhluanPK, String noiDung) {
        this.binhluanPK = binhluanPK;
        this.noiDung = noiDung;
    }

    public Binhluan(String iDBinhLuan, String iDUser, String iDCuaHang, String iDMonAn) {
        this.binhluanPK = new BinhluanPK(iDBinhLuan, iDUser, iDCuaHang, iDMonAn);
    }

    public BinhluanPK getBinhluanPK() {
        return binhluanPK;
    }

    public void setBinhluanPK(BinhluanPK binhluanPK) {
        this.binhluanPK = binhluanPK;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Cuahang getCuahang() {
        return cuahang;
    }

    public void setCuahang(Cuahang cuahang) {
        this.cuahang = cuahang;
    }

    public Monan getMonan() {
        return monan;
    }

    public void setMonan(Monan monan) {
        this.monan = monan;
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
        hash += (binhluanPK != null ? binhluanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Binhluan)) {
            return false;
        }
        Binhluan other = (Binhluan) object;
        if ((this.binhluanPK == null && other.binhluanPK != null) || (this.binhluanPK != null && !this.binhluanPK.equals(other.binhluanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Binhluan[ binhluanPK=" + binhluanPK + " ]";
    }
    
}
