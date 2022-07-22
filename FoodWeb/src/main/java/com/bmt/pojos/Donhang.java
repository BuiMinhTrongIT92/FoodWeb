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
@Table(name = "donhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donhang.findAll", query = "SELECT d FROM Donhang d"),
    @NamedQuery(name = "Donhang.findByIDDonHang", query = "SELECT d FROM Donhang d WHERE d.donhangPK.iDDonHang = :iDDonHang"),
    @NamedQuery(name = "Donhang.findByNgayTao", query = "SELECT d FROM Donhang d WHERE d.ngayTao = :ngayTao"),
    @NamedQuery(name = "Donhang.findBySoLuong", query = "SELECT d FROM Donhang d WHERE d.soLuong = :soLuong"),
    @NamedQuery(name = "Donhang.findByThanhTien", query = "SELECT d FROM Donhang d WHERE d.thanhTien = :thanhTien"),
    @NamedQuery(name = "Donhang.findByKhuyenMai", query = "SELECT d FROM Donhang d WHERE d.khuyenMai = :khuyenMai"),
    @NamedQuery(name = "Donhang.findByTrangThai", query = "SELECT d FROM Donhang d WHERE d.trangThai = :trangThai"),
    @NamedQuery(name = "Donhang.findByIDUser", query = "SELECT d FROM Donhang d WHERE d.donhangPK.iDUser = :iDUser"),
    @NamedQuery(name = "Donhang.findByIDCuaHang", query = "SELECT d FROM Donhang d WHERE d.donhangPK.iDCuaHang = :iDCuaHang")})
public class Donhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DonhangPK donhangPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayTao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLuong")
    private double soLuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ThanhTien")
    private double thanhTien;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KhuyenMai")
    private Double khuyenMai;
    @Size(max = 45)
    @Column(name = "TrangThai")
    private String trangThai;
    @JoinColumn(name = "IDCuaHang", referencedColumnName = "IDCuaHang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuahang cuahang;
    @JoinColumn(name = "IDUser", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donhang")
    private Set<DonhangMonan> donhangMonanSet;

    public Donhang() {
    }

    public Donhang(DonhangPK donhangPK) {
        this.donhangPK = donhangPK;
    }

    public Donhang(DonhangPK donhangPK, Date ngayTao, double soLuong, double thanhTien) {
        this.donhangPK = donhangPK;
        this.ngayTao = ngayTao;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public Donhang(String iDDonHang, String iDUser, String iDCuaHang) {
        this.donhangPK = new DonhangPK(iDDonHang, iDUser, iDCuaHang);
    }

    public DonhangPK getDonhangPK() {
        return donhangPK;
    }

    public void setDonhangPK(DonhangPK donhangPK) {
        this.donhangPK = donhangPK;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Double getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(Double khuyenMai) {
        this.khuyenMai = khuyenMai;
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
        hash += (donhangPK != null ? donhangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donhang)) {
            return false;
        }
        Donhang other = (Donhang) object;
        if ((this.donhangPK == null && other.donhangPK != null) || (this.donhangPK != null && !this.donhangPK.equals(other.donhangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojos.Donhang[ donhangPK=" + donhangPK + " ]";
    }
    
}
