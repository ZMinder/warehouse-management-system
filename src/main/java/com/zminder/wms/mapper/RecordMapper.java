package com.zminder.wms.mapper;

import com.zminder.wms.pojo.Record;

import java.util.List;

public interface RecordMapper {
    List<Record> selectAll();

    List<Record> selectFuzzy(Record record);
}
