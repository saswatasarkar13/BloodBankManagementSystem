package com.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springboot.models.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    

    

}