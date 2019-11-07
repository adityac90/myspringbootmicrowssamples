package com.ehi.vi.generators;

import com.google.gson.internal.LinkedTreeMap;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelGenerator {
    public static ByteArrayInputStream customersToExcel(List<Object> searchResultAsList, String searchName) throws IOException {

        final String[] COLUMNs = extractHeaderInfo(searchResultAsList);
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream()
        ) {
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet(searchName);

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            headerCellStyle.setLocked(true);
            headerCellStyle.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());

            // Row for Header
            Row headerRow = sheet.createRow(0);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }

            // CellStyle for Age
            CellStyle ageCellStyle = workbook.createCellStyle();
            ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

            int rowIdx = 1;
            for (Object o : searchResultAsList) {
                Row row = sheet.createRow(rowIdx++);
                final LinkedTreeMap<String, Object> data = (LinkedTreeMap<String, Object>) o;
                int colIdx = 0;
                for (Object d : data.values()) {
                    row.createCell(colIdx++).setCellValue(d.toString());
                }
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    private static String[] extractHeaderInfo(List<Object> searchResultAsList) {
        final Object searchResultObj = searchResultAsList.get(0);
        String[] headers = null;
        LinkedTreeMap<String, Object> dataSet;
        if (searchResultObj instanceof LinkedTreeMap) {
            dataSet = (LinkedTreeMap<String, Object>) searchResultObj;
            headers = dataSet.keySet().toArray(new String[dataSet.size()]);
        }
        return headers;
    }
}
