package com.zminder.wms.service;

import com.zminder.wms.pojo.Record;
import com.zminder.wms.utils.Page;

import java.util.List;

public interface RecordService {
    List<Record> queryAll();

    Page<Record> queryFuzzy(int pageSize, int pageNum, Record record);
}
