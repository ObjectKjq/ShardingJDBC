package com.kdf.shardingjdbc.controller;

import com.kdf.shardingjdbc.model.Goods;
import com.kdf.shardingjdbc.model.User;
import com.kdf.shardingjdbc.service.GoodsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @PostMapping("/add")
    public Boolean addGoods(@RequestBody Goods goods) {
        // 获取用户信息
        goodsService.addGoods(goods);
        return true;
    }

}
