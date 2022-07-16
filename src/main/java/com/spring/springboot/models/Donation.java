package com.spring.springboot.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "donation")
public class Donation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "blood_group", nullable = false)
    private String blood_group;

    @Column(name = "date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "status", columnDefinition = "varchar(255) default 'pending'", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "donation_center_id", nullable = false)
    private DonationCenter donationCenter;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    public Donation() {
        // default constructor
    }

    public Donation(Long id, String blood_group, Date date, DonationCenter donationCenter) {
        this.id = id;
        this.blood_group = blood_group;
        this.date = date;
        this.donationCenter = donationCenter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DonationCenter getDonationCenter() {
        return donationCenter;
    }

    public void setDonationCenter(DonationCenter donationCenter) {
        this.donationCenter = donationCenter;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}