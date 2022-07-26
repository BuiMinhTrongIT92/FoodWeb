

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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByTennguoidung", query = "SELECT u FROM User u WHERE u.tennguoidung = :tennguoidung"),
    @NamedQuery(name = "User.findByTaikhoan", query = "SELECT u FROM User u WHERE u.taikhoan = :taikhoan"),
    @NamedQuery(name = "User.findByMatkhau", query = "SELECT u FROM User u WHERE u.matkhau = :matkhau"),
    @NamedQuery(name = "User.findByGioitinh", query = "SELECT u FROM User u WHERE u.gioitinh = :gioitinh"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findBySdt", query = "SELECT u FROM User u WHERE u.sdt = :sdt"),
    @NamedQuery(name = "User.findByDiachi", query = "SELECT u FROM User u WHERE u.diachi = :diachi"),
    @NamedQuery(name = "User.findByNgaytao", query = "SELECT u FROM User u WHERE u.ngaytao = :ngaytao"),
    @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role"),
    @NamedQuery(name = "User.findByAvatar", query = "SELECT u FROM User u WHERE u.avatar = :avatar")})
public class User implements Serializable {
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    @JsonIgnore
    private Set<Binhluan> binhluanSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    @JsonIgnore
    private Set<Loaimonan> loaimonanSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    @JsonIgnore
    private Set<Theodoi> theodoiSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    @JsonIgnore
    private Set<Quidinh> quidinhSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    @JsonIgnore
    private Set<Danhgia> danhgiaSet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    @JsonIgnore
    private Set<Donhang> donhangSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    @JsonIgnore
    private Set<Cuahang> cuahangSet;

    private static String QUANLY = "ROLE_QUANLY";
    private static String NGUOIDUNG = "ROLE_NGUOIDUNG";
    private static String ADMIN = "ROLE_ADMIN";

    private static long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tennguoidung")
    private String tennguoidung;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "taikhoan")
    private String taikhoan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "matkhau")
    @JsonIgnore
    private String matkhau;
    @Size(max = 45)
    @Column(name = "gioitinh")
    private String gioitinh;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Column(name = "sdt")
    private Integer sdt;
    @Size(max = 45)
    @Column(name = "diachi")
    private String diachi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaytao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaytao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "role")
    private String role;
    @Size(max = 500)
    @Column(name = "avatar")
    private String avatar;
    @OneToMany(mappedBy = "iduser")
    @JsonIgnore
    private Set<Thongbao> thongbaoSet;
    @Transient
    private String nhaplaimatkhau;
    @Transient
    private MultipartFile file;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, String tennguoidung, String taikhoan, String matkhau, String email, Date ngaytao, boolean active, String role) {
        this.id = id;
        this.tennguoidung = tennguoidung;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.email = email;
        this.ngaytao = ngaytao;
        this.active = active;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTennguoidung() {
        return tennguoidung;
    }

    public void setTennguoidung(String tennguoidung) {
        this.tennguoidung = tennguoidung;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSdt() {
        return sdt;
    }

    public void setSdt(Integer sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public boolean getActive() {
        return isActive();
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Set<Thongbao> getThongbaoSet() {
        return thongbaoSet;
    }

    public void setThongbaoSet(Set<Thongbao> thongbaoSet) {
        this.thongbaoSet = thongbaoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bmt.pojo.User[ id=" + getId() + " ]";
    }

    /**
     * @return the nhaplaimatkhau
     */
    public String getNhaplaimatkhau() {
        return nhaplaimatkhau;
    }

    /**
     * @param nhaplaimatkhau the nhaplaimatkhau to set
     */
    public void setNhaplaimatkhau(String nhaplaimatkhau) {
        this.nhaplaimatkhau = nhaplaimatkhau;
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

    @XmlTransient
    public Set<Cuahang> getCuahangSet() {
        return cuahangSet;
    }

    public void setCuahangSet(Set<Cuahang> cuahangSet) {
        this.cuahangSet = cuahangSet;
    }

    @XmlTransient
    public Set<Theodoi> getTheodoiSet() {
        return theodoiSet;
    }

    public void setTheodoiSet(Set<Theodoi> theodoiSet) {
        this.theodoiSet = theodoiSet;
    }

    @XmlTransient
    public Set<Binhluan> getBinhluanSet() {
        return binhluanSet;
    }

    public void setBinhluanSet(Set<Binhluan> binhluanSet) {
        this.binhluanSet = binhluanSet;
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

    /**
     * @return the loaimonanSet
     */
    public Set<Loaimonan> getLoaimonanSet() {
        return loaimonanSet;
    }

    /**
     * @param loaimonanSet the loaimonanSet to set
     */
    public void setLoaimonanSet(Set<Loaimonan> loaimonanSet) {
        this.loaimonanSet = loaimonanSet;
    }

    /**
     * @return the QUANLY
     */
    public static String getQUANLY() {
        return QUANLY;
    }

    /**
     * @param aQUANLY the QUANLY to set
     */
    public static void setQUANLY(String aQUANLY) {
        QUANLY = aQUANLY;
    }

    /**
     * @return the NGUOIDUNG
     */
    public static String getNGUOIDUNG() {
        return NGUOIDUNG;
    }

    /**
     * @param aNGUOIDUNG the NGUOIDUNG to set
     */
    public static void setNGUOIDUNG(String aNGUOIDUNG) {
        NGUOIDUNG = aNGUOIDUNG;
    }

    /**
     * @return the ADMIN
     */
    public static String getADMIN() {
        return ADMIN;
    }

    /**
     * @param aADMIN the ADMIN to set
     */
    public static void setADMIN(String aADMIN) {
        ADMIN = aADMIN;
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

}
