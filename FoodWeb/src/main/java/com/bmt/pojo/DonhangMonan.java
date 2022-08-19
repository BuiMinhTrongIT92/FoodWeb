/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
    @NamedQuery(name = "DonhangMonan.findByIddonhangmonan", query = "SELECT d FROM DonhangMonan d WHERE d.iddonhangmonan = :iddonhangmonan"),
    @NamedQuery(name = "DonhangMonan.findBySoluong", query = "SELECT d FROM DonhangMonan d WHERE d.soluong = :soluong"),
    @NamedQuery(name = "DonhangMonan.findByGia", query = "SELECT d FROM DonhangMonan d WHERE d.gia = :gia"),
    @NamedQuery(name = "DonhangMonan.findByTongtien", query = "SELECT d FROM DonhangMonan d WHERE d.tongtien = :tongtien")})
public class DonhangMonan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddonhangmonan")
    private Integer iddonhangmonan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluong")
    private int soluong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia")
    private double gia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tongtien")
    private double tongtien;
    @JoinColumn(name = "iddonhang", referencedColumnName = "iddonhang")
    @ManyToOne(optional = false)
    private Donhang iddonhang;
    @JoinColumn(name = "idmonan", referencedColumnName = "idmonan")
    @ManyToOne(optional = false)
    private Monan idmonan;

    public DonhangMonan() {
    }

    public DonhangMonan(Integer iddonhangmonan) {
        this.iddonhangmonan = iddonhangmonan;
    }

    public DonhangMonan(Integer iddonhangmonan, int soluong, double gia, double tongtien) {
        this.iddonhangmonan = iddonhangmonan;
        this.soluong = soluong;
        this.gia = gia;
        this.tongtien = tongtien;
    }

    public Integer getIddonhangmonan() {
        return iddonhangmonan;
    }

    public void setIddonhangmonan(Integer iddonhangmonan) {
        this.iddonhangmonan = iddonhangmonan;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public Donhang getIddonhang() {
        return iddonhang;
    }

    public void setIddonhang(Donhang iddonhang) {
        this.iddonhang = iddonhang;
    }

    public Monan getIdmonan() {
        return idmonan;
    }

    public void setIdmonan(Monan idmonan) {
        this.idmonan = idmonan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddonhangmonan != null ? iddonhangmonan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonhangMonan)) {
            return false;
        }
        DonhangMonan other = (DonhangMonan) object;
        if ((this.iddonhangmonan == null && other.iddonhangmonan != null) || (this.iddonhangmonan != null && !this.iddonhangmonan.equals(other.iddonhangmonan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.DonhangMonan[ iddonhangmonan=" + iddonhangmonan + " ]";
    }
    
}
