package com.mushanwb.github.wxshop.service;

import com.mushanwb.github.wxshop.dao.GoodsDao;
import com.mushanwb.github.wxshop.dao.ShopDao;
import com.mushanwb.github.wxshop.generate.Goods;
import com.mushanwb.github.wxshop.generate.Shop;
import com.mushanwb.github.wxshop.generate.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GoodsServiceTest {
    @Mock
    private GoodsDao goodsDao;
    @Mock
    private ShopDao shopDao;

    @Mock
    private Shop shop;
    @Mock
    private Goods goods;

    @InjectMocks
    private GoodsService goodsService;

    @BeforeEach
    public void initUserContext() {
        // 假设现在登录的用户 id 为 1
        User user = new User();
        user.setId(1L);
        UserContext.setCurrentUser(user);
    }

    @AfterEach
    public void clearUserContext() {
        // 用完假的用户数据后要立即清理掉
        UserContext.setCurrentUser(null);
    }

    @Test
    public void createGoodsSuccessIfUserIsOwner() {
        // 假设当调用 shopDao.findShopById 这个方法的时候，无论传入一个什么样的 long 类型值，都会返回一个 shop
        Mockito.when(shopDao.findShopById(Mockito.anyLong())).thenReturn(shop);
        // 假设返回的 shop 里 userId 为 1，也就是跟模拟的用户 id 一致
        Mockito.when(shop.getOwnerUserId()).thenReturn(1L);
        // 假设添加商品成功后获得的 id 为 123
        Mockito.when(goodsDao.createGoods(goods)).thenReturn(123);

        // 验证插入后的 goods 和 goodsService.createGoods 方法得到的 goods 是一致的
        Assertions.assertEquals(goods, goodsService.createGoods(goods));

        // 验证 goods 确实被 setId 为 123
        Mockito.verify(goods).setId(123L);
    }

    @Test
    public void createGoodsFailedIfUserIsNotOwner() {

    }

}