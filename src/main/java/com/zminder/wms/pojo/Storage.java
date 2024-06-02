package com.zminder.wms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @TableName storage
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 仓库名
     */
    private String storageName;

    /**
     * 仓库描述
     */
    private String storageRemark;

}
