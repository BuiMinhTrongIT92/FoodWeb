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
@Table(name = "theodoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theodoi.findAll", query = "SELECT t FROM Theodoi t"),
    @NamedQuery(name = "Theodoi.findByIdtheodoi", query = "SELECT t FROM Theodoi t WHERE t.idtheodoi = :idtheodoi"),
    @NamedQuery(name = "Theodoi.findByTrangthai", query = "SELECT t FROM Theodoi t WHERE t.trangthai = :trangthai")})
public class Theodoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtheodoi")
    private Integer idtheodoi;
    @Column(name = "trangthai")
    private Boolean trangthai;
    @JoinColumn(name = "idcuahang", referencedColumnName = "idcuahang")
    @ManyToOne(optional = false)
    private Cuahang idcuahang;
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User iduser;

    public Theodoi() {
    }

    public Theodoi(Integer idtheodoi) {
        this.idtheodoi = idtheodoi;
    }

    public Integer getIdtheodoi() {
        return idtheodoi;
    }

    public void setIdtheodoi(Integer idtheodoi) {
        this.idtheodoi = idtheodoi;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    public Cuahang getIdcuahang() {
        return idcuahang;
    }

    public void setIdcuahang(Cuahang idcuahang) {
        this.idcuahang = idcuahang;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtheodoi != null ? idtheodoi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theodoi)) {
            return false;
        }
        Theodoi other = (Theodoi) object;
        if ((this.idtheodoi == null && other.idtheodoi != null) || (this.idtheodoi != null && !this.idtheodoi.equals(other.idtheodoi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Theodoi[ idtheodoi=" + idtheodoi + " ]";
    }
    
}
