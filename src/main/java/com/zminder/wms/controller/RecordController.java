package com.zminder.wms.controller;

import com.zminder.wms.pojo.Record;
import com.zminder.wms.service.RecordService;
import com.zminder.wms.utils.Page;
import com.zminder.wms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
@CrossOrigin
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping
    public Result<List<Record>> queryAll() {
        List<Record> records = recordService.queryAll();
        return Result.success(records);
    }

    @PostMapping
    public Result<Page<Record>> queryFuzzy(@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                           @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                           @RequestBody Record record) {
        Page<Record> recordPage = recordService.queryFuzzy(pageSize, pageNum, record);
        return Result.success(recordPage);
    }
}
