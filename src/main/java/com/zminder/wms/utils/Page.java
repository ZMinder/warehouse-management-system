package com.zminder.wms.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    private Integer pageSize;//每页实际返回的条数
    private Integer pageNum;//实际返回的页码
    private Long total;//总记录数
    List<T> data;//存储的数据
}
