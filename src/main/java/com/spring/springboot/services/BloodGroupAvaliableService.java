package com.spring.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springboot.models.BloodAvailable;
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

    public BloodGroupAvailable findByCityAndBloodGroup(BloodAvailable city_id, String bloodGroup) {
        Optional<BloodGroupAvailable> res = this.bloodGroupAvailableRepository.findByCityAndBloodGroup(city_id,
                bloodGroup);

        if (res.isPresent())
            return res.get();

        return null;
    }

    public void delete(BloodGroupAvailable obj) {
        this.bloodGroupAvailableRepository.delete(obj);
    }
}
