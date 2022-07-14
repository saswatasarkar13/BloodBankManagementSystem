package com.spring.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.springboot.models.ProcureBlood;

@Repository
public interface ProcureBloodRepository extends JpaRepository<ProcureBlood, Long> {
    
    @Query ("SELECT pb FROM ProcureBlood pb WHERE pb.user_id =:id")
    public List<ProcureBlood> findAllByUserId(@Param("id") Long userId);
    
}


