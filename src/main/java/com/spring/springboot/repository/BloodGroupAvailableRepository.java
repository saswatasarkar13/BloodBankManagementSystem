package com.spring.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.springboot.models.BloodGroupAvailable;

@Repository
public interface BloodGroupAvailableRepository extends JpaRepository<BloodGroupAvailable, Long> {

    @Query("SELECT b FROM BloodGroupAvailable b WHERE b.city_id =:c")
    public List<BloodGroupAvailable> findAllByCity(@Param("c") Long city_id);
}
