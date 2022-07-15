package com.spring.springboot.models;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "blood_avaliable", uniqueConstraints = @UniqueConstraint(columnNames = { "city" }))
public class BloodAvailable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToMany(mappedBy = "city_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BloodGroupAvailable> blood_groups;

    @JsonIgnore
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DonationCenter> centres;

    public BloodAvailable() {
        // default constructor
    }

    public BloodAvailable(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<BloodGroupAvailable> getBlood_groups() {
        return blood_groups;
    }

    public void setBlood_groups(List<BloodGroupAvailable> blood_groups) {
        this.blood_groups = blood_groups;
    }

    public List<DonationCenter> getCentres() {
        return centres;
    }

    public void setCentres(List<DonationCenter> centres) {
        this.centres = centres;
    }

}
