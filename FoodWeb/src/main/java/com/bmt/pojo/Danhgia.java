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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "danhgia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Danhgia.findAll", query = "SELECT d FROM Danhgia d"),
    @NamedQuery(name = "Danhgia.findByIddanhgia", query = "SELECT d FROM Danhgia d WHERE d.iddanhgia = :iddanhgia"),
    @NamedQuery(name = "Danhgia.findBySao", query = "SELECT d FROM Danhgia d WHERE d.sao = :sao")})
public class Danhgia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddanhgia")
    private Integer iddanhgia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sao")
    private double sao;
    @JoinColumn(name = "idcuahang", referencedColumnName = "idcuahang")
    @ManyToOne
    private Cuahang idcuahang;
    @JoinColumn(name = "idmonan", referencedColumnName = "idmonan")
    @ManyToOne
    private Monan idmonan;
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User iduser;

    public Danhgia() {
    }

    public Danhgia(Integer iddanhgia) {
        this.iddanhgia = iddanhgia;
    }

    public Danhgia(Integer iddanhgia, double sao) {
        this.iddanhgia = iddanhgia;
        this.sao = sao;
    }

    public Integer getIddanhgia() {
        return iddanhgia;
    }

    public void setIddanhgia(Integer iddanhgia) {
        this.iddanhgia = iddanhgia;
    }

    public double getSao() {
        return sao;
    }

    public void setSao(double sao) {
        this.sao = sao;
    }

    public Cuahang getIdcuahang() {
        return idcuahang;
    }

    public void setIdcuahang(Cuahang idcuahang) {
        this.idcuahang = idcuahang;
    }

    public Monan getIdmonan() {
        return idmonan;
    }

    public void setIdmonan(Monan idmonan) {
        this.idmonan = idmonan;
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
        hash += (iddanhgia != null ? iddanhgia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Danhgia)) {
            return false;
        }
        Danhgia other = (Danhgia) object;
        if ((this.iddanhgia == null && other.iddanhgia != null) || (this.iddanhgia != null && !this.iddanhgia.equals(other.iddanhgia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Danhgia[ iddanhgia=" + iddanhgia + " ]";
    }
    
}
