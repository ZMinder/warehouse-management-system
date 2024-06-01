package com.zminder.wms.service;

import com.zminder.wms.pojo.Storage;
import com.zminder.wms.utils.Page;

import java.util.List;

public interface StorageService {
    Page<Storage> queryAll(int pageSize, int pageNum);
    Storage queryByStorageName(String storageName);
    int save(Storage storage);
    int removeByStorageName(String storageName);
    int modify(Storage storage);
}
