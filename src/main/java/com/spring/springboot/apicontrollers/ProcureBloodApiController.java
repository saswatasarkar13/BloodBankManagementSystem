package com.spring.springboot.apicontrollers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.models.ProcureBlood;
import com.spring.springboot.services.ProcureBloodService;

@RestController 
@RequestMapping (value = "/api/procure")
public class ProcureBloodApiController 
{
    @Autowired
    private ProcureBloodService procureBloodService;

    @RequestMapping (value = "/status", method = RequestMethod.PUT)
    public String setStatus(@RequestBody Map <String, String> body){
    String pbid = body.get("id");
    ProcureBlood procureBlood = this.procureBloodService.findById(Long.parseLong(pbid));
    procureBlood.setStatus("Completed");
    ProcureBlood procureBloodStatus =  this.procureBloodService.save(procureBlood);
    if (procureBloodStatus == null)
        return "Unseccessfull";
    
    return "Successfull";
    
    }
}
