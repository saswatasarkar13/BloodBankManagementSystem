package com.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.springboot.models.DonationCenter;

@Repository
public interface DonationCenterRepository extends JpaRepository<DonationCenter, Long>{


    
}
