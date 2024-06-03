package com.zminder.wms.mapper;

import com.zminder.wms.pojo.Record;
import com.zminder.wms.pojo.RecordAlias;

import java.util.List;

public interface RecordMapper {
    List<RecordAlias> selectAll();

    List<RecordAlias> selectFuzzy(RecordAlias recordAlias);

    Integer insert(Record record);
}
