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
@Table(name = "monan_loaimonan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonanLoaimonan.findAll", query = "SELECT m FROM MonanLoaimonan m"),
    @NamedQuery(name = "MonanLoaimonan.findByIdmonanloaimonan", query = "SELECT m FROM MonanLoaimonan m WHERE m.idmonanloaimonan = :idmonanloaimonan")})
public class MonanLoaimonan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmonanloaimonan")
    private Integer idmonanloaimonan;
    @JoinColumn(name = "idloaimonan", referencedColumnName = "IDLoaiMonAn")
    @ManyToOne(optional = false)
    private Loaimonan idloaimonan;
    @JoinColumn(name = "idmonan", referencedColumnName = "idmonan")
    @ManyToOne(optional = false)
    private Monan idmonan;

    public MonanLoaimonan() {
    }

    public MonanLoaimonan(Integer idmonanloaimonan) {
        this.idmonanloaimonan = idmonanloaimonan;
    }

    public Integer getIdmonanloaimonan() {
        return idmonanloaimonan;
    }

    public void setIdmonanloaimonan(Integer idmonanloaimonan) {
        this.idmonanloaimonan = idmonanloaimonan;
    }

    public Loaimonan getIdloaimonan() {
        return idloaimonan;
    }

    public void setIdloaimonan(Loaimonan idloaimonan) {
        this.idloaimonan = idloaimonan;
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
        hash += (idmonanloaimonan != null ? idmonanloaimonan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonanLoaimonan)) {
            return false;
        }
        MonanLoaimonan other = (MonanLoaimonan) object;
        if ((this.idmonanloaimonan == null && other.idmonanloaimonan != null) || (this.idmonanloaimonan != null && !this.idmonanloaimonan.equals(other.idmonanloaimonan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.MonanLoaimonan[ idmonanloaimonan=" + idmonanloaimonan + " ]";
    }
    
}
