package com.spring.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "centre")
@DynamicInsert
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "centre_name", nullable = false)
    private String centre_name;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private BloodAvailable city_id;

    public Centre() {
        // default constructor
    }

    public Centre(Long id, String centre_name, BloodAvailable city_id) {
        this.id = id;
        this.centre_name = centre_name;
        this.city_id = city_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCentre_name(String centre_name) {
        this.centre_name = centre_name;
    }

    public String getCentre_name() {
        return centre_name;
    }

    public BloodAvailable getCity_id() {
        return city_id;
    }

    public void setCity_id(BloodAvailable city_id) {
        this.city_id = city_id;
    }

}
