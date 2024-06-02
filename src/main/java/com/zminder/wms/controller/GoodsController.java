package com.zminder.wms.controller;

import com.zminder.wms.pojo.Goods;
import com.zminder.wms.service.GoodsService;
import com.zminder.wms.utils.Page;
import com.zminder.wms.utils.Result;
import com.zminder.wms.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@CrossOrigin
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public Result<List<Goods>> queryAll() {
        List<Goods> goods = goodsService.queryAll();
        if (null == goods) {
            return Result.fail(null);
        }
        return Result.success(goods);
    }

    @PostMapping("/fuzzy")
    public Result<Page<Goods>> queryFuzzyByPage(@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                                @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                @RequestBody Goods goods) {
        Page<Goods> goodsPage = goodsService.queryFuzzyByPage(pageSize, pageNum, goods);
        return Result.success(goodsPage);
    }

    @GetMapping()
    public Result<Goods> queryByGoodsNameAndStorageAndType(@RequestParam("goodsName") String goodsName,
                                                           @RequestParam("storageId") Integer storageId,
                                                           @RequestParam("typeId") Integer typeId) {
        Goods goods = goodsService.queryByGoodsNameAndStorageAndType(goodsName, storageId, typeId);
        if (null == goods) {
            return Result.error(ResultCode.GOODS_NOT_EXISTS, null);
        }
        return Result.success(goods);
    }

    @PostMapping
    public Result<Integer> save(Goods goods) {
        int res = goodsService.save(goods);
        if (res == 0) {
            return Result.fail(null);
        }
        return Result.success(res);
    }

    @DeleteMapping("/{id}")
    public Result<Integer> removeByById(@PathVariable("id") Integer id) {
        int res = goodsService.removeById(id);
        if (res == 0) {
            return Result.fail(null);
        }
        return Result.success(res);
    }

    @PutMapping
    public Result<Integer> modify(Goods goods) {
        int res = goodsService.modify(goods);
        if (res == 0) {
            return Result.fail(null);
        }
        return Result.success(res);
    }
}
