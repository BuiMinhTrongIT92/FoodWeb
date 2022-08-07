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
@Table(name = "thongbao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thongbao.findAll", query = "SELECT t FROM Thongbao t"),
    @NamedQuery(name = "Thongbao.findByIdthongbao", query = "SELECT t FROM Thongbao t WHERE t.idthongbao = :idthongbao"),
    @NamedQuery(name = "Thongbao.findByNoidung", query = "SELECT t FROM Thongbao t WHERE t.noidung = :noidung"),
    @NamedQuery(name = "Thongbao.findByActive", query = "SELECT t FROM Thongbao t WHERE t.active = :active")})
public class Thongbao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idthongbao")
    private Integer idthongbao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "noidung")
    private String noidung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne
    private User iduser;

    public Thongbao() {
    }

    public Thongbao(Integer idthongbao) {
        this.idthongbao = idthongbao;
    }

    public Thongbao(Integer idthongbao, String noidung, boolean active) {
        this.idthongbao = idthongbao;
        this.noidung = noidung;
        this.active = active;
    }

    public Integer getIdthongbao() {
        return idthongbao;
    }

    public void setIdthongbao(Integer idthongbao) {
        this.idthongbao = idthongbao;
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

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idthongbao != null ? idthongbao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thongbao)) {
            return false;
        }
        Thongbao other = (Thongbao) object;
        if ((this.idthongbao == null && other.idthongbao != null) || (this.idthongbao != null && !this.idthongbao.equals(other.idthongbao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Thongbao[ idthongbao=" + idthongbao + " ]";
    }
    
}
