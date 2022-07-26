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
    @NamedQuery(name = "Loaimonan.findByIDLoaiMonAn", query = "SELECT l FROM Loaimonan l WHERE l.iDLoaiMonAn = :iDLoaiMonAn"),
    @NamedQuery(name = "Loaimonan.findByTenLoai", query = "SELECT l FROM Loaimonan l WHERE l.tenLoai = :tenLoai"),
    @NamedQuery(name = "Loaimonan.findByActive", query = "SELECT l FROM Loaimonan l WHERE l.active = :active")})
public class Loaimonan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLoaiMonAn")
    private Integer iDLoaiMonAn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TenLoai")
    private String tenLoai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Active")
    private boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idloaimonan")
    private Set<MonanLoaimonan> monanLoaimonanSet;

    public Loaimonan() {
    }

    public Loaimonan(Integer iDLoaiMonAn) {
        this.iDLoaiMonAn = iDLoaiMonAn;
    }

    public Loaimonan(Integer iDLoaiMonAn, String tenLoai, boolean active) {
        this.iDLoaiMonAn = iDLoaiMonAn;
        this.tenLoai = tenLoai;
        this.active = active;
    }

    public Integer getIDLoaiMonAn() {
        return iDLoaiMonAn;
    }

    public void setIDLoaiMonAn(Integer iDLoaiMonAn) {
        this.iDLoaiMonAn = iDLoaiMonAn;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
        hash += (iDLoaiMonAn != null ? iDLoaiMonAn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loaimonan)) {
            return false;
        }
        Loaimonan other = (Loaimonan) object;
        if ((this.iDLoaiMonAn == null && other.iDLoaiMonAn != null) || (this.iDLoaiMonAn != null && !this.iDLoaiMonAn.equals(other.iDLoaiMonAn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Loaimonan[ iDLoaiMonAn=" + iDLoaiMonAn + " ]";
    }
    
}
