package com.spring.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springboot.models.Donation;
import com.spring.springboot.repository.DonationRepository;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;
    
    public Donation save(Donation donation)
    {
        return this.donationRepository.save(donation);
    }
    
}
