package com.zminder.wms.service;

import com.zminder.wms.pojo.Storage;
import com.zminder.wms.utils.Page;

public interface StorageService {
    Page<Storage> queryAll(int pageSize, int pageNum, String storageName);

    Storage queryByStorageName(String storageName);

    int save(Storage storage);

    int removeByStorageName(String storageName);

    int modify(Storage storage);
}
