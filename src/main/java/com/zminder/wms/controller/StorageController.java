package com.zminder.wms.controller;

import com.zminder.wms.pojo.Storage;
import com.zminder.wms.service.StorageService;
import com.zminder.wms.utils.Page;
import com.zminder.wms.utils.Result;
import com.zminder.wms.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
@CrossOrigin
public class StorageController {
    @Autowired
    private StorageService storageService;

    @GetMapping
    public Result<Page<Storage>> queryAll(@RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                          @RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                          @RequestParam(value = "storageName",required = false,defaultValue = "") String storageName) {

        Page<Storage> storagePage = storageService.queryAll(pageSize, pageNum,storageName);
        return Result.success(storagePage);
    }

    @PostMapping
    public Result<Integer> save(@RequestBody Storage storage) {
        int save = storageService.save(storage);
        if (save == 0) {
            return Result.fail(null);
        }
        return Result.success(save);
    }

    @DeleteMapping("/{storageName}")
    public Result<Integer> removeByStorageName(@PathVariable("storageName") String storageName) {
        int res = storageService.removeByStorageName(storageName);
        if (res == 0) {
            return Result.fail(null);
        }
        return Result.success(res);
    }

    @PutMapping
    public Result<Integer> modify(@RequestBody Storage storage) {
        int modify = storageService.modify(storage);
        if (modify == 0) {
            return Result.fail(null);
        }
        return Result.success(modify);
    }
}
