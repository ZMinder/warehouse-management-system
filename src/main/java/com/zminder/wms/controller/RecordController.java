package com.zminder.wms.controller;

import com.zminder.wms.pojo.RecordAlias;
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
    public Result<List<RecordAlias>> queryAll() {
        List<RecordAlias> recordAliases = recordService.queryAll();
        return Result.success(recordAliases);
    }

    @PostMapping
    public Result<Page<RecordAlias>> queryFuzzy(@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                                @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                @RequestBody RecordAlias recordAlias) {
        Page<RecordAlias> recordPage = recordService.queryFuzzy(pageSize, pageNum, recordAlias);
        return Result.success(recordPage);
    }
}
