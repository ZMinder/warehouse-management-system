package com.zminder.wms.controller;

import com.zminder.wms.pojo.Storage;
import com.zminder.wms.service.StorageService;
import com.zminder.wms.utils.Page;
import com.zminder.wms.utils.Result;
import com.zminder.wms.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
@CrossOrigin
public class StorageController {
    @Autowired
    private StorageService storageService;

    public Result<Page<Storage>> queryAll(int pageSize, int pageNum) {
        Page<Storage> storagePage = storageService.queryAll(pageSize, pageNum);
        return Result.success(storagePage);
    }

    public Result<Storage> queryByStorageName(String storageName) {
        Storage storage = storageService.queryByStorageName(storageName);
        if (null == storage) {
            return Result.error(ResultCode.STORAGE_NOT_EXISTS, null);
        }
        return Result.success(storage);
    }

    public Result<Integer> save(Storage storage) {
        int save = storageService.save(storage);
        if (save == 0) {
            return Result.fail(null);
        }
        return Result.success(save);
    }

    public Result<Integer> removeByStorageName(String storageName) {
        int res = storageService.removeByStorageName(storageName);
        if (res == 0) {
            return Result.fail(null);
        }
        return Result.success(res);
    }

    public Result<Integer> modify(Storage storage) {
        int modify = storageService.modify(storage);
        if (modify == 0) {
            return Result.fail(null);
        }
        return Result.success(modify);
    }
}
