package com.spring.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.springboot.models.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT dn FROM Donation dn WHERE dn.userId =:id")
    public List<Donation> findByUserId(@Param("id") Long userId);

    public Optional<Donation> findById(Long id);

}
