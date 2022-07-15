package com.spring.springboot.apicontrollers;

import java.util.HashMap;
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
    public Map<String, Object> setStatus(@RequestBody Map <String, String> body){
    String pbid = body.get("id");
    String pbStatus =  body.get("status");
    HashMap<String, Object> map = new HashMap<>();
    ProcureBlood procureBlood = this.procureBloodService.findById(Long.parseLong(pbid));
    procureBlood.setStatus(pbStatus);
    ProcureBlood procureBloodStatus =  this.procureBloodService.save(procureBlood);
    if (procureBloodStatus == null){
        map.put("success", false);
        return map;
    }
    else
    {
    map.put("success",true);
    return map;
    }
}
}
