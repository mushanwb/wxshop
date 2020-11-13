package com.mushanwb.github.wxshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mushanwb.github.wxshop.WxshopApplication;
import com.mushanwb.github.wxshop.entity.Response;
import com.mushanwb.github.wxshop.generate.Goods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WxshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)    //随机端口
@TestPropertySource(properties = { "spring.config.location=classpath:test-application.yml" })    // 测试数据库配置
public class GoodsIntegrationTest extends AbstractIntegrationTest {

    @Test
    public void testCreateGoods() throws JsonProcessingException {
        String cookie = loginAndGetCookie();

        Goods goods = new Goods();
        goods.setName("肥皂");
        goods.setDescription("纯天然肥皂");
        goods.setDetails("这是一块好肥皂");
        goods.setImgUrl("http://url");
        goods.setPrice(1000L);
        goods.setStock(10);
        goods.setShopId(1L);

        HttpResponse response = doHttpRequest("/v1/api/goods",
                false,
                goods,
                cookie);
        // 通过 TypeReference 将范型转化为 goods 对象
        Response<Goods> responseData = objectMapper.readValue(response.body, new TypeReference<Response<Goods>>() {});
        Assertions.assertEquals(HttpStatus.CREATED.value(), response.code);
        Assertions.assertEquals("肥皂", responseData.getData().getName());
    }

    @Test
    public void testDeleteGoods() {

    }
}
