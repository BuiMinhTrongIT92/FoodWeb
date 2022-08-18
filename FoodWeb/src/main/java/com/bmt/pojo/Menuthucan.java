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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "menuthucan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menuthucan.findAll", query = "SELECT m FROM Menuthucan m"),
    @NamedQuery(name = "Menuthucan.findByIdmenuthucan", query = "SELECT m FROM Menuthucan m WHERE m.idmenuthucan = :idmenuthucan"),
    @NamedQuery(name = "Menuthucan.findByActive", query = "SELECT m FROM Menuthucan m WHERE m.active = :active")})
public class Menuthucan implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmenuthucan")
    private Integer idmenuthucan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @JoinColumn(name = "idcuahang", referencedColumnName = "idcuahang")
    @ManyToOne(optional = false)
    private Cuahang idcuahang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmenuthucan")
    @JsonIgnore
    private Set<MenuthucanMonan> menuthucanMonanSet;
    @Column(name = "thoidiembatdau")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoidiembatdau;
    @Column(name = "thoidiemketthuc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoidiemketthuc;

    public Menuthucan() {
    }

    public Menuthucan(Integer idmenuthucan) {
        this.idmenuthucan = idmenuthucan;
    }

    public Menuthucan(Integer idmenuthucan, boolean active) {
        this.idmenuthucan = idmenuthucan;
        this.active = active;
    }

    public Integer getIdmenuthucan() {
        return idmenuthucan;
    }

    public void setIdmenuthucan(Integer idmenuthucan) {
        this.idmenuthucan = idmenuthucan;
    }

    public boolean getActive() {
        return isActive();
    }

    public void setActive(boolean active) {
        this.active = active;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getIdmenuthucan() != null ? getIdmenuthucan().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menuthucan)) {
            return false;
        }
        Menuthucan other = (Menuthucan) object;
        if ((this.getIdmenuthucan() == null && other.getIdmenuthucan() != null) || (this.getIdmenuthucan() != null && !this.idmenuthucan.equals(other.idmenuthucan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Menuthucan[ idmenuthucan=" + getIdmenuthucan() + " ]";
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
     * @return the thoidiemketthuc
     */
    public Date getThoidiemketthuc() {
        return thoidiemketthuc;
    }

    /**
     * @param thoidiemketthuc the thoidiemketthuc to set
     */
    public void setThoidiemketthuc(Date thoidiemketthuc) {
        this.thoidiemketthuc = thoidiemketthuc;
    }

    /**
     * @return the thoidiembatdau
     */
    public Date getThoidiembatdau() {
        return thoidiembatdau;
    }

    /**
     * @param thoidiembatdau the thoidiembatdau to set
     */
    public void setThoidiembatdau(Date thoidiembatdau) {
        this.thoidiembatdau = thoidiembatdau;
    }
    
}
