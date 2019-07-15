package com.example.demo.commen.upload;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.commen.MyRsp ;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("upload")
@CrossOrigin        //处理跨越请求
public class UploadController {



    @PostMapping("/addImage")
    @ResponseBody
    public Object addImage(@RequestParam(name = "image_data", required = false) MultipartFile file) {

        String fileName = file.getOriginalFilename();
        //文件上传
        if (!file.isEmpty()) {
            try {
                //图片命名
//                String newCompanyImageName = "newPIC";
                String newCompanyImagepath = "D:\\imag\\"+file.getOriginalFilename();
                File newFile = new File(newCompanyImagepath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();//刷新
                out.close();//关闭
            } catch (IOException e) {
                e.printStackTrace();
                return MyRsp.error().msg("上传失败");
            }
        }
        return MyRsp.success(fileName).msg("上传成功");
    }



}
