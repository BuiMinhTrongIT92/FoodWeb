/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Menuthucan.findByIDMenuThucAn", query = "SELECT m FROM Menuthucan m WHERE m.menuthucanPK.iDMenuThucAn = :iDMenuThucAn"),
    @NamedQuery(name = "Menuthucan.findByActive", query = "SELECT m FROM Menuthucan m WHERE m.active = :active"),
    @NamedQuery(name = "Menuthucan.findByIDCuaHang", query = "SELECT m FROM Menuthucan m WHERE m.menuthucanPK.iDCuaHang = :iDCuaHang")})
public class Menuthucan implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MenuthucanPK menuthucanPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Active")
    private boolean active;
    @JoinTable(name = "menuthucan_monan", joinColumns = {
        @JoinColumn(name = "IDMenuThucAn", referencedColumnName = "IDMenuThucAn")}, inverseJoinColumns = {
        @JoinColumn(name = "IDMonAn", referencedColumnName = "IDMonAn")})
    @ManyToMany
    private Set<Monan> monanSet;
    @JoinColumn(name = "IDCuaHang", referencedColumnName = "IDCuaHang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuahang cuahang;

    public Menuthucan() {
    }

    public Menuthucan(MenuthucanPK menuthucanPK) {
        this.menuthucanPK = menuthucanPK;
    }

    public Menuthucan(MenuthucanPK menuthucanPK, boolean active) {
        this.menuthucanPK = menuthucanPK;
        this.active = active;
    }

    public Menuthucan(String iDMenuThucAn, String iDCuaHang) {
        this.menuthucanPK = new MenuthucanPK(iDMenuThucAn, iDCuaHang);
    }

    public MenuthucanPK getMenuthucanPK() {
        return menuthucanPK;
    }

    public void setMenuthucanPK(MenuthucanPK menuthucanPK) {
        this.menuthucanPK = menuthucanPK;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Set<Monan> getMonanSet() {
        return monanSet;
    }

    public void setMonanSet(Set<Monan> monanSet) {
        this.monanSet = monanSet;
    }

    public Cuahang getCuahang() {
        return cuahang;
    }

    public void setCuahang(Cuahang cuahang) {
        this.cuahang = cuahang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuthucanPK != null ? menuthucanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menuthucan)) {
            return false;
        }
        Menuthucan other = (Menuthucan) object;
        if ((this.menuthucanPK == null && other.menuthucanPK != null) || (this.menuthucanPK != null && !this.menuthucanPK.equals(other.menuthucanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Menuthucan[ menuthucanPK=" + menuthucanPK + " ]";
    }
    
}
