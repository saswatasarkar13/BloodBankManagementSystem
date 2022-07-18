// package com.spring.springboot.helpers;

// import java.io.File;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.nio.file.StandardCopyOption;

// import org.springframework.core.io.ClassPathResource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.multipart.MultipartFile;

// @Component
// public class FileUpload {
//     public final String UPLOAD_DIR = new ClassPathResource("static/uploads/").getFile().getAbsolutePath();;

//     public FileUpload() throws IOException {

//     }

//     public boolean uploadFile(MultipartFile file) {

//         try {
//             String filePath = UPLOAD_DIR + File.separator + file.getOriginalFilename();

//             Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

//             return true;
//         } catch (Exception e) {
//             e.printStackTrace();
//             return false;
//         }

//     }
// }
