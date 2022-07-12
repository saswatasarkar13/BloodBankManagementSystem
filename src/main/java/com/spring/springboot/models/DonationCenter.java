package com.spring.springboot.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DonationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "city", nullable = false)
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "donationCenter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Donation> donations;

    public DonationCenter() {
        // default constructor
    }

    public DonationCenter(String name, String city, List<Donation> donations) {
        this.name = name;
        this.city = city;
        this.donations = donations;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Donation> getDonation() {
        return donations;
    }

    public void setDonation(List<Donation> donations) {
        this.donations = donations;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

}