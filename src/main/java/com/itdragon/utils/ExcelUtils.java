package com.itdragon.utils;

import com.itdragon.pojo.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tyk
 * @Date: 2019/6/3 15:10
 * @Description:
 */
public class ExcelUtils {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    public static List<List<String>> getLists(MultipartFile file, int numOfSheet) throws IOException {
        //核查文件的准确性：空，格式
        checkFile(file);

        //获取工作簿
        Workbook workbook = getWorkbook(file);

        List<List<String>> lists = new ArrayList<>(128);
        //获取第一张工作表
        if (workbook != null) {
            Sheet sheet = workbook.getSheetAt(numOfSheet);
            //获取工作表总行数
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();

            int firstCellNum = sheet.getRow(0).getFirstCellNum();
            int lastCellNum = sheet.getRow(0).getLastCellNum();

            //创建数组集合,遍历工作簿并保存工作簿的内容
            for (int i = firstRow + 1; i <= lastRow; i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                List<String> strings = new ArrayList<>();
                for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    getCellValue(cell);
                    strings.add(getCellValue(cell));
                }
                lists.add(strings);
            }
        }
        return lists;
    }

    public static void checkFile(MultipartFile file) throws IOException {
        if (null == file) {
            throw new FileNotFoundException("文件不存在");
        }
        String fileName = file.getOriginalFilename();
        //根据文件的后缀名创建响应的工作簿
        if (!fileName.endsWith(".xls") && !fileName.endsWith(".xlsx")) {
            throw new IOException(fileName+"不是EXCEL文件！");
        }
    }

    public static Workbook getWorkbook(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        Workbook workbook = null;
        try {
            if (fileName.endsWith(".xls")) {
                workbook = new HSSFWorkbook(file.getInputStream());
            }
            if (fileName.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream());
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return workbook;
    }

    /**
     * 获取单元格的值
     * @param cell
     * @return
     */
    private static String getCellValue(Cell cell) {
        String value = "";
        if (cell==null) {
            return value;
        }
        int cellType = cell.getCellType();
        switch (cellType) {
            case Cell.CELL_TYPE_NUMERIC:
                value = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_STRING:
                value = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                value = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            case Cell.CELL_TYPE_ERROR:
                value = "非法字符";
                break;
            default:
                value = "未知类型";
        }

        return value;
    }

}

