package com.zminder.wms.mapper;

import com.zminder.wms.pojo.GoodsType;

import java.util.List;

/**
 * @author 86176
 * @description 针对表【goods_type】的数据库操作Mapper
 * @createDate 2024-06-02 12:00:08
 * @Entity .GoodsType
 */
public interface GoodsTypeMapper {

    List<GoodsType> selectFuzzyByGoodsTypeName(String goodsTypeName);

    GoodsType selectByGoodsTypeName(String goodsTypeName);

    int insert(GoodsType goodsType);

    int deleteByGoodsTypeName(String goodsTypeName);

    int update(GoodsType goodsType);
}
