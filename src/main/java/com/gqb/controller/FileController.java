package com.gqb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
@RequestMapping("file")
public class FileController {

    private static String uploadPath = "E:" + File.separator;
    private static String downloadPath = "E:" + File.separator;

    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {//上传多个文件 @RequestParam("file") MultipartFile[] file[]
        if (file != null && !file.isEmpty()) {
            //获得原始文件名
            String originalFilename = file.getOriginalFilename();
            //重新命名 原始文件名 + 时间
            String prefixFilename = originalFilename.substring(0, originalFilename.lastIndexOf("."));
            String newFilename = prefixFilename + "_" + new Date().getTime() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //构建文件
            File newFile = new File(uploadPath + newFilename);
            try {
                file.transferTo(newFile);
                model.addAttribute("is", originalFilename + "save success");
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("is", originalFilename + "save failure");
            }
        }
        return "result";
    }

    @RequestMapping("download")
    public String download(HttpServletResponse response) {//谷歌不可以，其他行
        String filename = "msdia80.dll";

        //通过Paths工具类获取Path对象
        Path path = Paths.get(downloadPath, filename);

        //判断该路径文件是否存在
        if (Files.exists(path)) {
            //获取文件后缀
            String suffixFilename = filename.substring(filename.lastIndexOf(".") + 1);
            //设置响应contentType
            response.setContentType("application/" + suffixFilename);

            try {
                response.addHeader("Content-Disposition:", "attachment; filename=" + new String(filename.getBytes("UTF-8"), "ISO8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            try {
                Files.copy(path, response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "result";
    }
}
