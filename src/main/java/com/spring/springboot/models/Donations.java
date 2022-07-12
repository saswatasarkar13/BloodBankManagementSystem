package com.spring.springboot.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "donations")

public class Donations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private Date date;
    private String blood_group;
    
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "blood_group", nullable = false)
    private String blood_group;

    public Donations()
    {
        //default constructor
    }
    
    public Donations(Long id, Date date, String blood_group)
    {
        this.id = id;
        this.date = date;
        this.blood_group = blood_group;
    }

    
}