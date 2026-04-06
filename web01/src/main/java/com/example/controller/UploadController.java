package com.example.controller;


import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String name,Integer age ,MultipartFile file) throws IOException {
        log.info("文件上传开始,{}",file);
        log.info("文件名：{}",file.getOriginalFilename());
        log.info("文件大小：{}",file.getSize());
        log.info("文件类型：{}",file.getContentType());
        log.info("文件保存路径：{}",file.getResource());
        String originalFilename = file.getOriginalFilename();
        String extend = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newfileName = UUID.randomUUID().toString()+extend;
        file.transferTo(new File("E/images/" + newfileName));

        return Result.success();
    }
}
