package me.zhengjie.utils.fasttest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadHelper {

    private static final Logger logger = LoggerFactory.getLogger(DownloadHelper.class);
    public String rootPath;

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
