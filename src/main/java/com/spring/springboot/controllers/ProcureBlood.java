package com.spring.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.springboot.services.ProcureBloodService;

@Controller
public class ProcureBlood {
    @Autowired
    private ProcureBloodService procureBloodService;
    
}
