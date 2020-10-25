package com.pss.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/9 9:17
 */
@RestController
public class FileController {
    @RequestMapping(value = "/user/upload.do",method = RequestMethod.POST)
//    @PostMapping("/user/upload.do")
    public ModelAndView upload(MultipartFile upload, HttpServletRequest request) throws IOException {
        ModelAndView mv = new ModelAndView();
        //1.获得原始文件名称
        String fileName = upload.getOriginalFilename();
        //2.获取文件后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //3.生成新文件名
        String newFileName = UUID.randomUUID() + suffixName;
        //4.校验文件存储目录
        String uploadDir = request.getServletContext().getRealPath("/upload");
        File file = new File(uploadDir);
        if(!file.exists()){
            file.mkdirs();
        }
        System.out.println("文件所在位置" + uploadDir + "/" + newFileName);
        //5.保存文件到指定位置
        upload.transferTo(new File(uploadDir,newFileName));
        mv.addObject("fileName",fileName);
        mv.addObject("newFileName",newFileName);
        mv.addObject("ver","1024");
        mv.setViewName("/view/user/user_center.jsp");
        return mv;
    }

    @RequestMapping(value = "/download.do",method = RequestMethod.GET)
//    @GetMapping("/download.do")
    public ResponseEntity<byte[]> download(MultipartFile upload, HttpServletRequest request, String newFileName,String originalFileName) throws IOException {
        //文件所在文件夹路径
        String path = request.getServletContext().getRealPath("upload/");
        //文件路径
        String filePath = path + newFileName;
        //将文件读入内存
        byte[] fileBody = FileUtils.readFileToByteArray(new File(filePath));
        //下载显示中文文件名，防止乱码
        String downloadFileName = new String(originalFileName.getBytes("UTF-8"),"iso-8859-1");
        HttpHeaders headers = new HttpHeaders();
        //通知浏览器，以attachment的方式打开图片
        headers.setContentDispositionFormData("attachment",downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(fileBody,headers, HttpStatus.OK);
        return responseEntity;
    }
}
