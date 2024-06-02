package com.zminder.wms.controller;

import com.zminder.wms.pojo.GoodsType;
import com.zminder.wms.service.GoodsTypeService;
import com.zminder.wms.utils.Page;
import com.zminder.wms.utils.Result;
import com.zminder.wms.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
@CrossOrigin
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService goodsTypeService;

    @GetMapping
    public Result<Page<GoodsType>> queryAll(@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                            @RequestParam(value = "storageName", required = false, defaultValue = "") String goodsTypeName) {

        Page<GoodsType> storagePage = goodsTypeService.queryAll(pageSize, pageNum, goodsTypeName);
        return Result.success(storagePage);
    }

    @GetMapping("/{goodsTypeName}")
    public Result<GoodsType> queryByStorageName(@PathVariable("goodsTypeName") String goodsTypeName) {
        GoodsType goodsType = goodsTypeService.queryByGoodsTypeName(goodsTypeName);
        if (null == goodsType) {
            return Result.error(ResultCode.GOODS_TYPE_NOT_EXISTS, null);
        }
        return Result.success(goodsType);
    }

    @PostMapping
    public Result<Integer> save(@RequestBody GoodsType goodsType) {
        int save = goodsTypeService.save(goodsType);
        if (save == 0) {
            return Result.fail(null);
        }
        return Result.success(save);
    }

    @DeleteMapping("/{goodsTypeName}")
    public Result<Integer> removeByStorageName(@PathVariable("goodsTypeName") String goodsTypeName) {
        int res = goodsTypeService.removeByGoodsTypeName(goodsTypeName);
        if (res == 0) {
            return Result.fail(null);
        }
        return Result.success(res);
    }

    @PutMapping
    public Result<Integer> modify(@RequestBody GoodsType goodsType) {
        int modify = goodsTypeService.modify(goodsType);
        if (modify == 0) {
            return Result.fail(null);
        }
        return Result.success(modify);
    }
}
