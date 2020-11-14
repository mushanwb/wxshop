package com.mushanwb.github.wxshop.service;

import com.mushanwb.github.wxshop.dao.GoodsDao;
import com.mushanwb.github.wxshop.dao.ShopDao;
import com.mushanwb.github.wxshop.entity.DataStatus;
import com.mushanwb.github.wxshop.entity.PageResponse;
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

import java.util.List;

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
        // 假设当调用 shopDao.findShopById 这个方法的时候，无论传入一个什么样的 long 类型值，都会返回一个 shop
        Mockito.when(shopDao.findShopById(Mockito.anyLong())).thenReturn(shop);
        // 假设返回的 shop 里 userId 为 2，也就是跟模拟的用户 id 不一致
        Mockito.when(shop.getOwnerUserId()).thenReturn(2L);

        Assertions.assertThrows(GoodsService.NotAuthorizedForShopException.class, () -> {
            goodsService.createGoods(goods);
        });
    }

    @Test
    public void deleteGoodsSuccessIfUserIsOwner() {
        Long deleteGoodsId = 1L;
        // 假设当调用 shopDao.findShopById 这个方法的时候，无论传入一个什么样的 long 类型值，都会返回一个 shop
        Mockito.when(shopDao.findShopById(Mockito.anyLong())).thenReturn(shop);
        // 假设返回的 shop 里 userId 为 1，也就是跟模拟的用户 id 一致
        Mockito.when(shop.getOwnerUserId()).thenReturn(1L);
        Mockito.when(goodsDao.getGoodsById(deleteGoodsId)).thenReturn(goods);

        goodsService.deleteGoodsById(deleteGoodsId);
        Mockito.verify(goods).setStatus(DataStatus.DELETED.getName());
    }

    @Test
    public void throwExceptionIfGoodsNotFound() {
        Long deleteGoodsId = 1L;
        // 假设当调用 shopDao.findShopById 这个方法的时候，无论传入一个什么样的 long 类型值，都会返回一个 shop
        Mockito.when(shopDao.findShopById(Mockito.anyLong())).thenReturn(shop);
        // 假设返回的 shop 里 userId 为 1，也就是跟模拟的用户 id 一致
        Mockito.when(shop.getOwnerUserId()).thenReturn(1L);
        // 假设 goodsDao.getGoodsById 返回一个 null
        Mockito.when(goodsDao.getGoodsById(deleteGoodsId)).thenReturn(null);

        // 断言调用 goodsService.deleteGoodsById 将会抛出异常
        Assertions.assertThrows(GoodsDao.ResourceNotFoundException.class, () -> goodsService.deleteGoodsById(deleteGoodsId));
    }

    @Test
    public void deleteGoodsThrowExceptionIfUserIsNotOwner() {
        Long deleteGoodsId = 1L;
        // 假设当调用 shopDao.findShopById 这个方法的时候，无论传入一个什么样的 long 类型值，都会返回一个 shop
        Mockito.when(shopDao.findShopById(Mockito.anyLong())).thenReturn(shop);
        // 假设返回的 shop 里 userId 为 2，也就是跟模拟的用户 id 不一致
        Mockito.when(shop.getOwnerUserId()).thenReturn(2L);

        Assertions.assertThrows(GoodsService.NotAuthorizedForShopException.class, () -> {
            goodsService.deleteGoodsById(deleteGoodsId);
        });
    }

    @Test
    public void getGoodsSuccessWithNullShopId() {
        int pageNumber = 5;
        int pageSize = 10;
        // 创建一个假的 list<Goods> 结构
        List<Goods> mockGoods = Mockito.mock(List.class);

        // 假设 shopId 为 null 时，总条数为 55
        Mockito.when(goodsDao.countAll(null)).thenReturn(55);
        // 假设调用 goodsDao.pageGoods 返回 创建好的假 list<Goods> 结构
        Mockito.when(goodsDao.pageGoods(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(mockGoods);

        // 当调用 goodsService.getGoods 时返回的结果
        PageResponse<Goods> result = goodsService.getGoods(pageNumber, pageSize, null);

        // 断定 返回的结果中总页数为 6，当前页为 5，每页数量为 10，数据为创建的假数据
        Assertions.assertEquals(6, result.getTotalPage());
        Assertions.assertEquals(5, result.getPageNum());
        Assertions.assertEquals(10, result.getPageSize());
        Assertions.assertEquals(mockGoods, result.getData());
    }

    @Test
    public void getGoodsSuccessWithNonNullShopId() {
        int pageNumber = 5;
        int pageSize = 10;
        // 创建一个假的 list<Goods> 结构
        List<Goods> mockGoods = Mockito.mock(List.class);

        // 假设 shopId 为 456 时，总条数为 100
        Mockito.when(goodsDao.countAll(456)).thenReturn(100);
        // 假设调用 goodsDao.pageGoods 返回 创建好的假 list<Goods> 结构
        Mockito.when(goodsDao.pageGoods(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(mockGoods);

        // 当调用 goodsService.getGoods 时返回的结果
        PageResponse<Goods> result = goodsService.getGoods(pageNumber, pageSize, 456);

        // 断定 返回的结果中总页数为 6，当前页为 5，每页数量为 10，数据为创建的假数据
        Assertions.assertEquals(10, result.getTotalPage());
        Assertions.assertEquals(5, result.getPageNum());
        Assertions.assertEquals(10, result.getPageSize());
        Assertions.assertEquals(mockGoods, result.getData());
    }

}