package com.ehi.vi.controllers;

import com.ehi.vi.generators.ExcelGenerator;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/export/searchResult")
public class SearchResultExportController {
    @PostMapping("/{downloadFileName}")
    public ResponseEntity<InputStreamResource> downloadSearchResultAsExcel(@RequestParam(value = "searchName", required = true) String searchName, @RequestBody String jsonSearchResult, @PathVariable String downloadFileName) {
        final List<Object> searchResultAsList = new GsonJsonParser().parseList(jsonSearchResult);
        final String headerValue = "attachment; filename=" + downloadFileName + ".xlsx";
        ByteArrayInputStream in = null;
        if (searchResultAsList.size() > 0) {

            try {
                in = ExcelGenerator.customersToExcel(searchResultAsList,searchName);
            } catch (IOException e) {
                return ResponseEntity
                        .notFound().build();
            }
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", headerValue);
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(in));


    }


}
