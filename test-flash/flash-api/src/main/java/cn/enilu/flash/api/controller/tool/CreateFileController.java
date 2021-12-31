package cn.enilu.flash.api.controller.tool;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.api.helper.DDate;
import cn.enilu.flash.bean.vo.front.Rets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 测试工具
 */
@RestController
@RequestMapping("/createfile")
public class CreateFileController extends BaseController {

    @Value("${resource.file.dir}")
    public String resourceDir;

    @GetMapping("/create")
    public Object create(Integer total) {
        /*
    自动生成导入商户的文件，通过指定的total参数来确定生成文件的记录行数
     */
        System.out.println(total);
        System.out.println("Enter function:     create");
        String secTime = DDate.getReportDateTime().replace("-", "");
        String fileName = "C:\\data\\" + "CreateFile" + secTime + "_" + total + "_ZYT_I.txt";

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
                long merId =  current + System.nanoTime();
                String merchantId = "MI" + String.valueOf(merId).substring(0, 13);
                String line = String.format(
                        // 商户名称到秒，用于查询
                        "I," + merchantId + ",法定名称测试有限公司"+secTime+",经营名称测试有限公司,SHANGHADKANGMED CO.LTD,822001,156,2900,5699,1,01,LN2021070800001,上海市浦东新区,注册地址上海市浦东新区,1,程建國,01,310109199001010013,张三,通讯地址上海市浦东新区,021-12345678,177-1234-5678,2,外包收单机构001,https://www.baDdD.com,百度APP,DCP20200813001,01,6222111122221234567,1000,01,20210531,医药咨询，从事医疗器械领域内的技术开发、技术咨询、技术服务、技术转让，商务信息咨询，会务服务，物业管理，食用农产品的销售，文具用品、五金交电、日用百货、洗涤用品、化妆品、电子产品、计算机、软件及辅助设备的批发、零售，从事货物进出口及技术进出口业务，自有房屋租赁，货物运输代理，仓储服务（除危险化学品），打包服务，人工搬运服务。,2|2900|3300|3000,01|02|03" + "\r\n"
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
        return Rets.success(fileName);

    }


}
