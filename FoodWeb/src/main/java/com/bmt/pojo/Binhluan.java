/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Binhluan.findByIdbinhluan", query = "SELECT b FROM Binhluan b WHERE b.idbinhluan = :idbinhluan"),
    @NamedQuery(name = "Binhluan.findByNoidung", query = "SELECT b FROM Binhluan b WHERE b.noidung = :noidung")})
public class Binhluan implements Serializable {

    @Column(name = "thoigian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigian = new Date();

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbinhluan")
    private Integer idbinhluan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "noidung")
    private String noidung;
    @JoinColumn(name = "idcuahang", referencedColumnName = "idcuahang")
    @ManyToOne(optional = false)
    private Cuahang idcuahang;
    @JoinColumn(name = "idmonan", referencedColumnName = "idmonan")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Monan idmonan;
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonProperty("user")
    private User iduser;

    public Binhluan() {
    }

    public Binhluan(Integer idbinhluan) {
        this.idbinhluan = idbinhluan;
    }

    public Binhluan(Integer idbinhluan, String noidung) {
        this.idbinhluan = idbinhluan;
        this.noidung = noidung;
    }

    public Integer getIdbinhluan() {
        return idbinhluan;
    }

    public void setIdbinhluan(Integer idbinhluan) {
        this.idbinhluan = idbinhluan;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Cuahang getIdcuahang() {
        return idcuahang;
    }

    public void setIdcuahang(Cuahang idcuahang) {
        this.idcuahang = idcuahang;
    }

    public Monan getIdmonan() {
        return idmonan;
    }

    public void setIdmonan(Monan idmonan) {
        this.idmonan = idmonan;
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
        hash += (idbinhluan != null ? idbinhluan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Binhluan)) {
            return false;
        }
        Binhluan other = (Binhluan) object;
        if ((this.idbinhluan == null && other.idbinhluan != null) || (this.idbinhluan != null && !this.idbinhluan.equals(other.idbinhluan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Binhluan[ idbinhluan=" + idbinhluan + " ]";
    }  

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }
}
