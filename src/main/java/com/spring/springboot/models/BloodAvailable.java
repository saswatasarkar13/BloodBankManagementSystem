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

@Entity
@Table(name = "blood_avaliable", uniqueConstraints = @UniqueConstraint(columnNames = { "city" }))
public class BloodAvailable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String city;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BloodGroupAvailable> blood_groups;

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

}
