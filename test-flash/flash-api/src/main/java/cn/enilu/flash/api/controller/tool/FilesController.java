package cn.enilu.flash.api.controller.tool;

import cn.enilu.flash.api.helper.ReadJson;
import cn.enilu.flash.api.helper.ReadXml;
import cn.enilu.flash.api.helper.WriteToExcel;
import cn.enilu.flash.bean.vo.front.Rets;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/files")
public class FilesController {
    private static final Logger logger = LoggerFactory.getLogger(FilesController.class);
    //在文件操作中，不用/或者\最好，推荐使用File.separator
    private final static String fileDir = "files";
    private final static String rootPath = System.getProperty("user.home") + File.separator + fileDir + File.separator;
    String storagePath ;

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
                        storagePath = rootPath + multipartFiles[i].getOriginalFilename();
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
        return Rets.success(storagePath);
    }

    @RequestMapping("/km2xls")
    public Object km2xlsFile(@RequestParam("file") MultipartFile mf) {
        String xlsFile="";
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
                    List<List<String>> allCaseList = ReadJson.readJson(storagePath);
                    System.out.printf("Total case number is: " + allCaseList.size());
                    WriteToExcel.writeToExcel(allCaseList, rootPath, xlsFile);
                    return Rets.success(xlsFile + ".xls");

                    //或者下面的
                    // Path path = Paths.get(storagePath);
                    //Files.write(path,multipartFiles[i].getBytes());
                } catch (IOException e) {
                    logger.error(ExceptionUtils.getFullStackTrace(e));
                }
            }


        } catch (Exception e) {
            return Rets.failure(e.getMessage());
        }
        return Rets.success(xlsFile + ".xls");
    }

    @RequestMapping("/xm2xls")
    public Object xm2xlsFile(@RequestParam("file") MultipartFile mf) {
        String xlsFile="";
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
                    xlsFile = (uuid + mf.getOriginalFilename()).replace(".xmind", "");
                    List<List<String>> allCaseList = ReadXml.readXml(storagePath);
                    System.out.printf("Total case number is: " + allCaseList.size());
                    WriteToExcel.writeToExcel(allCaseList, rootPath, xlsFile);
                    return Rets.success(xlsFile + ".xls");

                    //或者下面的
                    // Path path = Paths.get(storagePath);
                    //Files.write(path,multipartFiles[i].getBytes());
                } catch (IOException e) {
                    logger.error(ExceptionUtils.getFullStackTrace(e));
                }
            }


        } catch (Exception e) {
            return Rets.failure(e.getMessage());
        }
        return Rets.success(xlsFile + ".xls");
    }


    /**
     * http://localhost:8080/file/download?fileName=新建文本文档.txt
     *
     * @param fileName
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/download")
    public Object downloadFile(@RequestParam String fileName, final HttpServletResponse response, final HttpServletRequest request) {
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
                return Rets.failure("下载附件失败，请检查文件“" + fileName + "”是否存在");
            }
            //复制
            IOUtils.copy(is, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException e) {
            return Rets.failure("下载附件失败,error:" + e.getMessage());
        }
        //文件的关闭放在finally中
        finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                logger.error(ExceptionUtils.getFullStackTrace(e));
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                logger.error(ExceptionUtils.getFullStackTrace(e));
            }
        }
        return null;
    }
}
