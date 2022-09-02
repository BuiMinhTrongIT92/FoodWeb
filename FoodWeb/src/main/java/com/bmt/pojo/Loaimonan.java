/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
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

    private static long serialVersionUID = 1L;
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
    @JsonIgnore
    private Set<MonanLoaimonan> monanLoaimonanSet;
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonProperty("user")
    @JsonIgnore
    private User iduser;

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
        return isActive();
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
        hash += (getIdloaimonan() != null ? getIdloaimonan().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loaimonan)) {
            return false;
        }
        Loaimonan other = (Loaimonan) object;
        if ((this.getIdloaimonan() == null && other.getIdloaimonan() != null) || (this.getIdloaimonan() != null && !this.idloaimonan.equals(other.idloaimonan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Loaimonan[ idloaimonan=" + getIdloaimonan() + " ]";
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

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @return the iduser
     */
    public User getIduser() {
        return iduser;
    }

    /**
     * @param iduser the iduser to set
     */
    public void setIduser(User iduser) {
        this.iduser = iduser;
    }
    
}
