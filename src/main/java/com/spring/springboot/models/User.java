package com.spring.springboot.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "blood_group", nullable = false)
    private String blood_group;

    @Column(name = "dob", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "pincode", nullable = true)
    private Integer pincode;

    @Column(name = "is_admin", columnDefinition = "boolean default false")
    private boolean isAdmin;

    @Column(name = "is_actively_donating", columnDefinition = "boolean default false")
    private boolean isActivelyDonating;

    @JsonIgnore
    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProcureBlood> procureBlood;

    @JsonIgnore
    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Donation> donations;

    public User() {
        // default constructor
    }

    public User(Long id, String name, String email, String password, String contact, String blood_group, Date dob,
            String city, String state, String address, Integer pincode, boolean isActivelyDonating) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.blood_group = blood_group;
        this.dob = dob;
        this.city = city;
        this.state = state;
        this.address = address;
        this.pincode = pincode;
        this.isActivelyDonating = isActivelyDonating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isActivelyDonating() {
        return isActivelyDonating;
    }

    public void setActivelyDonating(boolean isActivelyDonating) {
        this.isActivelyDonating = isActivelyDonating;
    }

    public List<ProcureBlood> getProcureBlood() {
        return procureBlood;
    }

    public void setProcureBlood(List<ProcureBlood> procureBlood) {
        this.procureBlood = procureBlood;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

}
