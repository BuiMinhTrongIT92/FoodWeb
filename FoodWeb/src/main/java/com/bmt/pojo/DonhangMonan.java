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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "donhang_monan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonhangMonan.findAll", query = "SELECT d FROM DonhangMonan d"),
    @NamedQuery(name = "DonhangMonan.findByIDDonHang", query = "SELECT d FROM DonhangMonan d WHERE d.donhangMonanPK.iDDonHang = :iDDonHang"),
    @NamedQuery(name = "DonhangMonan.findByIDMonAn", query = "SELECT d FROM DonhangMonan d WHERE d.donhangMonanPK.iDMonAn = :iDMonAn"),
    @NamedQuery(name = "DonhangMonan.findBySoLuong", query = "SELECT d FROM DonhangMonan d WHERE d.soLuong = :soLuong")})
public class DonhangMonan implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DonhangMonanPK donhangMonanPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLuong")
    private int soLuong;
    @JoinColumn(name = "IDDonHang", referencedColumnName = "IDDonHang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Donhang donhang;
    @JoinColumn(name = "IDMonAn", referencedColumnName = "IDMonAn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Monan monan;

    public DonhangMonan() {
    }

    public DonhangMonan(DonhangMonanPK donhangMonanPK) {
        this.donhangMonanPK = donhangMonanPK;
    }

    public DonhangMonan(DonhangMonanPK donhangMonanPK, int soLuong) {
        this.donhangMonanPK = donhangMonanPK;
        this.soLuong = soLuong;
    }

    public DonhangMonan(String iDDonHang, String iDMonAn) {
        this.donhangMonanPK = new DonhangMonanPK(iDDonHang, iDMonAn);
    }

    public DonhangMonanPK getDonhangMonanPK() {
        return donhangMonanPK;
    }

    public void setDonhangMonanPK(DonhangMonanPK donhangMonanPK) {
        this.donhangMonanPK = donhangMonanPK;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Donhang getDonhang() {
        return donhang;
    }

    public void setDonhang(Donhang donhang) {
        this.donhang = donhang;
    }

    public Monan getMonan() {
        return monan;
    }

    public void setMonan(Monan monan) {
        this.monan = monan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donhangMonanPK != null ? donhangMonanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonhangMonan)) {
            return false;
        }
        DonhangMonan other = (DonhangMonan) object;
        if ((this.donhangMonanPK == null && other.donhangMonanPK != null) || (this.donhangMonanPK != null && !this.donhangMonanPK.equals(other.donhangMonanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.DonhangMonan[ donhangMonanPK=" + donhangMonanPK + " ]";
    }
    
}
