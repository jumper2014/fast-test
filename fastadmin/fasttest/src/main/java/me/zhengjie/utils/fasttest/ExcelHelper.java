package me.zhengjie.utils.fasttest;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static org.apache.poi.hssf.record.ExtendedFormatRecord.CENTER;
import static org.apache.poi.hssf.record.ExtendedFormatRecord.THIN;
import static org.apache.poi.ss.usermodel.PatternFormatting.SOLID_FOREGROUND;

/**
 * 将用例写入Excel
 */
public class ExcelHelper {
    /**
     * 将用例写入Excel
     *
     * @return
     */
    public static HSSFWorkbook writeToExcel(List<List<String>> allCaseList, String xmindFolderPath, String excelName) {
        int caseCount = 0;
        // 第一步：创建Excel工作簿对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 第二步：创建工作表
        HSSFSheet sheet = workbook.createSheet(excelName);
        // 第三步：在sheet中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        // 第四步:声明列对象
        HSSFCell cell1 = row.createCell(1 - 1);
        HSSFCell cell2 = row.createCell(2 - 1);
        HSSFCell cell3 = row.createCell(3 - 1);
        HSSFCell cell4 = row.createCell(4 - 1);
        HSSFCell cell5 = row.createCell(5 - 1);
        HSSFCell cell6 = row.createCell(6 - 1);
        HSSFCell cell7 = row.createCell(7 - 1);
        HSSFCell cell8 = row.createCell(8 - 1);
        HSSFCell cell9 = row.createCell(9 - 1);
        HSSFCell cell10 = row.createCell(10 - 1);
        HSSFCell cell11 = row.createCell(11 - 1);
        HSSFCell cell12 = row.createCell(12 - 1);
        HSSFCell cell13 = row.createCell(13 - 1);

        cell1.setCellValue("Project");  // cell1.setCellValue("测试案例路径");
        cell2.setCellValue("Test Folder");  // cell2.setCellValue("测试案例名称");
        cell3.setCellValue("Environment"); // cell3.setCellValue("测试案例描述");
        cell4.setCellValue("Owner"); // cell4.setCellValue("预计执行工时（分钟）");
        cell5.setCellValue("Work Product");  // cell5.setCellValue("步骤描述");
        cell6.setCellValue("Name");  //  cell6.setCellValue("预期结果");
        cell7.setCellValue("Description");
        cell8.setCellValue("Pre Conditions");
        cell9.setCellValue("Component");
        cell10.setCellValue("Priority");
        cell11.setCellValue("Method");
        cell12.setCellValue("Type");
        cell13.setCellValue("Add to Regression");

        // 设置表头样式
        HSSFCellStyle styleHead = workbook.createCellStyle();
        // 设置表头字体
        HSSFFont fontHead = workbook.createFont();
        cell1.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell2.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell3.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell4.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell5.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell6.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell7.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell8.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell9.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell10.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell11.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell12.setCellStyle(getHeadStyle(styleHead, fontHead));
        cell13.setCellStyle(getHeadStyle(styleHead, fontHead));

        // 设置列宽
        sheet.setColumnWidth(1 - 1, 20 * 256);
        sheet.setColumnWidth(2 - 1, 20 * 256);
        sheet.setColumnWidth(3 - 1, 20 * 256);
        sheet.setColumnWidth(4 - 1, 20 * 256);
        sheet.setColumnWidth(5 - 1, 10 * 256);
        sheet.setColumnWidth(6 - 1, 60 * 256);
        sheet.setColumnWidth(7 - 1, 60 * 256);
        sheet.setColumnWidth(8 - 1, 60 * 256);
        sheet.setColumnWidth(9 - 1, 15 * 256);
        sheet.setColumnWidth(10 - 1, 15 * 256);
        sheet.setColumnWidth(11 - 1, 15 * 256);
        sheet.setColumnWidth(12 - 1, 15 * 256);
        sheet.setColumnWidth(13 - 1, 15 * 256);

        int caseNameIndex = 0;
        int caseDescIndex = 1;
        int casePreIndex = 2;
        // 设置单元格样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置单元格字体
        HSSFFont font = workbook.createFont();
        // 存储之前一个案例的名字，如果一样表示是同一个案例
        String preCase = "";


        // 遍历所有case集合
        for (int i = 0; i < allCaseList.size(); i++) {
//            System.out.println("-------------------");
//            System.out.println("Row: " + String.valueOf(i));
            // 创建用例内容的行，表头为第0行，因此真正的内容从i+1行开始

            // 取出单条用例
            List<String> caseList = allCaseList.get(i);
            String caseName = caseList.get(caseNameIndex);
            String caseDesc = caseList.get(caseDescIndex);
            String casePrecondition = caseList.get(casePreIndex);
            row = sheet.createRow(i + 1);
            // 第一列为测试用例的路径
            HSSFCell c1 = row.createCell(1 - 1);
            c1.setCellValue("Feature Team 1");
            HSSFCell c2 = row.createCell(2 - 1);
            c2.setCellValue("");
            HSSFCell c3 = row.createCell(3 - 1);
            c3.setCellValue("Development");
            HSSFCell c4 = row.createCell(4 - 1);
            c4.setCellValue("me@ft.com");
            HSSFCell c5 = row.createCell(5 - 1);
            c5.setCellValue("");
            HSSFCell c6 = row.createCell(6 - 1);
            c6.setCellValue(caseName);
            HSSFCell c7 = row.createCell(7 - 1);
            c7.setCellValue(caseDesc);
            HSSFCell c8 = row.createCell(8 - 1);
            c8.setCellValue(casePrecondition);
            HSSFCell c9 = row.createCell(9 - 1);
            c9.setCellValue("");
            HSSFCell c10 = row.createCell(10 - 1);
            c10.setCellValue("Critical");
            HSSFCell c11 = row.createCell(11 - 1);
            c11.setCellValue("Automated");
            HSSFCell c12 = row.createCell(12 - 1);
            c11.setCellValue("Functional");
            HSSFCell c13 = row.createCell(13 - 1);
            c11.setCellValue("Yes");
        }

        FileOutputStream out;
        try {
            // 生成文件路径: 当前目录
            String filePath = xmindFolderPath;
            // 文件名
            String fileName = excelName + ".xls";
            // 生成excel文件
            out = new FileOutputStream(filePath + fileName);
            workbook.write(out);
            System.out.println("Transfer done. Path:" + filePath + fileName);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return workbook;

    }

    /**
     * 设置表头格式 颜色可参照：https://blog.csdn.net/w405722907/article/details/76915903
     *
     * @param styleHead
     * @return
     */
    public static HSSFCellStyle getHeadStyle(HSSFCellStyle styleHead, HSSFFont fontHead) {
        // 水平居中
        styleHead.setAlignment(HorizontalAlignment.forInt(CENTER));
        // 垂直居中
        styleHead.setVerticalAlignment(VerticalAlignment.forInt(CENTER));
        // 设置标题背景色
        styleHead.setFillPattern(FillPatternType.forInt(SOLID_FOREGROUND));
//        styleHead.setFillForegroundColor(IndexedColors.LIME.getIndex());// 绿色
        styleHead.setFillForegroundColor(IndexedColors.PALE_BLUE.index);// 蓝色

        // 设置四周边框
        styleHead.setBorderBottom(BorderStyle.valueOf(THIN));// 下边框
        styleHead.setBorderLeft(BorderStyle.valueOf(THIN));// 左边框
        styleHead.setBorderTop(BorderStyle.valueOf(THIN));// 上边框
        styleHead.setBorderRight(BorderStyle.valueOf(THIN));// 右边框

        // 设置自动换行;
        styleHead.setWrapText(true);

        // 设置字体
        fontHead.setFontName("微软雅黑");
        fontHead.setBold(true);
        styleHead.setFont(fontHead);

        // 自定义一个原谅色
//        HSSFPalette customPalette = workbook.getCustomPalette();
//        HSSFColor yuanLiangColor = customPalette.addColor((byte) 146, (byte) 208, (byte) 80);

        return styleHead;
    }

    /**
     * 设置单元格格式 颜色可参照：https://blog.csdn.net/w405722907/article/details/76915903
     * 对格式的设置进行优化，提升了性能：https://blog.csdn.net/qq592304796/article/details/52608714/
     *
     * @param style
     * @return
     */
    public static HSSFCellStyle getCellStyle(HSSFCellStyle style, HSSFFont font) {
        // 垂直居中
        style.setVerticalAlignment(VerticalAlignment.forInt(CENTER));
        // 设置自动换行;
        style.setWrapText(true);
        font.setFontName("微软雅黑");
        style.setFont(font);
        return style;
    }

}
