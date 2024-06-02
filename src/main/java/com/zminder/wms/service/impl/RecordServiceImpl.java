package com.zminder.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zminder.wms.mapper.RecordMapper;
import com.zminder.wms.pojo.Record;
import com.zminder.wms.service.RecordService;
import com.zminder.wms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Record> queryAll() {
        List<Record> records = recordMapper.selectAll();
        return records;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Record> queryFuzzy(int pageSize, int pageNum, Record record) {
        PageHelper.startPage(pageNum, pageSize);
        List<Record> records = recordMapper.selectFuzzy(record);
        PageInfo<Record> recordPageInfo = new PageInfo<>(records);
        List<Record> recordList = recordPageInfo.getList();
        int realPageSize = recordList.size();
        int realPageNum = recordPageInfo.getPageNum();
        long total = recordPageInfo.getTotal();
        return new Page<>(realPageSize, realPageNum, total, recordList);
    }
}
