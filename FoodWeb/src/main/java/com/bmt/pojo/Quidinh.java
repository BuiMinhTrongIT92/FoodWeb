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
@Table(name = "quidinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quidinh.findAll", query = "SELECT q FROM Quidinh q"),
    @NamedQuery(name = "Quidinh.findByIDQuiDinh", query = "SELECT q FROM Quidinh q WHERE q.quidinhPK.iDQuiDinh = :iDQuiDinh"),
    @NamedQuery(name = "Quidinh.findByTenQuiDinh", query = "SELECT q FROM Quidinh q WHERE q.tenQuiDinh = :tenQuiDinh"),
    @NamedQuery(name = "Quidinh.findByNoiDung", query = "SELECT q FROM Quidinh q WHERE q.noiDung = :noiDung"),
    @NamedQuery(name = "Quidinh.findByIDUser", query = "SELECT q FROM Quidinh q WHERE q.quidinhPK.iDUser = :iDUser"),
    @NamedQuery(name = "Quidinh.findByIDCuaHang", query = "SELECT q FROM Quidinh q WHERE q.quidinhPK.iDCuaHang = :iDCuaHang")})
public class Quidinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuidinhPK quidinhPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenQuiDinh")
    private String tenQuiDinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NoiDung")
    private String noiDung;
    @JoinColumn(name = "IDCuaHang", referencedColumnName = "IDCuaHang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuahang cuahang;
    @JoinColumn(name = "IDUser", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Quidinh() {
    }

    public Quidinh(QuidinhPK quidinhPK) {
        this.quidinhPK = quidinhPK;
    }

    public Quidinh(QuidinhPK quidinhPK, String tenQuiDinh, String noiDung) {
        this.quidinhPK = quidinhPK;
        this.tenQuiDinh = tenQuiDinh;
        this.noiDung = noiDung;
    }

    public Quidinh(String iDQuiDinh, String iDUser, String iDCuaHang) {
        this.quidinhPK = new QuidinhPK(iDQuiDinh, iDUser, iDCuaHang);
    }

    public QuidinhPK getQuidinhPK() {
        return quidinhPK;
    }

    public void setQuidinhPK(QuidinhPK quidinhPK) {
        this.quidinhPK = quidinhPK;
    }

    public String getTenQuiDinh() {
        return tenQuiDinh;
    }

    public void setTenQuiDinh(String tenQuiDinh) {
        this.tenQuiDinh = tenQuiDinh;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quidinhPK != null ? quidinhPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quidinh)) {
            return false;
        }
        Quidinh other = (Quidinh) object;
        if ((this.quidinhPK == null && other.quidinhPK != null) || (this.quidinhPK != null && !this.quidinhPK.equals(other.quidinhPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Quidinh[ quidinhPK=" + quidinhPK + " ]";
    }
    
}
