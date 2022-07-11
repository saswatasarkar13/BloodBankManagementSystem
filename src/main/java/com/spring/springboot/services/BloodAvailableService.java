package com.spring.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springboot.models.BloodAvailable;
import com.spring.springboot.repository.BloodAvailableRepository;

@Service
public class BloodAvailableService {

    @Autowired
    private BloodAvailableRepository bloodAvaliableRepository;

    public List<BloodAvailable> getAll() {
        List<BloodAvailable> list = this.bloodAvaliableRepository.findAll();

        return list;
    }

    public List<BloodAvailable> getAvailableCities(String city) {
        List<BloodAvailable> obj = this.bloodAvaliableRepository.getAvailableCities();

        return obj;
    }

    public BloodAvailable save(BloodAvailable obj) {
        return this.bloodAvaliableRepository.save(obj);
    }

    public BloodAvailable findByCity(String city) {
        return this.bloodAvaliableRepository.findByCity(city);
    }
}
