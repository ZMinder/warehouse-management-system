package com.zminder.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zminder.wms.mapper.GoodsMapper;
import com.zminder.wms.pojo.Goods;
import com.zminder.wms.service.GoodsService;
import com.zminder.wms.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Goods> queryAll() {
        return goodsMapper.selectALL();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Goods> queryFuzzyByPage(int pageSize, int pageNum, Goods goods) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goodsInfo = goodsMapper.selectFuzzy(goods);
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsInfo);
        List<Goods> goodsList = goodsPageInfo.getList();
        int realPageSize = goodsList.size();
        int realPageNum = goodsPageInfo.getPageNum();
        long total = goodsPageInfo.getTotal();
        return new Page<>(realPageSize, realPageNum, total, goodsList);
    }

    @Override
    @Transactional(readOnly = true)
    public Goods queryByGoodsNameAndStorageAndType(String goodsName, Integer storageId, Integer typeId) {
        return goodsMapper.selectByGoodsNameAndStorageAndType(goodsName, storageId, typeId);
    }

    @Override
    public int save(Goods goods) {
        return goodsMapper.insert(goods);
    }

    @Override
    public int removeById(Integer id) {
        return goodsMapper.deleteById(id);
    }

    @Override
    public int modify(Goods goods) {
        return goodsMapper.update(goods);
    }
}