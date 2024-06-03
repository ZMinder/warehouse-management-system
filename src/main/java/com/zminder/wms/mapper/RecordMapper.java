package com.zminder.wms.mapper;

import com.zminder.wms.pojo.Record;
import com.zminder.wms.pojo.RecordAlias;

import java.util.List;
import java.util.Map;

public interface RecordMapper {
    List<RecordAlias> selectAll();


    List<RecordAlias> selectFuzzy(Map<String, Object> map);

    Integer insert(Record record);
}
