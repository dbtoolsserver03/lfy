package com.zhouyu.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.EasyExcel;
import com.zhouyu.domain.Salaries;
import com.zhouyu.listener.SalariesListener;

import jakarta.annotation.Resource;

/**
 * 作者：周瑜大都督
 */
@Service
public class ImportService {

    @Resource
    private SalariesListener salariesListener;

    private ExecutorService executorService = Executors.newFixedThreadPool(20);

    public void importExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Salaries.class, salariesListener).doReadAll();
    }


    public void importExcelAsync(MultipartFile file) {
        // 开20个线程分别处理20个sheet

        List<Callable<Object>> tasks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int num = i;
            tasks.add(() -> {
                EasyExcel.read(file.getInputStream(), Salaries.class, salariesListener)
                        .sheet(num).doRead();
                return null;
            });
        }

        try {
            executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
