package com.zminder.wms.service;

import com.zminder.wms.pojo.GoodsType;
import com.zminder.wms.pojo.Storage;
import com.zminder.wms.utils.Page;

public interface GoodsTypeService {
    Page<GoodsType> queryAll(int pageSize, int pageNum, String goodsTypeName);

    GoodsType queryByGoodsTypeName(String goodsTypeName);

    int save(GoodsType goodsType);

    int removeByGoodsTypeName(String goodsTypeName);

    int modify(GoodsType goodsType);
}
