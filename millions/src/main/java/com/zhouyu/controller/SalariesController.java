package com.zhouyu.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zhouyu.service.ExportService;
import com.zhouyu.service.ImportService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 作者：周瑜大都督
 */

@RestController
public class SalariesController {

    @Resource
    private ExportService exportService;

    @Resource
    private ImportService importService;


    @GetMapping("export1")
    public void exportExcel1(HttpServletResponse response) throws IOException {
        exportService.exportExcel1(response);
    }


    @GetMapping("export2")
    public void exportExcel2(HttpServletResponse response) throws IOException {
        exportService.exportExcel2(response);
    }


    @GetMapping("export3")
    public void exportExcel3(HttpServletResponse response) throws IOException {
        exportService.exportExcel3(response);
    }

    @GetMapping("export4")
    public void exportExcel4(HttpServletResponse response) throws IOException, InterruptedException {
        exportService.exportExcel4(response);
    }

    @PostMapping("import")
    public void importExcel(MultipartFile file) throws IOException {
//        importService.importExcel(file);
    	System.out.println(1111111111);
        importService.importExcelAsync(file);
        System.out.println(222222222);
    }


}
