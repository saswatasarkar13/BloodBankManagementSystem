package com.spring.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.springboot.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

    public List<User> findByName(String name);

    @Query("SELECT u FROM User u WHERE u.blood_group =:b AND u.city =:c AND u.isActivelyDonating=true")
    public List<User> findByBloodGroupAndCityAndDonating(@Param("b") String blood_group, @Param("c") String city);

}
