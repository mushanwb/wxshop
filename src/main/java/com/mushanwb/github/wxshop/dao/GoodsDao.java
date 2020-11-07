package com.mushanwb.github.wxshop.dao;

import com.mushanwb.github.wxshop.generate.Goods;
import com.mushanwb.github.wxshop.generate.GoodsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsDao {
    private final SqlSessionFactory sqlSessionFactory;

    @Autowired
    public GoodsDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Goods createGoods(Goods goods) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
            long goodsId = goodsMapper.insert(goods);
            goods.setId(goodsId);
            return goods;
        }
    }

}
