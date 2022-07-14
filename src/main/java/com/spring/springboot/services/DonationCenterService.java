package com.spring.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springboot.models.DonationCenter;
import com.spring.springboot.repository.DonationCenterRepository;

@Service
public class DonationCenterService 
{
    @Autowired
    private DonationCenterRepository donationCenterRepository;

    public List<DonationCenter> findAllCentres()
    {
        return this.donationCenterRepository.findAll();
    }

    public DonationCenter save(DonationCenter donationCenter)
    {
        return this.donationCenterRepository.save(donationCenter);
    }


}
