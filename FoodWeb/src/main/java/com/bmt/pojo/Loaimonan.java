/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "loaimonan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loaimonan.findAll", query = "SELECT l FROM Loaimonan l"),
    @NamedQuery(name = "Loaimonan.findByIdloaimonan", query = "SELECT l FROM Loaimonan l WHERE l.idloaimonan = :idloaimonan"),
    @NamedQuery(name = "Loaimonan.findByTenloai", query = "SELECT l FROM Loaimonan l WHERE l.tenloai = :tenloai"),
    @NamedQuery(name = "Loaimonan.findByActive", query = "SELECT l FROM Loaimonan l WHERE l.active = :active"),
    @NamedQuery(name = "Loaimonan.findByAnhloaimonan", query = "SELECT l FROM Loaimonan l WHERE l.anhloaimonan = :anhloaimonan")})
public class Loaimonan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idloaimonan")
    private Integer idloaimonan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tenloai")
    private String tenloai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Size(max = 200)
    @Column(name = "anhloaimonan")
    private String anhloaimonan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idloaimonan")
    private Set<MonanLoaimonan> monanLoaimonanSet;

    public Loaimonan() {
    }

    public Loaimonan(Integer idloaimonan) {
        this.idloaimonan = idloaimonan;
    }

    public Loaimonan(Integer idloaimonan, String tenloai, boolean active) {
        this.idloaimonan = idloaimonan;
        this.tenloai = tenloai;
        this.active = active;
    }

    public Integer getIdloaimonan() {
        return idloaimonan;
    }

    public void setIdloaimonan(Integer idloaimonan) {
        this.idloaimonan = idloaimonan;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAnhloaimonan() {
        return anhloaimonan;
    }

    public void setAnhloaimonan(String anhloaimonan) {
        this.anhloaimonan = anhloaimonan;
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
        hash += (idloaimonan != null ? idloaimonan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loaimonan)) {
            return false;
        }
        Loaimonan other = (Loaimonan) object;
        if ((this.idloaimonan == null && other.idloaimonan != null) || (this.idloaimonan != null && !this.idloaimonan.equals(other.idloaimonan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Loaimonan[ idloaimonan=" + idloaimonan + " ]";
    }
    
}
