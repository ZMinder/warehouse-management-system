package com.zminder.wms.mapper;

import com.zminder.wms.pojo.Goods;

import java.util.List;

/**
 * @author 86176
 * @description 针对表【goods_type】的数据库操作Mapper
 * @createDate 2024-06-02 12:00:08
 * @Entity .GoodsType
 */
public interface GoodsMapper {

    List<Goods> selectALL();

    List<Goods> selectFuzzy(Goods goods);

    Goods selectByGoodsNameAndStorageAndType(String goodsName, Integer storageId, Integer typeId);

    int deleteById(Integer id);

    int insert(Goods goods);

    int update(Goods goods);
}
