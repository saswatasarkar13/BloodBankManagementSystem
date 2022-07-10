package com.spring.springboot.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.springboot.models.BloodAvailable;

@Repository
public interface BloodAvailableRepository extends JpaRepository<BloodAvailable, Long> {

    // @Query("SELECT a.city FROM book_available a")
    // public List<Object> getAvailableCities();
}
