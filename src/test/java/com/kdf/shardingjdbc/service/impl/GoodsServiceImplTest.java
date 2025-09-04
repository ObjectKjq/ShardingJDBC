package com.kdf.shardingjdbc.service.impl;

import com.kdf.shardingjdbc.model.Goods;
import com.kdf.shardingjdbc.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsServiceImplTest {

    @Resource
    private GoodsService goodsService;

    @Test
    void addGoods() {
        Goods goods = new Goods();
        // goods.setGid();
        goods.setGname("小米手机");
        goods.setUserId(100);
        goods.setGstatus(0);
        goodsService.addGoods(goods);
    }

}