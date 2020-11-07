package com.mushanwb.github.wxshop.controller;

import com.mushanwb.github.wxshop.generate.Goods;
import com.mushanwb.github.wxshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class GoodsController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("goods")
    public Goods createdGoods(@RequestBody Goods goods) {
        return goodsService.createGoods(goods);
    }

}
