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
    @NamedQuery(name = "Quidinh.findByIdquidinh", query = "SELECT q FROM Quidinh q WHERE q.idquidinh = :idquidinh"),
    @NamedQuery(name = "Quidinh.findByTenquidinh", query = "SELECT q FROM Quidinh q WHERE q.tenquidinh = :tenquidinh"),
    @NamedQuery(name = "Quidinh.findByNoidung", query = "SELECT q FROM Quidinh q WHERE q.noidung = :noidung"),
    @NamedQuery(name = "Quidinh.findByActive", query = "SELECT q FROM Quidinh q WHERE q.active = :active")})
public class Quidinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idquidinh")
    private Integer idquidinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenquidinh")
    private String tenquidinh;
    @Size(max = 45)
    @Column(name = "noidung")
    @NotNull
    private String noidung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @JoinColumn(name = "idcuahang", referencedColumnName = "idcuahang")
    @ManyToOne(optional = false)
    private Cuahang idcuahang;
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User iduser;

    public Quidinh() {
    }

    public Quidinh(Integer idquidinh) {
        this.idquidinh = idquidinh;
    }

    public Quidinh(Integer idquidinh, String tenquidinh, boolean active) {
        this.idquidinh = idquidinh;
        this.tenquidinh = tenquidinh;
        this.active = active;
    }

    public Integer getIdquidinh() {
        return idquidinh;
    }

    public void setIdquidinh(Integer idquidinh) {
        this.idquidinh = idquidinh;
    }

    public String getTenquidinh() {
        return tenquidinh;
    }

    public void setTenquidinh(String tenquidinh) {
        this.tenquidinh = tenquidinh;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public boolean getActive() {
        return active;
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

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquidinh != null ? idquidinh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quidinh)) {
            return false;
        }
        Quidinh other = (Quidinh) object;
        if ((this.idquidinh == null && other.idquidinh != null) || (this.idquidinh != null && !this.idquidinh.equals(other.idquidinh))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Quidinh[ idquidinh=" + idquidinh + " ]";
    }
    
}
