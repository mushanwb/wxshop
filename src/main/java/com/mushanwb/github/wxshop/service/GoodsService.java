package com.mushanwb.github.wxshop.service;

import com.mushanwb.github.wxshop.dao.GoodsDao;
import com.mushanwb.github.wxshop.dao.ShopDao;
import com.mushanwb.github.wxshop.entity.DataStatus;
import com.mushanwb.github.wxshop.entity.PageResponse;
import com.mushanwb.github.wxshop.entity.WxShopException;
import com.mushanwb.github.wxshop.generate.Goods;
import com.mushanwb.github.wxshop.generate.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GoodsService {

    private final GoodsDao goodsDao;
    private final ShopDao shopDao;


    @Autowired
    public GoodsService(GoodsDao goodsDao,
                        ShopDao shopDao) {
        this.goodsDao = goodsDao;
        this.shopDao = shopDao;
    }

    public Goods createGoods(Goods goods) {
        Shop shop = shopDao.findShopById(goods.getShopId());

        if (Objects.equals(shop.getOwnerUserId(), UserContext.getCurrentUser().getId())) {
            goodsDao.createGoods(goods);
            return goods;
        } else {
            throw WxShopException.forbidden("无权访问！");
        }
    }

    public Goods deleteGoodsById(Long goodsId) {
        Shop shop = shopDao.findShopById(goodsId);

        if (Objects.equals(shop.getOwnerUserId(), UserContext.getCurrentUser().getId())) {
            Goods goods = goodsDao.getGoodsById(goodsId);
            if (goods == null) {
                throw WxShopException.notFound("商品未找到");
            }
            goods.setStatus(DataStatus.DELETED.getName());
            goodsDao.deleteGoodsById(goods);
            return goods;
        } else {
            throw WxShopException.forbidden("无权访问！");
        }
    }

    public PageResponse<Goods> getGoods(Integer pageNum, Integer pageSize, Integer shopId) {
        // 知道有多少个元素
        // 才知道有多少页
        int totalNum = goodsDao.countAll(shopId);
        int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : (totalNum / pageSize) + 1;
        List<Goods> goods = goodsDao.pageGoods(pageNum, pageSize, shopId);
        return PageResponse.pageData(pageNum, pageSize, totalPage, goods);
    }

    public Goods updateGoods(Goods goods) {
        Shop shop = shopDao.findShopById(goods.getShopId());

        if (Objects.equals(shop.getOwnerUserId(), UserContext.getCurrentUser().getId())) {
            int affectedRows = goodsDao.updateGoods(goods);
            if (affectedRows == 0) {
                throw WxShopException.notFound("商品未找到");
            }
            return goods;
        } else {
            throw WxShopException.forbidden("无权访问！");
        }
    }



}
