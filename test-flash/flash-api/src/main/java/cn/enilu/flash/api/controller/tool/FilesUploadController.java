package cn.enilu.flash.api.controller.tool;

import cn.enilu.flash.bean.vo.front.Rets;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @Description: soringboot整合vue,文件上传下载
 * @Author: yanhonghai
 * @Date: 2019/4/17 0:56
 */
//上传不要用@Controller,用@RestController
@RestController
@RequestMapping("/files")
public class FilesUploadController {
    private static final Logger logger = LoggerFactory.getLogger(FilesUploadController.class);
    //在文件操作中，不用/或者\最好，推荐使用File.separator
    private final static String fileDir = "files";
    private final static String rootPath = System.getProperty("user.home") + File.separator + fileDir + File.separator;

    @RequestMapping("/upload")
    public Object uploadFile(@RequestParam("file") MultipartFile[] multipartFiles) {
        File fileDir = new File(rootPath);
        if (!fileDir.exists() && !fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        try {
            if (multipartFiles != null && multipartFiles.length > 0) {
                for (int i = 0; i < multipartFiles.length; i++) {
                    try {
                        //以原来的名称命名,覆盖掉旧的
                        String storagePath = rootPath + multipartFiles[i].getOriginalFilename();
                        logger.info("上传的文件：" + multipartFiles[i].getName() + "," + multipartFiles[i].getContentType() + "," + multipartFiles[i].getOriginalFilename()
                                + "，保存的路径为：" + storagePath);
                        Streams.copy(multipartFiles[i].getInputStream(), new FileOutputStream(storagePath), true);
                        //或者下面的
                        // Path path = Paths.get(storagePath);
                        //Files.write(path,multipartFiles[i].getBytes());
                    } catch (IOException e) {
                        logger.error(ExceptionUtils.getFullStackTrace(e));
                    }
                }
            }

        } catch (Exception e) {
            return Rets.failure(e.getMessage());
        }
        return Rets.success("上传成功!");
    }
}
