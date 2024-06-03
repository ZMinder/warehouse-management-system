package com.zminder.wms.controller;

import com.zminder.wms.pojo.Goods;
import com.zminder.wms.pojo.Record;
import com.zminder.wms.pojo.RecordAlias;
import com.zminder.wms.service.GoodsService;
import com.zminder.wms.service.RecordService;
import com.zminder.wms.utils.Page;
import com.zminder.wms.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/record")
@CrossOrigin
public class RecordController {
    @Autowired
    private RecordService recordService;

    @Autowired
    private GoodsService goodsService;

    @GetMapping
    public Result<List<RecordAlias>> queryAll() {
        List<RecordAlias> recordAliases = recordService.queryAll();
        return Result.success(recordAliases);
    }

    @GetMapping("/{operatorId}")
    public Result<Page<RecordAlias>> queryByOperatorId(@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                                       @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                       @PathVariable("operatorId") int operatorId) {
        Page<RecordAlias> recordAliasPage = recordService.queryByOperatorId(pageSize, pageNum, operatorId);
        return Result.success(recordAliasPage);
    }

    @PostMapping("/fuzzy")
    public Result<Page<RecordAlias>> queryFuzzy(@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                                @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                @RequestBody RecordAlias recordAlias) {
        Page<RecordAlias> recordPage = recordService.queryFuzzy(pageSize, pageNum, recordAlias);
        return Result.success(recordPage);
    }

    @PostMapping
    public Result save(@RequestBody Record record) {
        //获取当前系统时间并格式化
        LocalDateTime operationTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(operationTime);
        record.setOperationTime(format);
        //对goods表进行出库或入库操作
        Goods goods = goodsService.queryById(record.getGoodsId());
        if (record.getRecordType().equals("入库")) {
            goods.setGoodsCount(goods.getGoodsCount() + record.getGoodsCount());
        } else if (record.getRecordType().equals("出库")) {
            goods.setGoodsCount(goods.getGoodsCount() - record.getGoodsCount());
        }
        //执行入库或出库操作
        int modify = goodsService.modify(goods);
        //增加记录
        Integer save = recordService.save(record);
        if (save == 0) {
            return Result.fail(null);
        }
        return Result.success(save);
    }
}
