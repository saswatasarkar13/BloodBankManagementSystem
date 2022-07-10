package com.spring.springboot.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blood_group_avaliable")
public class BloodGroupAvailable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "blood_group")
    private String blood_group;

    private Integer quantity;

    // @ManyToOne
    // @JoinColumn(name = "city_id")
    // private BloodAvailable city_id;

    public BloodGroupAvailable() {
        // default constructor
    }

    public BloodGroupAvailable(String blood_group, Integer quantity, BloodAvailable city_id) {
        this.blood_group = blood_group;
        this.quantity = quantity;
        // this.city_id = city_id;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // public BloodAvailable getId() {
    //     return city_id;
    // }

    // public void setId(BloodAvailable city_id) {
    //     this.city_id = city_id;
    // }

}
