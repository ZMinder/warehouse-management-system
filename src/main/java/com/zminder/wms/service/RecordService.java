package com.zminder.wms.service;

import com.zminder.wms.pojo.Record;
import com.zminder.wms.pojo.RecordAlias;
import com.zminder.wms.utils.Page;

import java.util.List;

public interface RecordService {
    List<RecordAlias> queryAll();

    Page<RecordAlias> queryByOperatorId(int pageSize, int pageNum, int operatorId);

    Page<RecordAlias> queryFuzzy(int pageSize, int pageNum, RecordAlias recordAlias);

    Integer save(Record record);
}
