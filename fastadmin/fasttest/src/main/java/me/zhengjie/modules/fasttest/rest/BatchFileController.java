package me.zhengjie.modules.fasttest.rest;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.modules.fasttest.domain.Batch;
import me.zhengjie.utils.fasttest.DateHelper;
import me.zhengjie.utils.fasttest.DownloadHelper;
import me.zhengjie.utils.fasttest.FileHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@RestController
@RequiredArgsConstructor
@Api(tags = "FastTest：创建批量文件")
@RequestMapping("/api/batch")
public class BatchFileController {
    private static final Logger logger = LoggerFactory.getLogger(Km2XlsController.class);
    //在文件操作中，不用/或者\最好，推荐使用File.separator
    private final static String fileDir = "batch";
    private final static String rootPath = System.getProperty("user.home") + File.separator + fileDir + File.separator;

    @PostMapping
    @AnonymousAccess
    public Object create(@RequestBody Batch batch) {
        // 自动生成批量文件，通过指定的total参数来确定生成文件的记录行数
        Integer total = batch.getTotal();
        System.out.println(total);
        System.out.println("Enter function:     create");
        String secTime = DateHelper.getReportDateTime().replace("-", "");
        String shortName = "BatchFile" + secTime + "_" + total + ".txt";
        String fileName = rootPath + shortName;

        FileHelper.createDir(rootPath);
        File file = null;
        FileWriter fw = null;
        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);

            int num = 0;
            long current = System.currentTimeMillis();
            for (int i = 0; i < total; i++) {
                String itemId = "Item" + String.valueOf(current + System.nanoTime()).substring(0, 13);
                String line = String.format(
                        // 注意唯一性
                        "A," + itemId + ",法定名称测试有限公司" + secTime + ",经营名称测试有限公司,SHANGHADKANGMED CO.LTD,822001,156,2|2900|3300|3000,01|02|03" + "\r\n"
                );

                fw.write(line);
                num += 1;
                if (num % 1000 == 0) fw.flush();
            }

            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileName);
        return ResponseEntity.ok(shortName);

    }

    @GetMapping("/download")
    @AnonymousAccess
    public ResponseEntity<Object> downloadFile(@RequestParam String fileName, final HttpServletResponse response, final HttpServletRequest request) {
        DownloadHelper helper = new DownloadHelper();
        helper.rootPath = rootPath;
        return helper.downloadFile(fileName, response, request);
    }


}
