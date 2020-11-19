package com.mushanwb.github.wxshop.service;

import com.mushanwb.github.wxshop.dao.ShopDao;
import com.mushanwb.github.wxshop.entity.DataStatus;
import com.mushanwb.github.wxshop.entity.WxShopException;
import com.mushanwb.github.wxshop.generate.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ShopService {

    private final ShopDao shopDao;

    @Autowired
    public ShopService(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    public Shop createShop(Shop createShop) {
        Long ownerUserId = UserContext.getCurrentUser().getId();
        createShop.setOwnerUserId(ownerUserId);
        createShop.setStatus(DataStatus.OK.getName());
        shopDao.createShop(createShop);
        return createShop;
    }

    public Shop updateShop(Shop updateShop) {
        Shop shop = shopDao.findShopById(updateShop.getId());
        if (shop == null) {
            throw new WxShopException.ResourceNotFoundException("店铺未找到");
        }
        if (Objects.equals(shop.getOwnerUserId(), UserContext.getCurrentUser().getId())) {
            shopDao.updateShop(updateShop);
            return updateShop;
        } else {
            throw new WxShopException.NotAuthorizedForShopException("无权访问！");
        }
    }
}
