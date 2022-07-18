package com.spring.springboot.apicontrollers;

import java.util.HashMap;
import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// import com.spring.springboot.helpers.FileUpload;

@RestController
@RequestMapping(value = "/api/file")
public class FileUploadApiController {

    // @Autowired
    // private FileUpload fileUploadHelper;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String, Object> addProfilePicture(@RequestParam("file") MultipartFile file) {
        HashMap<String, Object> map = new HashMap<>();
        // try {
        // if (file.isEmpty()) {
        // map.put("success", false);
        // return map;
        // }

        // String filename = file.getOriginalFilename();
        // String path = "/uploads/" + filename;

        // boolean res = fileUploadHelper.uploadFile(file);

        // map.put("filepath", path);
        // map.put("success", res);
        // } catch (Exception e) {
        // e.printStackTrace();
        // map.put("success", false);
        // }

        map.put("success", false);
        return map;
    }
}
