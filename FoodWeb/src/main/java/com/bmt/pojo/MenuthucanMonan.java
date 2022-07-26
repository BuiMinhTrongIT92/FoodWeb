/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "menuthucan_monan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuthucanMonan.findAll", query = "SELECT m FROM MenuthucanMonan m"),
    @NamedQuery(name = "MenuthucanMonan.findByIdmenuthucanmonan", query = "SELECT m FROM MenuthucanMonan m WHERE m.idmenuthucanmonan = :idmenuthucanmonan")})
public class MenuthucanMonan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmenuthucanmonan")
    private Integer idmenuthucanmonan;
    @JoinColumn(name = "idmenuthucan", referencedColumnName = "idmenuthucan")
    @ManyToOne(optional = false)
    private Menuthucan idmenuthucan;
    @JoinColumn(name = "idmonan", referencedColumnName = "idmonan")
    @ManyToOne(optional = false)
    private Monan idmonan;

    public MenuthucanMonan() {
    }

    public MenuthucanMonan(Integer idmenuthucanmonan) {
        this.idmenuthucanmonan = idmenuthucanmonan;
    }

    public Integer getIdmenuthucanmonan() {
        return idmenuthucanmonan;
    }

    public void setIdmenuthucanmonan(Integer idmenuthucanmonan) {
        this.idmenuthucanmonan = idmenuthucanmonan;
    }

    public Menuthucan getIdmenuthucan() {
        return idmenuthucan;
    }

    public void setIdmenuthucan(Menuthucan idmenuthucan) {
        this.idmenuthucan = idmenuthucan;
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
        hash += (idmenuthucanmonan != null ? idmenuthucanmonan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuthucanMonan)) {
            return false;
        }
        MenuthucanMonan other = (MenuthucanMonan) object;
        if ((this.idmenuthucanmonan == null && other.idmenuthucanmonan != null) || (this.idmenuthucanmonan != null && !this.idmenuthucanmonan.equals(other.idmenuthucanmonan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.MenuthucanMonan[ idmenuthucanmonan=" + idmenuthucanmonan + " ]";
    }
    
}
