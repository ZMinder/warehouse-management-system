package com.zminder.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zminder.wms.mapper.StorageMapper;
import com.zminder.wms.pojo.Storage;
import com.zminder.wms.service.StorageService;
import com.zminder.wms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<Storage> queryAll(int pageSize, int pageNum,String storageName) {
        PageHelper.startPage(pageNum, pageSize);
        List<Storage> storages = storageMapper.selectByStorageName(storageName);
        PageInfo<Storage> storagePageInfo = new PageInfo<>(storages);
        List<Storage> list = storagePageInfo.getList();
        int realPageSize = list.size();
        System.out.println(realPageSize);
        System.out.println(list);
        System.out.println(storages);
        int realPageNum = storagePageInfo.getPageNum();
        long total = storagePageInfo.getTotal();
        return new Page<>(realPageSize, realPageNum, total, list);
    }

    @Override
    public int save(Storage storage) {
        return storageMapper.insert(storage);
    }

    @Override
    public int removeByStorageName(String storageName) {
        return storageMapper.deleteByStorageName(storageName);
    }

    @Override
    public int modify(Storage storage) {
        return storageMapper.update(storage);
    }
}
