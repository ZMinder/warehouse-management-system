package com.zminder.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zminder.wms.mapper.GoodsTypeMapper;
import com.zminder.wms.pojo.GoodsType;
import com.zminder.wms.service.GoodsTypeService;
import com.zminder.wms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public Page<GoodsType> queryByPage(int pageSize, int pageNum, String goodsTypeName) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsType> storages = goodsTypeMapper.selectFuzzyByGoodsTypeName(goodsTypeName);
        PageInfo<GoodsType> storagePageInfo = new PageInfo<>(storages);
        List<GoodsType> list = storagePageInfo.getList();
        int realPageSize = list.size();
        int realPageNum = storagePageInfo.getPageNum();
        long total = storagePageInfo.getTotal();
        return new Page<>(realPageSize, realPageNum, total, list);
    }

    @Override
    public GoodsType queryByGoodsTypeName(String goodsTypeName) {
        return goodsTypeMapper.selectByGoodsTypeName(goodsTypeName);
    }

    @Override
    public int save(GoodsType goodsType) {
        return goodsTypeMapper.insert(goodsType);
    }

    @Override
    public int removeByGoodsTypeName(String goodsTypeName) {
        return goodsTypeMapper.deleteByGoodsTypeName(goodsTypeName);
    }

    @Override
    public int modify(GoodsType goodsType) {
        return goodsTypeMapper.update(goodsType);
    }

    @Override
    public List<GoodsType> queryAll() {
        return goodsTypeMapper.selectALL();
    }
}
