package me.zhengjie.modules.fasttest.rest;

import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.modules.fasttest.domain.RemoteCopy;
import me.zhengjie.utils.fasttest.SshHelper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;


//上传不要用@Controller,用@RestController
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rfile")
public class RemoteCopyController {
    private static final Logger logger = LoggerFactory.getLogger(RemoteCopyController.class);
    //在文件操作中，不用/或者\最好，推荐使用File.separator
    private final static String fileDir = "rfile";
    private final static String rootPath = System.getProperty("user.home") + File.separator + fileDir + File.separator;

    @PostMapping
    @AnonymousAccess
    public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile mf) {
        File fileDir = new File(rootPath);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String storagePath = "";
        if (!fileDir.exists() && !fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        try {
            if (mf != null) {
                try {
                    storagePath = rootPath + uuid + mf.getOriginalFilename();
                    logger.info("上传的文件：" + mf.getName() + "," + mf.getContentType() + "," + mf.getOriginalFilename()
                            + "，保存的路径为：" + storagePath);
                    Streams.copy(mf.getInputStream(), new FileOutputStream(storagePath), true);
                } catch (IOException e) {
                    logger.error(ExceptionUtils.getStackTrace(e));
                    throw e;
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(storagePath);
    }

    @PutMapping
    @AnonymousAccess
    public ResponseEntity<Object> copyFile(@RequestBody RemoteCopy body, final HttpServletRequest request) {
        String fileName = body.getFileName();
        String remoteDir = body.getRemoteDir();
        SshHelper.copy(rootPath+fileName, remoteDir, false);
        return ResponseEntity.ok(remoteDir + "/" + fileName);
    }


}
