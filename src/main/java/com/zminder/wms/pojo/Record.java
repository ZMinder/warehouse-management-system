package com.zminder.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName record
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private Integer id;

    private Integer goodsId;

    private Integer operatorId;

    private Integer licensorId;

    private String recordType;

    private Integer goodsCount;

    private String operationTime;

    private String recordRemark;
}
