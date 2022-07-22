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
@Table(name = "danhgia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Danhgia.findAll", query = "SELECT d FROM Danhgia d"),
    @NamedQuery(name = "Danhgia.findByIDDanhGia", query = "SELECT d FROM Danhgia d WHERE d.danhgiaPK.iDDanhGia = :iDDanhGia"),
    @NamedQuery(name = "Danhgia.findBySao", query = "SELECT d FROM Danhgia d WHERE d.sao = :sao"),
    @NamedQuery(name = "Danhgia.findByIDMonAn", query = "SELECT d FROM Danhgia d WHERE d.danhgiaPK.iDMonAn = :iDMonAn"),
    @NamedQuery(name = "Danhgia.findByIDCuaHang", query = "SELECT d FROM Danhgia d WHERE d.danhgiaPK.iDCuaHang = :iDCuaHang"),
    @NamedQuery(name = "Danhgia.findByIDUser", query = "SELECT d FROM Danhgia d WHERE d.danhgiaPK.iDUser = :iDUser")})
public class Danhgia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DanhgiaPK danhgiaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sao")
    private double sao;
    @JoinColumn(name = "IDCuaHang", referencedColumnName = "IDCuaHang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuahang cuahang;
    @JoinColumn(name = "IDMonAn", referencedColumnName = "IDMonAn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Monan monan;
    @JoinColumn(name = "IDUser", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Danhgia() {
    }

    public Danhgia(DanhgiaPK danhgiaPK) {
        this.danhgiaPK = danhgiaPK;
    }

    public Danhgia(DanhgiaPK danhgiaPK, double sao) {
        this.danhgiaPK = danhgiaPK;
        this.sao = sao;
    }

    public Danhgia(int iDDanhGia, String iDMonAn, String iDCuaHang, String iDUser) {
        this.danhgiaPK = new DanhgiaPK(iDDanhGia, iDMonAn, iDCuaHang, iDUser);
    }

    public DanhgiaPK getDanhgiaPK() {
        return danhgiaPK;
    }

    public void setDanhgiaPK(DanhgiaPK danhgiaPK) {
        this.danhgiaPK = danhgiaPK;
    }

    public double getSao() {
        return sao;
    }

    public void setSao(double sao) {
        this.sao = sao;
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
        hash += (danhgiaPK != null ? danhgiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Danhgia)) {
            return false;
        }
        Danhgia other = (Danhgia) object;
        if ((this.danhgiaPK == null && other.danhgiaPK != null) || (this.danhgiaPK != null && !this.danhgiaPK.equals(other.danhgiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Danhgia[ danhgiaPK=" + danhgiaPK + " ]";
    }
    
}
