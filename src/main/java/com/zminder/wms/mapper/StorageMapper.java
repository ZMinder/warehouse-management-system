package com.zminder.wms.mapper;

import com.zminder.wms.pojo.Storage;

import java.util.List;

public interface StorageMapper {
    List<Storage> selectAll();
    Storage selectByStorageName(String storageName);
    int insert(Storage storage);
    int deleteByStorageName(String storageName);
    int update(Storage storage);
}
