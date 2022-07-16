package com.spring.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.springboot.models.BloodAvailable;
import com.spring.springboot.models.DonationCenter;

@Repository
public interface DonationCenterRepository extends JpaRepository<DonationCenter, Long> {

    @Query("SELECT dc FROM DonationCenter dc WHERE dc.city =:city")
    public List<DonationCenter> findAllByCity(@Param("city") BloodAvailable city);

}
