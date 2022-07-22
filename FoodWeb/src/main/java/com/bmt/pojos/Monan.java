/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "monan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monan.findAll", query = "SELECT m FROM Monan m"),
    @NamedQuery(name = "Monan.findByIDMonAn", query = "SELECT m FROM Monan m WHERE m.monanPK.iDMonAn = :iDMonAn"),
    @NamedQuery(name = "Monan.findByTenMonAn", query = "SELECT m FROM Monan m WHERE m.tenMonAn = :tenMonAn"),
    @NamedQuery(name = "Monan.findByGia", query = "SELECT m FROM Monan m WHERE m.gia = :gia"),
    @NamedQuery(name = "Monan.findBySoLuong", query = "SELECT m FROM Monan m WHERE m.soLuong = :soLuong"),
    @NamedQuery(name = "Monan.findByThoiDiemBan", query = "SELECT m FROM Monan m WHERE m.thoiDiemBan = :thoiDiemBan"),
    @NamedQuery(name = "Monan.findByThoiDiemKetThuc", query = "SELECT m FROM Monan m WHERE m.thoiDiemKetThuc = :thoiDiemKetThuc"),
    @NamedQuery(name = "Monan.findByTrangThai", query = "SELECT m FROM Monan m WHERE m.trangThai = :trangThai"),
    @NamedQuery(name = "Monan.findByActive", query = "SELECT m FROM Monan m WHERE m.active = :active"),
    @NamedQuery(name = "Monan.findByIDCuaHang", query = "SELECT m FROM Monan m WHERE m.monanPK.iDCuaHang = :iDCuaHang")})
public class Monan implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MonanPK monanPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenMonAn")
    private String tenMonAn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gia")
    private double gia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SoLuong")
    private Double soLuong;
    @Column(name = "ThoiDiemBan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiDiemBan;
    @Column(name = "ThoiDiemKetThuc")
    private Double thoiDiemKetThuc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TrangThai")
    private boolean trangThai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Active")
    private boolean active;
    @ManyToMany(mappedBy = "monanSet")
    private Set<Menuthucan> menuthucanSet;
    @ManyToMany(mappedBy = "monanSet")
    private Set<Loaimonan> loaimonanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monan")
    private Set<Binhluan> binhluanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monan")
    private Set<Danhgia> danhgiaSet;
    @JoinColumn(name = "IDCuaHang", referencedColumnName = "IDCuaHang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuahang cuahang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monan")
    private Set<DonhangMonan> donhangMonanSet;

    public Monan() {
    }

    public Monan(MonanPK monanPK) {
        this.monanPK = monanPK;
    }

    public Monan(MonanPK monanPK, String tenMonAn, double gia, boolean trangThai, boolean active) {
        this.monanPK = monanPK;
        this.tenMonAn = tenMonAn;
        this.gia = gia;
        this.trangThai = trangThai;
        this.active = active;
    }

    public Monan(String iDMonAn, String iDCuaHang) {
        this.monanPK = new MonanPK(iDMonAn, iDCuaHang);
    }

    public MonanPK getMonanPK() {
        return monanPK;
    }

    public void setMonanPK(MonanPK monanPK) {
        this.monanPK = monanPK;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Double soLuong) {
        this.soLuong = soLuong;
    }

    public Date getThoiDiemBan() {
        return thoiDiemBan;
    }

    public void setThoiDiemBan(Date thoiDiemBan) {
        this.thoiDiemBan = thoiDiemBan;
    }

    public Double getThoiDiemKetThuc() {
        return thoiDiemKetThuc;
    }

    public void setThoiDiemKetThuc(Double thoiDiemKetThuc) {
        this.thoiDiemKetThuc = thoiDiemKetThuc;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Set<Menuthucan> getMenuthucanSet() {
        return menuthucanSet;
    }

    public void setMenuthucanSet(Set<Menuthucan> menuthucanSet) {
        this.menuthucanSet = menuthucanSet;
    }

    @XmlTransient
    public Set<Loaimonan> getLoaimonanSet() {
        return loaimonanSet;
    }

    public void setLoaimonanSet(Set<Loaimonan> loaimonanSet) {
        this.loaimonanSet = loaimonanSet;
    }

    @XmlTransient
    public Set<Binhluan> getBinhluanSet() {
        return binhluanSet;
    }

    public void setBinhluanSet(Set<Binhluan> binhluanSet) {
        this.binhluanSet = binhluanSet;
    }

    @XmlTransient
    public Set<Danhgia> getDanhgiaSet() {
        return danhgiaSet;
    }

    public void setDanhgiaSet(Set<Danhgia> danhgiaSet) {
        this.danhgiaSet = danhgiaSet;
    }

    public Cuahang getCuahang() {
        return cuahang;
    }

    public void setCuahang(Cuahang cuahang) {
        this.cuahang = cuahang;
    }

    @XmlTransient
    public Set<DonhangMonan> getDonhangMonanSet() {
        return donhangMonanSet;
    }

    public void setDonhangMonanSet(Set<DonhangMonan> donhangMonanSet) {
        this.donhangMonanSet = donhangMonanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monanPK != null ? monanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monan)) {
            return false;
        }
        Monan other = (Monan) object;
        if ((this.monanPK == null && other.monanPK != null) || (this.monanPK != null && !this.monanPK.equals(other.monanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojos.Monan[ monanPK=" + monanPK + " ]";
    }
    
}
