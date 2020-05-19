package com.yg.learn.controller;

import com.yg.learn.util.FastDFSClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class FastDfsController {

    private static Logger logger = LoggerFactory.getLogger(FastDfsController.class);

    @Autowired
    FastDFSClientUtil fastDFSClientUtil;

    @RequestMapping("/upload")
    public String getUpload() {
        System.out.println("upload");
        return "upload";
    }


    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            // 获取原文件名
            String origFileName = file.getOriginalFilename();
            logger.info("原始文件名：{}", origFileName);

            // 获取扩展名
            String extName = origFileName.substring(origFileName.lastIndexOf(".") + 1);
            logger.info("原始文件扩展名：{}", extName);

            // 获取文件存储路径
            String[] uriArray = fastDFSClientUtil.uploadFile(file.getBytes(), extName);

            String groupName = uriArray[0];
            String fileId = uriArray[1];

            String uri = groupName + "/" + fileId;
            logger.info("返回的文件存储路径：{}", uri);
            return uri;

        } catch (Exception e) {
            logger.error(e.toString(), e);
            return null;
        }
    }

    /**
     * 下载文件
     * @param groupName
     * @param fileId
     * @return
     */
    @RequestMapping("/downloadFile")
    @ResponseBody
    public void downloadFile(@RequestParam("groupName") String groupName,
                             @RequestParam("fileId") String fileId, HttpServletResponse response) {

        try {

            // 获取文件名
            int index = fileId.lastIndexOf("/");
            String fileName = fileId.substring(index + 1);

            /**
             * 参数格式：
             * groupName: group1
             * fileId: M00/00/00/wKjlj15o9rGAP5MkAACpl5L2fqw700.jpg
             */
            byte[] fileByte = fastDFSClientUtil.downloadFile(groupName, fileId);
            InputStream inputStream = new ByteArrayInputStream(fileByte);
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

            byte[] buff = new byte[1024];
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
            os.close();
            bis.close();
            logger.info("Download  successfully!");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }

    }


    /**
     * 删除文件
     * @param groupName
     * @param fileId
     * @return
     */
    @RequestMapping("/deleteFile")
    @ResponseBody
    public String deleteFile(@RequestParam("groupName") String groupName,
                             @RequestParam("fileId") String fileId) {
        try {
            /**
             * 参数格式：
             * groupName: group1
             * fileId: M00/00/00/wKjlj15o9rGAP5MkAACpl5L2fqw700.jpg
             */
            int i = fastDFSClientUtil.deleteFile(groupName, fileId);
            return (i > 0) ? "删除文件成功" : "删除文件失败";
        } catch (Exception e) {
            logger.error(e.toString(), e);
            return null;
        }

    }

}
