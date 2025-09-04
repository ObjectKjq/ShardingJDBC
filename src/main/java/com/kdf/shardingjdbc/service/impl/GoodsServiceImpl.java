package com.kdf.shardingjdbc.service.impl;

import com.kdf.shardingjdbc.mapper.GoodsMapper;
import com.kdf.shardingjdbc.model.Goods;
import com.kdf.shardingjdbc.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public void addGoods(Goods goods) {
        goodsMapper.insert(goods);
    }
}
