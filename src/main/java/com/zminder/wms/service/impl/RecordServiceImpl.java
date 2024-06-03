package com.zminder.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zminder.wms.mapper.RecordMapper;
import com.zminder.wms.pojo.Record;
import com.zminder.wms.pojo.RecordAlias;
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
    public List<RecordAlias> queryAll() {
        List<RecordAlias> recordAliases = recordMapper.selectAll();
        return recordAliases;
    }

    @Override
    public Page<RecordAlias> queryByOperatorId(int pageSize, int pageNum, int operatorId) {
        PageHelper.startPage(pageNum, pageSize);
        List<RecordAlias> recordAliases = recordMapper.selectByOperatorId(operatorId);
        PageInfo<RecordAlias> recordPageInfo = new PageInfo<>(recordAliases);
        List<RecordAlias> recordAliasList = recordPageInfo.getList();
        int realPageSize = recordAliasList.size();
        int realPageNum = recordPageInfo.getPageNum();
        long total = recordPageInfo.getTotal();
        return new Page<>(realPageSize, realPageNum, total, recordAliasList);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RecordAlias> queryFuzzy(int pageSize, int pageNum, RecordAlias recordAlias) {
        PageHelper.startPage(pageNum, pageSize);
        List<RecordAlias> recordAliases = recordMapper.selectFuzzy(recordAlias);
        PageInfo<RecordAlias> recordPageInfo = new PageInfo<>(recordAliases);
        List<RecordAlias> recordAliasList = recordPageInfo.getList();
        int realPageSize = recordAliasList.size();
        int realPageNum = recordPageInfo.getPageNum();
        long total = recordPageInfo.getTotal();
        return new Page<>(realPageSize, realPageNum, total, recordAliasList);
    }

    @Override
    public Integer save(Record record) {
        return recordMapper.insert(record);
    }
}
