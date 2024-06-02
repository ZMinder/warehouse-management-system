package com.zminder.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName goods
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private Integer id;

    private String goodsName;

    private Integer goodsStorage;

    private Integer goodsType;

    private Integer goodsCount;

    private String goodsRemark;
}
