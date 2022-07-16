package com.spring.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springboot.models.BloodGroupAvailable;
import com.spring.springboot.repository.BloodGroupAvailableRepository;

@Service
public class BloodGroupAvaliableService {

    @Autowired
    private BloodGroupAvailableRepository bloodGroupAvailableRepository;

    public List<BloodGroupAvailable> getAllById(Long id) {
        List<BloodGroupAvailable> list = this.bloodGroupAvailableRepository.findAllByCity(id);

        return list;
    }

    public BloodGroupAvailable save(BloodGroupAvailable ob) {
        return this.bloodGroupAvailableRepository.save(ob);
    }

    public BloodGroupAvailable findByCityAndBloodGroup(Long city_id, String bloodGroup) {

        // System.out.println(city_id + " bg => " + bloodGroup);

        // System.out.println("asff => " +
        // this.bloodGroupAvailableRepository.findAllByCity(city_id));

        Optional<BloodGroupAvailable> res = this.bloodGroupAvailableRepository.findByCityAndBloodGroup(city_id,
                bloodGroup);

        System.out.println("|..............." + res.isPresent());

        if (res.isPresent()) {
            return res.get();
        }

        return null;
    }
}
