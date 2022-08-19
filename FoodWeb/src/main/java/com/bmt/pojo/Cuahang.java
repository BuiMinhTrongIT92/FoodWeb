/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "cuahang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuahang.findAll", query = "SELECT c FROM Cuahang c"),
    @NamedQuery(name = "Cuahang.findByIdcuahang", query = "SELECT c FROM Cuahang c WHERE c.idcuahang = :idcuahang"),
    @NamedQuery(name = "Cuahang.findByTencuahang", query = "SELECT c FROM Cuahang c WHERE c.tencuahang = :tencuahang"),
    @NamedQuery(name = "Cuahang.findByDiachi", query = "SELECT c FROM Cuahang c WHERE c.diachi = :diachi"),
    @NamedQuery(name = "Cuahang.findByActive", query = "SELECT c FROM Cuahang c WHERE c.active = :active"),
    @NamedQuery(name = "Cuahang.findByLogo", query = "SELECT c FROM Cuahang c WHERE c.logo = :logo")})
public class Cuahang implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuahang")
    @JsonIgnore
    private Set<Donhang> donhangSet;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "idcuahang")
    private String idcuahang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tencuahang")
    private String tencuahang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "diachi")
    private String diachi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Size(max = 500)
    @Column(name = "logo")
    private String logo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuahang")
    @JsonIgnore
    private Set<Monan> monanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuahang")
    @JsonIgnore
    private Set<Theodoi> theodoiSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuahang")
    @JsonIgnore
    private Set<Menuthucan> menuthucanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuahang")
    @JsonIgnore
    private Set<Binhluan> binhluanSet;
    @JoinColumn(name = "iduser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User iduser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcuahang")
    @JsonIgnore
    private Set<Quidinh> quidinhSet;
    @OneToMany(mappedBy = "idcuahang")
    @JsonIgnore
    private Set<Danhgia> danhgiaSet;
    @Transient
    private MultipartFile file;

    public Cuahang() {
    }

    public Cuahang(String idcuahang) {
        this.idcuahang = idcuahang;
    }

    public Cuahang(String idcuahang, String tencuahang, String diachi, boolean active) {
        this.idcuahang = idcuahang;
        this.tencuahang = tencuahang;
        this.diachi = diachi;
        this.active = active;
    }

    public String getIdcuahang() {
        return idcuahang;
    }

    public void setIdcuahang(String idcuahang) {
        this.idcuahang = idcuahang;
    }

    public String getTencuahang() {
        return tencuahang;
    }

    public void setTencuahang(String tencuahang) {
        this.tencuahang = tencuahang;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @XmlTransient
    public Set<Monan> getMonanSet() {
        return monanSet;
    }

    public void setMonanSet(Set<Monan> monanSet) {
        this.monanSet = monanSet;
    }

    @XmlTransient
    public Set<Theodoi> getTheodoiSet() {
        return theodoiSet;
    }

    public void setTheodoiSet(Set<Theodoi> theodoiSet) {
        this.theodoiSet = theodoiSet;
    }

    @XmlTransient
    public Set<Menuthucan> getMenuthucanSet() {
        return menuthucanSet;
    }

    public void setMenuthucanSet(Set<Menuthucan> menuthucanSet) {
        this.menuthucanSet = menuthucanSet;
    }

    @XmlTransient
    public Set<Binhluan> getBinhluanSet() {
        return binhluanSet;
    }

    public void setBinhluanSet(Set<Binhluan> binhluanSet) {
        this.binhluanSet = binhluanSet;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    @XmlTransient
    public Set<Quidinh> getQuidinhSet() {
        return quidinhSet;
    }

    public void setQuidinhSet(Set<Quidinh> quidinhSet) {
        this.quidinhSet = quidinhSet;
    }

    @XmlTransient
    public Set<Danhgia> getDanhgiaSet() {
        return danhgiaSet;
    }

    public void setDanhgiaSet(Set<Danhgia> danhgiaSet) {
        this.danhgiaSet = danhgiaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuahang != null ? idcuahang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuahang)) {
            return false;
        }
        Cuahang other = (Cuahang) object;
        if ((this.idcuahang == null && other.idcuahang != null) || (this.idcuahang != null && !this.idcuahang.equals(other.idcuahang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.Cuahang[ idcuahang=" + idcuahang + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @XmlTransient
    public Set<Donhang> getDonhangSet() {
        return donhangSet;
    }

    public void setDonhangSet(Set<Donhang> donhangSet) {
        this.donhangSet = donhangSet;
    }
    
}
