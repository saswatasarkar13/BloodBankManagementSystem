package com.spring.springboot.models;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class ProcureBlood 
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;

    @Column (name = "quantity", nullable = false)
    private Integer quantity;

    @Column (name = "date", nullable = false)
    private Date date;

    @Column (name = "is_donation", columnDefinition = "boolean default false" )
    private Boolean isDonation;

    @Column (name = "blood_group", nullable = false)
    private String blood_group;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user_id;

    public ProcureBlood() {
    }


    public ProcureBlood(Integer quantity, Date date, Boolean isDonation, String blood_group, User user_id) {
        this.quantity = quantity;
        this.date = date;
        this.isDonation = isDonation;
        this.blood_group = blood_group;
        this.user_id = user_id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsDonation() {
        return isDonation;
    }

    public void setIsDonation(Boolean isDonation) {
        this.isDonation = isDonation;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

       

}
