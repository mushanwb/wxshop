package com.mushanwb.github.wxshop.service;

import com.mushanwb.github.wxshop.dao.GoodsDao;
import com.mushanwb.github.wxshop.generate.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    private final GoodsDao goodsDao;

    @Autowired
    public GoodsService(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public Goods createGoods(Goods goods) {
        return goodsDao.createGoods(goods);
    }
}
