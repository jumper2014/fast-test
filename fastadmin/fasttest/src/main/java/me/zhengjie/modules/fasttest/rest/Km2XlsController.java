package me.zhengjie.modules.fasttest.rest;

import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.utils.fasttest.ExcelHelper;
import me.zhengjie.utils.fasttest.JsonHelper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * @Description: soringboot整合vue, 文件上传下载
 * @Author: yanhonghai
 * @Date: 2019/4/17 0:56
 */
//上传不要用@Controller,用@RestController
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kmind")
public class Km2XlsController {
    private static final Logger logger = LoggerFactory.getLogger(Km2XlsController.class);
    //在文件操作中，不用/或者\最好，推荐使用File.separator
    private final static String fileDir = "km";
    private final static String rootPath = System.getProperty("user.home") + File.separator + fileDir + File.separator;

    @PostMapping
    @AnonymousAccess
    public ResponseEntity<Object> km2xlsFile(@RequestParam("file") MultipartFile mf) {
        String xlsFile = "";
        File fileDir = new File(rootPath);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        if (!fileDir.exists() && !fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        try {
            if (mf != null) {
                try {
                    String storagePath = rootPath + uuid + mf.getOriginalFilename();
                    logger.info("上传的文件：" + mf.getName() + "," + mf.getContentType() + "," + mf.getOriginalFilename()
                            + "，保存的路径为：" + storagePath);
                    Streams.copy(mf.getInputStream(), new FileOutputStream(storagePath), true);
                    xlsFile = (uuid + mf.getOriginalFilename()).replace(".km", "");
                    List<List<String>> allCaseList = JsonHelper.readJson(storagePath);
                    System.out.printf("Total case number is: " + allCaseList.size());
                    ExcelHelper.writeToExcel(allCaseList, rootPath, xlsFile);
//                    return ResponseEntity.ok(xlsFile + ".xls");

                } catch (IOException e) {
                    logger.error(ExceptionUtils.getStackTrace(e));
                    throw e;
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(xlsFile + ".xls");
    }


    /**
     * http://localhost:8080/api/kmind/download?fileName=新建文本文档.txt
     *
     * @param fileName
     * @param response
     * @param request
     * @return
     */
    @GetMapping("/download")
    @AnonymousAccess
    public ResponseEntity<Object> downloadFile(@RequestParam String fileName, final HttpServletResponse response, final HttpServletRequest request) {
        OutputStream os = null;
        InputStream is = null;
        try {
            // 取得输出流
            os = response.getOutputStream();
            // 清空输出流
            response.reset();
            response.setContentType("application/x-download;charset=GBK");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "iso-8859-1"));
            //读取流
            File f = new File(rootPath + fileName);
            is = new FileInputStream(f);
            if (is == null) {
                logger.error("下载附件失败，请检查文件“" + fileName + "”是否存在");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("下载附件失败，请检查文件“" + fileName + "”是否存在");
            }
            //复制
            IOUtils.copy(is, response.getOutputStream());
            response.getOutputStream().flush();
            new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("下载附件失败,error:" + e.getMessage());
        }
        //文件的关闭放在finally中
        finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                logger.error(ExceptionUtils.getStackTrace(e));
            }
        }
        return null;
    }
}
