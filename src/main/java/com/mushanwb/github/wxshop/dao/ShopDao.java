package com.mushanwb.github.wxshop.dao;

import com.mushanwb.github.wxshop.generate.Shop;
import com.mushanwb.github.wxshop.generate.ShopExample;
import com.mushanwb.github.wxshop.generate.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopDao {

    private final ShopMapper shopMapper;

    @Autowired
    public ShopDao(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    public Shop findShopById(Long shopId) {
        return shopMapper.selectByPrimaryKey(shopId);
    }

    public void createShop(Shop createShop) {
        shopMapper.insert(createShop);
    }

    public void updateShop(Shop updateShop) {
        shopMapper.updateByPrimaryKeySelective(updateShop);
    }
}
