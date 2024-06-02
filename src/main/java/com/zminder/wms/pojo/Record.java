package com.zminder.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private Integer recordId;
    private String goodsName;
    private String storageName;
    private String goodsTypeName;
    private String operatorNickname;
    private String licensorNickname;
    private String recordType;
    private Integer goodsCount;
    private Date operationTime;
    private String recordRemark;
}
