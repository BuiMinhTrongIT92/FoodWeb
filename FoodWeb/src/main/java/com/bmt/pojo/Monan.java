/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
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
    @NamedQuery(name = "Monan.findByIdmonan", query = "SELECT m FROM Monan m WHERE m.idmonan = :idmonan"),
    @NamedQuery(name = "Monan.findByTenmonan", query = "SELECT m FROM Monan m WHERE m.tenmonan = :tenmonan"),
    @NamedQuery(name = "Monan.findByGia", query = "SELECT m FROM Monan m WHERE m.gia = :gia"),
    @NamedQuery(name = "Monan.findBySoluong", query = "SELECT m FROM Monan m WHERE m.soluong = :soluong"),
    @NamedQuery(name = "Monan.findByThoidiemban", query = "SELECT m FROM Monan m WHERE m.thoidiemban = :thoidiemban"),
    @NamedQuery(name = "Monan.findByThoidiemketthuc", query = "SELECT m FROM Monan m WHERE m.thoidiemketthuc = :thoidiemketthuc"),
    @NamedQuery(name = "Monan.findByTrangthai", query = "SELECT m FROM Monan m WHERE m.trangthai = :trangthai"),
    @NamedQuery(name = "Monan.findByActive", query = "SELECT m FROM Monan m WHERE m.active = :active"),
    @NamedQuery(name = "Monan.findByAnhmonan", query = "SELECT m FROM Monan m WHERE m.anhmonan = :anhmonan")})
public class Monan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmonan")
    private Integer idmonan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenmonan")
    private String tenmonan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia")
    @Min(value = 10000, message = "{monan.gia.nhonhat}")
    private double gia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "soluong")
    private Double soluong;
    @Column(name = "thoidiemban")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoidiemban;
    @Column(name = "thoidiemketthuc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoidiemketthuc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trangthai")
    private boolean trangthai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Size(max = 500)
    @Column(name = "anhmonan")
    private String anhmonan;
    @JoinColumn(name = "idcuahang", referencedColumnName = "idcuahang")
    @ManyToOne(optional = false)
    private Cuahang idcuahang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmonan")
    @JsonIgnore
    private Set<MenuthucanMonan> menuthucanMonanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmonan")
    @JsonIgnore
    private Set<Binhluan> binhluanSet;
    @OneToMany(mappedBy = "idmonan")
    @JsonIgnore
    private Set<Danhgia> danhgiaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmonan")
    @JsonIgnore
    private Set<DonhangMonan> donhangMonanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmonan")
    @JsonIgnore
    private Set<MonanLoaimonan> monanLoaimonanSet;

    public Monan() {
    }

    public Monan(Integer idmonan) {
        this.idmonan = idmonan;
    }

    public Monan(Integer idmonan, String tenmonan, double gia, boolean trangthai, boolean active) {
        this.idmonan = idmonan;
        this.tenmonan = tenmonan;
        this.gia = gia;
        this.trangthai = trangthai;
        this.active = active;
    }

    public Integer getIdmonan() {
        return idmonan;
    }

    public void setIdmonan(Integer idmonan) {
        this.idmonan = idmonan;
    }

    public String getTenmonan() {
        return tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        this.tenmonan = tenmonan;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Double getSoluong() {
        return soluong;
    }

    public void setSoluong(Double soluong) {
        this.soluong = soluong;
    }

    public Date getThoidiemban() {
        return thoidiemban;
    }

    public void setThoidiemban(Date thoidiemban) {
        this.thoidiemban = thoidiemban;
    }

    public Date getThoidiemketthuc() {
        return thoidiemketthuc;
    }

    public void setThoidiemketthuc(Date thoidiemketthuc) {
        this.thoidiemketthuc = thoidiemketthuc;
    }

    public boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAnhmonan() {
        return anhmonan;
    }

    public void setAnhmonan(String anhmonan) {
        this.anhmonan = anhmonan;
    }

    public Cuahang getIdcuahang() {
        return idcuahang;
    }

    public void setIdcuahang(Cuahang idcuahang) {
        this.idcuahang = idcuahang;
    }

    @XmlTransient
    public Set<MenuthucanMonan> getMenuthucanMonanSet() {
        return menuthucanMonanSet;
    }

    public void setMenuthucanMonanSet(Set<MenuthucanMonan> menuthucanMonanSet) {
        this.menuthucanMonanSet = menuthucanMonanSet;
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

    @XmlTransient
    public Set<DonhangMonan> getDonhangMonanSet() {
        return donhangMonanSet;
    }

    public void setDonhangMonanSet(Set<DonhangMonan> donhangMonanSet) {
        this.donhangMonanSet = donhangMonanSet;
    }

    @XmlTransient
    public Set<MonanLoaimonan> getMonanLoaimonanSet() {
        return monanLoaimonanSet;
    }

    public void setMonanLoaimonanSet(Set<MonanLoaimonan> monanLoaimonanSet) {
        this.monanLoaimonanSet = monanLoaimonanSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmonan != null ? idmonan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monan)) {
            return false;
        }
        Monan other = (Monan) object;
        if ((this.idmonan == null && other.idmonan != null) || (this.idmonan != null && !this.idmonan.equals(other.idmonan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Monan[ idmonan=" + idmonan + " ]";
    }
    
}
