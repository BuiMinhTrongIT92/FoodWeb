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
import javax.persistence.Id;
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
    @NamedQuery(name = "Donhang.findByIddonhang", query = "SELECT d FROM Donhang d WHERE d.iddonhang = :iddonhang"),
    @NamedQuery(name = "Donhang.findByNgaytao", query = "SELECT d FROM Donhang d WHERE d.ngaytao = :ngaytao"),
    @NamedQuery(name = "Donhang.findByKhuyenmai", query = "SELECT d FROM Donhang d WHERE d.khuyenmai = :khuyenmai"),
    @NamedQuery(name = "Donhang.findByTrangthai", query = "SELECT d FROM Donhang d WHERE d.trangthai = :trangthai"),
    @NamedQuery(name = "Donhang.findByTongtien", query = "SELECT d FROM Donhang d WHERE d.tongtien = :tongtien")})
public class Donhang implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddonhang")
    @JsonIgnore
    private Set<DonhangMonan> donhangMonanSet;

    private static long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "iddonhang")
    private String iddonhang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaytao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "khuyenmai")
    private Double khuyenmai;
    @Size(max = 45)
    @Column(name = "trangthai")
    private String trangthai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tongtien")
    private double tongtien;
    @JoinColumn(name = "idcuahang", referencedColumnName = "idcuahang")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Cuahang idcuahang;
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User iduser;

    public Donhang() {
    }

    public Donhang(String iddonhang) {
        this.iddonhang = iddonhang;
    }

    public Donhang(String iddonhang, Date ngaytao, double tongtien) {
        this.iddonhang = iddonhang;
        this.ngaytao = ngaytao;
        this.tongtien = tongtien;
    }

    public String getIddonhang() {
        return iddonhang;
    }

    public void setIddonhang(String iddonhang) {
        this.iddonhang = iddonhang;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Double getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(Double khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public Cuahang getIdcuahang() {
        return idcuahang;
    }

    public void setIdcuahang(Cuahang idcuahang) {
        this.idcuahang = idcuahang;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIddonhang() != null ? getIddonhang().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donhang)) {
            return false;
        }
        Donhang other = (Donhang) object;
        if ((this.getIddonhang() == null && other.getIddonhang() != null) || (this.getIddonhang() != null && !this.iddonhang.equals(other.iddonhang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Donhang[ iddonhang=" + getIddonhang() + " ]";
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    @XmlTransient
    public Set<DonhangMonan> getDonhangMonanSet() {
        return donhangMonanSet;
    }

    public void setDonhangMonanSet(Set<DonhangMonan> donhangMonanSet) {
        this.donhangMonanSet = donhangMonanSet;
    }
    
}
