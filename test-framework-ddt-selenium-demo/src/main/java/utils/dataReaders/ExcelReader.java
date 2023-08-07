package utils.dataReaders;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExcelReader {
    private static final Logger logger = LoggerFactory.getLogger(ExcelReader.class);
    private XSSFWorkbook workbook;

    public ExcelReader(String fileName) {
        try {
            workbook = new XSSFWorkbook(fileName);
        } catch (IOException e) {
            logger.error("读取Excel文件时出错，错误信息：{}", e.getMessage());
        }
    }

    public List<Map<String, String>> readExcelData2MapList(String sheetName) throws Exception {
        XSSFSheet sheet = workbook.getSheet(sheetName);
        List<Map<String, String>> list = new ArrayList<>();
        try {
            XSSFRow titleRow = sheet.getRow(0);
            logger.info("Sheet:{} has {} lines", sheetName, sheet.getLastRowNum());
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                XSSFRow row = sheet.getRow(rowNum);

                if (row == null) {
                    continue;
                }

                Map<String, String> map = new HashMap<>();
                for (int cellNum = 0; cellNum < titleRow.getLastCellNum(); cellNum++) {
                    XSSFCell xssfCell = row.getCell(cellNum);
                    XSSFCell titleRowCell = titleRow.getCell(cellNum);
                    map.put(getCellValue(titleRowCell), getCellValue(xssfCell));
                }
                list.add(map);
            }
        } catch (Exception e) {
            logger.error("Read Excel sheet to MapList error: {}", e.getMessage());
            e.printStackTrace();
        } finally {
            workbook.close();
        }
        return list;
    }

    public Map<String, Map<String, String>> readExcelData2Maps(String sheetName) throws Exception {
        // 循环工作表Sheet
        XSSFSheet sheet = workbook.getSheet(sheetName);
        Map<String, Map<String, String>> rowMap = new HashMap<>();

        try {
            // 循环行Row
            XSSFRow titleRow = sheet.getRow(0);
            logger.info("工作表{}总共有{}行数据", sheetName, sheet.getLastRowNum());
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                XSSFRow row = sheet.getRow(rowNum);

                if (row == null) {
                    continue;
                }

                Map<String, String> map = new HashMap<>();

                XSSFCell firstColumnCell = row.getCell(0);
                // 循环列Cell
                for (int cellNum = 0; cellNum < titleRow.getLastCellNum(); cellNum++) {
                    //每行每列的单元格取值
                    XSSFCell xssfCell = row.getCell(cellNum);
                    //每个列对应的列名（第一行）
                    XSSFCell titleRowCell = titleRow.getCell(cellNum);
                    //每列加上列名作为Key-Value存放
                    map.put(getCellValue(titleRowCell), getCellValue(xssfCell));
                }
                rowMap.put(getCellValue(firstColumnCell), map);
            }
        } catch (Exception e) {
            logger.error("读取Excel工作表到Maps时出错，错误信息：{}", e.getMessage());
        } finally {
            workbook.close();
        }
        return rowMap;
    }


    public String[][] getDataWithHeader(String sheetName) {
        return getDataArea(sheetName, 1, 1);
    }

    public String[][] getDataNoHeader(String sheetName) {
        return getDataArea(sheetName, 2, 1);
    }

    //将Excel的有效行列读入一个二维数组中
    public String[][] getDataArea(String sheetName, int rowStartIndex, int colStartIndex) {
        String[][] dataSets = null;

        try {
            XSSFSheet sheet = this.workbook.getSheet(sheetName);
            int totalRow = sheet.getLastRowNum() + 1;
            int totalCol = sheet.getRow(0).getLastCellNum();
            if (rowStartIndex < totalRow && colStartIndex < totalCol) {
                dataSets = new String[totalRow - rowStartIndex + 1][totalCol - colStartIndex + 1];

                for (int i = rowStartIndex - 1; i < totalRow; i++) {
                    XSSFRow rows = sheet.getRow(i);

                    for (int j = colStartIndex - 1; j < totalCol; j++) {
                        XSSFCell cell = rows.getCell(j);
                        dataSets[i - rowStartIndex + 1][j - colStartIndex + 1] = getCellValue(cell);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("读取Excel工作表（开始行{}，开始列{}）时出错，错误信息：{}", rowStartIndex, colStartIndex, e.getStackTrace());
        }

        return dataSets;
    }

    public static String getCellValue(XSSFCell cell) {
        String cellValue = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case NUMERIC:
                    cellValue = numericParse(cell);
                    break;
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                case ERROR:
                    break;
                default:
                    cellValue = cell.toString();
            }
        }
        return cellValue;
    }

    private static String numericParse(XSSFCell cell) {
        String cellValue;
        double value = cell.getNumericCellValue();
        int intValue = (int) value;
        cellValue = value > (double) intValue ? String.valueOf(value) : String.valueOf(intValue);

        return cellValue;
    }

    public int getNumberOfRows(String sheetName) {
        XSSFSheet sheet = this.workbook.getSheet(sheetName);
        return sheet.getLastRowNum() + 1;
    }

    public String getRowValues(String sheetName, int rowNum) {
        StringBuilder valuesBuf = new StringBuilder();

        try {
            XSSFSheet sheet = this.workbook.getSheet(sheetName);
            int totalCol = sheet.getRow(0).getLastCellNum();
            XSSFRow row = sheet.getRow(rowNum);
            valuesBuf.append(row.getCell(0).toString());

            for (int i = 1; i < totalCol; i++) {
                XSSFCell cell = row.getCell(i);
                valuesBuf.append(", ");
                valuesBuf.append(getCellValue(cell));
            }
        } catch (Exception e) {
            logger.error("读取Excel工作表第{}行信息时出错，错误信息：{}", rowNum, e.getStackTrace());
            return null;
        }

        logger.debug("The row " + rowNum + " values are: " + valuesBuf);
        return valuesBuf.toString();
    }
}
