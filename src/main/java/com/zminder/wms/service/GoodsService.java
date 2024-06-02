package com.zminder.wms.service;

import com.zminder.wms.pojo.Goods;
import com.zminder.wms.utils.Page;

import java.util.List;

public interface GoodsService {
    List<Goods> queryAll();

    Page<Goods> queryFuzzyByPage(int pageSize, int pageNum, Goods goods);

    Goods queryByGoodsNameAndStorageAndType(String goodsName, Integer storageId, Integer typeId);

    int save(Goods goods);

    int removeById(Integer id);

    int modify(Goods goods);
}
