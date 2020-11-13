package com.mushanwb.github.wxshop.dao;

import com.mushanwb.github.wxshop.entity.DataStatus;
import com.mushanwb.github.wxshop.generate.Goods;
import com.mushanwb.github.wxshop.generate.GoodsExample;
import com.mushanwb.github.wxshop.generate.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsDao {
    private final GoodsMapper goodsMapper;

    @Autowired
    public GoodsDao(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    public Goods createGoods(Goods goods) {
        long goodsId = goodsMapper.insert(goods);
        goods.setId(goodsId);
        return goods;
    }

    public Goods deleteGoodsById(Long goodsId) {
        Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
        if (goods == null) {
            throw new ResourceNotFoundException("商品未找到");
        }
        goods.setStatus(DataStatus.OK.getName());
        goodsMapper.updateByPrimaryKey(goods);
        return goods;
    }

    public int countAll(Integer shopId) {
        GoodsExample goodsExample = goodsExampleByShopId(shopId);
        return (int) goodsMapper.countByExample(goodsExample);
    }

    public List<Goods> pageGoods(Integer pageNum, Integer pageSize, Integer shopId) {
        GoodsExample goodsExample = goodsExampleByShopId(shopId);
        goodsExample.setLimit(pageSize);
        goodsExample.setOffset((pageNum - 1) * pageSize);
        return goodsMapper.selectByExample(goodsExample);
    }

    private GoodsExample goodsExampleByShopId(Integer shopId) {
        GoodsExample goodsExample = new GoodsExample();
        if (shopId == null) {
            goodsExample.createCriteria().andStatusEqualTo(DataStatus.OK.getName());
        } else {
            goodsExample.createCriteria()
                    .andStatusEqualTo(DataStatus.OK.getName())
                    .andShopIdEqualTo(shopId.longValue());
        }
        return goodsExample;
    }

    public static class ResourceNotFoundException extends RuntimeException{
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}
